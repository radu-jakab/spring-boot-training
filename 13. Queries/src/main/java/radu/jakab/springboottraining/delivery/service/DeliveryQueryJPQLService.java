package radu.jakab.springboottraining.delivery.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;
import radu.jakab.springboottraining.delivery.repo.DeliveryRepo;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryQueryJPQLService implements DeliveryQueryAPI {

    private final DeliveryRepo deliveryRepo;
    private final DeliveryMapper deliveryMapper;

    @Override
    public List<DeliveryDTO> getAllDeliveriesWithStatus(DeliveryStatusEnum status) {
        List<Delivery> result = deliveryRepo.findDeliveryByStatusIs(status);
        return result.stream()
                .map(deliveryMapper::mapDeliveryToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DeliveryDTO> getAllOngoingDeliveries() {
        List<Delivery> result = deliveryRepo.getOngoingDeliveries();
        return result.stream()
                .map(deliveryMapper::mapDeliveryToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DeliveryDTO> getAllOngoingLateDeliveries() {
        List<DeliveryStatusEnum> statuses = Arrays.asList(DeliveryStatusEnum.NEW,
                DeliveryStatusEnum.ASSIGNED, DeliveryStatusEnum.PICKED_UP);
        List<Delivery> result = deliveryRepo.findAllByStatusInAndExpectedDeliveryTimeAfter(statuses, ZonedDateTime.now());
        return result.stream()
                .map(deliveryMapper::mapDeliveryToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<DeliveryDTO> getAllOngoingDeliveriesForCourier(String courierId) {
        List<Delivery> result = deliveryRepo.getOngoingDeliveriesByCourier(courierId);
        return result.stream()
                .map(deliveryMapper::mapDeliveryToDTO)
                .collect(Collectors.toList());
    }
}
