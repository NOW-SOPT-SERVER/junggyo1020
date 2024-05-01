package com.sopt.practice2.Service;

import com.sopt.practice2.Repository.MemberRepository;
import com.sopt.practice2.Web.dto.MemberCreateDto;
import com.sopt.practice2.Web.dto.MemberFindDto;
import com.sopt.practice2.domain.Member;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public String createMember(
            MemberCreateDto memberCreateDto
    ) {
        Member member = Member.builder()
                .name(memberCreateDto.name())
                .part(memberCreateDto.part())
                .age(memberCreateDto.age())
                .build();
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
        memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        );
        memberRepository.deleteById(memberId);
    }

    // 멤버 리스트 모든 멤버를 조회하는 메서드 추가하기
    public List<MemberFindDto> findAllMembers() {
        return memberRepository.findAll().stream()
                .map(member -> new MemberFindDto(member.getName(), member.getPart(), member.getAge()))
                .collect(Collectors.toList());
    }
}
