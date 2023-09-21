package az.monitoringSoftware.monitoringSoftware.business.service;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.ProductService;
import az.monitoringSoftware.monitoringSoftware.business.requests.product.CreateProductRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.product.GetProductByIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.product.UpdateProductRequest;
import az.monitoringSoftware.monitoringSoftware.business.responses.products.GetAllProductResponse;
import az.monitoringSoftware.monitoringSoftware.core.utilities.exception.BusinessException;
import az.monitoringSoftware.monitoringSoftware.business.rules.ProductBusinessRules;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.ProductRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapperManager modelMapperManager;
    private final MessageSource messageSource;
    private final ProductBusinessRules productBusinessRules;

    @Override
    public void add(CreateProductRequest createProductRequest) throws BusinessException {
        log.info("There was an ad product when the new table was set up" + createProductRequest);
        Product product = modelMapperManager.forRequest()
                .map(createProductRequest, Product.class);
        product.setCreatedAt(LocalDateTime.now());
        product.setStockCount(createProductRequest.getCount());
        log.info("The product was saved in the database" + product);
        productRepository.save(product);
    }

    @Override
    public List<GetAllProductResponse> getAll() {
        log.info("Product were searched in the database" + productRepository);
        List<Product> products = productRepository.findAll();
        List<GetAllProductResponse> productsList = products
                .stream()
                .map(product -> modelMapperManager.forRequest()
                        .map(product, GetAllProductResponse.class))
                .toList();
        log.info("The found desks were presented in the form of a list"+productsList);
        return productsList;
    }


    @Override
    public void delete(UUID id) {
        log.info("Deleting product based on entered id" + id);
        productRepository.deleteById(id);
    }


    @Override
    public void update(UpdateProductRequest updateProductRequest) {
        log.info("Finding product based on entered id" + updateProductRequest);
        Optional<Product> product= productRepository.findById(UUID.fromString(String.valueOf(updateProductRequest.getId())));
        log.info("Searching the product based on the entered id" + product);
        if (product == null)
            throw new NotFoundException(messageSource.
                    getMessage("product.doesntExists", null, null, null
                    ));
        log.info("Making the included changes" + updateProductRequest);
        modelMapperManager.forRequest().map(updateProductRequest, product.get());
        product.get().setUpdatedAt(LocalDateTime.now());
        log.info("Saving changes" + product);
        productRepository.save(product.get());
    }

    @Override
    public GetProductByIdRequest getById(UUID id) {
        log.info("Finding product based on entered id" + id);
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
