package com.guesthouse.mapper;

import com.guesthouse.dto.CategoryDto;
import com.guesthouse.dto.ProductDto;
import com.guesthouse.dto.ProductReviewDto;
import com.guesthouse.exception.ResourceNotFoundException;
import com.guesthouse.model.Category;
import com.guesthouse.model.Product;
import com.guesthouse.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Component
public class ProductMapper extends AbstractMapper<Product, ProductDto> {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    private final ProductReviewMapper productReviewMapper;

    @Override
    public Product convertToEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        Category category;
        Long categoryId = productDto.getCategoryId();
        if (categoryId != null) {
            category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Category with id " + categoryId + " not found"));
        } else {
            category = categoryMapper.convertToEntity(productDto.getCategoryDto());
        }
        product.setCategory(category);
        return product;
    }

    @Override
    public ProductDto convertToDto(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());

        if (isInitialized(product.getCategory())) {
            CategoryDto categoryDto = categoryMapper.convertToDto(product.getCategory());
            productDto.setCategoryDto(categoryDto);
        }

        if (isInitialized(product.getProductReviews())) {
            log.info("Product reviews initialized " );
            List<ProductReviewDto> productReviewDtos = product.getProductReviews()
                    .stream()
                    .map(productReviewMapper::convertToDto)
                    .collect(Collectors.toList());

            productDto.setProductReviews(productReviewDtos);

        }
        return productDto;
    }
}
