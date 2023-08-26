package az.monitoringSoftware.monitoringSoftware.webApi.controllers;

import az.monitoringSoftware.monitoringSoftware.business.concretes.ProductManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.products.CreateProductsRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.products.GetProductsByIdResponse;
import az.monitoringSoftware.monitoringSoftware.business.requests.products.UpdateProductRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.products.GetAllProductsRequest;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private final ProductManager productManager;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateProductsRequest createProductsRequest) throws BusinessException {
        productManager.add(createProductsRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllProductsRequest> getAll() {
        return productManager.getAll();
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        productManager.delete(UUID.fromString(id));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(  @RequestBody UpdateProductRequest updateProductRequest) {
        productManager.update( updateProductRequest);
    }

    @GetMapping("/getById")
    public ResponseEntity<GetProductsByIdResponse> getById(String id){
        return ResponseEntity.ok  (productManager.getById(UUID.fromString(id)));


    }

}
