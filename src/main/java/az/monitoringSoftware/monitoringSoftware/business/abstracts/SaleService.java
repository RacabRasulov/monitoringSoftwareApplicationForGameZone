package az.monitoringSoftware.monitoringSoftware.business.abstracts;

import az.monitoringSoftware.monitoringSoftware.business.requests.sale.CreateSaleRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.sale.GetSaleByDeskIdRequest;

import java.util.UUID;

public interface SaleService {
    void add(CreateSaleRequest createSaleRequest);

    GetSaleByDeskIdRequest getSaleByDeskIdRequest(String id);
}
