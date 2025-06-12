package dongcom.service;

import dongcom.domain.BookingStatus;
import dongcom.modal.Booking;
import dongcom.modal.StudyReport;
import dongcom.payload_dto.ServiceDTO;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.UserDTO;
import dongcom.payload_dto.BookingRequest;

import java.time.LocalDateTime;
import java.util.*;

public interface BookingService {
    Booking createBooking(BookingRequest booking, UserDTO userDTO, StudyDTO studyDTO, Set<ServiceDTO> serviceDTO)
            throws Exception;

    List<Booking> getBookingsByCustomer(Long customerId);

    List<Booking> getBookingByStudy(Long studyId);

    Booking getBookingById(Long id);

    Booking updateBooking(Long bookingId, BookingStatus status);

    List<Booking> getBookingByDate(LocalDateTime date, Long studyId);

    StudyReport getStudyReport(Long studyId);
}
