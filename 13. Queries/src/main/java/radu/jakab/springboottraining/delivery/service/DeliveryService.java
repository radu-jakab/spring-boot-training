package radu.jakab.springboottraining.delivery.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.client.dto.ClientAddressDTO;
import radu.jakab.springboottraining.client.service.ClientAddressMapper;
import radu.jakab.springboottraining.client.service.ClientAddressService;
import radu.jakab.springboottraining.courier.model.Courier;
import radu.jakab.springboottraining.courier.service.CourierService;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;
import radu.jakab.springboottraining.delivery.repo.DeliveryRepo;
import radu.jakab.springboottraining.intercept.DeliveryI18NException;
import radu.jakab.springboottraining.utils.MessagesService;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryService {
    private final DeliveryRepo deliveryRepo;

    private final DeliveryMapper deliveryMapper;
    private final ClientAddressMapper clientAddressMapper;
    private final ClientAddressService clientAddressService;
    private final CourierService courierService;
    private final MessagesService messagesService;
    private final DeliveryValidator deliveryValidator;

    public DeliveryDTO requestDelivery(DeliveryDTO deliveryDTO) {
        Delivery delivery = deliveryMapper.mapDTOtoDelivery(deliveryDTO);
        setDeliveryDefaults(delivery);
        deliveryValidator.validateCreate(delivery);

        // get existing client address; if null, create it
        ClientAddressDTO clientAddressDTO = clientAddressService.getOne(delivery.getClientAddress().getId());
        if (clientAddressDTO == null) {
            clientAddressDTO = clientAddressService.create(deliveryDTO.getClientAddress());
        }
        delivery.setClientAddress(clientAddressMapper.mapDTOtoClientAddress(clientAddressDTO));

        // create the delivery object, cascades to products
        delivery = deliveryRepo.save(delivery);

        return deliveryMapper.mapDeliveryToDTO(delivery);
    }

    public DeliveryDTO assignDelivery(String courierId, String deliveryId) {
        // find the two participating objects
        Delivery delivery = getOneMustExist(deliveryId);
        Courier courier = courierService.getOneMustExist(courierId);

        // set the new courier and save
        delivery.setCourier(courier);
        delivery = deliveryRepo.save(delivery);

        return deliveryMapper.mapDeliveryToDTO(delivery);
    }

    public Delivery getOneMustExist(String id) {
        return deliveryRepo.findById(id)
                .orElseThrow(() -> new DeliveryI18NException(messagesService.getMessage("delivery.not.found", id)));
    }

    private void setDeliveryDefaults(Delivery delivery) {
        // set status to NEW
        delivery.setStatus(DeliveryStatusEnum.NEW);

        // compute total cost
        BigDecimal productsCost = delivery.getProducts().stream()
                .map(product -> product.getCost().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        delivery.setTotalCost(delivery.getDeliveryCost().add(productsCost));
    }

}
