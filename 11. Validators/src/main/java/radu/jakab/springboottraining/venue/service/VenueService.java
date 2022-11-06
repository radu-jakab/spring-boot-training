package radu.jakab.springboottraining.venue.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.venue.dto.VenueDTO;
import radu.jakab.springboottraining.venue.model.Venue;
import radu.jakab.springboottraining.venue.repo.VenueRepo;

import java.util.List;

// tells Spring that this is a component (bean)
@Service
// build a constructor for all final fields, this will handle autowiring
@RequiredArgsConstructor
public class VenueService {
    private final VenueRepo venueRepo;

    private final VenueMapper venueMapper;

    public VenueDTO create(VenueDTO venueDTO) {
        // map the DTO to an entity object
        Venue venue = venueMapper.mapDTOtoVenue(venueDTO);

        // add it to the database, and (!) read the resulting object
        // for new objects, the system creates the IDs
        venue = venueRepo.save(venue);

        // map the resulted entity back into a DTO
        return venueMapper.mapVenueToDTO(venue);
    }

    public VenueDTO update(VenueDTO venueDTO) {
        // find the object in the database
        Venue venue = venueRepo.findById(venueDTO.getId()).orElseThrow();

        // write relevant fields to it
        venueMapper.writeDTOtoVenue(venueDTO, venue);

        // save object
        venue = venueRepo.save(venue);

        // map the resulted entity back into a DTO
        return venueMapper.mapVenueToDTO(venue);
    }

    public VenueDTO getOne(String id) {
        // find the object in the database
        Venue venue = venueRepo.findById(id).orElseThrow();
        return venueMapper.mapVenueToDTO(venue);
    }

    public List<VenueDTO> getAll() {
        List<Venue> venues = venueRepo.findAll();
        return venueMapper.mapVenueListToDTOList(venues);
    }

    public void delete(String id) {
        venueRepo.deleteById(id);
    }
}
