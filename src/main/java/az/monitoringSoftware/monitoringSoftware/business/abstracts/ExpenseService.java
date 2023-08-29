package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.expense.CreatExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.expense.GetExpenseByNameRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.expense.UpdateExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.expense.GetAllExpenseResponse;

import java.util.List;
import java.util.UUID;

public interface ExpenseService {
//    void add(CreatExpenseRequest creatExpenseRequest);

    void add(CreatExpenseRequest creatExpenseRequest);

    void delete(UUID id);

    GetExpenseByNameRequest getByName(GetExpenseByNameRequest getExpenseByNameRequest);

    List<GetAllExpenseResponse> getAll();

    void update(UpdateExpenseRequest updateExpenseRequest);
}
