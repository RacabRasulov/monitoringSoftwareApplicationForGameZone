package az.monitoringSoftware.monitoringSoftware.business.requests.expense;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class GetExpenseByNameRequest {
    private String name;
}
