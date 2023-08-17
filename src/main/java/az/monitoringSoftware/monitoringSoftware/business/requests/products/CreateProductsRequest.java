package az.monitoringSoftware.monitoringSoftware.business.requests.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateProductsRequest {

    @NotNull(message = "Product name can't be null")
    @Size(min = 2,max = 64,message = "Product name length must be min 2 max 64")
    private String name;
    private UUID id;
    private Double price;
    private String explanation;


}
