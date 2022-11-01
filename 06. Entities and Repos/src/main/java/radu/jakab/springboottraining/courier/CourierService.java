package radu.jakab.springboottraining.courier;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

// tells Spring that this is a component (bean)
@Service
// build a constructor for all final fields, this will handle autowiring
@RequiredArgsConstructor
public class CourierService {
    private static List<CourierDTO> COURIERS = new ArrayList<>();

    private final CourierRepo courierRepo;

    public CourierDTO create(CourierDTO courierDTO) {
        // for new objects, the system creates the IDs
        courierDTO.setId(UUID.randomUUID().toString());

        // add it to the database
        COURIERS.add(courierDTO);
        return courierDTO;
    }

    public CourierDTO updateCourierInfo(CourierDTO courierDTO) {
        // find the object
        CourierDTO savedObject = getOne(courierDTO.getId());

        // copy relevant fields
        savedObject.setName(courierDTO.getName());

        // return the resulting object
        return savedObject;
    }

    public CourierDTO updateCourierLocation(String courierId,
                                            Double lat,
                                            Double lon) {
        // find the object
        CourierDTO savedObject = getOne(courierId);

        // copy relevant fields
        savedObject.setLat(lat);
        savedObject.setLon(lon);

        // return the resulting object
        return savedObject;
    }

    public CourierDTO activateCourier(String courierId) {
        // find the object
        CourierDTO savedObject = getOne(courierId);

        // set relevant fields
        savedObject.setActive(true);

        // return the resulting object
        return savedObject;
    }

    public CourierDTO deactivateCourier(String courierId) {
        // find the object
        CourierDTO savedObject = getOne(courierId);

        // set relevant fields
        savedObject.setActive(true);

        // return the resulting object
        return savedObject;
    }

    public List<CourierDTO> getAll() {
        return new ArrayList<>(COURIERS);
    }

    public CourierDTO getOne(String id) {
        return COURIERS.stream()
                .filter(c -> c.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public CourierDTO assignDelivery(String courierId,
                                     String orderId) {
        // TODO do nothing for now
        return null;
    }

    public void delete(String id) {
        COURIERS = COURIERS.stream()
                .filter(c -> !c.getId().equals(id))
                .collect(Collectors.toList());
    }
}
