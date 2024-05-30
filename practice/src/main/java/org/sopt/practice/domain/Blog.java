package org.sopt.practice.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;

    public static Blog create(final Member member, final String title, final String description){
        return Blog.builder()
                .member(member)
                .title(title)
                .description(description)
                .build();
    }

    @Builder
    private Blog(Member member, String title, String description){
        this.member = member;
        this.title = title;
        this.description = description;
    }

    public void updateTitle(String title){
        this.title = title;
    }
}
