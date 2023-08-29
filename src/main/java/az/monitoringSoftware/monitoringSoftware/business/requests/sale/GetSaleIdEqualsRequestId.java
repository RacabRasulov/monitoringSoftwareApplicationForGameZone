package az.monitoringSoftware.monitoringSoftware.business.requests.sale;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class GetSaleIdEqualsRequestId {

    private LocalDateTime startDate;
    private String deviceName;
    private UUID deviceId;
    private String deskName;
    private UUID deskId;
    private Double devicePrice;
    private Integer hour;
    private Integer minutes;
    private Boolean isDefaultTimeChecked;
    private Integer totalMinutes;
    private Double totalProductAmount;
    private Double totalGameAmount;
    private Double totalAmount;
    private Boolean isSaleEnded;
}
