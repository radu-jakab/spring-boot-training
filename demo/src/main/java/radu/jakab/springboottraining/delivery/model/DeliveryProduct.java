package radu.jakab.springboottraining.delivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;

@Data
@Entity
public class DeliveryProduct {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    private String name;
    private Double quantity;
    private BigDecimal cost;

    @ManyToOne
    private Delivery delivery;
}
