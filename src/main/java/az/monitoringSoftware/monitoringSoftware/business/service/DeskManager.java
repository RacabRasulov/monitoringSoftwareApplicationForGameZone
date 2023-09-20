package az.monitoringSoftware.monitoringSoftware.business.service;

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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class DeskManager implements DeskService {
    public final DeskRepository deskRepository;
    public final DeskBusinessRules deskBusinessRules;
    public final ModelMapperManager modelMapperManager;

    @Override
    public void add(CreateDeskRequest createDeskRequest) throws BusinessException {
        log.info("There was an ad check when the new desk was set up" + deskBusinessRules);
        deskBusinessRules.checkIfDeskExists(createDeskRequest.getName());
        log.info("A new desk has been created" + createDeskRequest);
        Desk desk = modelMapperManager.forRequest().map(createDeskRequest, Desk.class);
        log.info("The desk was saved in the database" + desk);
        deskRepository.save(desk);
    }


    @Override
    public List<GetAllDeskResponse> getAll() {
        log.info("Desk were searched in the database" + deskRepository);
        List<Desk> desks = deskRepository.findAll();
        List<GetAllDeskResponse> deskList = desks.stream()
                .map(desk -> modelMapperManager.forResponse()
                        .map(desk, GetAllDeskResponse.class))
                .toList();
        log.info("The found desks were presented in the form of a list" + deskList);
        return deskList;

    }

    @Override
    public void delete(UUID id) {
        log.info("Deleting Desk based on entered id" + id);
        deskRepository.deleteById(id);
    }

    @Override
    public GetDeskByIdRequest getById(UUID id) {
        log.info("Finding desk based on entered id" + id);
        return modelMapperManager.forResponse()
                .map(deskRepository.findById(
                                UUID.fromString((String.valueOf((id)))))
                        , GetDeskByIdRequest.class);
    }

    @Override
    public void update(UpdateDeskRequest updateDeskRequest) {
        log.info("Finding desk based on entered id" + updateDeskRequest);
        Optional<Desk> desk = deskRepository.
                findById(UUID.fromString(String.valueOf
                        (updateDeskRequest.getId())));
        log.info("Searching the database based on the entered id" + desk);
        if (desk.isPresent()) {
            Boolean lastUsingStatus = desk.get().getLastUsingStatus();
            if (lastUsingStatus == null || !lastUsingStatus) {
                log.info("Making the included changes" + updateDeskRequest);
                modelMapperManager.forRequest().map(updateDeskRequest, desk.get());
                log.info("Saving changes" + desk);
                deskRepository.save(desk.get());
            }
        }
    }

    @Override
    public void updateLastUsingStatus(UpdateDeskLastUsingStatus updateDeskLastUsingStatus) {
        log.info("Finding last use date from database based on id" + updateDeskLastUsingStatus);
        Optional<Desk> desk = deskRepository.findById(updateDeskLastUsingStatus.getId());
        log.info("Changes have been made" + updateDeskLastUsingStatus);
        modelMapperManager.forRequest().map(updateDeskLastUsingStatus, desk.get());
        log.info("Saving changes" + desk);
        deskRepository.save(desk.get());
    }


}
