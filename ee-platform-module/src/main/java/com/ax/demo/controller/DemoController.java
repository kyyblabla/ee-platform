package com.ax.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyy on 2017/9/28.
 */
@RequestMapping("/demo")
@RestController
public class DemoController {


    @GetMapping("/hotswap/newreturn")
    public String hotSwapDemo() {
        return "第一个值";
//        return "热部署之后的值";
    }

//    @GetMapping("/hotswap/newfun")
//    public String newFun() {
//        return "newFun";
//    }

}
