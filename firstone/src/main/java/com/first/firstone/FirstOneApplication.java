package com.first.firstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = "com.first.firstone")
public class FirstOneApplication {
    public static void main(String[] args){
        SpringApplication.run(FirstOneApplication.class, args);
    }
    
}
