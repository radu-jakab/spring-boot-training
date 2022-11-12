package radu.jakab.springboottraining.delivery.service;

import org.springframework.data.domain.Page;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.dto.DeliverySearchCriteriaDTO;
import radu.jakab.springboottraining.delivery.dto.PageDTO;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;

public interface DeliverySearchAPI {
    Page<Delivery> findAllByStatusEquals(DeliveryStatusEnum status, PageDTO page);

    Page<Delivery> findAllOngoingDeliveries(PageDTO page);

    Page<Delivery> findAllOngoingLateDeliveries(PageDTO page);

    Page<Delivery> findAllOngoingDeliveriesForCourierId(String id, PageDTO page);

    Page<DeliveryDTO> search(DeliverySearchCriteriaDTO criteria);
}
