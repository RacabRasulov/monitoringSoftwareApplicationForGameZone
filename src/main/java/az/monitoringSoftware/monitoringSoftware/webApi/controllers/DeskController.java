package az.monitoringSoftware.monitoringSoftware.webApi.controllers;


import az.monitoringSoftware.monitoringSoftware.business.concretes.DeskManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.desks.CreateDesksRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.desks.GetDesksByIdReponse;
import az.monitoringSoftware.monitoringSoftware.business.requests.desks.UpdateDesksResponse;
import az.monitoringSoftware.monitoringSoftware.business.responses.desk.GetAllDesksRequest;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/desk")
@AllArgsConstructor
public class DeskController {
    public final DeskManager deskManager;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateDesksRequest createDeskRequest) throws BusinessException {
        deskManager.add(createDeskRequest);
    }


    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllDesksRequest> getAll() {
        return deskManager.getAll();

    }

    @DeleteMapping("/delete{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable  UUID id){
        deskManager.delete(id);
    }

    @GetMapping("/getById")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity< GetDesksByIdReponse> getById(String id){
      return  ResponseEntity.ok( deskManager.getById(UUID.fromString(id)));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateDesksResponse updateDesksResponse) {
        deskManager.update(updateDesksResponse);
    }

}
