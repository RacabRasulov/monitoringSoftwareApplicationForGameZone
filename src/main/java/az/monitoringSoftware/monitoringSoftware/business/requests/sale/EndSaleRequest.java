package az.monitoringSoftware.monitoringSoftware.business.requests.sale;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class EndSaleRequest {

    private UUID deskId;
    private Double totalProductAmount;
    private Double totalGameAmount;
    private Double totalAmount;
    private Boolean isSaleEnded;


}
