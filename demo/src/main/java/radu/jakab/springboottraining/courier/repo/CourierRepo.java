package radu.jakab.springboottraining.courier.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import radu.jakab.springboottraining.courier.model.Courier;

// tells Spring that this is a component (bean); not required, as extending JpaRepository automatically adds the annotation
@Repository
public interface CourierRepo extends JpaRepository<Courier, String> {

    @Modifying
    @Query("update Courier c set c.lat=:lat, c.lon=:lon where c.id=:id")
    void updateCourierLocation(@Param("id") String id,
                               @Param("lat") Double lat,
                               @Param("lon") Double lon);
}
