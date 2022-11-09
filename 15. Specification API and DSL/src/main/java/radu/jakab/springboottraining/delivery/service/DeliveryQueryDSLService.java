package radu.jakab.springboottraining.delivery.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.dto.DeliverySearchDTO;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;
import radu.jakab.springboottraining.delivery.model.QDelivery;
import radu.jakab.springboottraining.delivery.repo.DeliveryRepo;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class DeliveryQueryDSLService implements DeliveryQueryAPI {

    private final DeliveryRepo deliveryRepo;
    private final DeliveryMapper deliveryMapper;

    @Override
    public List<DeliveryDTO> getAllDeliveriesWithStatus(DeliveryStatusEnum status) {
        QDelivery delivery = QDelivery.delivery;
        BooleanExpression haveStatus = delivery.status.eq(status);
        List<Delivery> result = IterableUtils.toList(deliveryRepo.findAll(haveStatus));
        return result.stream()
                .map(deliveryMapper::mapDeliveryToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DeliveryDTO> getAllOngoingDeliveries() {
        QDelivery delivery = QDelivery.delivery;
        BooleanExpression areOngoing = delivery.status.in(Arrays.asList(DeliveryStatusEnum.NEW, DeliveryStatusEnum.ASSIGNED, DeliveryStatusEnum.PICKED_UP));
        List<Delivery> result = IterableUtils.toList(deliveryRepo.findAll(areOngoing));
        return result.stream()
                .map(deliveryMapper::mapDeliveryToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DeliveryDTO> getAllOngoingLateDeliveries() {
        QDelivery delivery = QDelivery.delivery;
        BooleanExpression areOngoing = delivery.status.in(Arrays.asList(DeliveryStatusEnum.NEW, DeliveryStatusEnum.ASSIGNED, DeliveryStatusEnum.PICKED_UP));
        BooleanExpression haveLateStatus = delivery.expectedDeliveryTime.after(ZonedDateTime.now());
        List<Delivery> result = IterableUtils.toList(deliveryRepo.findAll(areOngoing.and(haveLateStatus)));
        return result.stream()
                .map(deliveryMapper::mapDeliveryToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DeliveryDTO> getAllOngoingDeliveriesForCourier(String courierId) {
        QDelivery delivery = QDelivery.delivery;
        BooleanExpression areOngoing = delivery.status.in(Arrays.asList(DeliveryStatusEnum.NEW, DeliveryStatusEnum.ASSIGNED, DeliveryStatusEnum.PICKED_UP));
        BooleanExpression haveCourier = delivery.courier.id.eq(courierId);
        List<Delivery> result = IterableUtils.toList(deliveryRepo.findAll(areOngoing.and(haveCourier)));
        return result.stream()
                .map(deliveryMapper::mapDeliveryToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<DeliveryDTO> search(DeliverySearchDTO dto) {
        QDelivery delivery = QDelivery.delivery;

        // build predicate
        BooleanBuilder builder = new BooleanBuilder();
        if (dto.getStatusIn() != null) builder.and(delivery.status.in(dto.getStatusIn()));
        if (dto.getCourierId() != null) builder.and(delivery.courier.id.eq(dto.getCourierId()));
        if (dto.getVenueNameBeginsWith() != null)
            builder.and(delivery.venue.name.startsWith(dto.getVenueNameBeginsWith()));
        if (dto.getId() != null) builder.and(delivery.id.eq(dto.getId()));
        if (dto.getExpectedDeliveryTimeBefore() != null)
            builder.and(delivery.expectedDeliveryTime.before(dto.getExpectedDeliveryTimeBefore()));

        if (builder.getValue() != null) {
            return deliveryRepo.findAll(builder.getValue(), dto.getPage().toPageRequest())
                    .map(deliveryMapper::mapDeliveryToDTO);
        } else {
            return Page.empty();
        }
    }
}
