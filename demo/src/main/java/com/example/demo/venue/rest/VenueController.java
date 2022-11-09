package com.example.demo.venue.rest;

import com.example.demo.venue.dto.VenueDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("venue")
public class VenueController {

    @PostMapping()
    public ResponseEntity<VenueDTO> create(@RequestBody VenueDTO venueDTO) {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping
    public ResponseEntity<VenueDTO> update(@RequestBody VenueDTO venueDTO) {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<VenueDTO> getOne(@PathVariable String id) {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping()
    public ResponseEntity<List<VenueDTO>> getAll() {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(String id) {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }
}
