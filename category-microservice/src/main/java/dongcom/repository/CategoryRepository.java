package dongcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dongcom.modal.Category;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Set<Category> findByStudyId(Long studyId);
}
