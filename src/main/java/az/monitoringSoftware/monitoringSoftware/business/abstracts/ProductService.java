package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.CreateProductsRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.products.GetAllProductsRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    void addProduct(CreateProductsRequest createProductsRequest);
    List<GetAllProductsRequest> getAll();
}
