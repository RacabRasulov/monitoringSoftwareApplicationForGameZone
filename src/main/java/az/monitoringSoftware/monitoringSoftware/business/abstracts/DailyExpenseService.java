package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.CreateDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.UpdateDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.dailyExpense.GetAllDailyExpenseResponse;
import az.monitoringSoftware.monitoringSoftware.domain.entities.DailyExpense;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface DailyExpenseService {
    void add(CreateDailyExpenseRequest createDailyExpenseRequest);

    void delete(UUID id);

    List<GetAllDailyExpenseResponse> getAll();

    void update(UpdateDailyExpenseRequest updateDailyExpenseRequest);

    List<GetAllDailyExpenseResponse> getAllByCreatedAt(String dateString);
}
