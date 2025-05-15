package dongcom.service;

import dongcom.modal.Category;
import dongcom.payload_dto.StudyDTO;
import java.util.Set;

public interface CategoryService {

    Category saveCategory(Category category, StudyDTO studyDTO);

    Set<Category> getAllCategoryByStudy(Long id);

    Category getCategoryById(Long id) throws Exception;

    void deleteCategoryById(Long id, Long studyId) throws Exception;
};
