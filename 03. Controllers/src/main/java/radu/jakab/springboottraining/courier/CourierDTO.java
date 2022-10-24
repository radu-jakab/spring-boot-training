package radu.jakab.springboottraining.courier;

import lombok.Data;

// lombok
@Data
public class CourierDTO {
    private String id;
    private String name;
    private double lat;
    private double lon;
    private boolean active;
}
