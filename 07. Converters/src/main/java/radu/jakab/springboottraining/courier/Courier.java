package radu.jakab.springboottraining.courier;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Table(name = "courier")
public class Courier {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column
    private String name;

    @Column
    private Double lat;

    @Column
    private Double lon;

    @Column
    private Boolean active;
}
