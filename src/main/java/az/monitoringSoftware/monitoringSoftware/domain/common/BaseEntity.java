package az.monitoringSoftware.monitoringSoftware.domain.common;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass

public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "created_at", updatable = false, nullable = true)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    @Column(name = "created_by", nullable = true, updatable = false)
    private String createdBy;

    @Column(name = "updated_by", nullable = true)
    private String updatedBy;

//    @PrePersist
//    protected void prePersist() {
//        if (this.createdAt == null) createdAt = LocalDateTime.now();
//        createdBy = SecurityContextHolder.getContext().getAuthentication().getName();
//    }
//
//    @PreUpdate
//    protected void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//        updatedBy = SecurityContextHolder.getContext().getAuthentication().getName();
//    }
}
