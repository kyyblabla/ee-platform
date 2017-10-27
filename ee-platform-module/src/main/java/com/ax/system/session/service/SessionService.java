package com.ax.system.session.service;

import com.ax.common.security.JwtTokenService;
import com.ax.system.session.dto.SessionDto;
import com.ax.system.user.entity.User;
import com.ax.system.session.security.JwtAuthUserDetailsFactory;
import com.ax.system.user.service.RoleService;
import com.ax.system.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kyy on 2017/9/8.
 */
@Service
public class SessionService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("用户名不存在 '%s'.", username));
        }
        //获取用户角色
        List<String> roles = roleService.getAllByUserId(user.getId()).stream()
                .map(role -> StringUtils.join("ROLE_", role.getName().toUpperCase()))
                .collect(Collectors.toList());
        return JwtAuthUserDetailsFactory.create(user, roles);
    }

    public String login(SessionDto sessionDto) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(sessionDto.getName(), sessionDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtTokenService.createToken(authenticate);
        return token;
    }

}
