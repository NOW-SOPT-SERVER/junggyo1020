package org.sopt.seminar3.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Member와 Blog는 1:1 관계
    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;

    @Builder(access = PRIVATE)
    private Blog(Member member, String title, String description) {
        this.member = member;
        this.title = title;
        this.description = description;
    }
    public static Blog create(Member member, String title, String description) {
        return Blog.builder()
                .member(member)
                .title(title)
                .description(description)
                .build();
    }



    public void updateTitle(
            String title
    ){
        this.title = title;
    }
}
