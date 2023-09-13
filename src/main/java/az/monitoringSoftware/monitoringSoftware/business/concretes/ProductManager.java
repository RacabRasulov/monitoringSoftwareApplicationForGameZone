package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.ProductService;
import az.monitoringSoftware.monitoringSoftware.business.requests.product.CreateProductRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.product.GetProductByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.product.UpdateProductRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.products.GetAllProductResponse;
import az.monitoringSoftware.monitoringSoftware.business.rules.BusinessException;
import az.monitoringSoftware.monitoringSoftware.business.rules.ProductBusinessRules;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.ProductRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
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
    public void add(CreateProductRequest createProductRequest) throws BusinessException {
        Product product = modelMapperManager.forRequest()
                .map(createProductRequest, Product.class);
        product.setCreatedAt(LocalDateTime.now());
        product.setStockCount(createProductRequest.getCount());
        productRepository.save(product);
    }

    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductResponse> productsList = products
                .stream()
                .map(product -> modelMapperManager.forRequest()
                        .map(product, GetAllProductResponse.class))
                .toList();

        return productsList;
    }


    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }


    @Override
    public void update(UpdateProductRequest updateProductRequest) {

        Optional<Product> product= productRepository.findById(UUID.fromString(String.valueOf(updateProductRequest.getId())));

        if (product == null)
            throw new NotFoundException(messageSource.
                    getMessage("product.doesntExists", null, null, null
                    ));

        modelMapperManager.forRequest().map(updateProductRequest, product.get());
        product.get().setUpdatedAt(LocalDateTime.now());
        productRepository.save(product.get());
    }

    @Override
    public GetProductByIdRequest getById(UUID id) {

        return modelMapperManager.forResponse()
                .map(productRepository.findById(
                                UUID.fromString(String.valueOf((id))))
                        , GetProductByIdRequest.class);
    }

    @Override
    public List<GetAllProductResponse> getAllWithStock() {
        List<Product> products = productRepository.findAllWithStock();
        List<GetAllProductResponse> productsList = products
                .stream()
                .map(product -> modelMapperManager.forRequest()
                        .map(product, GetAllProductResponse.class))
                .toList();

        return productsList;
    }


}
