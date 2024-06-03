package org.sopt.practice.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.practice.domain.enums.Part;

@Entity //Jpa가 관리하는 객체
@Getter //전체 필드에 대한 getter 함수 정의
@NoArgsConstructor //기본 생성자 생성
public class Member {

    @Id //식별자 값
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 생성을 데이터베이스에 위임
    private Long id;

    private String username; // 유저 이름

    private String password; // 유저 비밀번호

    @Enumerated(EnumType.STRING) //Enum의 이름을 데이터베이스에 저장
    private Part part;

    private int age;

//    정적 팩토리 메서드로 객체 생성
    public static Member create(String name, String password, Part part, int age){
        return Member.builder()
                .username(name)
                .password(password)
                .part(part)
                .age(age)
                .build();
    }

    // 빌더패턴으로 객체 생성
    @Builder
    private Member(final String username, String password,final Part part, final int age){
        this.username = username;
        this.password = password;
        this.part = part;
        this.age = age;
    }
}
