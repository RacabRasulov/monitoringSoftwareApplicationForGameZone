package az.monitoringSoftware.monitoringSoftware.webApi.controllers;

import az.monitoringSoftware.monitoringSoftware.business.concretes.EmployeeManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.employee.CreatEmployeeRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.employee.UpdateEmployeeResponse;
import az.monitoringSoftware.monitoringSoftware.business.responses.employe.GetAllEmployeeRequest;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {
    public final EmployeeManager employeeManager;
    @PutMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreatEmployeeRequest creatEmployeeRequest) throws BusinessException {

        employeeManager.add(creatEmployeeRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllEmployeeRequest> getAll(){
     return employeeManager.getAll();
    }


    @DeleteMapping("/delete{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id){
        employeeManager.delete(id);
    }

    @GetMapping("/getById")
    @ResponseStatus(HttpStatus.OK)
    public void getById(UUID id){
        employeeManager.getById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateEmployeeResponse updateEmployeeResponse){
        employeeManager.update(updateEmployeeResponse);
    }

}
