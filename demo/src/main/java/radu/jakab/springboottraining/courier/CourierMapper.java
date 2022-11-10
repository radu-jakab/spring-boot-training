package radu.jakab.springboottraining.courier;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import radu.jakab.springboottraining.courier.dto.CourierDTO;
import radu.jakab.springboottraining.courier.dto.CourierInfoDTO;
import radu.jakab.springboottraining.courier.dto.CourierLocationDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourierMapper {

    Courier mapDTOtoCourier(CourierDTO courierDTO);

    @Mapping(target = "id", ignore = true)
    void writeInfoDTOFieldsToCourier(CourierInfoDTO courierDTO, @MappingTarget Courier courier);

    @Mapping(target = "id", ignore = true)
    void writeLocationDTOFieldsToCourier(CourierLocationDTO courierDTO, @MappingTarget Courier courier);

    CourierDTO mapCourierToDTO(Courier courier);

    List<CourierDTO> mapCourierListToDTOList(List<Courier> courier);
}
