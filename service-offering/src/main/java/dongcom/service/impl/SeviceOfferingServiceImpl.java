package dongcom.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import dongcom.modal.ServiceOffering;
import dongcom.payload_dto.CategoryDTO;
import dongcom.payload_dto.ServiceDTO;
import dongcom.payload_dto.StudyDTO;
import dongcom.service.ServiceOffieringService;

@Service
public class SeviceOfferingServiceImpl implements ServiceOffieringService {

    @Override
    public ServiceOffering createService(StudyDTO studyDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createService'");
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering service) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateService'");
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
