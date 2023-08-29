package az.monitoringSoftware.monitoringSoftware.business.requests.sale;

import az.monitoringSoftware.monitoringSoftware.business.requests.saleProduct.CreatSaleProductRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateSaleRequest {
    private Timestamp startDate;
    private UUID deskId;
    private Integer hour;
    private Integer minutes;
    private Boolean isDefaultTimeChecked;
    private List<CreatSaleProductRequest> saleProducts;

}
