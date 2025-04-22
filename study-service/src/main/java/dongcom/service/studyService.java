package dongcom.service;

import java.util.List;

import dongcom.modal.Study;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.UserDTO;

public interface StudyService {
    Study createStudy(StudyDTO study, UserDTO user);

    void updateStudy(StudyDTO study, UserDTO user, Long studyId) throws Exception;

    List<Study> getAllStudies();

    Study getStudyById(Long studyId);

    Study getStudyByOwnerId(Long ownerId);

    List<Study> searchStudyByCityName(String city);
}
