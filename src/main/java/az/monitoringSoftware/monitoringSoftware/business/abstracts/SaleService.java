package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.sale.CreateSaleRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.sale.EndSaleRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.sale.GetSaleByDeskIdRequest;

import java.util.UUID;

public interface SaleService {
    void add(CreateSaleRequest createSaleRequest);

    GetSaleByDeskIdRequest getSaleByDeskIdRequest(UUID id);

    void endSaleRequest(EndSaleRequest endSaleRequest);
}
