package radu.jakab.springboottraining.client.service;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import radu.jakab.springboottraining.client.dto.ClientAddressDTO;
import radu.jakab.springboottraining.client.model.ClientAddress;
import radu.jakab.springboottraining.delivery.service.DeliveryMapper;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {DeliveryMapper.class})
public interface ClientAddressMapper {

    ClientAddress mapDTOToClientAddress(ClientAddressDTO clientAddressDTO);

    ClientAddressDTO mapClientAddressToDTO(ClientAddress clientAddress);
}
