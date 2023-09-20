package az.monitoringSoftware.monitoringSoftware.business.rules;

import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductBusinessRules {

    private ProductRepository productRepository;
    public void checkIfProductExists(String name) throws BusinessException {
        if (productRepository.existsByName(name))
            throw new BusinessException("Product already exists");
    }

}
