package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.DailyExpenseService;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.CreateDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.UpdateDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.dailyExpense.GetAllDailyExpenseResponse;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.DailyExpenseRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.DailyExpense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DailyExpenseManager implements DailyExpenseService {

    public final ModelMapperManager modelMapperManager;
    public final DailyExpenseRepository dailyExpenseRepository;

    @Override
    public void add(CreateDailyExpenseRequest createDailyExpenseRequest) {

        DailyExpense dailyExpense = modelMapperManager.forRequest()
                .map(createDailyExpenseRequest, DailyExpense.class);
        dailyExpense.setCreatedAt(createDailyExpenseRequest.getCreatedAt());
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
        dailyExpense1.setCreatedAt(updateDailyExpenseRequest.getCreatedAt());
        modelMapperManager.forRequest().map(updateDailyExpenseRequest, dailyExpense1);
        dailyExpenseRepository.save(dailyExpense1);


    }

    @Override
    public List<GetAllDailyExpenseResponse> getAllByCreatedAt(String dateString) {
        // Parse the dateString to a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);

        // Use the repository method to find expenses by date
        return dailyExpenseRepository.findAllByCreatedAtDate(date)
                .stream()
                .map(d->modelMapperManager.forResponse().map(d,GetAllDailyExpenseResponse.class)).collect(Collectors.toList());
    }
}
