package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.product.CreateProductRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.product.GetProductByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.product.UpdateProductRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.products.GetAllProductResponse;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void add(CreateProductRequest createProductRequest) throws BusinessException;

    List<GetAllProductResponse> getAll();


    void delete(UUID id);


    void update(UpdateProductRequest updateProductRequest);

    GetProductByIdRequest getById(UUID id);
}
