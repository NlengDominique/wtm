package fr.univjardinage.jardinage.repo;

import fr.univjardinage.jardinage.entity.Product;
import fr.univjardinage.jardinage.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(ProductCategory category);
    List<Product> findByActiveTrue(Boolean active);
    List<Product> findByActiveFalse(Boolean active);
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<Product> findByCategoryAndActiveTrue(ProductCategory category, Boolean active);
    Optional<Product> findByNameIgnoreCase(String name);
    Long countByCategory(ProductCategory category);
    Boolean existsByNameIgnoreCase(String name);
    @Query("SELECT p from Product p where p.stock < :threshold and p.active = true ")
    List<Product> findLowStockProducts(@Param("threshold") Integer threshold);
    @Query("SELECT DISTINCT p.category from Product p where p.active=true ")
    List<ProductCategory> findAllActiveCategories();
    @Query(value = "select * from products where price > : minPrice and stock > 0",nativeQuery = true)
    List<Product> findAvailableProductsAbovePrice(@Param("minPrice") BigDecimal minPrice);
}
