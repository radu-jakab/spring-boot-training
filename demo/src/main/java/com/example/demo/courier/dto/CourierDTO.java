package com.example.demo.courier.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "This is a courier")
public class CourierDTO {

    @Schema(name = "This is the ID, use UUID", nullable = true)
    private String id;
    private String name;
    private Double lat;
    private Double lon;
    private Boolean active;
}
