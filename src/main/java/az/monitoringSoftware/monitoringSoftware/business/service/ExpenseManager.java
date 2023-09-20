package az.monitoringSoftware.monitoringSoftware.business.service;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.ExpenseService;
import az.monitoringSoftware.monitoringSoftware.business.requests.expense.CreatExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.expense.GetExpenseByNameRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.expense.UpdateExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.expense.GetAllExpenseResponse;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.ExpenseRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Expense;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class ExpenseManager implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ModelMapperManager modelMapperManager;

    @Override
    public void add(CreatExpenseRequest creatExpenseRequest) {
        log.info("A new expense has been created" + creatExpenseRequest);
        Expense expense = modelMapperManager.forRequest()
                .map(creatExpenseRequest, Expense.class);
        log.info("The expenditure was recorded in the database" + expense);
        expenseRepository.save(expense);
    }

    @Override
    public void delete(UUID id) {
        log.info("The expense has been deleted from the database" + id);
        expenseRepository.deleteById(id);
    }


    @Override
    public GetExpenseByNameRequest getByName(GetExpenseByNameRequest getExpenseByNameRequest) {
        log.info("Finding desk based on entered name" + getExpenseByNameRequest);
        return modelMapperManager.forResponse()
                .map(expenseRepository.findExpenseByName(getExpenseByNameRequest.getName())
                        , GetExpenseByNameRequest.class);

    }

    @Override
    public List<GetAllExpenseResponse> getAll() {
        log.info("Expense were searched in the database" + expenseRepository);
        List<Expense> expenses = expenseRepository.findAll();
        log.info("The found tables were presented in the form of a list" + expenses);
        return expenses.stream()
                .map(expense -> modelMapperManager.forResponse()
                        .map(expense, GetAllExpenseResponse.class))
                .toList();
    }

    @Override
    public void update(UpdateExpenseRequest updateExpenseRequest) {
        log.info("Finding expense based on entered id" + updateExpenseRequest);
        Optional<Expense> expenses = expenseRepository.findById(updateExpenseRequest.getId());
        log.info("Data found based on id" + expenses);
        Expense expense = expenses.get();
        modelMapperManager.forRequest().map(updateExpenseRequest, expense);
        log.info("The information after the change was written to the memory" + expense);
        expenseRepository.save(expense);
    }
}
