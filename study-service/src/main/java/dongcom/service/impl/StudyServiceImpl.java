package dongcom.service.impl;

import dongcom.service.StudyService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import dongcom.modal.Study;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.UserDTO;
import dongcom.repository.StudyRepository;

@Service
@RequiredArgsConstructor
public class StudyServiceImpl implements StudyService {
    private final StudyRepository studyRepository;

    @Override
    public Study createStudy(StudyDTO req, UserDTO user) {
        Study study = new Study();
        study.setName(req.getName());
        study.setAddress(req.getAddress());
        study.setEmail(req.getCity());
        study.setCity(req.getCity());
        study.setImages(req.getImages());
        study.setOwnerId(user.getId());
        study.setOpenTime(req.getOpenTime());
        study.setCloseTime(req.getCloseTime());
        study.setPhoneNumber(req.getPhoneNumber());

        return studyRepository.save(study);
    }

    @Override
    public void updateStudy(StudyDTO req, UserDTO user, Long studyId) throws Exception {
        Study existingStudy = studyRepository.findById(req.getId()).orElse(null);

        if (existingStudy != null && existingStudy.getOwnerId().equals(user.getId())) {
            existingStudy.setName(req.getName());
            existingStudy.setAddress(req.getAddress());
            existingStudy.setEmail(req.getCity());
            existingStudy.setCity(req.getCity());
            existingStudy.setImages(req.getImages());
            existingStudy.setOwnerId(user.getId());
            existingStudy.setOpenTime(req.getOpenTime());
            existingStudy.setCloseTime(req.getCloseTime());
            existingStudy.setPhoneNumber(req.getPhoneNumber());

        }
        throw new Exception("study not exist");
    }

    @Override
    public List<Study> getAllStudies() {
        return studyRepository.findAll();
    }

    @Override
    public Study getStudyById(Long studyId) throws Exception {
        Study study = studyRepository.findById(studyId).orElse(null);
        if (study == null) {
            throw new Exception("study not exist");
        }
        return study;
    }

    @Override
    public Study getStudyByOwnerId(Long ownerId) {
        return studyRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Study> searchStudyByCityName(String city) {
        return studyRepository.searchStudy(city);
    }
}
