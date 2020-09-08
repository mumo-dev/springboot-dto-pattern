package com.guesthouse.controller;


import com.guesthouse.service.AbstractCrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@AllArgsConstructor
public abstract class AbstractCrudController<T, D> {
    protected final AbstractCrudService<T,D> abstractCrudService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    protected Collection<D> getAll() {
        return abstractCrudService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    protected D getById(@PathVariable(name = "id") Long id) {
        return abstractCrudService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    protected D create(@Valid @RequestBody D dto) {
        return abstractCrudService.create(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    protected D update(@Valid @RequestBody D dto, @PathVariable(name = "id") Long id) {
        return abstractCrudService.update(dto, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete( @PathVariable(name = "id") Long id) {
         abstractCrudService.delete(id);
    }

}
