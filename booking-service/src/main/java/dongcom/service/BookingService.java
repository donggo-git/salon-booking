package dongcom.service;

import dongcom.domain.BookingStatus;
import dongcom.modal.Booking;
import dongcom.modal.StudyReport;
import dongcom.payload_dto.ServiceDTO;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.UserDTO;
import dongcom.payload_dto.BookingRequest;

import java.time.LocalDate;
import java.util.*;

public interface BookingService {
    Booking createBooking(BookingRequest booking, UserDTO userDTO, StudyDTO studyDTO, Set<ServiceDTO> serviceDTO)
            throws Exception;

    List<Booking> getBookingsByCustomer(Long customerId);

    List<Booking> getBookingByStudy(Long studyId);

    Booking getBookingById(Long id) throws Exception;

    Booking updateBooking(Long bookingId, BookingStatus status) throws Exception;

    List<Booking> getBookingByDate(LocalDate date, Long studyId);

    StudyReport getStudyReport(Long studyId);
}
