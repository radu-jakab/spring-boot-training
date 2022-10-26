package radu.jakab.springboottraining.courier;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

@Data
public class CourierDTO {

    @Parameter(description = "A String value that is a unique ID of this courier", required = true)
    private String id;
    private String name;
    private Double lat;
    private Double lon;
    private Boolean active;
}
