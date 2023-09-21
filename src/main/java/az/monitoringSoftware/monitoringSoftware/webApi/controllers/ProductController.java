package az.monitoringSoftware.monitoringSoftware.webApi.controllers;

import az.monitoringSoftware.monitoringSoftware.business.service.ProductManager;
import az.monitoringSoftware.monitoringSoftware.business.requests.product.CreateProductRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.product.GetProductByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.product.UpdateProductRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.products.GetAllProductResponse;
import az.monitoringSoftware.monitoringSoftware.core.utilities.exception.BusinessException;
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

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateProductRequest createProductRequest) throws BusinessException {
        productManager.add(createProductRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllProductResponse> getAll() {
        return productManager.getAll();
    }

    @GetMapping("/getAllWithStock")
    public List<GetAllProductResponse> getAllWithStock() {
        return productManager.getAllWithStock();
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        productManager.delete(UUID.fromString(id));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody UpdateProductRequest updateProductRequest) {
        productManager.update(updateProductRequest);
    }

    @GetMapping("/getById")
    public ResponseEntity<GetProductByIdRequest> getById(String id) {
        return ResponseEntity.ok(productManager.getById(UUID.fromString(id)));
    }
}
