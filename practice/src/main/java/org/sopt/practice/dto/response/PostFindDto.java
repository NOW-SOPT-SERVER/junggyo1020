package org.sopt.practice.dto.response;

import org.sopt.practice.domain.Post;

public record PostFindDto(
        Long blogId,
        String title,
        String content

) {
    public static PostFindDto of(
            Post post
    ){
        return new PostFindDto(post.getBlog().getId(), post.getTitle(), post.getContent());
    }
}
