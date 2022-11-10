package radu.jakab.springboottraining.courier;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.courier.dto.CourierDTO;
import radu.jakab.springboottraining.courier.dto.CourierInfoDTO;
import radu.jakab.springboottraining.courier.dto.CourierLocationDTO;

import java.util.List;

// tells Spring that this is a component (bean)
@Service
// build a constructor for all final fields, this will handle autowiring
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepo repo;

    private final CourierMapper mapper;

    public CourierDTO create(CourierDTO courierDTO) {
        // map the DTO to an entity object
        Courier courier = mapper.mapDTOtoCourier(courierDTO);
        courier.setActive(false);

        // add it to the database, and (!) read the resulting object
        // for new objects, the system creates the IDs
        courier = repo.save(courier);

        // map the resulted entity back into a DTO
        return mapper.mapCourierToDTO(courier);
    }

    public CourierDTO updateCourierInfo(CourierInfoDTO dto) {
        // find the object in the database
        Courier courier = repo.findById(dto.getId()).orElseThrow();

        // write relevant fields to it
        mapper.writeInfoDTOFieldsToCourier(dto, courier);

        // save object
        courier = repo.save(courier);

        // map the resulted entity back into a DTO
        return mapper.mapCourierToDTO(courier);
    }

    public CourierDTO updateCourierLocation(CourierLocationDTO courierLocationDTO) {
        // find the object in the database
        Courier courier = repo.findById(courierLocationDTO.getId()).orElseThrow();

        // write relevant fields to it
        mapper.writeLocationDTOFieldsToCourier(courierLocationDTO, courier);

        // save object
        courier = repo.save(courier);

        // map the resulted entity back into a DTO
        return mapper.mapCourierToDTO(courier);
    }

    public CourierDTO activateCourier(String courierId) {
        // find the object in the database
        Courier courier = repo.findById(courierId).orElseThrow();

        // set relevant fields
        courier.setActive(true);

        // map the resulted entity back into a DTO
        return mapper.mapCourierToDTO(courier);
    }

    public CourierDTO deactivateCourier(String courierId) {
        // find the object in the database
        Courier courier = repo.findById(courierId).orElseThrow();

        // set relevant fields
        courier.setActive(false);

        // map the resulted entity back into a DTO
        return mapper.mapCourierToDTO(courier);
    }

    public List<CourierDTO> getAll() {
        // FIXME this is a bad idea
        return mapper.mapCourierListToDTOList(repo.findAll());
    }

    public CourierDTO getOne(String id) {
        Courier courier = repo.findById(id).orElseThrow();
        return mapper.mapCourierToDTO(courier);
    }

    public CourierDTO assignDelivery(String courierId,
                                     String orderId) {
        // TODO do nothing for now
        return null;
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
