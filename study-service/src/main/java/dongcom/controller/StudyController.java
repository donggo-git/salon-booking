package dongcom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import dongcom.mapper.StudyMapper;
import dongcom.modal.Study;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.UserDTO;
import dongcom.service.StudyService;

@RestController
@RequestMapping("/api/study")
@RequiredArgsConstructor
public class StudyController {
    private final StudyService studyService;

    @PostMapping
    public ResponseEntity<StudyDTO> createStudy(@RequestBody StudyDTO studyDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Study study = studyService.createStudy(studyDTO, userDTO);
        StudyDTO studyDTO1 = StudyMapper.mapToDTO(study);
        return ResponseEntity.ok(studyDTO1);
    }

    @PatchMapping("/{studyId}")
    public ResponseEntity<StudyDTO> updateStudy(
            @PathVariable Long studyId,
            @RequestBody StudyDTO studyDTO) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Study study = studyService.updateStudy(studyDTO, userDTO, studyId);
        StudyDTO studyDTO1 = StudyMapper.mapToDTO(study);
        return ResponseEntity.ok(studyDTO1);
    }
}
