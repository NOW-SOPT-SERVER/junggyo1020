package org.sopt.clonecoding.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    public static Member create(String name, int age)
    {
        return Member.builder()
                .name(name)
                .age(age)
                .build();
    }

    @Builder
    public Member(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
}
