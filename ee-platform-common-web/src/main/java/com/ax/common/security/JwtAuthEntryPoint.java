/**
 * Copyright (c) 2017-present Laszlo Csontos All rights reserved.
 * <p>
 * This file is part of springuni-particles.
 * <p>
 * springuni-particles is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * springuni-particles is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License
 * along with springuni-particles.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ax.common.security;

import com.alibaba.fastjson.JSON;
import com.ax.common.web.RestErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


/**
 * 权限异常处理，由于权限校验在Controller处理之前，在@RestExceptionHandler无法处理权限错误
 * Created by kyy on 9/9/17.
 */
@Slf4j
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(
            HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException {
        //TODO 根据异常类型转换http状态码：401、403
        RestErrorResponse restErrorResponse = RestErrorResponse.create(UNAUTHORIZED, authException);
        response.setStatus(restErrorResponse.getStatusCode());
        response.setContentType(APPLICATION_JSON_UTF8_VALUE);
        JSON.writeJSONString(response.getWriter(), restErrorResponse);
    }

}
