package radu.jakab.springboottraining.client.service;

import org.mapstruct.Mapper;
import radu.jakab.springboottraining.client.dto.ClientAddressDTO;
import radu.jakab.springboottraining.client.model.ClientAddress;

@Mapper(componentModel = "spring")
public interface ClientAddressMapper {

    ClientAddress mapDTOtoClientAddress(ClientAddressDTO clientAddressDTO);

    ClientAddressDTO mapClientAddressToDTO(ClientAddress clientAddress);
}
