package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.SaleService;
import az.monitoringSoftware.monitoringSoftware.business.requests.sale.CreatSalesRequest;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.SaleRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Sale;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaleManager implements SaleService {
    public final SaleRepository saleRepository;
    public final ModelMapperManager modelMapperManager;

    @Override
    public void add(CreatSalesRequest creatSalesRequest) {
        Sale sale = modelMapperManager.forRequest()
                .map(creatSalesRequest, Sale.class);
        saleRepository.save(sale);

    }

}
