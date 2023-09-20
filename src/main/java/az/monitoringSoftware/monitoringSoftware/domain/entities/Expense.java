package az.monitoringSoftware.monitoringSoftware.domain.entities;


import az.monitoringSoftware.monitoringSoftware.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expenses")
public class Expense extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "expense", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DailyExpense> dailyExpenses;
}
