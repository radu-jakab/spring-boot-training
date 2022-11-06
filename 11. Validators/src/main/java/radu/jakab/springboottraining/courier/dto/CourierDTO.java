package radu.jakab.springboottraining.courier.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierDTO {

    @Parameter(description = "A String value that is a unique ID of this courier", required = true)
    private String id;
    private String name;
    private Double lat;
    private Double lon;
    private Boolean active;
}
