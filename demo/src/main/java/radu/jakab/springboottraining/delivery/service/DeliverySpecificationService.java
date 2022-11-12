package radu.jakab.springboottraining.delivery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.DeliveryAppProfiles;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.dto.DeliverySearchCriteriaDTO;
import radu.jakab.springboottraining.delivery.dto.PageDTO;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;
import radu.jakab.springboottraining.delivery.repo.DeliveryRepo;

import java.util.Arrays;

@Service
@Profile(DeliveryAppProfiles.DEV)
@RequiredArgsConstructor
public class DeliverySpecificationService implements DeliverySearchAPI {

    private final DeliveryRepo deliveryRepo;
    private final DeliveryMapper deliveryMapper;

    @Override
    public Page<Delivery> findAllByStatusEquals(DeliveryStatusEnum status, PageDTO page) {
        return null;
    }

    @Override
    public Page<Delivery> findAllOngoingDeliveries(PageDTO page) {
        return null;
    }

    @Override
    public Page<Delivery> findAllOngoingLateDeliveries(PageDTO page) {
        return null;
    }

    @Override
    public Page<Delivery> findAllOngoingDeliveriesForCourierId(String id, PageDTO page) {
        DeliverySearchCriteriaDTO criteria = new DeliverySearchCriteriaDTO();
        criteria.setCourierIdEquals(id);
        criteria.setStatusIn(Arrays.asList(DeliveryStatusEnum.NEW,
                DeliveryStatusEnum.ASSIGNED, DeliveryStatusEnum.PICKED_UP));

        DeliverySearchSpecification spec = new DeliverySearchSpecification(criteria);
        return deliveryRepo.findAll(spec, page.toPageRequest());
    }

    @Override
    public Page<DeliveryDTO> search(DeliverySearchCriteriaDTO criteria) {
        DeliverySearchSpecification spec = new DeliverySearchSpecification(criteria);
        return deliveryRepo.findAll(spec, criteria.getPage().toPageRequest())
                .map(deliveryMapper::mapDeliveryToDTO);
    }
}
