package az.monitoringSoftware.monitoringSoftware.webApi.controllers;

import az.monitoringSoftware.monitoringSoftware.business.concretes.ExpenseManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.expense.CreatExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.expense.GetExpenseByNameRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.expense.UpdateExpenseRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.expense.GetAllExpenseResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/expense")
public class ExpenseController {
    public final ExpenseManager expenseManager;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreatExpenseRequest creatExpenseRequest) {
        expenseManager.add(creatExpenseRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id) {
        expenseManager.delete(id);
    }

    @GetMapping("/getByName")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GetExpenseByNameRequest> getByName(GetExpenseByNameRequest getExpenseByNameRequest) {

        return ResponseEntity.ok(expenseManager.getByName(getExpenseByNameRequest));
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllExpenseResponse> getAll() {
        return expenseManager.getAll();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody UpdateExpenseRequest updateExpenseRequest){
        expenseManager.update(updateExpenseRequest);
    }



}



