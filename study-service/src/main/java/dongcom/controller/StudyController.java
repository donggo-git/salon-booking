package dongcom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import dongcom.modal.Study;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.UserDTO;
import dongcom.service.StudyService;

@RestController
@RequestMapping("/api/studies")
@RequiredArgsConstructor
public class StudyController {
    private final StudyService studyService;

    public ResponseEntity<StudyDTO> createStudy(@RequestBody StudyDTO studyDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Study study = studyService.createStudy(studyDTO, userDTO);

        return null;
    }
}
