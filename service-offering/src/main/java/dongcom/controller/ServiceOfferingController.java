package dongcom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dongcom.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;

import java.util.*;
import dongcom.modal.ServiceOffering;

@RestController
@RequestMapping("/api/service-offering")
@RequiredArgsConstructor
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @GetMapping("/study/{studyId}")
    public ResponseEntity<Set<ServiceOffering>> getServiceBySalonId(
            @PathVariable Long studyId,
            @RequestParam(required = false) Long categoryId) {

        Set<ServiceOffering> serviceOffering = serviceOfferingService.getAllServiceByStudy(studyId, categoryId);
        return ResponseEntity.ok(serviceOffering);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOffering> getServiceById(@PathVariable Long id) throws Exception {
        ServiceOffering serviceOffering = serviceOfferingService.getServiceById(id);
        return ResponseEntity.ok(serviceOffering);
    }

    @GetMapping("/list/{ids}")
    public ResponseEntity<Set<ServiceOffering>> getServicesIds(
            @PathVariable Set<Long> ids) {

        Set<ServiceOffering> serviceOffering = serviceOfferingService.getServicesbyIds(ids);
        return ResponseEntity.ok(serviceOffering);
    }
}
