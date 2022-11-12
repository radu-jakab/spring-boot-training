package radu.jakab.springboottraining.delivery.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.dto.DeliverySearchCriteriaDTO;
import radu.jakab.springboottraining.delivery.service.DeliverySearchAPI;
import radu.jakab.springboottraining.delivery.service.DeliveryService;

@RestController
@RequestMapping("delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private DeliveryService deliveryService;

    private DeliverySearchAPI deliverySearchAPI;

    @PostMapping("request-new")
    public ResponseEntity<DeliveryDTO> requestDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        DeliveryDTO result = deliveryService.requestDelivery(deliveryDTO);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<Page<DeliveryDTO>> search(@RequestBody DeliverySearchCriteriaDTO criteria) {
        Page<DeliveryDTO> result = deliverySearchAPI.search(criteria);
        return ResponseEntity.ok(result);
    }
}
