package org.example.config;

import org.example.dao.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//@Configuration可以替代那个配置文件
//还有一个注解叫做@Configurable可以指明在new的时候，也就是构造函数开始执行的时候，将类中的@Autowire的对象先注入，然后再开始构造
@Configuration
public class ConfigPerson {

    @Bean("person")
    public Person getPerson(){
        return new Person(2,"zhang2");
    }
}
