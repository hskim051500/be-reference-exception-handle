package com.springboot.member.controller.worse_case;

import com.springboot.exception.BusinessLogicException;
import com.springboot.exception.ExceptionCode;
import com.springboot.member.dto.MemberPostDto;
import com.springboot.member.entity.Member;
import com.springboot.member.mapper.MemberMapper;
import com.springboot.member.service.worse_case.MemberServiceWorseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/worse-case/members")
public class MemberControllerWorseCase {
    private final MemberServiceWorseCase memberService;
    private final MemberMapper mapper;

    public MemberControllerWorseCase(MemberServiceWorseCase memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    // Worse case
    @PostMapping
    public ResponseEntity postMember(MemberPostDto memberPostDto) {
        boolean existsMember = memberService.existsMember(memberPostDto.getEmail());
        if (!existsMember) {
            Member response = memberService.createMember(mapper.memberPostDtoToMember(memberPostDto));
            return new ResponseEntity<>(mapper.memberToMemberResponseDto(response),
                    HttpStatus.CREATED);
        }

        throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
    }
}
