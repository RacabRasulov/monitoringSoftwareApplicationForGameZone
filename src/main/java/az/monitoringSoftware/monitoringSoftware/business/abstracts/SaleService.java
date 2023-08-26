package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.sale.CreateSaleRequest;

public interface SaleService {
    void add(CreateSaleRequest createSaleRequest);
}
