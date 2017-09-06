package com.ax.system.controller;

import com.ax.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyy on 2017/9/6.
 */
@RequestMapping("/api/v1/system")
@RestController
public class SystemController extends BaseController {

    @GetMapping("/info")
    public String info() {
        return "hello";
    }

}
