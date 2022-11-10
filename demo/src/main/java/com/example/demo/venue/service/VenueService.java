package com.example.demo.venue.service;

import com.example.demo.venue.dto.VenueDTO;
import com.example.demo.venue.repo.VenueRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VenueService {

    private List<VenueDTO> VENUES = new ArrayList<>();

    private final VenueRepo venueRepo;

    public VenueDTO create(VenueDTO venueDTO) {
        venueDTO.setId(UUID.randomUUID().toString());
        VENUES.add(venueDTO);
        return venueDTO;
    }

    public VenueDTO update(VenueDTO venueDTO) {
        VenueDTO existing = VENUES.stream()
                .filter(v -> Objects.equals(v.getId(), venueDTO.getId()))
                .findAny().orElse(null);
        if (existing != null) {
            existing.setName(venueDTO.getName());
            existing.setLat(venueDTO.getLat());
            existing.setLon(venueDTO.getLon());
            existing.setContactNumber(venueDTO.getContactNumber());
        }
        return existing;
    }

    public VenueDTO getOne(String id) {
        return VENUES.stream()
                .filter(v -> Objects.equals(v.getId(), id))
                .findAny().orElse(null);
    }

    public List<VenueDTO> getAll() {
        return VENUES;
    }

    public void delete(String id) {
        VENUES = VENUES.stream()
                .filter(v -> !Objects.equals(v.getId(), id))
                .collect(Collectors.toList());
    }
}
