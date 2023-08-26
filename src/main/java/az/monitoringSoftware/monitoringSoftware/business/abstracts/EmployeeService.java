package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.employee.CreatEmployeeRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.employee.GetEmployeeByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.employee.UpdateEmployeeRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.employe.GetAllEmployeeResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    void add(CreatEmployeeRequest creatEmployeeRequest);

    List<GetAllEmployeeResponse> getAll();

    void delete(UUID id);

    GetEmployeeByIdRequest getById(UUID id);

    void update(UpdateEmployeeRequest updateEmployeeRequest);
}
