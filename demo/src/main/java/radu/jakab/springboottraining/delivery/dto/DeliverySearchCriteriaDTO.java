package radu.jakab.springboottraining.delivery.dto;

import lombok.Data;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class DeliverySearchCriteriaDTO {

    private List<DeliveryStatusEnum> statusIn;
    private ZonedDateTime expectedDeliveryTimeBefore;
    private String venueNameLike;
    private Double latGreaterThan;
    private Double latLessThan;
    private String courierIdEquals;
    private PageDTO page;
}
