package dongcom.controller;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import dongcom.mapper.BookingMapper;
import dongcom.modal.Booking;
import dongcom.payload_dto.BookingDTO;
import dongcom.payload_dto.BookingRequest;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.UserDTO;
import dongcom.payload_dto.ServiceDTO;
import dongcom.service.BookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService BookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(
            @RequestParam Long studyId,
            @RequestBody BookingRequest bookingRequest) throws Exception {

        UserDTO user = new UserDTO();
        user.setId(1L);

        StudyDTO study = new StudyDTO();
        study.setId(studyId);

        Set<ServiceDTO> serviceDTOSet = new HashSet<>();
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(1L);
        serviceDTO.setPrice(399);
        serviceDTO.setDuration(45);
        serviceDTO.setName("self study path way guide");

        serviceDTOSet.add(serviceDTO);

        Booking booking = BookingService.createBooking(bookingRequest, user, study, serviceDTOSet);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/customer")
    public ResponseEntity<Set<BookingDTO>> getBookingsByCustomer() {

        List<Booking> bookings = BookingService.getBookingsByCustomer(1L);

        return ResponseEntity.ok(getBookingDTOs(bookings));
    }

    private Set<BookingDTO> getBookingDTOs(List<Booking> bookings) {
        return bookings.stream().map(booking -> {
            return BookingMapper.toDTO(booking);
        }).collect(Collectors.toSet());
    }

    @GetMapping("/study")
    public ResponseEntity<Set<BookingDTO>> getBookingsByStudy() {

        List<Booking> bookings = BookingService.getBookingByStudy(1L);

        return ResponseEntity.ok(getBookingDTOs(bookings));
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDTO> getBookingsById(
            @PathVariable Long bookingId) throws Exception {

        Booking booking = BookingService.getBookingById(bookingId);

        return ResponseEntity.ok(BookingMapper.toDTO(booking));
    }

    @PutMapping("/{bookingId}/status")
    public ResponseEntity<BookingDTO> updateBookingStatus(
            @PathVariable Long bookingId,
            @RequestParam BookingStatus status) throws Exception {

        Booking booking = BookingService.updateBooking(bookingId, status);

        return ResponseEntity.ok(BookingMapper.toDTO(booking));
    }

    @GetMapping("/slots/study/{studyId}/date/{date}")
    public ResponseEntity<List<BookingDTO>> getBookedSlot(
            @PathVariable Long studyId,
            @RequestParam LocalDate date) throws Exception {

        List<Booking> booking = BookingService.getBookingByDate(date, studyId);

        return ResponseEntity.ok(getBookingDTOs(booking));
    }

}
