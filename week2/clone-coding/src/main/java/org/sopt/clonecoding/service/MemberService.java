package org.sopt.clonecoding.service;

import lombok.RequiredArgsConstructor;
import org.sopt.clonecoding.domain.Member;
import org.sopt.clonecoding.repository.MemberRepository;
import org.sopt.clonecoding.web.dto.MemberCreateDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional
    public String createMember(MemberCreateDto memberCreateDto){
        Member member = Member.create(memberCreateDto.name(), memberCreateDto.age());
        memberRepository.save(member);
        return member.getId().toString();
    }
}
