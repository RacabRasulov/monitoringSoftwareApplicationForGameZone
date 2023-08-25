package az.monitoringSoftware.monitoringSoftware.domain.entities;


import az.monitoringSoftware.monitoringSoftware.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Devices")
public class Device extends BaseEntity {
    private String name;
    private double price;




    @OneToMany(mappedBy = "device",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Desk> desk;
}
