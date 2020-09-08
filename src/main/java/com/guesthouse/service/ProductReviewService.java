package com.guesthouse.service;

import com.guesthouse.dto.ProductDto;
import com.guesthouse.dto.ProductReviewDto;
import com.guesthouse.exception.InvalidRequestException;
import com.guesthouse.mapper.ProductMapper;
import com.guesthouse.mapper.ProductReviewMapper;
import com.guesthouse.model.ProductReview;
import com.guesthouse.repository.ProductReviewRepository;
import com.guesthouse.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductReviewService {

    private final ProductReviewRepository productReviewRepository;
    private final ProductReviewMapper productReviewMapper;

    public ProductReviewDto addReview(ProductReviewDto productReviewDto) {

        ProductReview productReview = productReviewRepository.findByUser_IdAndProduct_Id(
                productReviewDto.getUserId(), productReviewDto.getProductId()
        );

        if(productReview != null) {
            throw new InvalidRequestException("The user has reviewed this product before");
        }

        productReview =  productReviewMapper.convertToEntity(productReviewDto);
        ProductReview savedProductReview = productReviewRepository.save(productReview);
        return productReviewMapper.convertToDto(savedProductReview);
    }


    public List<ProductReviewDto> getProductReviews(Long productId) {

        return productReviewRepository.findByProduct_Id(productId)
                .stream()
                .map(productReviewMapper::convertToDto)
                .collect(Collectors.toList());

    }
}
