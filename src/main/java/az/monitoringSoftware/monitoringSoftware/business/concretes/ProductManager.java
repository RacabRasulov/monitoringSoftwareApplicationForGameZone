package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.ProductService;
import az.monitoringSoftware.monitoringSoftware.business.requests.products.CreateProductsRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.products.GetProductsByIdResponse;
import az.monitoringSoftware.monitoringSoftware.business.requests.products.UpdateProductRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.products.GetAllProductsRequest;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;
import az.monitoringSoftware.monitoringSoftware.business.rules.ProductBusinessRules;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.ProductRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapperManager modelMapperManager;
    private final MessageSource messageSource;
    private final ProductBusinessRules productBusinessRules;

    @Override
    public void add(CreateProductsRequest createProductsRequest) throws BusinessException {
        productBusinessRules.checkIfProductExists(createProductsRequest.getName());
        Product product = modelMapperManager.forRequest()
                .map(createProductsRequest, Product.class);
        productRepository.save(product);
    }

    @Override
    public List<GetAllProductsRequest> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductsRequest> productsList = products
                .stream()
                .map(product -> modelMapperManager.forRequest()
                        .map(product, GetAllProductsRequest.class))
                .toList();

        return productsList;
    }


    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }


    @Override
    public void update( UpdateProductRequest updateProductRequest) {

        Optional<Product> products = productRepository.findById(UUID.fromString(String.valueOf(updateProductRequest.getId())));

        if (products == null)
            throw new NotFoundException(messageSource.
                    getMessage("product.doesntExists", null, null, null
                    ));

        Product product = products.get();
        modelMapperManager.forRequest().map(updateProductRequest, product);
        productRepository.save(product);
    }

    @Override
    public GetProductsByIdResponse getById(UUID id) {

               return modelMapperManager.forResponse()
                .map(productRepository.findById(
                                UUID.fromString(String.valueOf((id))))
                        , GetProductsByIdResponse.class);
    }


}
