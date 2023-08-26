package az.monitoringSoftware.monitoringSoftware.business.requests.desk;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor

public class CreateDeskRequest {
    @NotNull(message = "Desk name can't be null")
    @NotEmpty(message = "Desk name can't be empty")
    @Size(min = 2, max = 64, message = "Device name length must be min 2max 64")
    private String name;

    @NotNull(message = "Device can't be null")
    @NotEmpty(message = "Device can't be empty")
    private String deviceId;

}
