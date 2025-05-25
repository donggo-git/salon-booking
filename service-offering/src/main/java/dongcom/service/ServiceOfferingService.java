package dongcom.service;

import dongcom.modal.ServiceOffering;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.CategoryDTO;
import dongcom.payload_dto.ServiceDTO;
import java.util.*;

public interface ServiceOfferingService {
    ServiceOffering createService(StudyDTO studyDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO);

    ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception;

    Set<ServiceOffering> getAllServiceByStudy(Long studyId, Long categoryId);

    List<ServiceOffering> getServicesbyIds(Set<Long> ids);
}
