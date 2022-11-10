package com.example.demo.venue.rest;

import com.example.demo.venue.dto.VenueDTO;
import com.example.demo.venue.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("venue")
@RequiredArgsConstructor
public class VenueController {

    private final VenueService venueService;

    @PostMapping()
    public ResponseEntity<VenueDTO> create(@RequestBody VenueDTO venueDTO) {
        VenueDTO result = venueService.create(venueDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<VenueDTO> update(@RequestBody VenueDTO venueDTO) {
        VenueDTO result = venueService.update(venueDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<VenueDTO> getOne(@PathVariable String id) {
        VenueDTO result = venueService.getOne(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<VenueDTO>> getAll() {
        List<VenueDTO> result = venueService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<Object> delete(String id) {
        venueService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
