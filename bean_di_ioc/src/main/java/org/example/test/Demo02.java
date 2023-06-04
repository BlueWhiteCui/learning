package org.example.test;

import org.example.dao.Person;
import org.example.dao.User01;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 使用@ComponentScan注解和@Component注解，以及@Value注解可以成功自动注入bean
 */
@ComponentScan("org.example.dao")
public class Demo02 {
    public static void main(String[] args) {
        //要加载注解，必须得使用AnnotationConfigApplicationContext来加载还有此注解的类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo02.class);
        User01 bean = context.getBean(User01.class);
        System.out.println(bean);
    }
}
