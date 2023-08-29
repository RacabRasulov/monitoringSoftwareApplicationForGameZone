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
public class UpdateDailyExpenseRequest {
    private LocalDateTime createdAt;
    private Double amount;
    private UUID id;
}
