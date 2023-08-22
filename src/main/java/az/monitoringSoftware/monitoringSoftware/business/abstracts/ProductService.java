package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.products.CreateProductsRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.products.GetProductsByIdResponse;
import az.monitoringSoftware.monitoringSoftware.business.requests.products.UpdateProductsResponse;
import az.monitoringSoftware.monitoringSoftware.business.responses.products.GetAllProductsRequest;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void add(CreateProductsRequest createProductsRequest) throws BusinessException;
    List<GetAllProductsRequest> getAll();


    void delete(UUID id);

    void update(UpdateProductsResponse updateProductsRequest);

    GetProductsByIdResponse getById(UUID id);
}
