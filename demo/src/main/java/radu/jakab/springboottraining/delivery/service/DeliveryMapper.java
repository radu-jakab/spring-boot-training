package radu.jakab.springboottraining.delivery.service;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import radu.jakab.springboottraining.client.service.ClientAddressMapper;
import radu.jakab.springboottraining.courier.CourierMapper;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.dto.DeliveryProductDTO;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.DeliveryProduct;
import radu.jakab.springboottraining.venue.VenueMapper;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {ClientAddressMapper.class, CourierMapper.class, VenueMapper.class})
public interface DeliveryMapper {

    Delivery mapDTOtoDelivery(DeliveryDTO deliveryDTO);

    DeliveryDTO mapDeliveryToDTO(Delivery delivery);

    DeliveryProduct mapDTOToDeliveryProduct(DeliveryProductDTO deliveryProductDTO);

    DeliveryProductDTO mapDeliveryProductToDTO(DeliveryProduct deliveryProduct);
}
