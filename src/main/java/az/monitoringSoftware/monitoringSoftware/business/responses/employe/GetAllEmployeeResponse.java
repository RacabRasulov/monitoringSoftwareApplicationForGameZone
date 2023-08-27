package az.monitoringSoftware.monitoringSoftware.business.responses.employe;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class GetAllEmployeeResponse {

    private String name;

    private String surname;
    private UUID id;
    private String contactNumber;
    private String passportSeries;
    private String passportNumber;
    private double salary;
}
