package az.monitoringSoftware.monitoringSoftware.business.responses.expense;


import lombok.*;
import java.util.UUID;

@Data
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class GetAllExpenseResponse {
    private UUID id;
    private String name;
}
