package com.springboot.advice;

import com.springboot.response.ErrorResponseV2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

/**
 * MethodArgumentNotValidException 처리
 *  - ErrorResponse.of(e.getBindingResult())를 이용해서 에러에 대한 구체적인 정보를 ErrorResponse가 만든다.
 * ConstraintViolationException 처리
 *  - ErrorResponse.of(e.getConstraintViolations())를 이용해서 에러에 대한 구체적인 정보를 ErrorResponse가 만든다.
 */
//@RestControllerAdvice
public class GlobalExceptionAdviceV2 {
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
}
