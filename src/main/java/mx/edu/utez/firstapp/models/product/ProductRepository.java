package mx.edu.utez.firstapp.models.product;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
}
