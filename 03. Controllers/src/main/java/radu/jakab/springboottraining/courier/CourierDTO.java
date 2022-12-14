package radu.jakab.springboottraining.courier;

import lombok.Data;

@Data
public class CourierDTO {
    private String id;
    private String name;
    private Double lat;
    private Double lon;
    private Boolean active;
}
