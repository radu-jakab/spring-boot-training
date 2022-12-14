package radu.jakab.springboottraining.courier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// tells Spring this class defines REST endpoints
// annotates all methods with @ResponseBody, making their return value the body of the HTTP response
@RestController
// all defined endpoints will have the common root "/courier"
@RequestMapping("courier")
public class CourierController {

    @PostMapping
    public ResponseEntity<CourierDTO> create(@RequestBody CourierDTO courierDTO) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CourierDTO> updateCourierInfo(@RequestBody CourierDTO courierDTO) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("location/{courierId}")
    public ResponseEntity<CourierDTO> updateCourierLocation(@PathVariable String courierId,
                                                            @RequestParam Double lat,
                                                            @RequestParam Double lon) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("activate/{courierId}")
    public ResponseEntity<CourierDTO> activateCourier(@PathVariable String courierId) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("deactivate/{courierId}")
    public ResponseEntity<CourierDTO> deactivateCourier(@PathVariable String courierId) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CourierDTO>> getAll() {
        // FIXME discuss why this is a bad idea
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CourierDTO> getOne(@PathVariable String id) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("assign-order")
    public ResponseEntity<CourierDTO> getOne(@RequestParam String courierId,
                                             @RequestParam String orderId) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
