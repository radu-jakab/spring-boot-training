package radu.jakab.springboottraining.venue.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import radu.jakab.springboottraining.venue.dto.VenueDTO;
import radu.jakab.springboottraining.venue.service.VenueService;

import java.util.List;

// tells Spring this class defines REST endpoints
// annotates all methods with @ResponseBody, making their return value the body of the HTTP response
@RestController
// all defined endpoints will have the common root "/venue"
@RequestMapping("venue")
// build a constructor for all final fields, this will handle autowiring
@RequiredArgsConstructor
public class VenueController implements VenueAPI {

    private final VenueService venueService;

    public ResponseEntity<VenueDTO> create(VenueDTO venueDTO) {
        VenueDTO result = venueService.create(venueDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<VenueDTO> update(VenueDTO venueDTO) {
        VenueDTO result = venueService.update(venueDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<VenueDTO> getOne(String id) {
        VenueDTO result = venueService.getOne(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<List<VenueDTO>> getAll() {
        // FIXME this is a bad idea
        List<VenueDTO> result = venueService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<Object> delete(String id) {
        venueService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
