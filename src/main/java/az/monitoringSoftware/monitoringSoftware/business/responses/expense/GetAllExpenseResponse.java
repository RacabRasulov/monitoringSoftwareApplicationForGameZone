package az.monitoringSoftware.monitoringSoftware.business.responses.expense;


import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class GetAllExpenseResponse {
    private UUID id;
    private String name;
}
