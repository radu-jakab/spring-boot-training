package radu.jakab.springboottraining.venue.service;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import radu.jakab.springboottraining.venue.dto.VenueDTO;
import radu.jakab.springboottraining.venue.model.Venue;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VenueMapper {

    Venue mapDTOtoVenue(VenueDTO venueDTO);

    VenueDTO mapVenueToDTO(Venue venue);

    void writeDTOtoVenue(VenueDTO venueDTO, @MappingTarget Venue venue);

    List<VenueDTO> mapVenueListToDTOList(List<Venue> venueDTOs);
}
