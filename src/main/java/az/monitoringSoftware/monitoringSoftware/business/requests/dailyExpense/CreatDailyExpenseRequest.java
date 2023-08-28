package az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class CreatDailyExpenseRequest {

    private Double amount;
    private UUID expenseId;
}
