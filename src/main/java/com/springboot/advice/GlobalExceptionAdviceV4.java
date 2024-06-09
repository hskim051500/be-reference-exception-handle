package com.springboot.advice;

import com.springboot.exception.BusinessLogicException;
import com.springboot.response.ErrorResponseV2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

/**
 * BusinessLogicException을 통해 적절한 예외를 동적으로 처리할 수 있음.
 *  - 처리는 실습 과제로 대체
 */
//@RestControllerAdvice
public class GlobalExceptionAdviceV4 {
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
    public ErrorResponseV2 handleBusinessLogicException(BusinessLogicException e) {
        System.out.println(e.getExceptionCode().getStatus());
        System.out.println(e.getMessage());
        return null;
    }
}
