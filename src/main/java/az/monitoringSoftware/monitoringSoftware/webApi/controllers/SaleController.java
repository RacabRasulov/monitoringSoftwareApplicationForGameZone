package az.monitoringSoftware.monitoringSoftware.webApi.controllers;

import az.monitoringSoftware.monitoringSoftware.business.concretes.SaleManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.sale.CreatSaleRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sale")
public class SaleController {
    private final SaleManager saleManager;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add( @RequestBody @Valid CreatSaleRequest creatSaleRequest){
        saleManager.add(creatSaleRequest);
    }


}
