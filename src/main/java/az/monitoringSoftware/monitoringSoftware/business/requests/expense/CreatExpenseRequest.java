package az.monitoringSoftware.monitoringSoftware.business.requests.expense;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class CreatExpenseRequest {
//    @NotNull(message = "Expense name can't be null")
//    @NotEmpty(message = "Expense name can't be empty")
//    @Size(min = 2, max = 64, message = "Expense name length must be min 2 max 64")
    private String name;
}
