package org.example.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class SpringDubboProvider {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("provider.xml");
        System.out.println("userService接口已经暴露了.......");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println("springDubboProvider类里面有错误.....");
            throw new RuntimeException(e);
        }
    }
}
