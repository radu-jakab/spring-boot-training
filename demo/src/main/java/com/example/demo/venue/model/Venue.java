package com.example.demo.venue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Table(name = "my_venues")
public class Venue {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    private String name;
    private Double lat;
    private Double lon;
    private String contactNumber;
}
