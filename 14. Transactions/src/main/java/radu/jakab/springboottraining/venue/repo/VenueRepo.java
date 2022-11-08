package radu.jakab.springboottraining.venue.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import radu.jakab.springboottraining.venue.model.Venue;

// tells Spring that this is a component (bean); not required, as extending JpaRepository automatically adds the annotation
@Repository
public interface VenueRepo extends JpaRepository<Venue, String> {
}
