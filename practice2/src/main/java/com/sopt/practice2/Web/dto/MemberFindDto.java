package com.sopt.practice2.Web.dto;

import com.sopt.practice2.domain.Member;
import com.sopt.practice2.domain.Part;

public record MemberFindDto(
        String name,
        Part part,
        int age
) {
    public static MemberFindDto of(
            Member member
    ){
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }
}
