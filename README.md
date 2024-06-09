# 예외 처리 레퍼런스 코드

### Description
예외 처리 레퍼런스 코드는 학습 컨텐츠에서 사용되는 예제 코드 + 라이브 세션에서 사용되는 예제 코드로 구성이 되어 있습니다.
* 학습 컨텐츠용 예제 코드
  * [@ExceptionHandler 예제 코드](#exceptionHandler-예제-코드)
  * [@RestControllerAdvice 예제 코드](#restControllerAdvice-예제-코드)
  * [비즈니스적인 예외 throw 예제 코드](#비즈니스적인-예외-throw-예제-코드)
* 라이브 세션용 예제 코드
  * [예외 처리 Worse case 예제 코드](#예외-처리-Worse-case-예제-코드)
    
> 예제 코드에 대한 더 구체적인 정보는 아래에서 확인하세요.

---

### @ExceptionHandler 예제 코드
@ExceptionHandler 애너테이션을 이용해 Controller에서 예외를 처리하는 예제 코드입니다.

* 소스 코드 경로
  * [src/main/java/com/codestates/member/controller](https://github.com/codestates-seb/be-reference-exception-handle/tree/main/src/main/java/com/codestates/member/controller)

---

### @RestControllerAdvice 예제 코드
@RestControllerAdvice 애너테이션을 이용해 Controller에서 throw된 예외를 공통으로 처리하는 예제 코드입니다.

* 소스 코드 경로
  * [src/main/java/com/codestates/advice](https://github.com/codestates-seb/be-reference-exception-handle/tree/main/src/main/java/com/codestates/advice)

---

### 비즈니스적인 예외 throw 예제 코드
서비스 계층에서 비즈니스적인 예외를 의도적으로 throw하는 예제 코드입니다.

* 소스 코드 경로
  * [src/main/java/com/codestates/member/service](https://github.com/codestates-seb/be-reference-exception-handle/tree/main/src/main/java/com/codestates/member/service)

---

### 예외 처리 Worse case 예제 코드
서비스 계층에서의 비즈니스적인 예외 처리에 대한 Worse case 예제 코드입니다.

* 소스 코드 경로
  * [src/main/java/com/codestates/member/service/worse_case](https://github.com/codestates-seb/be-reference-exception-handle/tree/main/src/main/java/com/codestates/member/service/worse_case)

---
