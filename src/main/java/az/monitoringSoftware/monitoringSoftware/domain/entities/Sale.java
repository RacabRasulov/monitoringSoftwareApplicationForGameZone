package az.monitoringSoftware.monitoringSoftware.domain.entities;

import az.monitoringSoftware.monitoringSoftware.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales")
public class Sale extends BaseEntity {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String deviceName;
    private UUID deviceId;
    private String deskName;
    private UUID deskId;
    private Double devicePrice;
    private Integer hour;
    private Integer minutes;
    private Boolean isDefaultTimeChecked;
    private Double totalProductAmount;
    private Double totalGameAmount;
    private Double totalAmount;
    private Boolean isSaleEnded;
    @OneToMany(mappedBy = "sale", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SaleProduct> saleProducts = new ArrayList<>();

}
