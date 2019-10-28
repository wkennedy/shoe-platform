package com.github.wkennedy.shoeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class ShoeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoeServiceApplication.class, args);
    }

}
