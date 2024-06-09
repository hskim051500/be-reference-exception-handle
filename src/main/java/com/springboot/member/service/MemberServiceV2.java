package com.springboot.member.service;

import com.springboot.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * V2
 *  - 메서드 구현
 *  - DI 적용
 *  - RuntimeException을 이용한 예외 throw
 */
@Service
public class MemberServiceV2 {
    public Member createMember(Member member) {
        // should business logic

        // member 객체는 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요.
        Member createdMember = member;
        return createdMember;
    }

    public Member updateMember(Member member) {
        // should business logic

        // member 객체는 나중에 DB에 업데이트 후, 되돌려 받는 것으로 변경 필요.
        Member updatedMember = member;
        return updatedMember;
    }

    public Member findMember(long memberId) {
        // should business logic

        throw new RuntimeException("Not found member");
    }

    public List<Member> findMembers() {
        // should business logic

        // member 객체는 나중에 DB에서 조회하는 것으로 변경 필요.
        List<Member> members = List.of(
                new Member(1, "hgd@gmail.com", "홍길동", "010-1234-5678"),
                new Member(2, "lml@gmail.com", "이몽룡", "010-1111-2222")
        );
        return members;
    }

    public void deleteMember(long memberId) {
        // should business logic
    }
}
