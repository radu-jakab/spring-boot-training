package radu.jakab.springboottraining.venue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// tells Spring this class defines REST endpoints
// annotates all methods with @ResponseBody, making their return value the body of the HTTP response
@RestController
// all defined endpoints will have the common root "/venue"
@RequestMapping("venue")
public class VenueController implements VenueAPI {

    public ResponseEntity<VenueDTO> create(VenueDTO venueDTO) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<VenueDTO> update(VenueDTO venueDTO) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<VenueDTO> getOne(String id) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<VenueDTO>> getAll() {
        // FIXME discuss why this is a bad idea
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Object> delete(String id) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
