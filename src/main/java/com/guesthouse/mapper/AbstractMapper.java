package com.guesthouse.mapper;

import com.guesthouse.dto.ProductReviewDto;
import com.guesthouse.model.ProductReview;
import com.guesthouse.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

public abstract class AbstractMapper<T, DTO> {
    public abstract T convertToEntity(DTO dto);

    public abstract DTO convertToDto(T t);

    protected boolean isInitialized(Object object) {
        return Hibernate.isInitialized(object);
    }

}
