package az.monitoringSoftware.monitoringSoftware.business.responses.sale;

import az.monitoringSoftware.monitoringSoftware.business.requests.saleProduct.CreatSaleProductRequest;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class GetAllSalesByDatesInterval {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String deviceName;
    private UUID deviceId;
    private String deskName;
    private UUID deskId;
    private Double devicePrice;
    private Integer hour;
    private Integer minutes;
    private Boolean isDefaultTimeChecked;
    private Long totalMinutes;
    private Double totalProductAmount;
    private Double totalGameAmount;
    private Double totalAmount;
    private Boolean isSaleEnded;
}
