package com.springboot.advice;

import com.springboot.response.ErrorResponseV2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

/**
 * 비즈니스 로직 예외 처리(RuntimeException) 정의만.
 *  - 현재는 미처리
 *  - RuntimeException은 가장 큰 범위인데 HttpStatus.NOT_FOUND로 고정하는 나쁜 케이스
 */
//@RestControllerAdvice
public class GlobalExceptionAdviceV3 {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseV2 handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        final ErrorResponseV2 response = ErrorResponseV2.of(e.getBindingResult());

        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseV2 handleConstraintViolationException(
            ConstraintViolationException e) {
        final ErrorResponseV2 response = ErrorResponseV2.of(e.getConstraintViolations());

        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseV2 handleResourceNotFoundException(RuntimeException e) {
        System.out.println(e.getMessage());
        return null;
    }
}
