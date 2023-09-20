package az.monitoringSoftware.monitoringSoftware.business.service;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.EmployeeService;
import az.monitoringSoftware.monitoringSoftware.business.requests.employee.CreatEmployeeRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.employee.GetEmployeeByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.employee.UpdateEmployeeRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.employe.GetAllEmployeeResponse;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.EmployeeRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    public final EmployeeRepository employeeRepository;
    public final ModelMapperManager modelMapperManager;

    @Override
    public void add(CreatEmployeeRequest creatEmployeeRequest) {
        log.info("A new employee has been created" + creatEmployeeRequest);
        Employee employee = modelMapperManager.forRequest().map(creatEmployeeRequest, Employee.class);
        log.info("A new employee was registered in the database" + employee);
        employeeRepository.save(employee);

    }

    @Override
    public List<GetAllEmployeeResponse> getAll() {
        log.info("Employees were searched in the database" + employeeRepository);
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeResponse> employeeList = employees
                .stream()
                .map(employee -> modelMapperManager.forRequest()
                        .map(employee, GetAllEmployeeResponse.class))
                .toList();
        log.info("The employees found in the database were returned in the form of a list" + employeeList);
        return employeeList;

    }

    @Override
    public void delete(UUID id) {
        log.info("Removed from database based on entered id" + id);
        employeeRepository.deleteById(id);
    }

    @Override
    public GetEmployeeByIdRequest getById(UUID id) {
        log.info("The database was searched based on the entered id" + id);
        return modelMapperManager.forResponse().map(employeeRepository.findById(
                        UUID.fromString(String.valueOf((id))))
                , GetEmployeeByIdRequest.class);

    }

    @Override
    public void update(UpdateEmployeeRequest updateEmployeeRequest) {
        log.info("Searched for change by entered id" + updateEmployeeRequest);
        Optional<Employee> employee = employeeRepository.findById(UUID.fromString(String.valueOf(updateEmployeeRequest.getId())));

//        if (employee == null)
//            throw new NotFoundException(messageSource.
//                    getMessage("product.doesntExists", null, null, null
//                    ));
        log.info("The id found based on the search data was received"+employee);
        Employee employee1 = employee.get();
        log.info("Appropriate changes have been made"+employee1);
        modelMapperManager.forRequest().map(updateEmployeeRequest, employee1);
        log.info("After the change, it was written to the database"+employee1);
        employeeRepository.save(employee1);
    }

}
