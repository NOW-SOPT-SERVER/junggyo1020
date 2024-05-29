package org.sopt.practice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopt.practice.domain.Member;
import org.sopt.practice.dto.MemberCreateDto;
import org.sopt.practice.dto.MemberFindAllDto;
import org.sopt.practice.dto.MemberFindDto;
import org.sopt.practice.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional //변경사항을 DB에 반영
    public String createMember(
            MemberCreateDto memberCreateDto
    ){
        Member member = Member.create(memberCreateDto.name(), memberCreateDto.part(), memberCreateDto.age());
        memberRepository.save(member);
        return member.getId().toString();
    }

    public MemberFindDto findMemberById(
            Long memberId
    ){
        return MemberFindDto.of(memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        ));
    }

    public void deleteMemberById(
            Long memberId
    ){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(
                        () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
                );
        memberRepository.delete(member);
    }

    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }
}
