package radu.jakab.springboottraining.courier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// tells Spring this class defines REST endpoints
// annotates all methods with @ResponseBody, making their return value the body of the HTTP response
@RestController
// all defined endpoints will have the common root "/courier"
@RequestMapping("courier")
public class CourierController implements CourierAPI {

    public ResponseEntity<CourierDTO> create(CourierDTO courierDTO) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<CourierDTO> updateCourierInfo(CourierDTO courierDTO) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<CourierDTO> updateCourierLocation(String courierId,
                                                            Double lat,
                                                            Double lon) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<CourierDTO> activateCourier(String courierId) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<CourierDTO> deactivateCourier(String courierId) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<CourierDTO>> getAll() {
        // FIXME discuss why this is a bad idea
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<CourierDTO> getOne(String id) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<CourierDTO> assignDelivery(String courierId,
                                                     String orderId) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Object> delete(String id) {
        // TODO do nothing for now
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
