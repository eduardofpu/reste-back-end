package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



//@EnableAutoConfiguration
//@ComponentScan
//@Configuration // defini as classes de configuraçao
@SpringBootApplication // faz a mesma coisa que as anotações acima
public class ApplicationStarte {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarte.class,args);
    }
}
