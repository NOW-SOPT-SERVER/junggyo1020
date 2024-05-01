package org.sopt.seminar3.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
