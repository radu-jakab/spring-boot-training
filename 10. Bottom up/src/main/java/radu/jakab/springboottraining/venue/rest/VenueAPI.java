package radu.jakab.springboottraining.venue.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import radu.jakab.springboottraining.venue.dto.VenueDTO;

import java.util.List;

@Tag(name = "Venue", description = "API for delivery venues. For a delivery to be requested, a valid existing venue " +
        "must be referenced. External implementors should add venues first, before placing orders for them")
public interface VenueAPI {
    @PostMapping
    @Operation(summary = "Create new venue")
    ResponseEntity<VenueDTO> create(@RequestBody VenueDTO venueDTO);

    @PutMapping
    @Operation(summary = "Update fields of an existing venue. ID must already be present in the system")
    ResponseEntity<VenueDTO> update(@RequestBody VenueDTO venueDTO);

    @GetMapping("{id}")
    @Operation(summary = "Retrieve venue for given ID")
    ResponseEntity<VenueDTO> getOne(@PathVariable String id);

    @GetMapping()
    @Operation(hidden = true)
    ResponseEntity<List<VenueDTO>> getAll();

    @DeleteMapping("{id}")
    @Operation(summary = "Delete venue for given ID, if present in the system",
            responses = {
                    @ApiResponse(responseCode = "200", description = "If the venue was found and successfully deleted"),
                    @ApiResponse(responseCode = "404", description = "If the venue was not found")
            })
    ResponseEntity<Object> delete(@PathVariable String id);
}
