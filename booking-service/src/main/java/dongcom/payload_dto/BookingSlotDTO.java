package dongcom.payload_dto;

import java.time.LocalDateTime;
import java.util.*;
import lombok.Data;

@Data
public class BookingSlotDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
