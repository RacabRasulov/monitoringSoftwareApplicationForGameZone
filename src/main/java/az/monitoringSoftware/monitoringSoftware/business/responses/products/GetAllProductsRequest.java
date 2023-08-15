package az.monitoringSoftware.monitoringSoftware.business.responses.products;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class GetAllProductsRequest {
    private UUID id;
    private String name;
    private Integer price;
    private String explanation;

}
