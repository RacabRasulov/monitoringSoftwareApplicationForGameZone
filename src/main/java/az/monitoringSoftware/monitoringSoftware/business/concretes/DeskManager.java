package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.DeskService;
import az.monitoringSoftware.monitoringSoftware.business.requests.desk.CreateDeskRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.desk.GetDeskByIdRequest;
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
//        if (products == null)
//            throw new NotFoundException(messageSource.
//                    getMessage("product.doesntExists", null, null, null
//                    ));

        Desk desk1 = desk.get();
        modelMapperManager.forRequest().map(updateDeskRequest, desk1);
        deskRepository.save(desk1);
    }

}
