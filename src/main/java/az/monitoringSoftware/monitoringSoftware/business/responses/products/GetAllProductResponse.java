package az.monitoringSoftware.monitoringSoftware.business.responses.products;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class GetAllProductResponse {
    private UUID id;
    private String name;
    private Double price;
    private String explanation;
    private double cost;
    private String nameOfSeller;
    private Integer count;
    private Double totalDebt;
    private Integer stockCount;
    private LocalDateTime CreatedDate;
}
