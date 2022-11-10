package radu.jakab.springboottraining.courier;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;
import radu.jakab.springboottraining.delivery.model.Delivery;

import java.util.List;

@Data
@Entity
@Table(name = "courier")
public class Courier {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    private String name;
    private Double lat;
    private Double lon;
    private Boolean active;

    @OneToMany(mappedBy = "courier")
    private List<Delivery> deliveries;
}
