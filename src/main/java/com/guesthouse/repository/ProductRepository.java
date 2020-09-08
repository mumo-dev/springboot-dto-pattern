package com.guesthouse.repository;

import com.guesthouse.model.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //@Query("SELECT p from  Product p LEFT JOIN FETCH p.category")
    @EntityGraph(attributePaths = {"category"})
    List<Product> findAll();

    @EntityGraph(attributePaths = {"category"})
    Optional<Product> findById(Long id);

    @Query("SELECT p from  Product p " +
            " INNER JOIN FETCH p.category" +
            " LEFT JOIN FETCH p.productReviews r" +
            " INNER JOIN FETCH  r.user " +
            " where p.id = :productId " )
    Product findByIdWithReviews(@Param("productId") Long productId);
}
