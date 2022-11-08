package radu.jakab.springboottraining.delivery.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DeliveryProductDTO {
    private String id;
    private String name;
    private BigDecimal cost;
    private Double quantity;
}
