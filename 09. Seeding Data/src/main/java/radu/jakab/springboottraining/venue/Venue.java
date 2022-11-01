package radu.jakab.springboottraining.venue;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Table(name = "venue")
public class Venue {

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
    private String contactNumber;
}
