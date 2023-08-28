package az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class GetDailyExpenseByIdRequest {
    private Double amount;
}
