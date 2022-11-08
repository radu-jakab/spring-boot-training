package radu.jakab.springboottraining.client.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Table(name = "client_address")
public class ClientAddress {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column
    private String clientId;

    @Column
    private String clientName;

    @Column
    private Double lat;

    @Column
    private Double lon;
}
