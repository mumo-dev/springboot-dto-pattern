package com.guesthouse.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.LazyGroup;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "product_reviews")
public class ProductReview extends AuditModel {

    @Column(name = "review_comment")
    private String reviewComment;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @LazyGroup("user")
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @LazyGroup("product")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
