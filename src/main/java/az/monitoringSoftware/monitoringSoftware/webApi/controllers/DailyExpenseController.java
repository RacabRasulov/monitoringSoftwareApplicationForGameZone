package az.monitoringSoftware.monitoringSoftware.webApi.controllers;

import az.monitoringSoftware.monitoringSoftware.business.service.DailyExpenseManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.CreateDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.GetDailyExpensesByDatesInterval;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.UpdateDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.dailyExpense.GetAllDailyExpenseResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/dailyExpense")
public class DailyExpenseController {
    public final DailyExpenseManager dailyExpenseManager;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateDailyExpenseRequest createDailyExpenseRequest) {
        dailyExpenseManager.add(createDailyExpenseRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id) {
        dailyExpenseManager.delete(id);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllDailyExpenseResponse> getAll() {
        return dailyExpenseManager.getAll();
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody UpdateDailyExpenseRequest updateDailyExpenseRequest) {
        dailyExpenseManager.update(updateDailyExpenseRequest);
    }

    @GetMapping("/getAllByDate/{date}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllDailyExpenseResponse> getAllByDate(@PathVariable String date) {
        return dailyExpenseManager.getAllByCreatedAt(date);
    }

    @GetMapping("/getAllDailyExpensesByDateInterval/{fromDate}/{toDate}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<GetDailyExpensesByDatesInterval>> getAllDailyExpensesByDateInterval(@PathVariable String fromDate, @PathVariable String toDate){
        return ResponseEntity.ok( dailyExpenseManager.getAllDailyExpensesByDateInterval(fromDate,toDate));
    }
}
