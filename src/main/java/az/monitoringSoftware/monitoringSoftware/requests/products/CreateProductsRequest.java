package az.monitoringSoftware.monitoringSoftware.requests.products;

import lombok.*;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateProductsRequest {
    private Long id;
    private String productName;
    private Integer productPrice;
    private String productExplanation;


}
