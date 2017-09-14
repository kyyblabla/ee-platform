package com.ax;

import com.ax.common.security.SecurityConfigSupport;
import com.ax.common.web.RestConfigSupport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 启动类
 * 每个模块包需要在 @ComponentScan 注解中配置才使相关功能组件被引入
 * 配置类需要在 @Import 中加入（仅当配置类不存在于ComponentScan配置的路径下时）
 * Created by kyy on 2017/9/6.
 */
@ComponentScan({"com.ax.system"})
@Import({RestConfigSupport.class, SecurityConfigSupport.class})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}
