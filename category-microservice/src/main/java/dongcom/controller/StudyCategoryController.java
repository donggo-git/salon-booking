package dongcom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dongcom.service.CategoryService;

import java.util.*;

import dongcom.modal.Category;
import dongcom.payload_dto.StudyDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories/study-owner")
public class StudyCategoryController {
    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<Category> createCategory(
            @RequestBody Category category) {

        StudyDTO studyDTO = new StudyDTO();
        studyDTO.setId(1L);
        Category categories = categoryService.saveCategory(category, studyDTO);

        return ResponseEntity.ok(categories);
    };
}
