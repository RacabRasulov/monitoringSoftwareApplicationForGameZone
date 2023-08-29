package az.monitoringSoftware.monitoringSoftware.business.responses.dailyExpense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class GetAllDailyExpenseResponse {
    private UUID id;
    private Double amount;
    private Timestamp createdAt;
    private String expenseName;
}
