package com.ax.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyy on 2017/9/9.
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping
    public String test(@RequestParam("test") String test) {
        return test;
    }

}
