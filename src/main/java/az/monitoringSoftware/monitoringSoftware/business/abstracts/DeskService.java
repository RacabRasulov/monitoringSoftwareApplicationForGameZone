package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.desks.CreateDesksRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.desks.GetDesksByIdReponse;
import az.monitoringSoftware.monitoringSoftware.business.requests.desks.UpdateDesksResponse;
import az.monitoringSoftware.monitoringSoftware.business.responses.desk.GetAllDesksRequest;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;

import java.util.List;
import java.util.UUID;

public interface DeskService {

    void add(CreateDesksRequest createDeskRequest) throws BusinessException;

    List<GetAllDesksRequest> getAll();

    void delete(UUID id);

    GetDesksByIdReponse getById(UUID id);

    void update(UpdateDesksResponse updateDesksResponse);
}
