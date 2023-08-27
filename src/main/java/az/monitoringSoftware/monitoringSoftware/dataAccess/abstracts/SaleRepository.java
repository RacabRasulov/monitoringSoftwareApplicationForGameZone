package az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts;

import az.monitoringSoftware.monitoringSoftware.domain.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SaleRepository extends JpaRepository<Sale, UUID> {


    Sale findByDeskId(UUID id);
    @Query("SELECT s FROM Sale s WHERE s.deskId = :id AND (s.isSaleEnded = false OR s.isSaleEnded IS NULL)")
    Optional<Sale> findSalesByDeskIdAndIsSaleEnded(UUID id);


}
