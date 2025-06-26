package dongcom.controller;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

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

    public ResponseEntity<Set<BookingDTO>> getBookingsByCustomer() {

        List<Booking> booking = BookingService.getBookingsByCustomer(1L);

        return null;
    }

    private Set<BookingDTO> getBookingDTOs(List<Booking> bookings) {
        return bookings.stream().map(booking -> {
            return BookingMapper.toDTO(booking);
        }).collect(Collectors.toSet());
    }
}
