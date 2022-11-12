package radu.jakab.springboottraining.delivery.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
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
import radu.jakab.springboottraining.delivery.model.QDelivery;
import radu.jakab.springboottraining.delivery.repo.DeliveryRepo;

import java.time.ZonedDateTime;
import java.util.Arrays;

@Service
@Profile(DeliveryAppProfiles.PROD)
@RequiredArgsConstructor
public class DeliverySearchDSLService implements DeliverySearchAPI {

    private final DeliveryRepo deliveryRepo;

    private final DeliveryMapper deliveryMapper;

    @Override
    public Page<Delivery> findAllByStatusEquals(DeliveryStatusEnum status, PageDTO page) {
        QDelivery delivery = QDelivery.delivery;
        BooleanExpression hasStatus = delivery.status.eq(status);
        return deliveryRepo.findAll(hasStatus, page.toPageRequest());
    }

    @Override
    public Page<Delivery> findAllOngoingDeliveries(PageDTO page) {
        QDelivery delivery = QDelivery.delivery;
        BooleanExpression hasStatus = delivery.status.in(Arrays.asList(
                DeliveryStatusEnum.NEW, DeliveryStatusEnum.ASSIGNED, DeliveryStatusEnum.PICKED_UP
        ));
        return deliveryRepo.findAll(hasStatus, page.toPageRequest());
    }

    @Override
    public Page<Delivery> findAllOngoingLateDeliveries(PageDTO page) {
        QDelivery delivery = QDelivery.delivery;
        BooleanExpression withStatus = delivery.status.in(Arrays.asList(
                DeliveryStatusEnum.NEW, DeliveryStatusEnum.ASSIGNED, DeliveryStatusEnum.PICKED_UP
        ));
        BooleanExpression areLate = delivery.expectedDeliveryTime.before(ZonedDateTime.now());
        return deliveryRepo.findAll(withStatus.and(areLate), page.toPageRequest());
    }

    @Override
    public Page<Delivery> findAllOngoingDeliveriesForCourierId(String id, PageDTO page) {
        return null;
    }

    @Override
    public Page<DeliveryDTO> search(DeliverySearchCriteriaDTO criteria) {
        QDelivery delivery = QDelivery.delivery;
        BooleanBuilder builder = new BooleanBuilder();

        if (criteria.getStatusIn() != null) {
            BooleanExpression p = delivery.status.in(criteria.getStatusIn());
            builder.and(p);
        }

        if (criteria.getExpectedDeliveryTimeBefore() != null) {
            BooleanExpression p = delivery.expectedDeliveryTime.before(criteria.getExpectedDeliveryTimeBefore());
            builder.and(p);
        }

        if (criteria.getCourierIdEquals() != null) {
            BooleanExpression p = delivery.courier.id.eq(criteria.getCourierIdEquals());
            builder.and(p);
        }

        if (criteria.getLatGreaterThan() != null) {
            BooleanExpression p = delivery.clientAddress.lat.gt(criteria.getLatGreaterThan());
            builder.and(p);
        }

        if (criteria.getLatLessThan() != null) {
            BooleanExpression p = delivery.clientAddress.lat.lt(criteria.getLatLessThan());
            builder.and(p);
        }

        if (criteria.getVenueNameLike() != null) {
            BooleanExpression p = delivery.venue.name.like("%" + criteria.getVenueNameLike() + "%");
            builder.and(p);
        }

        Page<Delivery> result = deliveryRepo.findAll(builder.getValue(), criteria.getPage().toPageRequest());
        return result.map(deliveryMapper::mapDeliveryToDTO);
    }

}
