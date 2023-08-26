package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.desk.CreateDeskRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.desk.GetDeskByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.desk.UpdateDeskRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.desk.GetAllDeskResponse;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;

import java.util.List;
import java.util.UUID;

public interface DeskService {

    void add(CreateDeskRequest createDeskRequest) throws BusinessException;

    List<GetAllDeskResponse> getAll();

    void delete(UUID id);

    GetDeskByIdRequest getById(UUID id);

    void update(UpdateDeskRequest updateDeskRequest);
}
