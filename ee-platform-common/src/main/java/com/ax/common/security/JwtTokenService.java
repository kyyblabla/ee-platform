package com.ax.common.security;

import com.ax.common.util.IdentityGenerator;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import javax.websocket.Session;
import java.util.*;
import java.util.stream.Collectors;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;
import static java.lang.System.currentTimeMillis;

/**
 * Created by kyy on 2017/9/8.
 */
public class JwtTokenService {

    private String jwtSecret; //秘钥
    private int jwtExpiresTime; //过期时间(s)

    public static final String AUTHORITIES = "AUTHORITIES";
    public static final String USER = "USER";

    public JwtTokenService(String jwtSecret, int jwtExpiresTime) {
        this.jwtSecret = jwtSecret;
        this.jwtExpiresTime = jwtExpiresTime;
    }

    /**
     * 刷新token
     *
     * @param oldToken
     * @return
     */
    public String refreshToken(String oldToken) {
        Authentication authentication = verifyToken(oldToken);
        return createToken(authentication);
    }

    /**
     * 创建token
     *
     * @param authentication
     * @return
     */
    public String createToken(Authentication authentication) {

        Claims claims = Jwts.claims()
                .setId(String.valueOf(IdentityGenerator.generate()))
                .setSubject(authentication.getName())
                .setExpiration(new Date(currentTimeMillis() + jwtExpiresTime * 1000))
                .setIssuedAt(new Date());

        String authorities = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));

        claims.put(AUTHORITIES, authorities);
        claims.put(USER, authentication.getPrincipal());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(HS512, jwtSecret)
                .compact();

    }


    /**
     * 验证token
     *
     * @param jwtToken
     * @return
     */
    public Authentication verifyToken(String jwtToken) {
        //TODO 进行数据库或者缓存的严格校验，目前只是信任token中的数据
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(jwtToken)
                    .getBody();
            //返回权限信息
            return createAuthentication(claims);
        } catch (ExpiredJwtException | SignatureException e) {
            throw new BadCredentialsException(e.getMessage(), e);
        } catch (UnsupportedJwtException | MalformedJwtException e) {
            throw new AuthenticationServiceException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new InternalAuthenticationServiceException(e.getMessage(), e);
        }
    }


    /**
     * 根据 Claims 构建出权限信息
     *
     * @param claims
     * @return
     */
    private static Authentication createAuthentication(Claims claims) {

        Collection<GrantedAuthority> authorities =
                Arrays.stream(String.valueOf(claims.get(AUTHORITIES)).split(","))
                        .map(String::trim)
                        .filter(StringUtils::hasText)
                        .map(String::toUpperCase)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toSet());
        Object userDetail = claims.get(USER);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetail, null, authorities);

        //设置用户信息
//        Date now = new Date();
//        Date expiration = claims.getExpiration();
//        Date notBefore = Optional.ofNullable(claims.getNotBefore()).orElse(now);
//        authentication.setAuthenticated(now.after(notBefore) && now.before(expiration));

        return authentication;

    }

}
