package com.springboot.exception;

public class MemberNotFoundException extends BusinessLogicException {
    public MemberNotFoundException() {
        super(ExceptionCode.MEMBER_NOT_FOUND);
    }
}
