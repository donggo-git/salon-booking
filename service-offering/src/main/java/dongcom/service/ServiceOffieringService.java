package dongcom.service;

import dongcom.modal.ServiceOffering;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.CategoryDTO;

public interface ServiceOffieringService {
    ServiceOffering createService(StudyDTO studyDTO, CategoryDTO categoryDTO);
}
