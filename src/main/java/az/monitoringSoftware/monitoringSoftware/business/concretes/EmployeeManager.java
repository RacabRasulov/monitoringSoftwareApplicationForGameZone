package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.EmployeeService;
import az.monitoringSoftware.monitoringSoftware.business.requests.employee.CreatEmployeeRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.employee.GetEmployeeByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.employee.UpdateEmployeeRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.employe.GetAllEmployeeResponse;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.EmployeeRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    public final EmployeeRepository employeeRepository;
    public final ModelMapperManager modelMapperManager;

    @Override
    public void add(CreatEmployeeRequest creatEmployeeRequest) {
        Employee employee = modelMapperManager.forRequest().map(creatEmployeeRequest, Employee.class);
        employeeRepository.save(employee);

    }

    @Override
    public List<GetAllEmployeeResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeResponse> employeeList = employees
                .stream()
                .map(employee -> modelMapperManager.forRequest()
                        .map(employee, GetAllEmployeeResponse.class))
                .toList();

        return employeeList;

    }

    @Override
    public void delete(UUID id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public GetEmployeeByIdRequest getById(UUID id) {
        return modelMapperManager.forResponse().map(employeeRepository.findById(
                        UUID.fromString(String.valueOf((id))))
                , GetEmployeeByIdRequest.class);

    }

    @Override
    public void update(UpdateEmployeeRequest updateEmployeeRequest) {
        Optional<Employee> employee = employeeRepository.findById(UUID.fromString(String.valueOf(updateEmployeeRequest.getId())));

//        if (employee == null)
//            throw new NotFoundException(messageSource.
//                    getMessage("product.doesntExists", null, null, null
//                    ));
        Employee employee1 = employee.get();
        modelMapperManager.forRequest().map(updateEmployeeRequest, employee1);
        employeeRepository.save(employee1);
    }

}
