package radu.jakab.springboottraining.delivery.dto;

import lombok.Data;
import radu.jakab.springboottraining.client.dto.ClientAddressDTO;
import radu.jakab.springboottraining.courier.dto.CourierDTO;
import radu.jakab.springboottraining.venue.dto.VenueDTO;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class DeliveryDTO {
    private String id;
    private VenueDTO venue;
    private ClientAddressDTO clientAddress;
    private CourierDTO courier;
    private List<DeliveryProductDTO> products;
    private BigDecimal deliveryCost;
    private BigDecimal totalCost;
    private ZonedDateTime expectedDeliveryTime;
}
