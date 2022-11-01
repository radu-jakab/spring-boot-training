package radu.jakab.springboottraining.venue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
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
