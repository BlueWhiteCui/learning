package org.example.test;

import org.example.config.ConfigPerson;
import org.example.dao.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 获取bean的第一种方式，@Configuration＋@Bean
 */
public class Demo01 {
    public static void main(String[] args) {
        //直接通过AnnotationConfigApplicationContext来加载有@Configration注解的类的class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigPerson.class);
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }
}
