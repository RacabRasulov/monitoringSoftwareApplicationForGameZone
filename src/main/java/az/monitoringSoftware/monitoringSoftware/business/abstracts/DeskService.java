package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.desk.CreateDesksRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.desk.GetDeskByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.desk.UpdateDesksResponse;
import az.monitoringSoftware.monitoringSoftware.business.responses.desk.GetAllDesksRequest;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;

import java.util.List;
import java.util.UUID;

public interface DeskService {

    void add(CreateDesksRequest createDeskRequest) throws BusinessException;

    List<GetAllDesksRequest> getAll();

    void delete(UUID id);

    GetDeskByIdRequest getById(UUID id);

    void update(UpdateDesksResponse updateDesksResponse);
}
