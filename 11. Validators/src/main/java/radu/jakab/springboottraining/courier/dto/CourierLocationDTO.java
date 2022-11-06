package radu.jakab.springboottraining.courier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourierLocationDTO {
    private String id;
    private Double lat;
    private Double lon;
}
