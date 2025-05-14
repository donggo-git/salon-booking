package dongcom.service.impl;

import dongcom.modal.Category;

import org.springframework.stereotype.Service;

import java.util.Set;

import dongcom.payload_dto.StudyDTO;
import dongcom.repository.CategoryRepository;
import dongcom.service.CategoryService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category, StudyDTO studyDTO) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setStudyId(category.getStudyId());
        newCategory.setImage(category.getImage());

        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<Category> getAllCategoryByStudy(Long id) {
        return categoryRepository.findByStudyId(id);
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null) {
            throw new Exception("category not exist with id " + id);
        }

        return category;
    }

    @Override
    public void deleteCategoryById(Long id) throws Exception {
        Category category = getCategoryById(id);
        categoryRepository.deleteById(id);
    }
}
