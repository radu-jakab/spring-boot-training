package radu.jakab.springboottraining.client.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import radu.jakab.springboottraining.client.model.ClientAddress;

@Repository
public interface ClientAddressRepo extends JpaRepository<ClientAddress, String> {
}
