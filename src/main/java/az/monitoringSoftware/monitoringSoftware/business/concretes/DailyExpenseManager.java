package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.DailyExpenseService;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.CreatDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.UpdateDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.dailyExpense.GetAllDailyExpenseResponse;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.DailyExpenseRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.DailyExpense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DailyExpenseManager implements DailyExpenseService {

    public final ModelMapperManager modelMapperManager;
    public final DailyExpenseRepository dailyExpenseRepository;

    @Override
    public void add(CreatDailyExpenseRequest creatDailyExpenseRequest) {

        DailyExpense dailyExpense = modelMapperManager.forRequest()
                .map(creatDailyExpenseRequest, DailyExpense.class);
        dailyExpense.setCreatedAt(creatDailyExpenseRequest.getCreatedAt().toLocalDateTime());
        dailyExpenseRepository.save(dailyExpense);
    }

    @Override
    public void delete(UUID id) {
        dailyExpenseRepository.deleteById(id);
    }

    @Override
    public List<GetAllDailyExpenseResponse> getAll() {
        List<DailyExpense> dailyExpenses = dailyExpenseRepository.findAll();

        return dailyExpenses.stream()
                .map(dailyExpense -> modelMapperManager.forResponse()
                        .map(dailyExpense, GetAllDailyExpenseResponse.class))
                .toList();
    }

    @Override
    public void update(UpdateDailyExpenseRequest updateDailyExpenseRequest) {

        Optional<DailyExpense> dailyExpense = dailyExpenseRepository
                .findById(updateDailyExpenseRequest.getId());

        DailyExpense dailyExpense1 = dailyExpense.get();
        dailyExpense1.setCreatedAt(updateDailyExpenseRequest.getCreatedAt().toLocalDateTime());
        modelMapperManager.forRequest().map(updateDailyExpenseRequest, dailyExpense1);
        dailyExpenseRepository.save(dailyExpense1);


    }


}
