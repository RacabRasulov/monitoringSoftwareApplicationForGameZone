package az.monitoringSoftware.monitoringSoftware.business.responses.desk;


import lombok.*;

import java.util.UUID;

@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class GetAllDesksRequest {
    private UUID id;
    private String name;
    private String deviceName;
    private String deviceId;
    private Double devicePrice;
    private Boolean lastUsingStatus;

}
