package com.guesthouse.mapper;

import com.guesthouse.dto.CategoryDto;
import com.guesthouse.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper extends AbstractMapper<Category, CategoryDto> {

    @Override
    public Category convertToEntity(CategoryDto categoryDto) {
        if(categoryDto == null) {
            return  null;
        }

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        return category;
    }

    @Override
    public CategoryDto convertToDto(Category category) {
        if(category == null) {
            return  null;
        }
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }
}
