package com.ax;

import com.ax.common.web.RestConfigSupport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by kyy on 2017/9/6.
 */
@ComponentScan("com.ax")
@Import({RestConfigSupport.class})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}
