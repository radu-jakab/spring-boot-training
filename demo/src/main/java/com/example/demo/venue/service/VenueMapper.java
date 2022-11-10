package com.example.demo.venue.service;

import com.example.demo.venue.dto.VenueDTO;
import com.example.demo.venue.model.Venue;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VenueMapper {

    Venue mapDTOtoVenue(VenueDTO venueDTO);

    VenueDTO mapVenueToDTO(Venue venue);

    List<VenueDTO> mapVenueListToDTOList(List<Venue> venue);
}
