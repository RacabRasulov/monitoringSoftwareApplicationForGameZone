package az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class GetDailyExpenseByIdRequest {
    private UUID id;
    private Double amount;
    private LocalDateTime createdAt;
    private String expenseName;
}
