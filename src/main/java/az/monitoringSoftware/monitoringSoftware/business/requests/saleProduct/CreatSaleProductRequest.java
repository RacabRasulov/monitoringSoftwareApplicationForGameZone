package az.monitoringSoftware.monitoringSoftware.business.requests.saleProduct;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreatSaleProductRequest {

    private UUID productId;
    private String name;
    private Double price;

    private Integer orderCount;
}
