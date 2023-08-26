package az.monitoringSoftware.monitoringSoftware.business.requests.sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreatSaleRequest {
    private Timestamp startDate;
    private UUID deskId;
    private List<CreatSaleRequest> saleProducts;

}
