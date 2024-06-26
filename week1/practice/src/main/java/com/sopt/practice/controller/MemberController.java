package com.sopt.practice.controller;

import com.sopt.practice.service.MemberService;
import com.sopt.practice.service.dto.MemberCreateDto;
import com.sopt.practice.service.dto.MemberFindDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity createMember(@RequestBody MemberCreateDto memberCreateDto)
    {
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreateDto))).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(
            @PathVariable Long memberId
    ){
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @DeleteMapping("/{memberId}")
    public void deleteMember(
            @PathVariable Long memberId
    ) {
        memberService.deleteMember(memberId);
    }

}
