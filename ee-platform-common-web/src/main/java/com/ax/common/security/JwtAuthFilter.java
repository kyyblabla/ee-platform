package com.ax.common.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kyy on 2017/9/8.
 */
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

    private JwtTokenService jwtTokenService;

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer";


    public JwtAuthFilter(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = getAuthentication(request);
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        try {
            filterChain.doFilter(request, response);
        }finally {
            //由于线程池复用，需要清理权限数据
            SecurityContextHolder.clearContext();
        }
    }

    private Authentication getAuthentication(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.isEmpty(authorizationHeader)) {
            return null;
        }

        if (!StringUtils.substringMatch(authorizationHeader, 0, TOKEN_PREFIX)) {
            return null;
        }

        String jwtToken = authorizationHeader.substring(TOKEN_PREFIX.length() + 1);
        try {
            return jwtTokenService.verifyToken(jwtToken);
        } catch (AuthenticationException e) {
            log.debug(e.getMessage(), e);
            return null;
        }
    }
}
