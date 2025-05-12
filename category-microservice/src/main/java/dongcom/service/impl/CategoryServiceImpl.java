package dongcom.service.impl;

import java.util.Locale.Category;

import org.springframework.stereotype.Service;

import java.util.Set;

import dongcom.payload_dto.StudyDTO;
import dongcom.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    Category saveCategory(Category category, StudyDTO studyDTO) {
    }

    @Override
    Set<Category> getAllCategoryByStudy(Long id) {
    }

    @Override
    Category getCategoryById(Long id) {
    }

    @Override
    void deleteCategoryById(Long id) {
    }
}
