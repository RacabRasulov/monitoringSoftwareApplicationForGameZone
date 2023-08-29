package az.monitoringSoftware.monitoringSoftware.business.requests.product;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

    @NotNull(message = "Product name can't be null")
    @Size(min = 2, max = 64, message = "Product name length must be min 2 max 64")
    private String name;
    private UUID id;
    private Double price;
    private String explanation;
    private double cost;
    private String nameOfSeller;
    private Integer count;
    private Double totalDebt;
}
