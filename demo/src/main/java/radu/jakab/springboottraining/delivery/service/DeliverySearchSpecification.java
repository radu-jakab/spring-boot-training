package radu.jakab.springboottraining.delivery.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import radu.jakab.springboottraining.delivery.dto.DeliverySearchCriteriaDTO;
import radu.jakab.springboottraining.delivery.model.Delivery;
import radu.jakab.springboottraining.delivery.model.Delivery_;
import radu.jakab.springboottraining.venue.model.Venue_;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DeliverySearchSpecification implements Specification<Delivery> {

    private final DeliverySearchCriteriaDTO criteria;

    @Override
    public Predicate toPredicate(Root<Delivery> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> result = new ArrayList<>();

        if (criteria.getVenueNameLike() != null)
            result.add(cb.like(root.get(Delivery_.VENUE).get(Venue_.NAME), criteria.getVenueNameLike() + "%"));

        if (criteria.getStatusIn() != null)
            result.add(cb.in(root.get(Delivery_.STATUS)).value(criteria.getStatusIn()));

        /// 5 prdeicate

        return cb.and(result.toArray(new Predicate[0]));
    }
}
