package com.example.demo.venue.dto;

import lombok.Data;

@Data
public class VenueDTO {
    private String id;
    private String name;
    private Double lat;
    private Double lon;
    private String contactNumber;
}
