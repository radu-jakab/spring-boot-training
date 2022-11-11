package radu.jakab.springboottraining.delivery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.client.dto.ClientAddressDTO;
import radu.jakab.springboottraining.client.service.ClientAddressService;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.DeliveryProduct;
import radu.jakab.springboottraining.delivery.repo.DeliveryRepo;
import radu.jakab.springboottraining.venue.VenueDTO;
import radu.jakab.springboottraining.venue.VenueService;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepo deliveryRepo;

    private final DeliveryMapper deliveryMapper;
    private final ClientAddressService clientAddressService;
    private final VenueService venueService;

    public DeliveryDTO addDelivery(DeliveryDTO deliveryDTO) {
        ClientAddressDTO clientAddressDTO = clientAddressService.getOne(deliveryDTO.getClientAddress().getId());
        if (clientAddressDTO == null) {
            clientAddressDTO = clientAddressService.create(deliveryDTO.getClientAddress());
        }
        deliveryDTO.setClientAddress(clientAddressDTO);

        VenueDTO venueDTO = venueService.getOne(deliveryDTO.getVenue().getId());
        if (venueDTO == null) {
            venueDTO = venueService.create(deliveryDTO.getVenue());
        }
        deliveryDTO.setVenue(venueDTO);

        // transform DTO to entity
        Delivery delivery = deliveryMapper.mapDTOtoDelivery(deliveryDTO);

        // compute total cost as sum of products cost + delivery cost
        BigDecimal productsCost = delivery.getProducts().stream()
                .map(DeliveryProduct::getCost)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        delivery.setTotalValue(productsCost.add(delivery.getDeliveryCost()));

        // set expected time of delivery
        if (delivery.getExpectedDeliveryTime() == null)
            delivery.setExpectedDeliveryTime(ZonedDateTime.now().plusHours(1));

        delivery = deliveryRepo.save(delivery);

        return deliveryMapper.mapDeliveryToDTO(delivery);
    }
}
