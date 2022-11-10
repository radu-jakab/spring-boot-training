package radu.jakab.springboottraining.client.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;
import radu.jakab.springboottraining.delivery.model.Delivery;

import java.util.List;

@Data
@Entity
public class ClientAddress {
    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    private String clientId;
    private String name;
    private Double lat;
    private Double lon;

    @OneToMany(mappedBy = "clientAddress")
    private List<Delivery> deliveries;
}
