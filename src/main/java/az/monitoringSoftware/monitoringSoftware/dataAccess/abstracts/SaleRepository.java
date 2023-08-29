package az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts;

import az.monitoringSoftware.monitoringSoftware.domain.entities.DailyExpense;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SaleRepository extends JpaRepository<Sale, UUID> {


    Sale findByDeskId(UUID id);
    void deleteByDeskId(UUID id);
    @Query("SELECT s FROM Sale s WHERE s.deskId = :id AND (s.isSaleEnded = false OR s.isSaleEnded IS NULL)")
    Optional<Sale> findSalesByDeskIdAndIsSaleNotEnded(UUID id);

    @Query("SELECT e FROM Sale e WHERE DATE(e.startDate) >= :fromDate and DATE(e.startDate) <= :toDate and e.isSaleEnded = true")
    List<DailyExpense> findAllSalesByDateInterval(@Param("fromDate") LocalDate fromDate,@Param("toDate") LocalDate toDate);
}
