package radu.jakab.springboottraining.delivery.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.dto.DeliverySearchDTO;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;

import java.util.List;

public interface DeliveryQueryAPI {
    List<DeliveryDTO> getAllDeliveriesWithStatus(DeliveryStatusEnum status);

    List<DeliveryDTO> getAllOngoingDeliveries();

    List<DeliveryDTO> getAllOngoingLateDeliveries();

    List<DeliveryDTO> getAllOngoingDeliveriesForCourier(String courierId);

    Page<DeliveryDTO> search(DeliverySearchDTO dto);
}
