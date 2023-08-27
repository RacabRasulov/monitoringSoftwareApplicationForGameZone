package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.DeskService;
import az.monitoringSoftware.monitoringSoftware.business.requests.desk.CreateDeskRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.desk.GetDeskByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.desk.UpdateDeskLastUsingStatus;
import az.monitoringSoftware.monitoringSoftware.business.requests.desk.UpdateDeskRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.desk.GetAllDeskResponse;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;
import az.monitoringSoftware.monitoringSoftware.business.rules.DeskBusinessRules;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.DeskRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Desk;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DeskManager implements DeskService {
    public final DeskRepository deskRepository;
    public final DeskBusinessRules deskBusinessRules;
    public final ModelMapperManager modelMapperManager;

    @Override
    public void add(CreateDeskRequest createDeskRequest) throws BusinessException {
        deskBusinessRules.checkIfDeskExists(createDeskRequest.getName());


        Desk desk = modelMapperManager.forRequest().map(createDeskRequest, Desk.class);
        deskRepository.save(desk);
    }


    @Override
    public List<GetAllDeskResponse> getAll() {
        List<Desk> desks = deskRepository.findAll();
        List<GetAllDeskResponse> deskList = desks.stream()
                .map(desk -> modelMapperManager.forResponse()
                        .map(desk, GetAllDeskResponse.class))
                .toList();

        return deskList;

    }

    @Override
    public void delete(UUID id) {
        deskRepository.deleteById(id);
    }

    @Override
    public GetDeskByIdRequest getById(UUID id) {
        return modelMapperManager.forResponse()
                .map(deskRepository.findById(
                                UUID.fromString((String.valueOf((id)))))
                        , GetDeskByIdRequest.class);
    }

    @Override
    public void update(UpdateDeskRequest updateDeskRequest) {

        Optional<Desk> desk = deskRepository.
                findById(UUID.fromString(String.valueOf
                        (updateDeskRequest.getId())));

        if (desk.isPresent()) {
            Boolean lastUsingStatus = desk.get().getLastUsingStatus();
            if (lastUsingStatus == null || !lastUsingStatus) {
                modelMapperManager.forRequest().map(updateDeskRequest, desk.get());
                deskRepository.save(desk.get());
            }
        }
    }

    @Override
    public void updateLastUsingStatus(UpdateDeskLastUsingStatus updateDeskLastUsingStatus) {

        Optional<Desk> desk = deskRepository.findById(updateDeskLastUsingStatus.getId());

        modelMapperManager.forRequest().map(updateDeskLastUsingStatus, desk.get());
        deskRepository.save(desk.get());
    }


}
