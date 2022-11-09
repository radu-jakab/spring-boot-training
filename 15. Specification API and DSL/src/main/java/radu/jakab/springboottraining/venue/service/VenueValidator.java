package radu.jakab.springboottraining.venue.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.utils.ValidationUtils;
import radu.jakab.springboottraining.utils.MessagesService;
import radu.jakab.springboottraining.venue.model.Venue;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueValidator {
    private final MessagesService messagesService;

    public void validateCreateOrUpdate(Venue venue) {
        List<String> errors = new ArrayList<>();

        errors.addAll(checkName(venue));
        errors.addAll(checkLatLon(venue));

        ValidationUtils.throwErrors(errors);
    }

    private List<String> checkName(Venue venue) {
        List<String> result = new ArrayList<>();
        if (venue.getName() == null || venue.getName().isEmpty())
            result.add(messagesService.getMessage("venue.name.empty"));
        return result;
    }

    public List<String> checkLatLon(Venue venue) {
        List<String> result = new ArrayList<>();
        if (venue.getLat() == null || venue.getLat() == 0)
            result.add(messagesService.getMessage("venue.lat.empty"));
        if (venue.getLon() == null || venue.getLon() == 0)
            result.add(messagesService.getMessage("venue.lon.empty"));
        return result;
    }
}
