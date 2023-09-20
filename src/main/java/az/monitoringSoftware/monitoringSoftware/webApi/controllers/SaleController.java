package az.monitoringSoftware.monitoringSoftware.webApi.controllers;

import az.monitoringSoftware.monitoringSoftware.business.service.SaleManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.sale.CreateSaleRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.sale.EndSaleRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.sale.GetSaleByDeskIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.sale.UpdateSaleRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.sale.GetAllSalesByDatesInterval;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sale")
public class SaleController {
    private final SaleManager saleManager;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateSaleRequest createSaleRequest) {
        saleManager.add(createSaleRequest);
    }

    @GetMapping("/getSaleByDeskId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GetSaleByDeskIdRequest> getSaleByDeskIdRequest(@PathVariable String id){
       return ResponseEntity.ok( saleManager.getSaleByDeskIdRequest(UUID.fromString(id)));
    }

    @PostMapping("/endSale")
    @ResponseStatus(HttpStatus.OK)
    public void endSale(@RequestBody @Valid EndSaleRequest endSaleRequest) {
        saleManager.endSaleRequest(endSaleRequest);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateSaleRequest updateSaleRequest){
        saleManager.update(updateSaleRequest);
    }

    @GetMapping("/getAllByDatesInterval/{fromDate}/{toDate}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<GetAllSalesByDatesInterval>> getAllByDatesInterval(@PathVariable String fromDate, @PathVariable String toDate){
        return ResponseEntity.ok( saleManager.getAllByDatesInterval(fromDate,toDate));
    }
}
