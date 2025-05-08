package dongcom.mapper;

import dongcom.modal.Study;
import dongcom.payload_dto.StudyDTO;

public class StudyMapper {
    public static StudyDTO mapToDTO(Study study) {
        StudyDTO studyDTO = new StudyDTO();
        studyDTO.setId(study.getId());
        studyDTO.setName(study.getName());
        studyDTO.setAddress(study.getAddress());
        studyDTO.setCity(study.getCity());
        studyDTO.setImages(study.getImages());
        studyDTO.setCloseTime(study.getCloseTime());
        studyDTO.setOpenTime(study.getOpenTime());
        studyDTO.setPhoneNumber(study.getPhoneNumber());
        studyDTO.setOwnerId(study.getOwnerId());
        studyDTO.setEmail(study.getEmail());

        return studyDTO;
    }

}
