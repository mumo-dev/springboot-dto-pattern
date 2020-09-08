package com.guesthouse.repository;

import com.guesthouse.model.ProductReview;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

    ProductReview findByUser_IdAndProduct_Id(Long userId, Long productId);

    @EntityGraph(attributePaths = {"user", "product"})
    Collection<ProductReview> findByProduct_Id(Long productId);
}
