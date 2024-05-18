package org.sopt.seminar3.dto;

import org.sopt.seminar3.domain.Post;

public record PostFindDto(String title, String content) {
    public static PostFindDto of(
            Post post
    ){
        return new PostFindDto(post.getTitle(), post.getContent());
    }
}
