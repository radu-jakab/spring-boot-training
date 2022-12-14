package radu.jakab.springboottraining.delivery.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;
import radu.jakab.springboottraining.client.model.ClientAddress;
import radu.jakab.springboottraining.courier.model.Courier;
import radu.jakab.springboottraining.venue.model.Venue;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column
    @Enumerated(EnumType.STRING)
    private DeliveryStatusEnum status;

    @ManyToOne
    private Venue venue;

    @ManyToOne
    private ClientAddress clientAddress;

    @ManyToOne
    private Courier courier;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "delivery")
    private List<DeliveryProduct> products;

    @Column
    private BigDecimal deliveryCost;

    @Column
    private BigDecimal totalCost;

    @Column
    private ZonedDateTime expectedDeliveryTime;
}
