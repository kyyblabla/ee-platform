package com.ax.common.web;

import com.ax.common.security.JwtAuthUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kyy on 2017/9/7.
 */
@Slf4j
public class BaseController {

    public JwtAuthUserDetails getSessionUser() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            JwtAuthUserDetails userDetails = (JwtAuthUserDetails) authentication.getPrincipal();
            return userDetails;
        } catch (Exception e) {
            log.debug("", e);
        }
        return null;
    }

}
