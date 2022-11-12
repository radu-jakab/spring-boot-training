package radu.jakab.springboottraining.courier.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import radu.jakab.springboottraining.courier.dto.CourierDTO;
import radu.jakab.springboottraining.courier.dto.CourierInfoDTO;
import radu.jakab.springboottraining.courier.dto.CourierLocationDTO;
import radu.jakab.springboottraining.courier.service.CourierService;

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

    public ResponseEntity<CourierDTO> updateCourierInfo(CourierInfoDTO courierInfoDTO) {
        CourierDTO result = courierService.updateCourierInfo(courierInfoDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<Object> updateCourierLocation(String courierId,
                                                        Double lat,
                                                        Double lon) {
        courierService.updateCourierLocation(new CourierLocationDTO(courierId, lat, lon));
        return new ResponseEntity<>(null, HttpStatus.OK);
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
        CourierDTO result = courierService.getOneMustExistDTO(id);
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
