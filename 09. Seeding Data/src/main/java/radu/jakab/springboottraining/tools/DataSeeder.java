package radu.jakab.springboottraining.tools;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import radu.jakab.springboottraining.courier.CourierService;
import radu.jakab.springboottraining.courier.dto.CourierDTO;
import radu.jakab.springboottraining.venue.VenueDTO;
import radu.jakab.springboottraining.venue.VenueService;

// this is the most generic type of component, but required for Spring to load and run it
@Component
// build a constructor for all final fields, this will handle autowiring
@RequiredArgsConstructor
public class DataSeeder implements ApplicationRunner {

    private final VenueService venueService;
    private final CourierService courierService;

    @Override
    public void run(ApplicationArguments args) {
        venueService.create(new VenueDTO("DataSeeder-ID1", "Venue 1", 25.1, 26.3, "+40 700 000 000"));
        venueService.create(new VenueDTO("DataSeeder-ID2", "Venue 2", 25.2, 26.5, "+40 700 000 001"));
        venueService.create(new VenueDTO("DataSeeder-ID3", "Venue 3", 25.3, 26.9, "+40 700 000 002"));
        venueService.create(new VenueDTO("DataSeeder-ID4", "Venue 4", 25.4, 26.1, "+40 700 000 003"));

        courierService.create(new CourierDTO("DataSeeder-ID1", "Courier 1", 25.1, 26.3, false));
        courierService.create(new CourierDTO("DataSeeder-ID2", "Courier 2", 25.5, 26.1, false));
        courierService.create(new CourierDTO("DataSeeder-ID3", "Courier 3", 25.3, 26.45, false));
        courierService.create(new CourierDTO("DataSeeder-ID4", "Courier 4", 25.2, 26.4, false));
    }
}
