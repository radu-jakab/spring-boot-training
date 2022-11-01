package radu.jakab.springboottraining.courier;

import lombok.RequiredArgsConstructor;
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
// build a constructor for all final fields, this will handle autowiring
@RequiredArgsConstructor
public class CourierController implements CourierAPI {

    private final CourierService courierService;

    public ResponseEntity<CourierDTO> create(CourierDTO courierDTO) {
        CourierDTO result = courierService.create(courierDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<CourierDTO> updateCourierInfo(CourierDTO courierDTO) {
        CourierDTO result = courierService.updateCourierInfo(courierDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<CourierDTO> updateCourierLocation(String courierId,
                                                            Double lat,
                                                            Double lon) {
        CourierDTO result = courierService.updateCourierLocation(courierId, lat, lon);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<CourierDTO> activateCourier(String courierId) {
        CourierDTO result = courierService.activateCourier(courierId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<CourierDTO> deactivateCourier(String courierId) {
        CourierDTO result = courierService.deactivateCourier(courierId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<List<CourierDTO>> getAll() {
        // FIXME discuss why this is a bad idea
        List<CourierDTO> result = courierService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<CourierDTO> getOne(String id) {
        CourierDTO result = courierService.getOne(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<CourierDTO> assignDelivery(String courierId,
                                                     String orderId) {
        CourierDTO result = courierService.assignDelivery(courierId, orderId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<Object> delete(String id) {
        courierService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
