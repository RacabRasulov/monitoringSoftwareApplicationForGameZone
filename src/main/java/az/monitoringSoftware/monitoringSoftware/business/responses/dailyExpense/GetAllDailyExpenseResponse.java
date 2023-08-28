package az.monitoringSoftware.monitoringSoftware.business.responses.dailyExpense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class GetAllDailyExpenseResponse {
    private Double amount;
}
