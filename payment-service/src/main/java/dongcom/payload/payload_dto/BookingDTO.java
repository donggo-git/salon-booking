package dongcom.payload.payload_dto;

import java.time.LocalDateTime;

import dongcom.domain.BookingStatus;
import jakarta.persistence.ElementCollection;
import lombok.Data;
import java.util.*;

@Data
public class BookingDTO {
    private Long id;

    private Long studyId;
    private Long customerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Set<Long> serviceIds;

    private BookingStatus status = BookingStatus.PENDING;

    private int totalPrice;
}
