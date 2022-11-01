package radu.jakab.springboottraining.venue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Venue", description = "Model for Venue objects")
public class VenueDTO {

    @Schema(description = "A String value that is a unique ID of this venue", required = true)
    private String id;

    @Schema(description = "The name of this venue", required = true)
    private String name;

    @Schema(description = "The GPS latitude of the venue, to be used for pickup coordinates. " +
            "Valid values are floating point between 0 and 90", required = true)
    private Double lat;

    @Schema(description = "The GPS longitude of the venue, to be used for pickup coordinates. " +
            "Valid values are floating point between 0 and 90", required = true)
    private Double lon;

    @Schema(description = "Contact phone number for this location; optional")
    private String contactNumber;
}
