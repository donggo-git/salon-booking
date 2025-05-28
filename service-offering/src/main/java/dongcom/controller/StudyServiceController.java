package dongcom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dongcom.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import java.util.*;
import java.util.Locale.Category;

import dongcom.modal.ServiceOffering;
import dongcom.payload_dto.CategoryDTO;
import dongcom.payload_dto.ServiceDTO;
import dongcom.payload_dto.StudyDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class StudyServiceController {
    private final ServiceOfferingService serviceOfferingService;

    @PostMapping
    public ResponseEntity<ServiceOffering> createService(
            @PathVariable ServiceDTO serviceDTO) {
        StudyDTO studyDTO = new StudyDTO();
        studyDTO.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategoryId());

        ServiceOffering serviceOfferings = serviceOfferingService.createService(studyDTO, serviceDTO, categoryDTO);
        return ResponseEntity.ok(serviceOfferings);
    }
}
