package com.guesthouse.exception.handlers;

import com.guesthouse.exception.InvalidRequestException;
import com.guesthouse.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidRequestAdvice {
    @ResponseBody
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiError invalidRequestFoundHandler(InvalidRequestException ex) {
        return new ApiError(HttpStatus.NOT_FOUND,ex.getMessage());
    }
}
