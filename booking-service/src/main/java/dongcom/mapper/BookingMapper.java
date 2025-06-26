package dongcom.mapper;

import dongcom.modal.Booking;
import dongcom.payload_dto.BookingDTO;

public class BookingMapper {
    public static BookingDTO toDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setCustomerId(booking.getCustomerId());
        bookingDTO.setStatus(booking.getStatus());
        bookingDTO.setStartTime(booking.getStartTime());
        bookingDTO.setEndTime(booking.getEndTime());
        bookingDTO.setStudyId(booking.getStudyId());
        bookingDTO.setServiceIds(booking.getServiceIds());

        return bookingDTO;
    }
}
