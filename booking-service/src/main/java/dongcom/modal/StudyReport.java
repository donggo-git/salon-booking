package dongcom.modal;

import lombok.Data;

@Data
public class StudyReport {
    private Long studyId;
    private String studyName;
    private Integer totalEarnings;
    private Integer totalBookings;
    private Integer cancelledBookings;
    private Double totalRefund;
}
