package dongcom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dongcom.service.ServiceOfferingService;
import java.util.*;
import dongcom.modal.ServiceOffering;

@RestController
@RequestMapping("/api/service-offering")
public class ServiceOfferingController {

    private ServiceOfferingService serviceOfferingService;

    public ResponseEntity<Set<ServiceOffering>> getServiceBySalonId() {
    }
}
