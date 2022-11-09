package radu.jakab.springboottraining.delivery.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import radu.jakab.springboottraining.courier.model.Courier_;
import radu.jakab.springboottraining.delivery.dto.DeliverySearchDTO;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.Delivery_;
import radu.jakab.springboottraining.venue.model.Venue_;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DeliverySpecifications implements Specification<Delivery> {

    private final DeliverySearchDTO dto;

    @Override
    public Predicate toPredicate(Root<Delivery> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> result = new ArrayList<>();

        if (dto.getStatusIn() != null && !dto.getStatusIn().isEmpty())
            result.add(cb.in(root.get(Delivery_.STATUS)).value(dto.getStatusIn()));

        if (dto.getVenueNameBeginsWith() != null)
            result.add(cb.like(root.get(Delivery_.VENUE).get(Venue_.NAME), dto.getVenueNameBeginsWith() + "%"));

        if (dto.getCourierId() != null)
            result.add(cb.equal(root.get(Delivery_.COURIER).get(Courier_.ID), dto.getCourierId()));

        if (dto.getExpectedDeliveryTimeBefore() != null)
            result.add(cb.lessThan(root.get(Delivery_.EXPECTED_DELIVERY_TIME), dto.getExpectedDeliveryTimeBefore()));

        if (dto.getId() != null)
            result.add(cb.equal(root.get(Delivery_.ID), dto.getId()));

        return cb.and(result.toArray(new Predicate[0]));
    }
}
