package com.guesthouse.service;

import com.guesthouse.mapper.AbstractMapper;
import com.guesthouse.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @param <T> Type - Entity
 * @param <D> Dto - type dto
 */
@AllArgsConstructor
public abstract class AbstractCrudService<T, D> {

    private final JpaRepository<T, Long> repository;
    private final AbstractMapper<T, D> mapper;

    public D create(D dto) {
        T t = mapper.convertToEntity(dto);
        T savedEntity = repository.save(t);
        return mapper.convertToDto(savedEntity);
    }
    public D update(D dto, Long id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource with id " + id + " not found"));
        T t = mapper.convertToEntity(dto);
        T savedEntity = repository.save(t);
        return mapper.convertToDto(savedEntity);
    }

    public D findById(Long id) {
        T t = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource with id " + id + " not found"));
        return mapper.convertToDto(t);
    }

    public Collection<D> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::convertToDto)
                .collect(Collectors.toList());
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    //   Page<T> findAll(Pageable pageable);
    //   void deleteAll(Iterable<Long> id);
}
