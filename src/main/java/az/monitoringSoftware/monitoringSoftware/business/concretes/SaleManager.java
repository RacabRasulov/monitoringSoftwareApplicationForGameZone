package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.SaleService;
import az.monitoringSoftware.monitoringSoftware.business.requests.sale.CreateSaleRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.sale.GetSaleByDeskIdRequest;
import az.monitoringSoftware.monitoringSoftware.business.requests.saleProduct.CreatSaleProductRequest;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.DeskRepository;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.ProductRepository;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.SaleRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Desk;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Sale;
import az.monitoringSoftware.monitoringSoftware.domain.entities.SaleProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SaleManager implements SaleService {
    private final SaleRepository saleRepository;
    private final ModelMapperManager modelMapperManager;
    private final DeskRepository deskRepository;


    @Override
    public void add(CreateSaleRequest createSaleRequest) {
        Optional<Desk> desk = deskRepository.findById(UUID.fromString(String
                .valueOf(createSaleRequest.getDeskId())));

        Sale sale = new Sale();

        for(CreatSaleProductRequest createSaleProduct : createSaleRequest.getSaleProducts()){
            SaleProduct saleProduct = new SaleProduct();
            saleProduct.setProductId(createSaleProduct.getProductId());
            saleProduct.setName(createSaleProduct.getName());
            saleProduct.setPrice(createSaleProduct.getPrice());
            saleProduct.setOrderCount(createSaleProduct.getOrderCount());
            sale.getSaleProducts().add(saleProduct);
        }

        sale.setStartDate(createSaleRequest.getStartDate());
        sale.setHour(createSaleRequest.getHour());
        sale.setMinutes(createSaleRequest.getMinutes());
        sale.setIsDefaultTimeChecked(createSaleRequest.getIsDefaultTimeChecked());
        sale.setDeskId(createSaleRequest.getDeskId());
        sale.setDeskName(desk.get().getName());
        sale.setDeviceId(desk.get().getDevice().getId());
        sale.setDeviceName(desk.get().getDevice().getName());
        sale.setDevicePrice(desk.get().getDevice().getPrice());
        for(SaleProduct product : sale.getSaleProducts()){
            product.setSale(sale);
        }
        saleRepository.save(sale);

    }

    @Override
    public GetSaleByDeskIdRequest getSaleByDeskIdRequest(String id) {

        Optional<Sale> saleDetails = saleRepository.findById(UUID.fromString("83f91dba-f560-4ca8-a90e-f06bd9a3bc9b"));

        if(saleDetails == null)
            return null;
        else{
            return modelMapperManager.forResponse()
                    .map(saleDetails, GetSaleByDeskIdRequest.class);
        }
    }

}
