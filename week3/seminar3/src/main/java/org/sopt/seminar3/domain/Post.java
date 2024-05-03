package org.sopt.seminar3.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    // Blog 와 Post는 N:1 관계
    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

    @Builder(access = PRIVATE)
    private Post(final Blog blog, final String title, final String content) {
        this.blog = blog;
        this.title = title;
        this.content = content;
    }

    // 생성 메서드 정의
    public static Post createPost(final Blog blog, final String title, final String content){
        return Post.builder()
                .blog(blog)
                .title(title)
                .content(content)
                .build();
    }
}

