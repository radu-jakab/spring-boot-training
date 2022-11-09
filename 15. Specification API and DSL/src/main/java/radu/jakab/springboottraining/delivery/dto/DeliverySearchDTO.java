package radu.jakab.springboottraining.delivery.dto;

import lombok.Data;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class DeliverySearchDTO {
    private List<DeliveryStatusEnum> statusIn;
    private String venueNameBeginsWith;
    private String id;
    private ZonedDateTime expectedDeliveryTimeBefore;
    private String courierId;
    private PageDTO page = new PageDTO(1, 1000, null, null);
}
