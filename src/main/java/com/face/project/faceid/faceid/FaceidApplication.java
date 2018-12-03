package com.face.project.faceid.faceid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.face.project.faceid.faceid.dao")
public class FaceidApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaceidApplication.class, args);
    }
}
