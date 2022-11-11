package radu.jakab.springboottraining.delivery.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import radu.jakab.springboottraining.client.dto.ClientAddressDTO;
import radu.jakab.springboottraining.courier.dto.CourierDTO;
import radu.jakab.springboottraining.venue.VenueDTO;

import java.math.BigDecimal;
import java.util.List;

@Data
public class DeliveryDTO {
    private String id;

    @NotNull
    private VenueDTO venue;
    private CourierDTO courier;
    private ClientAddressDTO clientAddress;
    private List<DeliveryProductDTO> products;
    private BigDecimal deliveryCost;
    private BigDecimal totalValue;
    private BigDecimal expectedDeliveryTime;
}
