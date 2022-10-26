package radu.jakab.springboottraining.venue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// tells Spring this class defines REST endpoints
// annotates all methods with @ResponseBody, making their return value the body of the HTTP response
@RestController
// all defined endpoints will have the common root "/venue"
@RequestMapping("venue")
public class VenueController {

    @PostMapping
    public ResponseEntity<VenueDTO> create(@RequestBody VenueDTO venueDTO) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<VenueDTO> update(@RequestBody VenueDTO venueDTO) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<VenueDTO> getOne(@PathVariable String id) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<VenueDTO>> getAll() {
        // FIXME discuss why this is a bad idea
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
