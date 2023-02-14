package com.blackhoodie.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ErrorResponse> handleException(ErrorException ex) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ErrorResponse res = objectMapper.readValue(ex.getMessage(), ErrorResponse.class);
        return new ResponseEntity(res, HttpStatus.BAD_REQUEST);
    }
}
