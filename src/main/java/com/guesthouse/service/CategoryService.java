package com.guesthouse.service;

import com.guesthouse.dto.CategoryDto;
import com.guesthouse.mapper.CategoryMapper;
import com.guesthouse.model.Category;
import com.guesthouse.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractCrudService<Category, CategoryDto> {

    private  final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        super(categoryRepository, categoryMapper);
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }
}
