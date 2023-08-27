package az.monitoringSoftware.monitoringSoftware.business.requests.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    @NotNull(message = "Product name can't be null")
    @NotEmpty(message = "Product name can't be empty")
    @Size(min = 2, max = 64, message = "Product name length must be min 2 max 64")
    private String name;
    private Double price;
    private String explanation;
    private double cost;
    private String nameOfSeller;


}
