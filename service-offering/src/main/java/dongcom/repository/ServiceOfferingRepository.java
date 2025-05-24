package dongcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dongcom.modal.ServiceOffering;
import java.util.*;

public interface ServiceOfferingRepository extends JpaRepository<ServiceOffering, Long> {

    Set<ServiceOffering> findByStudyId(Long studyId);
}
