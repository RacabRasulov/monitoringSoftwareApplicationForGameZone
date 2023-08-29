package az.monitoringSoftware.monitoringSoftware.business.requests.sale;

import az.monitoringSoftware.monitoringSoftware.business.requests.saleProduct.CreatSaleProductRequest;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class UpdateSaleRequest {
    private LocalDateTime startDate;
    private UUID deskId;
    private Integer hour;
    private Integer minutes;
    private Boolean isDefaultTimeChecked;
    private List<CreatSaleProductRequest> saleProducts;
}
