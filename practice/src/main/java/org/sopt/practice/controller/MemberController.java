package org.sopt.practice.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.domain.Member;
import org.sopt.practice.dto.request.MemberCreateRequest;
import org.sopt.practice.dto.response.MemberFindAllDto;
import org.sopt.practice.dto.response.MemberFindDto;
import org.sopt.practice.dto.response.UserJoinResponse;
import org.sopt.practice.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController //ResponseBody가 내부에 존재
@RequiredArgsConstructor //의존성 주입 (final 필드나, @NonNull 붙은 필드에 생성자 생성)
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<UserJoinResponse> createMember( //ResponseEntity는 빌더패턴 지원(상태코드, 헤더, 바디를 담아보냄)
            @RequestBody MemberCreateRequest memberCreateRequest
    ){
        UserJoinResponse userJoinResponse = memberService.createMember(memberCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userJoinResponse.userId())
                .body(userJoinResponse);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(
            @PathVariable Long memberId
    ){
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMemberById(
            @PathVariable Long memberId
    ){
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<MemberFindAllDto>> findAllMembers(){
        List<Member> members = memberService.findAllMembers();
        List<MemberFindAllDto> memberFindAllDtoList = members.stream()
                .map(MemberFindAllDto::of)
                .collect(Collectors.toList());
        return ResponseEntity.ok(memberFindAllDtoList);
    }
}