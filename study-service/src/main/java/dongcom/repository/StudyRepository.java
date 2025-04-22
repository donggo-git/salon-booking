package dongcom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dongcom.modal.Study;

public interface StudyRepository extends JpaRepository<Study, Long> {
    Study findByOwnerId(Long id);

    @Query("select s from Study s where" +
            "(lower(s.city) like lower(concat('%', :keyword, '%')) OR " +
            "lower(s.name) like lower(concat('%', :keyword, '%')) OR " +
            "lower(s.address) like lower(concat('%', :keyword, '%')))")
    List<Study> searchStudy(@Param("keyword") String keyword);
}
