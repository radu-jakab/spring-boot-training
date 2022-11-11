package radu.jakab.springboottraining.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.client.dto.ClientAddressDTO;
import radu.jakab.springboottraining.client.model.ClientAddress;
import radu.jakab.springboottraining.client.repo.ClientAddressRepo;

@Service
@RequiredArgsConstructor
public class ClientAddressService {

    private final ClientAddressRepo clientAddressRepo;
    private final ClientAddressMapper clientAddressMapper;

    public ClientAddressDTO getOne(String id) {
        ClientAddress result = clientAddressRepo.findById(id).orElse(null);
        return clientAddressMapper.mapClientAddressToDTO(result);
    }

    public ClientAddressDTO getOneMustExist(String id) {
        ClientAddress result = clientAddressRepo.findById(id).orElseThrow();
        return clientAddressMapper.mapClientAddressToDTO(result);
    }

    public ClientAddressDTO create(ClientAddressDTO dto) {
        dto.setId(null);
        ClientAddress clientAddress = clientAddressMapper.mapDTOToClientAddress(dto);

        clientAddress = clientAddressRepo.save(clientAddress);

        return clientAddressMapper.mapClientAddressToDTO(clientAddress);
    }
}
