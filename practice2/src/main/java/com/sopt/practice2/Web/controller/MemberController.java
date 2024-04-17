package com.sopt.practice2.Web.controller;

import com.sopt.practice2.Service.MemberService;
import com.sopt.practice2.Web.dto.MemberCreateDto;
import com.sopt.practice2.Web.dto.MemberFindDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController // @Controller + @ResponseBody : java 객체로 반환되는 값을 JSON으로 변환하여 리턴
@RequiredArgsConstructor // DI를 위해 사용, final 필드 + @NonNull이 붙은 필드에 대해 생성자 생성
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity createMember(
            @RequestBody MemberCreateDto memberCreateDto // DTO 데이터를 자바 객체로 변환하여 받아온다.
    ){
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreateDto))).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(
            @PathVariable Long memberId
    ){
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @DeleteMapping("/{memberId}")
    public void deleteMemberById(
            @PathVariable Long memberId
    ){
        memberService.deleteMemberById(memberId);
    }
}
