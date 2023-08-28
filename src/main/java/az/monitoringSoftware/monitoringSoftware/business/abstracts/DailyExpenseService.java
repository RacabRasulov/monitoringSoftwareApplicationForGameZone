package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.CreatDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.UpdateDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.dailyExpense.GetAllDailyExpenseResponse;

import java.util.List;
import java.util.UUID;

public interface DailyExpenseService {
    void add(CreatDailyExpenseRequest creatDailyExpenseRequest);

    void delete(UUID id);

    List<GetAllDailyExpenseResponse> getAll();

    void update(UpdateDailyExpenseRequest updateDailyExpenseRequest);
}
