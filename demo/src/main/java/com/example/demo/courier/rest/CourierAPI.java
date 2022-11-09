package com.example.demo.courier.rest;

import com.example.demo.courier.dto.CourierDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Venue Controller", description = "Venue Controller desc")
public interface CourierAPI {

    @Operation(summary = "Create courier")
    ResponseEntity<CourierDTO> create(CourierDTO courierDTO);

    @Operation(hidden = true)
    ResponseEntity<CourierDTO> updateInfo(String id,
                                          String name);

    ResponseEntity<CourierDTO> updateLocation(String id,
                                              Double lat,
                                              Double lon);

    ResponseEntity<CourierDTO> activate(String id);

    ResponseEntity<CourierDTO> deactivate(String id);

    ResponseEntity<CourierDTO> getOne(String id);

    ResponseEntity<List<CourierDTO>> getAll();

    ResponseEntity<CourierDTO> delete(String id);

}
