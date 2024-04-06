package com.sopt.practice.controller;

import com.sopt.practice.domain.Part;
import com.sopt.practice.repository.MemberRepository;
import com.sopt.practice.service.MemberService;
import com.sopt.practice.service.dto.MemberCreateDto;
import com.sopt.practice.settings.ApiTest;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

//import static com.sopt.practice.domain.Part.SERVER;

public class MemberControllerTest extends ApiTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Nested
    @DisplayName("멤버 생성 테스트")
    public class CreateMember{
        @Test
        @DisplayName("요청 성공 테스트")
        public void createMemberSuccess() throws Exception {
            //given
            final var request = new MemberCreateDto(
                    "정정교",
                    Part.SERVER,
                    27);
            //when
            final var response = RestAssured
                    .given()
                    .log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(request)
                    .when()
                    .post("/api/v1/member")
                    .then().log().all().extract();
            //then
            //assertions 의존성 junit
            Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        }
    }
}
