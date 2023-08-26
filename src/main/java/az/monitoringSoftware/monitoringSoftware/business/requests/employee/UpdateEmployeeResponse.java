package az.monitoringSoftware.monitoringSoftware.business.requests.employee;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeResponse {

    @NotNull(message = "Employe name can't be null")
    @NotEmpty(message = "Employe name can't be empty")
    @Size(min = 2,max = 64,message = "Employe name length must be min 2 max 64")
    private String name;

    @NotNull(message = "Employe surname can't be null")
    @NotEmpty(message = "Employe surname can't be empty")
    @Size(min = 2,max = 64,message = "Employe surname length must be min 2 max 64")
    private String surname;
    private UUID id;
    private Integer contactNumber;
    private String passportSeries;
    private Integer passportNumber;
    private double salary;
}

