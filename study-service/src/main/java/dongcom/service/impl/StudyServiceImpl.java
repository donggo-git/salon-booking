package dongcom.service.impl;

import dongcom.service.StudyService;

import java.util.List;

import dongcom.modal.Study;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.UserDTO;

public class StudyServiceImpl implements StudyService {

    @Override
    public Study createStudy(StudyDTO study, UserDTO user) {
        return null;
    }

    @Override
    public Study updateStudy(StudyDTO study, UserDTO user, Long studyId) {
        return null;
    }

    @Override
    public List<Study> getAllStudies() {
        return List.of();
    }

    public Study getStudyById(Long studyId) {
        return null;
    }

    @Override
    public Study getStudyByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public List<Study> searchStudyByCityName(String city) {
        return List.of();
    }
}
