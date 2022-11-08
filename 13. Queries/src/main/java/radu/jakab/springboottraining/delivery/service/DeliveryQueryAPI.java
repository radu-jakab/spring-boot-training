package radu.jakab.springboottraining.delivery.service;

import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;

import java.util.List;

public interface DeliveryQueryAPI {
    List<DeliveryDTO> getAllDeliveriesWithStatus(DeliveryStatusEnum status);

    List<DeliveryDTO> getAllOngoingDeliveries();

    List<DeliveryDTO> getAllOngoingLateDeliveries();

    List<DeliveryDTO> getAllOngoingDeliveriesForCourier(String courierId);
}
