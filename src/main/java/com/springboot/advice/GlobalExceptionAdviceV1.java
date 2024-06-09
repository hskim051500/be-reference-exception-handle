package com.springboot.advice;

import com.springboot.response.ErrorResponseV1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MethodArgumentNotValidException 처리
 *  - ErrorResponse를 만드는 로직이 포함되어 있다. (생성자 방식)
 * ConstraintViolationException 미처리
 */
//@RestControllerAdvice
public class GlobalExceptionAdviceV1 {
    @ExceptionHandler
    public ResponseEntity handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        List<ErrorResponseV1.FieldError> errors =
                fieldErrors.stream()
                        .map(error -> new ErrorResponseV1.FieldError(
                                error.getField(),
                                error.getRejectedValue(),
                                error.getDefaultMessage()))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(new ErrorResponseV1(errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleConstraintViolationException(
            ConstraintViolationException e) {
        // TODO should implement for validation
        System.out.println(e.getConstraintViolations().stream().collect(Collectors.toList()));

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
