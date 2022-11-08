package radu.jakab.springboottraining.client.dto;

import lombok.Data;

@Data
public class ClientAddressDTO {
    private String id;
    private String clientId;
    private String clientName;
    private Double lat;
    private Double lon;
}
