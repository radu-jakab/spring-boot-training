package radu.jakab.springboottraining.venue;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VenueMapper {

    Venue mapDTOtoVenue(VenueDTO venueDTO);

    VenueDTO mapVenueToDTO(Venue venue);

    void writeDTOtoVenue(VenueDTO venueDTO, @MappingTarget Venue venue);

    List<VenueDTO> mapVenueListToDTOList(List<Venue> venueDTOs);
}
