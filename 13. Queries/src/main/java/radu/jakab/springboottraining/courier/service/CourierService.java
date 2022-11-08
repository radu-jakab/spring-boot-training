package radu.jakab.springboottraining.courier.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.courier.dto.CourierDTO;
import radu.jakab.springboottraining.courier.dto.CourierInfoDTO;
import radu.jakab.springboottraining.courier.dto.CourierLocationDTO;
import radu.jakab.springboottraining.courier.model.Courier;
import radu.jakab.springboottraining.courier.repo.CourierRepo;
import radu.jakab.springboottraining.intercept.DeliveryI18NException;
import radu.jakab.springboottraining.utils.MessagesService;

import java.util.List;

// tells Spring that this is a component (bean)
@Service
// build a constructor for all final fields, this will handle autowiring
@RequiredArgsConstructor
public class CourierService {

    private final CourierRepo courierRepo;

    private final CourierMapper courierMapper;
    private final CourierValidator courierValidator;
    private final MessagesService messagesService;

    public CourierDTO create(CourierDTO courierDTO) {
        // map the DTO to an entity object
        Courier courier = courierMapper.mapDTOtoCourier(courierDTO);
        courierValidator.validateCreate(courier);
        courier.setActive(false);

        // add it to the database, and (!) read the resulting object
        // for new objects, the system creates the IDs
        courier = courierRepo.save(courier);

        // map the resulted entity back into a DTO
        return courierMapper.mapCourierToDTO(courier);
    }

    public CourierDTO updateCourierInfo(CourierInfoDTO courierInfoDTO) {
        // find the object in the database
        Courier courier = getOneMustExist(courierInfoDTO.getId());
        courierValidator.validateCourierInfoUpdate(courier);

        // write relevant fields to it
        courierMapper.writeInfoDTOFieldsToCourier(courierInfoDTO, courier);

        // save object
        courier = courierRepo.save(courier);

        // map the resulted entity back into a DTO
        return courierMapper.mapCourierToDTO(courier);
    }

    public CourierDTO updateCourierLocation(CourierLocationDTO courierLocationDTO) {
        // find the object in the database
        Courier courier = getOneMustExist(courierLocationDTO.getId());
        courierValidator.validateCourierLocationUpdate(courier);

        // write relevant fields to it
        courierMapper.writeLocationDTOFieldsToCourier(courierLocationDTO, courier);

        // save object
        courier = courierRepo.save(courier);

        // map the resulted entity back into a DTO
        return courierMapper.mapCourierToDTO(courier);
    }

    public CourierDTO activateCourier(String courierId) {
        // find the object in the database
        Courier courier = getOneMustExist(courierId);

        // set relevant fields
        courier.setActive(true);

        // map the resulted entity back into a DTO
        return courierMapper.mapCourierToDTO(courier);
    }

    public CourierDTO deactivateCourier(String courierId) {
        // find the object in the database
        Courier courier = getOneMustExist(courierId);

        // set relevant fields
        courier.setActive(false);

        // map the resulted entity back into a DTO
        return courierMapper.mapCourierToDTO(courier);
    }

    public List<CourierDTO> getAll() {
        // FIXME this is a bad idea
        return courierMapper.mapCourierListToDTOList(courierRepo.findAll());
    }

    public CourierDTO getOneMustExistDTO(String id) {
        Courier courier = getOneMustExist(id);
        return courierMapper.mapCourierToDTO(courier);
    }

    public Courier getOneMustExist(String id) {
        return courierRepo.findById(id)
                .orElseThrow(() -> new DeliveryI18NException(messagesService.getMessage("courier.not.found", id)));
    }

    public void delete(String id) {
        courierRepo.deleteById(id);
    }
}
