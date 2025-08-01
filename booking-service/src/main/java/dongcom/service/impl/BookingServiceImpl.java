package dongcom.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dongcom.domain.BookingStatus;
import dongcom.modal.Booking;
import dongcom.modal.StudyReport;
import dongcom.payload_dto.BookingRequest;
import dongcom.payload_dto.ServiceDTO;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.UserDTO;
import dongcom.repository.BookingRepository;
import dongcom.service.BookingService;
import lombok.RequiredArgsConstructor;;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public Booking createBooking(BookingRequest booking, UserDTO userDTO, StudyDTO studyDTO,
            Set<ServiceDTO> serviceDTOSet) throws Exception {
        // TODO Auto-generated method stub
        int totalDuration = serviceDTOSet.stream().mapToInt(ServiceDTO::getDuration).sum();

        LocalDateTime bookingStartTime = booking.getStartTime();
        LocalDateTime bookingEndTime = bookingStartTime.plusMinutes(totalDuration);

        Boolean isSlotAvailable = isTimeSlotAvailable(studyDTO, bookingStartTime, bookingEndTime);
        int totalPrice = serviceDTOSet.stream().mapToInt(ServiceDTO::getPrice).sum();
        Set<Long> idList = serviceDTOSet.stream().map(ServiceDTO::getId).collect(Collectors.toSet());

        Booking newBooking = new Booking();
        newBooking.setCustomerId(userDTO.getId());
        newBooking.setStudyId(studyDTO.getId());
        newBooking.setServiceIds(idList);
        newBooking.setStatus(BookingStatus.PENDING);
        newBooking.setStartTime(bookingStartTime);
        newBooking.setEndTime(bookingEndTime);
        newBooking.setTotalPrice(totalPrice);

        return bookingRepository.save(newBooking);
    }

    public Boolean isTimeSlotAvailable(StudyDTO studyDTO, LocalDateTime bookingStartTime,
            LocalDateTime bookingEndTime) throws Exception {

        LocalDateTime studyOpenTime = studyDTO.getOpenTime().atDate(bookingStartTime.toLocalDate());
        LocalDateTime studyCloseTime = studyDTO.getOpenTime().atDate(bookingEndTime.toLocalDate());
        List<Booking> existingBookings = getBookingByStudy(studyDTO.getId());

        if (bookingStartTime.isBefore(studyOpenTime) || bookingEndTime.isAfter(studyCloseTime))
            throw new Exception("Booking time must be in study service's working hour");

        for (Booking existingBooking : existingBookings) {
            LocalDateTime existingBookingStartTime = existingBooking.getStartTime();
            LocalDateTime existingBookingEndTime = existingBooking.getEndTime();

            if (bookingStartTime.isBefore(existingBookingEndTime) && bookingEndTime.isAfter(existingBookingStartTime)) {
                throw new Exception("slot í not available, choose different time");
            }

            if (bookingStartTime.isEqual(existingBookingStartTime) || bookingEndTime.isEqual(existingBookingEndTime)) {
                throw new Exception("slot í not available, choose different time");
            }
        }

        return true;

    }

    @Override
    public List<Booking> getBookingsByCustomer(Long customerId) {
        // TODO Auto-generated method stub
        return bookingRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Booking> getBookingByStudy(Long studyId) {
        // TODO Auto-generated method stub
        return bookingRepository.findByStudyId(studyId);
    }

    @Override
    public Booking getBookingById(Long id) throws Exception {
        // TODO Auto-generated method stub
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking == null)
            throw new Exception("booking not found");

        return booking;
    }

    @Override
    public Booking updateBooking(Long bookingId, BookingStatus status) throws Exception {
        // TODO Auto-generated method stub
        Booking booking = getBookingById(bookingId);

        booking.setStatus(status);
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingByDate(LocalDate date, Long studyId) {
        // TODO Auto-generated method stub
        List<Booking> allBookings = getBookingByStudy(studyId);

        if (date == null) {
            return allBookings;
        }

        return allBookings.stream()
                .filter(booking -> isSameDate(booking.getStartTime(), date) || isSameDate(booking.getEndTime(), date))
                .collect(Collectors.toList());
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getBookingByDate'");
    }

    private boolean isSameDate(LocalDateTime dateTime, LocalDate date) {
        return dateTime.toLocalDate().isEqual(date);
    }

    @Override
    public StudyReport getStudyReport(Long studyId) {
        // TODO Auto-generated method stub
        List<Booking> bookings = getBookingByStudy(studyId);

        int totalEarning = bookings.stream().mapToInt(Booking::getTotalPrice).sum();

        Integer totalBooking = bookings.size();
        List<Booking> cancelledBooking = bookings.stream()
                .filter(booking -> booking.getStatus().equals(BookingStatus.CANCELED)).collect(Collectors.toList());
        Double totalRefund = cancelledBooking.stream().mapToDouble(Booking::getTotalPrice).sum();

        StudyReport report = new StudyReport();
        report.setStudyId(studyId);
        report.setCancelledBookings(cancelledBooking.size());
        report.setTotalBookings(totalBooking);
        report.setTotalEarnings(totalEarning);
        report.setTotalRefund(totalRefund);
        return report;
    }

}
