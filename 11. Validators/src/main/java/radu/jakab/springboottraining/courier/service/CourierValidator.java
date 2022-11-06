package radu.jakab.springboottraining.courier.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import radu.jakab.springboottraining.courier.model.Courier;
import radu.jakab.springboottraining.utils.MessagesService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierValidator {

    private final MessagesService messagesService;

    public void validateCreate(Courier courier) {
        List<String> errors = new ArrayList<>();

        errors.addAll(checkName(courier));
        errors.addAll(checkLatLon(courier));

        throwErrors(errors);
    }

    public void validateCourierInfoUpdate(Courier courier) {
        List<String> errors = new ArrayList<>(checkName(courier));
        throwErrors(errors);
    }

    public void validateCourierLocationUpdate(Courier courier) {
        List<String> errors = new ArrayList<>(checkLatLon(courier));
        throwErrors(errors);
    }

    private List<String> checkName(Courier courier) {
        List<String> result = new ArrayList<>();
        if (courier.getName() == null || courier.getName().isEmpty())
            result.add(messagesService.getMessage("courier.name.empty"));
        return result;
    }

    private List<String> checkLatLon(Courier courier) {
        List<String> result = new ArrayList<>();
        if (courier.getLat() == null || courier.getLat() == 0)
            result.add(messagesService.getMessage("courier.lat.empty"));
        if (courier.getLon() == null || courier.getLon() == 0)
            result.add(messagesService.getMessage("courier.lon.empty"));
        return result;
    }

    private void throwErrors(List<String> errors) {
        if (!errors.isEmpty()) {
            String msg = String.join(". ", errors);
            throw Problem.valueOf(Status.EXPECTATION_FAILED, msg);
        }
    }
}
