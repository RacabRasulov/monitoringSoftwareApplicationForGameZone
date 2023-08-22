package az.monitoringSoftware.monitoringSoftware.business.requests.devices;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class CreatDevicesRequest {

    @NotNull (message = "Device name can't be null")
    @NotEmpty (message = "Device name can't be empty")
    @Size(min=2,max = 64,message = "Device name length must be min 2max 64")
    private String name;
    private double price;
    private String explanation;
}
