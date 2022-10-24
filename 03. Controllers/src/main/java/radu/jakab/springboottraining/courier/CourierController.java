package radu.jakab.springboottraining.courier;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// tells Spring this class defines REST endpoints; adds @ResponseBody to all methods
@RestController
// all defined endpoints will have the common root "/author"
@RequestMapping("courier")
public class CourierController {

    @PostMapping
    public ResponseEntity<CourierDTO> create(@RequestBody CourierDTO courierDTO) {
        // TODO do nothing for now
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<CourierDTO> update(@RequestBody CourierDTO courierDTO) {
        // TODO do nothing for now
        return ResponseEntity.ok(null);
    }

    @PutMapping("location/{id}")
    public void updateLocation(@PathVariable String id,
                               @RequestParam double lat,
                               @RequestParam double lon) {
        // TODO do nothing for now
    }

    @PutMapping("activate/{id}")
    public ResponseEntity<CourierDTO> activate(@PathVariable String id) {
        // TODO do nothing for now
        return ResponseEntity.ok(null);
    }

    @PutMapping("deactivate/{id}")
    public ResponseEntity<CourierDTO> deactivate(@PathVariable String id) {
        // TODO do nothing for now
        return ResponseEntity.ok(null);
    }

    @GetMapping("{id}")
    public ResponseEntity<CourierDTO> findOne(@PathVariable String id) {
        // TODO do nothing for now
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<List<CourierDTO>> list() {
        // TODO do nothing for now
        return ResponseEntity.ok(null);
    }

    @PutMapping("assign")
    public ResponseEntity<CourierDTO> assignDelivery(@RequestParam String deliveryId,
                                                     @RequestParam String courierId) {
        // TODO do nothing for now
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CourierDTO> delete(@PathVariable String id) {
        // TODO do nothing for now
        return ResponseEntity.ok(null);
    }
}
