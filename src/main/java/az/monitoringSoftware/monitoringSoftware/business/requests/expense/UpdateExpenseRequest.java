package az.monitoringSoftware.monitoringSoftware.business.requests.expense;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@ToString
@AllArgsConstructor
public class UpdateExpenseRequest {
    private String name;
    private UUID id;
}
