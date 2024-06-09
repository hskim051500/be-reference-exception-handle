package com.springboot.member.controller.controller_v8;

import com.springboot.member.dto.MemberPatchDto;
import com.springboot.member.dto.MemberPostDto;
import com.springboot.member.dto.MemberResponseDto;
import com.springboot.member.entity.Member;
import com.springboot.member.mapper.MemberMapper;
import com.springboot.member.service.MemberServiceV1;
import com.springboot.response.ErrorResponseV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;


/**
 * - @ExceptionHandler를 여러개 적용
 */
@RestController
@RequestMapping("/v8/members")
@Validated
@Slf4j
public class MemberControllerV8 {
    private final MemberServiceV1 memberService;
    private final MemberMapper mapper;

    public MemberControllerV8(MemberServiceV1 memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {
        Member member = mapper.memberPostDtoToMember(memberDto);

        Member response = memberService.createMember(member);

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(
            @PathVariable("member-id") @Positive long memberId,
            @Valid @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);

        Member response =
                memberService.updateMember(mapper.memberPatchDtoToMember(memberPatchDto));

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response),
                HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(
            @PathVariable("member-id") @Positive long memberId) {
        Member response = memberService.findMember(memberId);
        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        List<Member> members = memberService.findMembers();
        List<MemberResponseDto> response = mapper.membersToMemberResponseDtos(members);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(
            @PathVariable("member-id") @Positive long memberId) {
        System.out.println("# delete member");
        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException e) {
        // (1)
        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        // (2)
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
    public ResponseEntity handleException(ConstraintViolationException e) {
        /**
         * - ConstraintViolationException 클래스는 getBindingResult().getFieldErrors()
         * 와 같이 에러 정보를 얻을 수 없다.
         * - MethodArgumentNotValidException과 다르게 또 다른 방식으로 처리가 필요.
         */

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
