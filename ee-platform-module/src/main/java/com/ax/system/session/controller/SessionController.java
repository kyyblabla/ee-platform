package com.ax.system.session.controller;

import com.ax.system.session.dto.SessionDto;
import com.ax.system.session.service.SessionService;
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
