package az.monitoringSoftware.monitoringSoftware.business.requests.saleProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatSaleProductRequest {

    private UUID productId;
    private String name;
    private Double price;
    private Integer orderCount;
}
