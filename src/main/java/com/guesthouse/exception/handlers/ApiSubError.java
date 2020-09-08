package com.guesthouse.exception.handlers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiSubError {
    private String field;
    private String message;
}
