package radu.jakab.springboottraining.delivery.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.client.dto.ClientAddressDTO;
import radu.jakab.springboottraining.client.service.ClientAddressMapper;
import radu.jakab.springboottraining.client.service.ClientAddressService;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;
import radu.jakab.springboottraining.delivery.repo.DeliveryRepo;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryService {
    private final DeliveryRepo deliveryRepo;

    private final DeliveryMapper deliveryMapper;
    private final ClientAddressMapper clientAddressMapper;
    private final ClientAddressService clientAddressService;
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
