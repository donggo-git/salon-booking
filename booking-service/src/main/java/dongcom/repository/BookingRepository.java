package dongcom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dongcom.modal.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomerId(Long customerId);

    List<Booking> findByStudyId(Long studyId);
}
