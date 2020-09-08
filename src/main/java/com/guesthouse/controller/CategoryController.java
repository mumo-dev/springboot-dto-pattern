package com.guesthouse.controller;

import com.guesthouse.dto.CategoryDto;
import com.guesthouse.model.Category;
import com.guesthouse.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/categories")
public class CategoryController extends AbstractCrudController<Category, CategoryDto> {

    public CategoryController( CategoryService categoryService) {
        super(categoryService);
    }
}
