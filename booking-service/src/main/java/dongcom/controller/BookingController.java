package dongcom.controller;

import java.util.*;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dongcom.modal.Booking;
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
}
