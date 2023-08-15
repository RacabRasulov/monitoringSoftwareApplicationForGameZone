package az.monitoringSoftware.monitoringSoftware.webApi.controllers;

import az.monitoringSoftware.monitoringSoftware.business.concretes.ProductManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.CreateProductsRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.products.GetAllProductsRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private final ProductManager productManager;
    @GetMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(CreateProductsRequest createProductsRequest){
        productManager.addProduct(createProductsRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllProductsRequest> getAll(){
        return productManager.getAll();
    }
}
