package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.DeskService;
import az.monitoringSoftware.monitoringSoftware.business.requests.desks.CreateDesksRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.desks.GetDesksByIdReponse;
import az.monitoringSoftware.monitoringSoftware.business.requests.desks.UpdateDesksResponse;
import az.monitoringSoftware.monitoringSoftware.business.responses.desk.GetAllDesksRequest;
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
    public void add(CreateDesksRequest createDeskRequest) throws BusinessException {
        deskBusinessRules.checkIfDeskExists(createDeskRequest.getName());
        Desk desk = modelMapperManager.forRequest().map(createDeskRequest, Desk.class);
        deskRepository.save(desk);
    }


    @Override
    public List<GetAllDesksRequest> getAll() {
        List<Desk> desks = deskRepository.findAll();
        List<GetAllDesksRequest> deskList = desks.stream()
                .map(desk -> modelMapperManager.forRequest()
                        .map(desks, GetAllDesksRequest.class))
                .toList();

        return deskList;

    }

    @Override
    public void delete(UUID id) {
        deskRepository.deleteById(id);
    }

    @Override
    public GetDesksByIdReponse getById(UUID id) {
        Optional<Desk> desk = deskRepository.findById(id);

        return modelMapperManager.forResponse()
                .map(deskRepository.findById(
                                UUID.fromString((String.valueOf((id)))))
                        , GetDesksByIdReponse.class);
    }

    @Override
    public void update(UpdateDesksResponse updateDesksResponse) {

        Optional<Desk> products = deskRepository.
                findById(UUID.fromString(String.valueOf
                        (updateDesksResponse.getId())));
//        if (products == null)
//            throw new NotFoundException(messageSource.
//                    getMessage("product.doesntExists", null, null, null
//                    ));

        modelMapperManager.forRequest().map(updateDesksResponse, products.get());
    }

}
