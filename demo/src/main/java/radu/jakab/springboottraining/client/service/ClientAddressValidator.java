package radu.jakab.springboottraining.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.client.model.ClientAddress;
import radu.jakab.springboottraining.utils.MessagesService;
import radu.jakab.springboottraining.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientAddressValidator {
    private final MessagesService messagesService;

    public void validateCreateOrUpdate(ClientAddress clientAddress) {
        List<String> errors = new ArrayList<>();

        errors.addAll(checkName(clientAddress));
        errors.addAll(checkLatLon(clientAddress));

        ValidationUtils.throwErrors(errors);
    }

    private List<String> checkName(ClientAddress clientAddress) {
        List<String> result = new ArrayList<>();
        if (clientAddress.getClientName() == null || clientAddress.getClientName().isEmpty())
            result.add(messagesService.getMessage("client.name.empty"));
        return result;
    }

    public List<String> checkLatLon(ClientAddress clientAddress) {
        List<String> result = new ArrayList<>();
        if (clientAddress.getLat() == null || clientAddress.getLat() == 0)
            result.add(messagesService.getMessage("client.lat.empty"));
        if (clientAddress.getLon() == null || clientAddress.getLon() == 0)
            result.add(messagesService.getMessage("client.lon.empty"));
        return result;
    }
}
