package com.example.demo.venue.service;

import com.example.demo.venue.dto.VenueDTO;
import com.example.demo.venue.model.Venue;
import com.example.demo.venue.repo.VenueRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueService {

    private final VenueRepo venueRepo;
    private final VenueMapper venueMapper;

    public VenueDTO create(VenueDTO venueDTO) {
        Venue venue = venueMapper.mapDTOtoVenue(venueDTO);
        venue = venueRepo.save(venue);
        return venueMapper.mapVenueToDTO(venue);
    }

    public VenueDTO update(VenueDTO venueDTO) {
        Venue venue = venueMapper.mapDTOtoVenue(venueDTO);
        venue = venueRepo.save(venue);
        return venueMapper.mapVenueToDTO(venue);
    }

    public VenueDTO getOne(String id) {
        Venue result = venueRepo.findById(id).orElseThrow();
        return venueMapper.mapVenueToDTO(result);
    }

    public List<VenueDTO> getAll() {
        List<Venue> result = venueRepo.findAll();
        return venueMapper.mapVenueListToDTOList(result);
    }

    public void delete(String id) {
        venueRepo.deleteById(id);
    }
}
