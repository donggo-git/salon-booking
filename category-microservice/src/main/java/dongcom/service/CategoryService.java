package dongcom.service;

import java.util.Locale.Category;
import dongcom.payload_dto.StudyDTO;
import java.util.Set;

public interface CategoryService {

    Category saveCategory(Category category, StudyDTO studyDTO);

    Set<Category> getAllCategoryByStudy(Long id);

    Category getCategoryById(Long id);

    void deleteCategoryById(Long id);
};
