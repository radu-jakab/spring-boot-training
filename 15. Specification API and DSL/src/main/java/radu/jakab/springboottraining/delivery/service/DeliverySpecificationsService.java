package radu.jakab.springboottraining.delivery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.dto.DeliverySearchDTO;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;
import radu.jakab.springboottraining.delivery.repo.DeliveryRepo;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliverySpecificationsService implements DeliveryQueryAPI {
    private final DeliveryRepo deliveryRepo;
    private final DeliveryMapper deliveryMapper;

    @Override
    public List<DeliveryDTO> getAllDeliveriesWithStatus(DeliveryStatusEnum status) {
        DeliverySearchDTO dto = new DeliverySearchDTO();
        dto.setStatusIn(Collections.singletonList(status));
        return search(dto).getContent();
    }

    @Override
    public List<DeliveryDTO> getAllOngoingDeliveries() {
        DeliverySearchDTO dto = new DeliverySearchDTO();
        List<DeliveryStatusEnum> statuses = Arrays.asList(DeliveryStatusEnum.NEW,
                DeliveryStatusEnum.ASSIGNED, DeliveryStatusEnum.PICKED_UP);
        dto.setStatusIn(statuses);
        return search(dto).getContent();
    }

    @Override
    public List<DeliveryDTO> getAllOngoingLateDeliveries() {
        DeliverySearchDTO dto = new DeliverySearchDTO();
        List<DeliveryStatusEnum> statuses = Arrays.asList(DeliveryStatusEnum.NEW,
                DeliveryStatusEnum.ASSIGNED, DeliveryStatusEnum.PICKED_UP);
        dto.setStatusIn(statuses);
        dto.setExpectedDeliveryTimeBefore(ZonedDateTime.now());
        return search(dto).getContent();
    }

    @Override
    public List<DeliveryDTO> getAllOngoingDeliveriesForCourier(String courierId) {
        DeliverySearchDTO dto = new DeliverySearchDTO();
        List<DeliveryStatusEnum> statuses = Arrays.asList(DeliveryStatusEnum.NEW,
                DeliveryStatusEnum.ASSIGNED, DeliveryStatusEnum.PICKED_UP);
        dto.setStatusIn(statuses);
        dto.setCourierId(courierId);
        return search(dto).getContent();
    }

    @Override
    public Page<DeliveryDTO> search(DeliverySearchDTO dto) {
        DeliverySpecifications spec = new DeliverySpecifications(dto);
        return deliveryRepo.findAll(spec, dto.getPage().toPageRequest())
                .map(deliveryMapper::mapDeliveryToDTO);
    }
}
