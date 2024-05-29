package org.sopt.practice.dto;

import org.sopt.practice.domain.Member;
import org.sopt.practice.domain.Part;

public record MemberFindAllDto(

        String name,
        Part part,
        int age
) {
    public static MemberFindAllDto of(
            Member member
    ){
        return new MemberFindAllDto(member.getName(), member.getPart(), member.getAge());
    }
}
