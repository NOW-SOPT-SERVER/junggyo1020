package org.sopt.practice.common.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.sopt.practice.common.jwt.enums.JwtValidationType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private static final String USER_ID = "userId";

    private static final Long ACCESS_TOKEN_EXPIRATION_TIME = 24 * 60 * 60 * 1000L * 14;

    @Value("${jwt.secret}")
    private String JWT_SECRET;

    public String issueAccessToken(final Authentication authentication){
        return generateToken(authentication, ACCESS_TOKEN_EXPIRATION_TIME);
    }

    public String generateToken(Authentication authentication, Long tokenExpirationTime){
        final Date now = new Date();
        final Claims claims = Jwts.claims()
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenExpirationTime));

        claims.put(USER_ID, authentication.getPrincipal());

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setClaims(claims)
                .signWith(getSigningKey())
                .compact();
    }

    private SecretKey getSigningKey(){
        String encodedKey = Base64.getEncoder().encodeToString(JWT_SECRET.getBytes());
        return Keys.hmacShaKeyFor(encodedKey.getBytes());
    }

    public JwtValidationType validationToken(String token){
        try{
            final Claims claims = getBody(token);
            return JwtValidationType.VALID_JWT;
        } catch(MalformedJwtException ex){
            return JwtValidationType.INVALID_JWT_TOKEN;
        } catch(ExpiredJwtException ex){
            return JwtValidationType.EXPIRED_JWT_TOKEN;
        } catch(UnsupportedJwtException ex){
            return JwtValidationType.UNSUPPORTED_JWT_TOKEN;
        } catch(IllegalArgumentException ex){
            return JwtValidationType.EMPTY_JWT;
        }
    }

    private Claims getBody(final String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Long getUserFromJwt(String token){
        Claims claims = getBody(token);
        return Long.valueOf(claims.get(USER_ID).toString());
    }

}
