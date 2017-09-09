package com.ax.user.controller;

import com.ax.user.dto.SessionDto;
import com.ax.user.dto.UserDto;
import com.ax.user.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyy on 2017/9/8.
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping
    public String login(@RequestBody SessionDto sessionDto) {
        return sessionService.login(sessionDto);
    }
}
