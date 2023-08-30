package az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts;

import az.monitoringSoftware.monitoringSoftware.domain.entities.DailyExpense;
import az.monitoringSoftware.monitoringSoftware.domain.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface DailyExpenseRepository extends JpaRepository<DailyExpense, UUID> {
    @Query("SELECT e FROM DailyExpense e WHERE DATE(e.createdAt) = :date")
    List<DailyExpense> findAllByCreatedAtDate(@Param("date") LocalDate date);

    @Query("SELECT s FROM DailyExpense s WHERE FUNCTION('DATE', s.createdAt) >= :fromDate AND FUNCTION('DATE', s.createdAt) <= :toDate")
    List<DailyExpense> findDailyExpensesBetweenDates(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
