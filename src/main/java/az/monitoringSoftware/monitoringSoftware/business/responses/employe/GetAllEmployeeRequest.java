package az.monitoringSoftware.monitoringSoftware.business.responses.employe;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class GetAllEmployeeRequest {
    @NotNull(message = "Employe name can't be null")
    @NotEmpty(message = "Employe name can't be empty")
    @Size(min = 2,max = 64,message = "Employe name length must be min 2 max 64")
    private String name;

    @NotNull(message = "Employe surname can't be null")
    @NotEmpty(message = "Employe surname can't be empty")
    @Size(min = 2,max = 64,message = "Employe surname length must be min 2 max 64")
    private String surname;
    private Integer contactNumber;
    private String passportSeries;
    private Integer passportNumber;
    private double salary;
}
