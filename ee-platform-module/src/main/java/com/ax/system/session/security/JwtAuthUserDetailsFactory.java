package com.ax.system.session.security;

import com.ax.common.security.JwtAuthUserDetails;
import com.ax.system.user.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kyy on 2017/7/13.
 */
public class JwtAuthUserDetailsFactory {

    private JwtAuthUserDetailsFactory() {

    }

    public static JwtAuthUserDetails create(User user, List<String> roles) {
        List<SimpleGrantedAuthority> collect = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        JwtAuthUserDetails jwtAuthUserDetails = new
                JwtAuthUserDetails(user.getId(), user.getUserName(), user.getPassowrd(), collect);
        return jwtAuthUserDetails;
    }

}
