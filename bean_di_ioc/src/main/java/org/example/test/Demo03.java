package org.example.test;

import org.example.dao.User02;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

//@Import直接导入即可加载
@Import(User02.class)
public class Demo03 {
    public static void main(String[] args) {
        //很重要下面这个东西
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo03.class);
        User02 bean = context.getBean(User02.class);
        System.out.println(bean);
    }
}
