package com.guesthouse.controller;

import com.guesthouse.dto.ProductDto;
import com.guesthouse.dto.ProductReviewDto;
import com.guesthouse.model.Product;
import com.guesthouse.service.ProductReviewService;
import com.guesthouse.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController  extends AbstractCrudController<Product, ProductDto>{

    private final ProductService productService;
    private final ProductReviewService productReviewService;
    public ProductController(ProductService productService,ProductReviewService productReviewService) {
        super(productService);
        this.productService = productService;
        this.productReviewService = productReviewService;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{productId}/withreviews")
    public ProductDto getProductWithReviews(@PathVariable("productId")Long productId) {
        return productService.getProductWithReviews(productId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{productId}/reviews")
    public List<ProductReviewDto> getProductReviews(@PathVariable("productId")Long productId) {
       return productReviewService.getProductReviews(productId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{productId}/reviews")
    public ProductReviewDto addProductReview(
            @PathVariable("productId")Long productId, @Valid @RequestBody ProductReviewDto productReviewDto) {

        Long loggedInUserId = 1L;
        productReviewDto.setProductId(productId);
        productReviewDto.setUserId(loggedInUserId);
        return productReviewService.addReview(productReviewDto);
    }
}
