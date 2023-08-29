package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.ExpenseService;
import az.monitoringSoftware.monitoringSoftware.business.requests.expense.CreatExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.expense.GetExpenseByNameRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.expense.UpdateExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.expense.GetAllExpenseResponse;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.ExpenseRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Expense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExpenseManager implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ModelMapperManager modelMapperManager;

    @Override
    public void add(CreatExpenseRequest creatExpenseRequest) {

        Expense expense = modelMapperManager.forRequest()
                .map(creatExpenseRequest, Expense.class);

        expenseRepository.save(expense);
    }

    @Override
    public void delete(UUID id) {
        expenseRepository.deleteById(id);
    }


    @Override
    public GetExpenseByNameRequest getByName(GetExpenseByNameRequest getExpenseByNameRequest) {

        return modelMapperManager.forResponse()
                .map(expenseRepository.findExpenseByName(getExpenseByNameRequest.getName())

                        , GetExpenseByNameRequest.class);

    }

    @Override
    public List<GetAllExpenseResponse> getAll() {
        List<Expense> expenses = expenseRepository.findAll();

        return expenses.stream()
                .map(expense -> modelMapperManager.forResponse()
                        .map(expense, GetAllExpenseResponse.class))
                .toList();
    }

    @Override
    public void update(UpdateExpenseRequest updateExpenseRequest) {

        Optional<Expense> expenses = expenseRepository.findById(updateExpenseRequest.getId());

        Expense expense = expenses.get();

        modelMapperManager.forRequest().map(updateExpenseRequest, expense);
        expenseRepository.save(expense);


    }


}
