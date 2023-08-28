package az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts;

import az.monitoringSoftware.monitoringSoftware.domain.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
    Expense findExpenseByName(String name);

}
