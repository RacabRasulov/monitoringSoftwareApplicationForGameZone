package az.monitoringSoftware.monitoringSoftware.domain.entities;

import az.monitoringSoftware.monitoringSoftware.domain.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")
public class Product extends BaseEntity {
    private String name;
    private double price;
    private String explanation;
    private double cost;
    private String nameOfSeller;
    private Integer count;

}
