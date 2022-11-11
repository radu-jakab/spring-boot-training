package radu.jakab.springboottraining.delivery.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = "delivery")
@Entity
@Table(name = "delivery_product")
public class DeliveryProduct {
    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column
    private String name;

    @Column
    private BigDecimal cost;

    @Column
    private Double quantity;

    @ManyToOne
    private Delivery delivery;
}
