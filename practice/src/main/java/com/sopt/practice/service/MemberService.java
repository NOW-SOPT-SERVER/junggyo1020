package com.sopt.practice.service;

import com.sopt.practice.domain.Member;
import com.sopt.practice.repository.MemberRepository;
import com.sopt.practice.service.dto.MemberCreateDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional
    public String createMember(final MemberCreateDto memberCreateDto)
    {
        Member member = Member.create(memberCreateDto.name(),memberCreateDto.part(),memberCreateDto.age());
        memberRepository.save(member);
        return member.getId().toString();
    }

}
