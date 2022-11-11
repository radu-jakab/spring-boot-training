package radu.jakab.springboottraining.venue.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.intercept.DeliveryI18NException;
import radu.jakab.springboottraining.utils.MessagesService;
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
    private final VenueValidator venueValidator;
    private final MessagesService messagesService;

    public VenueDTO create(VenueDTO venueDTO) {
        // map the DTO to an entity object
        Venue venue = venueMapper.mapDTOtoVenue(venueDTO);
        venueValidator.validateCreateOrUpdate(venue);

        // add it to the database, and (!) read the resulting object
        // for new objects, the system creates the IDs
        venue = venueRepo.save(venue);

        // map the resulted entity back into a DTO
        return venueMapper.mapVenueToDTO(venue);
    }

    public VenueDTO update(VenueDTO venueDTO) {
        // find the object in the database
        Venue venue = getOneMustExist(venueDTO.getId());
        venueValidator.validateCreateOrUpdate(venue);

        // write relevant fields to it
        venueMapper.writeDTOtoVenue(venueDTO, venue);

        // save object
        venue = venueRepo.save(venue);

        // map the resulted entity back into a DTO
        return venueMapper.mapVenueToDTO(venue);
    }

    public VenueDTO getOneMustExistDTO(String id) {
        // find the object in the database
        Venue venue = getOneMustExist(id);
        return venueMapper.mapVenueToDTO(venue);
    }

    public Venue getOneMustExist(String id) {
        return venueRepo.findById(id)
                .orElseThrow(() -> new DeliveryI18NException(messagesService.getMessage("venue.not.found", id)));
    }

    public List<VenueDTO> getAll() {
        // FIXME this is a bad idea
        List<Venue> venues = venueRepo.findAll();
        return venueMapper.mapVenueListToDTOList(venues);
    }

    public void delete(String id) {
        venueRepo.deleteById(id);
    }
}
