package az.monitoringSoftware.monitoringSoftware.business.requests.sale;

import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreatSalesRequest {
    private Timestamp startDate;
    private String deviceName;
    private UUID deviceId;
    private String deskName;
    private UUID deskId;
    private Double devicePrice;
}
