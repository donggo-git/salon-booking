package dongcom.service;

import dongcom.modal.Booking;
import dongcom.payload_dto.ServiceDTO;
import dongcom.payload_dto.StudyDTO;
import dongcom.payload_dto.UserDTO;
import dongcom.payload_dto.BookingRequest;
import java.util.*;

public interface BookingService {
    Booking createBooking(BookingRequest booking, UserDTO userDTO, StudyDTO studyDTO, Set<ServiceDTO> serviceDTO);
}
