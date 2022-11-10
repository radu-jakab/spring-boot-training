package radu.jakab.springboottraining.delivery.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;
import radu.jakab.springboottraining.client.model.ClientAddress;
import radu.jakab.springboottraining.courier.Courier;
import radu.jakab.springboottraining.venue.Venue;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @ManyToOne
    private Venue venue;

    @ManyToOne
    private ClientAddress clientAddress;

    @ManyToOne
    private Courier courier;

    @OneToMany
    private List<DeliveryProduct> products;

    private BigDecimal deliveryCost;
    private BigDecimal totalValue;
    private BigDecimal expectedDeliveryTime;
}
