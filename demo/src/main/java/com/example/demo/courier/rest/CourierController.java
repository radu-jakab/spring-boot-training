package com.example.demo.courier.rest;

import com.example.demo.courier.dto.CourierDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courier")
public class CourierController implements CourierAPI {

    @PostMapping
    public ResponseEntity<CourierDTO> create(@RequestBody CourierDTO courierDTO) {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("update-info/{id}")
    public ResponseEntity<CourierDTO> updateInfo(@PathVariable String id,
                                                 @RequestParam String name) {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("update-location/{id}")
    public ResponseEntity<CourierDTO> updateLocation(@PathVariable String id,
                                                     @RequestParam Double lat,
                                                     @RequestParam Double lon) {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("activation/{id}")
    public ResponseEntity<CourierDTO> activate(@PathVariable String id) {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("deactivation/{id}")
    public ResponseEntity<CourierDTO> deactivate(@PathVariable String id) {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CourierDTO> getOne(@PathVariable String id) {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping
    public ResponseEntity<List<CourierDTO>> getAll() {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CourierDTO> delete(@PathVariable String id) {
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }
}
