package dongcom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import dongcom.service.CategoryService;
import lombok.RequiredArgsConstructor;

import dongcom.modal.Category;
import java.util.*;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/study/{id}")
    public ResponseEntity<Set<Category>> getCategoriesByStudy(
            @PathVariable Long id) {
        Set<Category> categories = categoryService.getAllCategoryByStudy(id);

        return ResponseEntity.ok(categories);
    };

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(
            @PathVariable Long id) throws Exception {
        Category category = categoryService.getCategoryById(id);

        return ResponseEntity.ok(category);
    };

}
