package org.example.test;

import org.example.dao.User04;
import org.example.support.MyImportSelector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 通过@Import导入实现了ImportSelector的接口的类，即可加载bean
 */
@Import(MyImportSelector.class)
public class Demo04 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo04.class);
        User04 bean = context.getBean(User04.class);
        System.out.println(bean);
    }
}
