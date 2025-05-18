package dongcom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @PostMapping()
    public ResponseEntity<Category> createCategory(
            @RequestBody Category category) {

        StudyDTO studyDTO = new StudyDTO();
        studyDTO.setId(1L);
        Category savedCategory = categoryService.saveCategory(category, studyDTO);

        return ResponseEntity.ok(savedCategory);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(
            @PathVariable Long id) throws Exception {

        StudyDTO studyDTO = new StudyDTO();
        studyDTO.setId(1L);
        categoryService.deleteCategoryById(id, studyDTO.getId());
        ;

        return ResponseEntity.ok("Delete success category");
    };
}
