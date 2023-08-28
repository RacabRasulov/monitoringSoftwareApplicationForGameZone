package az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts;

import az.monitoringSoftware.monitoringSoftware.domain.entities.DailyExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DailyExpenseRepository extends JpaRepository<DailyExpense, UUID> {
}
