package com.springboot.advice;

import com.springboot.exception.BusinessLogicException;
import com.springboot.response.ErrorResponseV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

/**
 * BusinessLogicException을 통해 적절한 예외를 동적으로 처리할 수 있음.
 *  - HTTP Status 코드만 넘기는 예시
 *  - ErrorResponse를 넘기는 처리는 실습 과제로 대체
 *  - Status가 고정되어 있지 않은 경우에는 ResponseEntity를 사용. 고정되어 있으면 @ResponseStatus를 사용
 */
//@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdviceV5 {
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
    public ResponseEntity handleBusinessLogicException(BusinessLogicException e) {
        System.out.println(e.getExceptionCode().getStatus());
        System.out.println(e.getMessage());
        return new ResponseEntity<>(HttpStatus.valueOf(e.getExceptionCode().getStatus()));
    }
}
