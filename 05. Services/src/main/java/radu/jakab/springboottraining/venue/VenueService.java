package radu.jakab.springboottraining.venue;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// tells Spring that this is a component (bean)
@Service
public class VenueService {

    private static List<VenueDTO> VENUES = new ArrayList<>();

    public VenueDTO create(VenueDTO venueDTO) {
        VENUES.add(venueDTO);
        return venueDTO;
    }

    public VenueDTO update(VenueDTO venueDTO) {
        VENUES = VENUES.stream()
                .filter(v -> !v.getId().equals(venueDTO.getId()))
                .collect(Collectors.toList());
        VENUES.add(venueDTO);
    }

    public VenueDTO getOne(String id) {
    }

    public List<VenueDTO> getAll() {
    }

    public void delete(String id) {
    }
}
