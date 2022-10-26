package radu.jakab.springboottraining.courier;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Courier", description = "API operations for couriers")
public interface CourierAPI {

    @PostMapping
    @Operation(summary = "Create new courier")
    ResponseEntity<CourierDTO> create(@RequestBody CourierDTO courierDTO);

    @PutMapping
    @Operation(summary = "Allows updating of courier info fields: name. Lat, lon and active are not affected via this API")
    ResponseEntity<CourierDTO> updateCourierInfo(@RequestBody CourierDTO courierDTO);

    @PutMapping("location/{courierId}")
    @Operation(summary = "Allows updating of courier location fields: lat, lon. Other fields are not affected by this operation")
    ResponseEntity<CourierDTO> updateCourierLocation(@PathVariable String courierId,
                                                     @RequestParam Double lat,
                                                     @RequestParam Double lon);

    @PutMapping("activate/{courierId}")
    @Operation(summary = "Allows starting a courier's work shift")
    ResponseEntity<CourierDTO> activateCourier(@PathVariable String courierId);

    @PutMapping("deactivate/{courierId}")
    @Operation(summary = "Allows ending a courier's work shift")
    ResponseEntity<CourierDTO> deactivateCourier(@PathVariable String courierId);

    @GetMapping
    @Operation(hidden = true)
    ResponseEntity<List<CourierDTO>> getAll();

    @GetMapping("{id}")
    @Operation(summary = "Retrieve courier for given ID")
    ResponseEntity<CourierDTO> getOne(@PathVariable String id);

    @PutMapping("assign-delivery")
    @Operation(summary = "Assign a delivery to be made by a courier")
    ResponseEntity<CourierDTO> assignDelivery(@RequestParam String courierId,
                                              @RequestParam String orderId);

    @DeleteMapping("{id}")
    @Operation(summary = "Delete courier for given ID, if present in the system",
            responses = {
                    @ApiResponse(responseCode = "200", description = "If the courier was found and successfully deleted"),
                    @ApiResponse(responseCode = "404", description = "If the courier was not found")
            })

    ResponseEntity<Object> delete(@PathVariable String id);
}
