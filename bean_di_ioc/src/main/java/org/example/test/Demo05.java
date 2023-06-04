package org.example.test;

import org.example.dao.User05;
import org.example.support.MyDeferredImportSelector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 通过@Import导入实现了ImportSelector的接口的类，即可加载bean
 */
@Import(MyDeferredImportSelector.class)
public class Demo05 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo05.class);
        User05 bean = context.getBean(User05.class);
        System.out.println(bean);
    }
}
