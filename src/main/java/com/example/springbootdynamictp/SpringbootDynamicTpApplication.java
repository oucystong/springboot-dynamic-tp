package com.example.springbootdynamictp;

import org.dromara.dynamictp.core.spring.EnableDynamicTp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamicTp
public class SpringbootDynamicTpApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDynamicTpApplication.class, args);
    }
}
