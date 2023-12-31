package az.monitoringSoftware.monitoringSoftware.business.responses.devices;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class GetAllDeviceResponse {
    private UUID id;
    private String name;
    private Double price;

}
