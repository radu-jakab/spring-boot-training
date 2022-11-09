package radu.jakab.springboottraining.delivery.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import radu.jakab.springboottraining.client.service.ClientAddressMapper;
import radu.jakab.springboottraining.courier.service.CourierMapper;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.dto.DeliveryProductDTO;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.DeliveryProduct;
import radu.jakab.springboottraining.venue.service.VenueMapper;

// "uses" tells the Mapper class to add other mappers, so that it may benefit from already-defined object translations
// otherwise, the implementation will generate a best-guess default
@Mapper(componentModel = "spring", uses = {VenueMapper.class, CourierMapper.class, ClientAddressMapper.class})
public interface DeliveryMapper {

    @Mapping(target = "delivery", ignore = true)
    DeliveryProduct mapDTOtoDeliveryProduct(DeliveryProductDTO deliveryProductDTO);

    Delivery mapDTOtoDelivery(DeliveryDTO deliveryDTO);

    DeliveryProductDTO mapDeliveryProductToDTO(DeliveryProduct deliveryProduct);

    DeliveryDTO mapDeliveryToDTO(Delivery delivery);
}
