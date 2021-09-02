package com.zcy.mobile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zcy.mobile.mapper")
public class ZcyMobileRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZcyMobileRedisApplication.class, args);
    }

}
