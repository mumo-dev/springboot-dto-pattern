package com.guesthouse.mapper;

import com.guesthouse.dto.ProductReviewDto;
import com.guesthouse.exception.ResourceNotFoundException;
import com.guesthouse.model.Product;
import com.guesthouse.model.ProductReview;
import com.guesthouse.model.User;
import com.guesthouse.repository.ProductRepository;
import com.guesthouse.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductReviewMapper extends AbstractMapper<ProductReview, ProductReviewDto> {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public ProductReview convertToEntity(ProductReviewDto productReviewDto) {

        if(productReviewDto == null) {
            return  null;
        }

        ProductReview productReview = new ProductReview();
        productReview.setId(productReviewDto.getReviewId());
        productReview.setRating(productReviewDto.getRating());
        productReview.setReviewComment(productReviewDto.getReviewComment());

        if(productReviewDto.getProductId() != null) {
            Product product = productRepository.findById(productReviewDto.getProductId())
                    .orElseThrow(()-> new ResourceNotFoundException(
                            "Product with id " + productReviewDto.getProductId() + " not found"));

            productReview.setProduct(product);
        }


        if(productReviewDto.getUserId() != null) {
            User user = userRepository.findById(productReviewDto.getUserId())
                    .orElseThrow(()-> new ResourceNotFoundException(
                            "User with id " + productReviewDto.getUserId() + " not found"));

            productReview.setUser(user);
        }

        return productReview;
    }

    @Override
    public ProductReviewDto convertToDto(ProductReview productReview) {

        if(productReview == null) {
            return  null;
        }

        ProductReviewDto productReviewDto = new ProductReviewDto();
        productReviewDto.setReviewId(productReview.getId());
        productReviewDto.setReviewComment(productReview.getReviewComment());
        productReviewDto.setRating(productReview.getRating());

        if(isInitialized(productReview.getProduct())) {
            productReviewDto.setProductId(productReview.getProduct().getId());
        }

        if(isInitialized(productReview.getUser())) {
            User user = productReview.getUser();
            productReviewDto.setUserId(user.getId());
            String fullName = user.getFirstName() + " " + user.getLastName();
            productReviewDto.setFullName(fullName);
        }

        productReviewDto.setCreatedAt(productReview.getCreatedAt());
        return productReviewDto;
    }
}
