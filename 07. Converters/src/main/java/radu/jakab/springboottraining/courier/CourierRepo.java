package radu.jakab.springboottraining.courier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// tells Spring that this is a component (bean); not required, as extending JpaRepository automatically adds the annotation
@Repository
public interface CourierRepo extends JpaRepository<Courier, String> {
}
