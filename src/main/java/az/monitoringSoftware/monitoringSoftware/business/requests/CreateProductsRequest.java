package az.monitoringSoftware.monitoringSoftware.business.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateProductsRequest {

    @NotNull(message = "Product name can't be null")
    @Size(min = 2,max = 64,message = "Product name length must be min 2 max 64")
    private String name;
    private Double price;
    private String explanation;


}
