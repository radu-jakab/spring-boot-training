package com.example.demo.courier.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
public class Courier {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;
    private String name;
    private Double lat;
    private Double lon;
    private Boolean active;
}
