package radu.jakab.springboottraining.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import radu.jakab.springboottraining.delivery.model.Delivery;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, String> {
}
