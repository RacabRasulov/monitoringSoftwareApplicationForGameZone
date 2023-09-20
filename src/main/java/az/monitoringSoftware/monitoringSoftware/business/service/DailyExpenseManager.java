package az.monitoringSoftware.monitoringSoftware.business.service;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.DailyExpenseService;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.CreateDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.GetDailyExpensesByDatesInterval;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.UpdateDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.dailyExpense.GetAllDailyExpenseResponse;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.DailyExpenseRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.DailyExpense;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class DailyExpenseManager implements DailyExpenseService {

    public final ModelMapperManager modelMapperManager;
    public final DailyExpenseRepository dailyExpenseRepository;

    @Override
    public void add(CreateDailyExpenseRequest createDailyExpenseRequest) {
        log.info("A new daily expense was created on request" + createDailyExpenseRequest);
        DailyExpense dailyExpense = modelMapperManager.forRequest()
                .map(createDailyExpenseRequest, DailyExpense.class);
        log.info("Daily expenses are set in local time" + dailyExpense);
        dailyExpense.setCreatedAt(createDailyExpenseRequest.getCreatedAt().toLocalDateTime());
        log.info("The daily expenditure was recorded in the database" + dailyExpense);
        dailyExpenseRepository.save(dailyExpense);
    }

    @Override
    public void delete(UUID id) {
        log.info("The daily expenditure has been deleted from the database" + id);
        dailyExpenseRepository.deleteById(id);
    }

    @Override
    public List<GetAllDailyExpenseResponse> getAll() {
        log.info("Searched for daily expenses based on input request" + dailyExpenseRepository.findAll());
        List<DailyExpense> dailyExpenses = dailyExpenseRepository.findAll();
        log.info("The found daily expenses were presented in the form of a list" + dailyExpenses);
        return dailyExpenses.stream()
                .map(dailyExpense -> modelMapperManager.forResponse()
                        .map(dailyExpense, GetAllDailyExpenseResponse.class))
                .toList();
    }

    @Override
    public void update(UpdateDailyExpenseRequest updateDailyExpenseRequest) {
        log.info("The database was searched for daily expenses based on the required Id" + updateDailyExpenseRequest);
        Optional<DailyExpense> dailyExpense = dailyExpenseRepository
                .findById(updateDailyExpenseRequest.getId());
        log.info("The database was searched for daily expenses based on the required Id" + updateDailyExpenseRequest);
        DailyExpense dailyExpense1 = dailyExpense.get();
        log.info("The time interval was applied" + dailyExpense1);
        dailyExpense1.setCreatedAt(updateDailyExpenseRequest.getCreatedAt());
        log.info("The update has been made" + updateDailyExpenseRequest + dailyExpense1);
        modelMapperManager.forRequest().map(updateDailyExpenseRequest, dailyExpense1);
        log.info("The database was saved to memory" + dailyExpense1);
        dailyExpenseRepository.save(dailyExpense1);
    }

    @Override
    public List<GetAllDailyExpenseResponse> getAllByCreatedAt(String dateString) {
        log.info("Parse the dateString to a LocalDate object" + dateString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);

        log.info("Use the repository method to find expenses by date" + dailyExpenseRepository);
        return dailyExpenseRepository.findAllByCreatedAtDate(date)
                .stream()
                .map(d->modelMapperManager.forResponse().map(d,GetAllDailyExpenseResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<GetDailyExpensesByDatesInterval> getAllDailyExpensesByDateInterval(String fromDateStr, String toDateStr) {
        log.info("Search by daily interval"+fromDateStr+toDateStr);
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date fromDate = dateFormat.parse(fromDateStr);
            Date toDate = dateFormat.parse(toDateStr);

            return dailyExpenseRepository.findDailyExpensesBetweenDates(fromDate, toDate)
                    .stream()
                    .map(x->modelMapperManager.forResponse().map(x, GetDailyExpensesByDatesInterval.class))
                    .collect(Collectors.toList());
        } catch (ParseException e) {

            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
