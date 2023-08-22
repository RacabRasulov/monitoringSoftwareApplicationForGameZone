package az.monitoringSoftware.monitoringSoftware.domain.entities;


import az.monitoringSoftware.monitoringSoftware.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Devices")
public class Device extends BaseEntity {
    private String name;
    private double price;
    private String explanation;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "desk", nullable = false)
    private Desk desk;


}
