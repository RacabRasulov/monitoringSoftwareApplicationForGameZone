package az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts;

import az.monitoringSoftware.monitoringSoftware.domain.entities.DailyExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface DailyExpenseRepository extends JpaRepository<DailyExpense, UUID> {
    @Query("SELECT e FROM DailyExpense e WHERE DATE(e.createdAt) = :date")
    List<DailyExpense> findAllByCreatedAtDate(@Param("date") LocalDate date);
}
