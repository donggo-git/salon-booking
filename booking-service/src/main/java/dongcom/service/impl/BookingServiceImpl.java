package dongcom.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import dongcom.domain.BookingStatus;
import dongcom.modal.Booking;
import dongcom.modal.StudyReport;
import dongcom.payload_dto.BookingRequest;
import dongcom.payload_dto.ServiceDTO;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.UserDTO;
import dongcom.repository.BookingRepository;
import dongcom.service.BookingService;;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public Booking createBooking(BookingRequest booking, UserDTO userDTO, StudyDTO studyDTO,
            Set<ServiceDTO> serviceDTO) {
        // TODO Auto-generated method stub
        int totalDuration = serviceDTO.stream().mapToInt(ServiceDTO::getDuration).sum();

        LocalDateTime bookingStartTime = booking.getStartTime();
        LocalDateTime bookingEndTime = bookingStartTime.plusMinutes(totalDuration);
        throw new UnsupportedOperationException("Unimplemented method 'createBooking'");
    }

    public Boolean isTimeSlotAvailable(StudyDTO studyDTO, LocalDateTime bookingStartTime,
            LocalDateTime bookingEndTime) throws Exception {

        LocalDateTime studyOpenTime = studyDTO.getOpenTime().atDate(bookingStartTime.toLocalDate());
        LocalDateTime studyCloseTime = studyDTO.getOpenTime().atDate(bookingEndTime.toLocalDate());

        if (bookingStartTime.isBefore(studyOpenTime) || bookingEndTime.isAfter(studyCloseTime))
            throw new Exception("Booking time must be in study service's working hour");
        return true;
    }

    @Override
    public List<Booking> getBookingsByCustomer(Long customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingsByCustomer'");
    }

    @Override
    public List<Booking> getBookingByStudy(Long studyId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingByStudy'");
    }

    @Override
    public Booking getBookingById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingById'");
    }

    @Override
    public Booking updateBooking(Long bookingId, BookingStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBooking'");
    }

    @Override
    public List<Booking> getBookingByDate(LocalDateTime date, Long studyId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingByDate'");
    }

    @Override
    public StudyReport getStudyReport(Long studyId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudyReport'");
    }

}
