package org.example.consumer;

import org.example.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDubboConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
        UserService bean = applicationContext.getBean(UserService.class);
        System.out.println(bean.getUser(3L));
    }
}
