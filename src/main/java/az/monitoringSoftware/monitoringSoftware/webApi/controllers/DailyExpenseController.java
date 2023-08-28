package az.monitoringSoftware.monitoringSoftware.webApi.controllers;

import az.monitoringSoftware.monitoringSoftware.business.concretes.DailyExpenseManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.CreatDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.dailyExpense.UpdateDailyExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.dailyExpense.GetAllDailyExpenseResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/dailyExpense")
public class DailyExpenseController {
    public final DailyExpenseManager dailyExpenseManager;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreatDailyExpenseRequest creatDailyExpenseRequest) {
        dailyExpenseManager.add(creatDailyExpenseRequest);
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

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody UpdateDailyExpenseRequest updateDailyExpenseRequest) {
        dailyExpenseManager.update(updateDailyExpenseRequest);
    }


}
