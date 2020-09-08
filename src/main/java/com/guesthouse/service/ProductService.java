package com.guesthouse.service;

import com.guesthouse.dto.ProductDto;
import com.guesthouse.exception.ResourceNotFoundException;
import com.guesthouse.mapper.ProductMapper;
import com.guesthouse.model.Product;
import com.guesthouse.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService extends AbstractCrudService<Product, ProductDto> {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        super(productRepository, productMapper);
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    public ProductDto getProductWithReviews(Long productId) {

        Product product = productRepository.findByIdWithReviews(productId);
        if(product == null) {
            throw new ResourceNotFoundException("Product with id "+ productId + " not found");
        }

        log.info("Fetched Product " + product);
        return productMapper.convertToDto(product);
    }
}
