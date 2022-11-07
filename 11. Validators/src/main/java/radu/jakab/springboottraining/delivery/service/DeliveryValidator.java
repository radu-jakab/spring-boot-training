package radu.jakab.springboottraining.delivery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.client.model.ClientAddress;
import radu.jakab.springboottraining.client.service.ClientAddressValidator;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.DeliveryProduct;
import radu.jakab.springboottraining.utils.DistanceUtils;
import radu.jakab.springboottraining.utils.MessagesService;
import radu.jakab.springboottraining.utils.ValidationUtils;
import radu.jakab.springboottraining.venue.model.Venue;
import radu.jakab.springboottraining.venue.service.VenueValidator;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryValidator {

    private final MessagesService messagesService;
    private final VenueValidator venueValidator;
    private final ClientAddressValidator clientAddressValidator;

    public void validateCreate(Delivery delivery) {
        List<String> errors = new ArrayList<>();

        delivery.getProducts().forEach(product -> {
            errors.addAll(checkProductCostAndQuantity(product));
            errors.addAll(ValidationUtils.checkMonetaryFormat(
                    product.getCost(),
                    messagesService.getMessage("delivery.product.cost.format")
            ));
        });
        errors.addAll(checkExpectedTime(delivery.getExpectedDeliveryTime()));
        errors.addAll(checkMaxDistance(delivery));
        errors.addAll(ValidationUtils.checkMonetaryFormat(
                delivery.getDeliveryCost(),
                messagesService.getMessage("delivery.cost.format")));

        ValidationUtils.throwErrors(errors);
    }

    private List<String> checkProductCostAndQuantity(DeliveryProduct deliveryProduct) {
        List<String> result = new ArrayList<>();
        if (deliveryProduct.getCost() == null)
            result.add(messagesService.getMessage("delivery.product.cost.empty"));
        if (deliveryProduct.getQuantity() == null)
            result.add(messagesService.getMessage("delivery.product.quantity.empty"));
        return result;
    }

    private List<String> checkExpectedTime(ZonedDateTime expectedTime) {
        List<String> result = new ArrayList<>();
        if (ZonedDateTime.now().isAfter(expectedTime))
            result.add(messagesService.getMessage("delivery.expected-time.past"));
        return result;
    }

    private List<String> checkMaxDistance(Delivery delivery) {
        List<String> result = new ArrayList<>();
        ClientAddress start = delivery.getClientAddress();
        Venue end = delivery.getVenue();

        result.addAll(clientAddressValidator.checkLatLon(start));
        result.addAll(venueValidator.checkLatLon(end));

        if (result.isEmpty()) {
            double dist = DistanceUtils.getDistanceMeters(start.getLat(), start.getLon(), end.getLat(), end.getLon());
            if (dist > 20000)
                result.add(messagesService.getMessage("delivery.max-distance.exceeded"));
        }
        return result;
    }
}
