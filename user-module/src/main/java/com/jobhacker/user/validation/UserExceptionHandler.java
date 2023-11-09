package com.jobhacker.user.validation;

import com.jobhacker.user.exception.AddingException;
import com.jobhacker.user.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class UserExceptionHandler {

    // handle Adding exception
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AddingException.class)
    public Map<String, String> handleAddingException(AddingException addingException){
        Map<String, String> error = new HashMap<>();
        error.put("error", addingException.getMessage());
        return error;
    }

    //handle AppUserNotFound exception
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleAppUserNotFoundException(UserNotFoundException userNotFoundException){
        Map<String, String> error = new HashMap<>();
        error.put("error", userNotFoundException.getMessage());
        return error;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}

