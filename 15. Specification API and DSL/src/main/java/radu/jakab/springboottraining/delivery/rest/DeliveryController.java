package radu.jakab.springboottraining.delivery.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import radu.jakab.springboottraining.delivery.dto.DeliveryDTO;
import radu.jakab.springboottraining.delivery.dto.DeliverySearchDTO;
import radu.jakab.springboottraining.delivery.model.DeliveryStatusEnum;
import radu.jakab.springboottraining.delivery.service.DeliveryQueryAPI;
import radu.jakab.springboottraining.delivery.service.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final DeliveryQueryAPI deliveryQueryAPI;

    @PostMapping("request-new")
    public ResponseEntity<DeliveryDTO> requestDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        DeliveryDTO result = deliveryService.requestDelivery(deliveryDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("assign")
    public ResponseEntity<DeliveryDTO> assignDelivery(@RequestParam String courierId,
                                                      @RequestParam String deliveryId) {
        DeliveryDTO result = deliveryService.assignDelivery(courierId, deliveryId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("with-status")
    public ResponseEntity<List<DeliveryDTO>> getAllDeliveriesWithStatus(@RequestParam DeliveryStatusEnum status) {
        List<DeliveryDTO> result = deliveryQueryAPI.getAllDeliveriesWithStatus(status);
        return ResponseEntity.ok(result);
    }

    @GetMapping("all-ongoing")
    public ResponseEntity<List<DeliveryDTO>> getAllOngoingDeliveries() {
        List<DeliveryDTO> result = deliveryQueryAPI.getAllOngoingDeliveries();
        return ResponseEntity.ok(result);
    }

    @GetMapping("all-ongoing-late")
    public ResponseEntity<List<DeliveryDTO>> getAllOngoingLateDeliveries() {
        List<DeliveryDTO> result = deliveryQueryAPI.getAllOngoingLateDeliveries();
        return ResponseEntity.ok(result);
    }

    @GetMapping("search")
    public ResponseEntity<Page<DeliveryDTO>> search(@RequestBody DeliverySearchDTO dto) {
        Page<DeliveryDTO> result = deliveryQueryAPI.search(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("all-ongoing-for-courier")
    public ResponseEntity<List<DeliveryDTO>> getAllOngoingDeliveriesForCourier(@RequestParam String courierId) {
        List<DeliveryDTO> result = deliveryQueryAPI.getAllOngoingDeliveriesForCourier(courierId);
        return ResponseEntity.ok(result);
    }
}
