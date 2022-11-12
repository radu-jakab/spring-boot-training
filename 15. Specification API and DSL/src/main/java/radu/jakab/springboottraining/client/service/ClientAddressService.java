package radu.jakab.springboottraining.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import radu.jakab.springboottraining.client.dto.ClientAddressDTO;
import radu.jakab.springboottraining.client.model.ClientAddress;
import radu.jakab.springboottraining.client.repo.ClientAddressRepo;

@Service
@RequiredArgsConstructor
public class ClientAddressService {

    private final ClientAddressRepo clientAddressRepo;

    private final ClientAddressMapper clientAddressMapper;
    private final ClientAddressValidator clientAddressValidator;

    public ClientAddressDTO getOne(String id) {
        ClientAddress result = clientAddressRepo.findById(id).orElse(null);
        return clientAddressMapper.mapClientAddressToDTO(result);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ClientAddressDTO create(ClientAddressDTO clientAddressDTO) {
        ClientAddress result = clientAddressMapper.mapDTOtoClientAddress(clientAddressDTO);

        clientAddressValidator.validateCreateOrUpdate(result);

        result = clientAddressRepo.save(result);
        return clientAddressMapper.mapClientAddressToDTO(result);
    }
}
