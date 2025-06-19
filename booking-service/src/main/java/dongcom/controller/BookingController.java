package dongcom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dongcom.modal.Booking;
import dongcom.payload_dto.BookingRequest;
import dongcom.service.BookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService BookingService;

    public ResponseEntity<Booking> createBooking(
            @RequestParam Long studyId,
            @RequestBody BookingRequest bookingRequest) {
        return null;
    }
}
