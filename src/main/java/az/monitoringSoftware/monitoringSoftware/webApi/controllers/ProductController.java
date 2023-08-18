package az.monitoringSoftware.monitoringSoftware.webApi.controllers;

import az.monitoringSoftware.monitoringSoftware.business.concretes.ProductManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.products.CreateProductsRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.products.GetProductsByIdResponse;
import az.monitoringSoftware.monitoringSoftware.business.requests.products.UpdateProductsResponse;
import az.monitoringSoftware.monitoringSoftware.business.responses.products.GetAllProductsRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private final ProductManager productManager;

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(CreateProductsRequest createProductsRequest) {
        productManager.add(createProductsRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllProductsRequest> getAll() {
        return productManager.getAll();
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam UUID id) {
        productManager.delete(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(UpdateProductsResponse updateProductsResponse) {
        productManager.update(updateProductsResponse);
    }

    @GetMapping("/getById")
    public GetProductsByIdResponse getById(String id){
        return productManager.getById(UUID.fromString(id));
    }

}
