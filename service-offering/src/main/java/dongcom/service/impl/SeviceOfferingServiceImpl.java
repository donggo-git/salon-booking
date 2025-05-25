package dongcom.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import dongcom.modal.ServiceOffering;
import dongcom.payload_dto.CategoryDTO;
import dongcom.payload_dto.ServiceDTO;
import dongcom.payload_dto.StudyDTO;
import dongcom.repository.ServiceOfferingRepository;
import dongcom.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeviceOfferingServiceImpl implements ServiceOfferingService {
    private final ServiceOfferingRepository serviceOfferingRepository;

    @Override
    public ServiceOffering createService(StudyDTO studyDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO) {
        // TODO Auto-generated method stub
        ServiceOffering serviceOffering = new ServiceOffering();
        serviceOffering.setImage(serviceDTO.getImage());
        serviceOffering.setStudyId(studyDTO.getId());
        serviceOffering.setName(serviceDTO.getName());
        serviceOffering.setDescription(serviceDTO.getDescription());
        serviceOffering.setCategoryId(serviceDTO.getCategoryId());
        serviceOffering.setPrice(serviceDTO.getPrice());
        serviceOffering.setDuration(serviceDTO.getDuration());

        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception {
        // TODO Auto-generated method stub

        ServiceOffering serviceOffering = serviceOfferingRepository.findById(serviceId).orElse(null);

        if (serviceOffering == null)
            throw new Exception("Service not exist with id: " + serviceId);

        serviceOffering.setImage(service.getImage());
        serviceOffering.setName(service.getName());
        serviceOffering.setDescription(service.getDescription());
        serviceOffering.setPrice(service.getPrice());
        serviceOffering.setDuration(service.getDuration());

        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public Set<ServiceOffering> getAllServiceByStudy(Long studyId, Long categoryId) {
        // TODO Auto-generated method stub

        throw new UnsupportedOperationException("Unimplemented method 'getAllServiceByStudy'");
    }

    @Override
    public List<ServiceOffering> getServicesbyIds(Set<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getServicesbyIds'");
    }

}
