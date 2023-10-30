package com.example.bes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.bes.mapper")
public class BesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BesApplication.class, args);
    }

}
