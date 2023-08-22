package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.employee.CreatEmployeeRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.employee.GetEmployeeByIdResponse;
import az.monitoringSoftware.monitoringSoftware.business.requests.employee.UpdateEmployeeResponse;
import az.monitoringSoftware.monitoringSoftware.business.responses.employe.GetAllEmployeeRequest;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    void add(CreatEmployeeRequest creatEmployeeRequest);

    List<GetAllEmployeeRequest> getAll();

    void delete(UUID id);

    GetEmployeeByIdResponse getById(UUID id);

    void update(UpdateEmployeeResponse updateEmployeeResponse);
}
