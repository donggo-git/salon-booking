package dongcom.payload.payload_dto;

import java.time.LocalTime;
import java.util.List;

import lombok.Data;

@Data
public class StudyDTO {
    private Long id;
    private String name;
    private List<String> images;
    private String address;
    private String phoneNumber;
    private String email;
    private String City;
    private Long ownerId;
    private LocalTime openTime;
    private LocalTime closeTime;
}
