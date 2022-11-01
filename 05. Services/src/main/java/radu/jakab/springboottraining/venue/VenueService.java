package radu.jakab.springboottraining.venue;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

// tells Spring that this is a component (bean)
@Service
public class VenueService {
    private static List<VenueDTO> VENUES = new ArrayList<>();

    public VenueDTO create(VenueDTO venueDTO) {
        // new objects get a new id from the system
        venueDTO.setId(UUID.randomUUID().toString());

        // add the object in our fake database
        VENUES.add(venueDTO);
        return venueDTO;
    }

    public VenueDTO update(VenueDTO venueDTO) {
        // for the update operation, we replace the object with this ID in the database
        delete(venueDTO.getId());
        VENUES.add(venueDTO);
        return venueDTO;
    }

    public VenueDTO getOne(String id) {
        // find the object for given ID
        return VENUES.stream()
                .filter(v -> v.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public List<VenueDTO> getAll() {
        // return a copy of this list, so outsiders cannot manipulate it
        return new ArrayList<>(VENUES);
    }

    public void delete(String id) {
        // filter the object out of the database
        VENUES = VENUES.stream()
                .filter(v -> !v.getId().equals(id))
                .collect(Collectors.toList());
    }
}
