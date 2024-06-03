package org.sopt.practice.dto.response;

import org.sopt.practice.domain.Member;
import org.sopt.practice.domain.enums.Part;

public record MemberFindDto(
        String name,
        Part part,
        int age
) {
    //정적 팩토리 메서드로 객체 생성
    public static MemberFindDto of(
            Member member
    ){
        return new MemberFindDto(member.getUsername(), member.getPart(), member.getAge());
    }
}
