package com.springboot.member.service.check_exception_example;


import com.springboot.member.entity.Member;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 체크 예외 예제 코드
 *  - try ~ catch 문으로 예외를 처리하든가 throws 키워드로 예외를 미루어야 함.
 */
public class MemberServiceCheckExceptionExample {
    /**
     * try ~ catch 문으로 체크 예외 처리하기
     */
    public Member findMemberV1(long memberId) {
        Member member = null; // DB에서 조회한다고 가정
        try {
            FileReader fileReader = new FileReader("D:/user/photo/" + member.getEmail() + memberId + ".png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return member;
    }

    /**
     * throws 키워드로 예외 전가
     *  - 즉, 메서드를 호출한 쪽에서 예외를 처리하도록 처리를 미룬다.
     */
    public Member findMemberV2(long memberId) throws FileNotFoundException {
        Member member = null; // DB에서 조회한다고 가정
        FileReader fileReader = new FileReader("D:/user/photo/" + member.getEmail() + memberId + ".png");

        return member;
    }
}
