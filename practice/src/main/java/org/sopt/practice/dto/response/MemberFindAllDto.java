package org.sopt.practice.dto.response;

import org.sopt.practice.domain.Member;
import org.sopt.practice.domain.enums.Part;

public record MemberFindAllDto(

        String name,
        Part part,
        int age
) {
    public static MemberFindAllDto of(
            Member member
    ){
        return new MemberFindAllDto(member.getUsername(), member.getPart(), member.getAge());
    }
}
