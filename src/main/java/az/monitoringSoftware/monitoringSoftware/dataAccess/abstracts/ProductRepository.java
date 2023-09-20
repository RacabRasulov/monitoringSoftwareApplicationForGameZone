package az.monitoringSoftware.monitoringSoftware.dataAccess.abstracts;

import az.monitoringSoftware.monitoringSoftware.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    void deleteById(UUID id);
    Optional<Product> findById(UUID id);
    boolean existsByName(String name);

    @Query("SELECT p FROM Product p WHERE p.stockCount > 0")
    List<Product> findAllWithStock();

}
