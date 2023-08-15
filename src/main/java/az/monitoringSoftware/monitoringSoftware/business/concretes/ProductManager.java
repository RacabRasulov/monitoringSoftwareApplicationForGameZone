package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.ProductService;
import az.monitoringSoftware.monitoringSoftware.business.requests.CreateProductsRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.products.GetAllProductsRequest;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.ProductRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapperManager modelMapperManager;
    @Override
    public void addProduct(CreateProductsRequest createProductsRequest) {
        Product product = modelMapperManager.forRequest().map(createProductsRequest,Product.class);
        productRepository.save(product);
    }

    @Override
    public List<GetAllProductsRequest> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductsRequest> productsList = products
                .stream()
                .map(product -> modelMapperManager.forRequest().map(product,GetAllProductsRequest.class))
                .toList();

        return productsList;
    }
}
