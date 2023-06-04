package org.example;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.service.UserService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DubboConsumerApplication {
    @DubboReference
    UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class,args);
    }

    @Bean
    public ApplicationRunner getBean(){
        return args -> {
            System.out.println(userService.getUser(4L));
        };
    }
}
