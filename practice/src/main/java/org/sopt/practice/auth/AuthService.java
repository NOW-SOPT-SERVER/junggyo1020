package org.sopt.practice.auth;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.auth.redis.domain.Token;
import org.sopt.practice.auth.redis.repository.RedisTokenRepository;
import org.sopt.practice.common.jwt.JwtTokenProvider;
import org.sopt.practice.domain.Member;
import org.sopt.practice.dto.request.LoginRequest;
import org.sopt.practice.dto.request.RefreshTokenRequest;
import org.sopt.practice.dto.response.LoginResponse;
import org.sopt.practice.exception.NotFoundException;
import org.sopt.practice.exception.enums.ErrorMessage;
import org.sopt.practice.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTokenRepository redisTokenRepository;
    private final MemberRepository memberRepository;

    public LoginResponse login(LoginRequest loginRequest){
        // 사용자의 자격 증명을 확인하는 로직
        Member member = memberRepository.findByUsername(loginRequest.username())
                .orElseThrow(() -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION));

        // 아이디와 비밀번호가 일치하는지 확인하는 로직
        if(!member.getPassword().equals(loginRequest.password())){
            throw new NotFoundException(ErrorMessage.INVALID_MEMBER_PASSWORD_EXCEPTION);
        }

        Long memberId = member.getId();

        String accessToken = jwtTokenProvider.issueAccessToken(
                UserAuthentication.createUserAuthentication(memberId)
        );

        String refreshToken = jwtTokenProvider.issueRefreshToken(
                UserAuthentication.createUserAuthentication(memberId)
        );

        //리프레시 토큰을 Redis에 저장
        redisTokenRepository.save(Token.of(memberId, refreshToken));

        return LoginResponse.of(accessToken, refreshToken);
    }

    public LoginResponse refreshAccessToken(RefreshTokenRequest refreshTokenRequest){
        String refreshToken = refreshTokenRequest.refreshToken();
        Token token = redisTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.INVALID_REFRESH_TOKEN_EXCEPTION));

        Long userId = token.getId();
        String newAccessToken = jwtTokenProvider.issueRefreshToken(
                UserAuthentication.createUserAuthentication(userId)
        );

        return LoginResponse.of(newAccessToken, refreshToken);
    }
}
