package az.monitoringSoftware.monitoringSoftware.business.concretes;

import az.monitoringSoftware.monitoringSoftware.business.abstracts.SaleService;
import az.monitoringSoftware.monitoringSoftware.business.requests.sale.CreatSaleRequest;
import az.monitoringSoftware.monitoringSoftware.core.utilities.mappers.ModelMapperManager;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.DeskRepository;
import az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts.SaleRepository;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Desk;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Sale;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SaleManager implements SaleService {
    public final SaleRepository saleRepository;
    public final ModelMapperManager modelMapperManager;
    public final DeskRepository deskRepository;


    @Override
    public void add(CreatSaleRequest creatSaleRequest) {
        Optional<Desk> desk = deskRepository.findById(UUID.fromString(String
                .valueOf(creatSaleRequest.getDeskId())));


        Sale sale = modelMapperManager.forRequest()
                .map(creatSaleRequest, Sale.class);

        sale.setDeskName(desk.get().getName());
        sale.setDeviceId(desk.get().getDevice().getId());
        sale.setDeviceName(desk.get().getDevice().getName());
        sale.setDevicePrice(desk.get().getDevice().getPrice());

        saleRepository.save(sale);

    }

}
