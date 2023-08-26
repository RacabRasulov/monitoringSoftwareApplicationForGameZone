package az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts;

import az.monitoringSoftware.monitoringSoftware.domain.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Device, UUID> {
    void deleteById(UUID id);

    boolean existsByName(String name);

    Optional<Device> findById(UUID id);
}
