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
@Table(name = "Product")
public class ProductEntity extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String productName;
    private Integer productPrice;
    private String productExplanation;


}
