package org.example;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.example.service.UserService;

public class Main {
    //直连的那个
    /*public static void main(String[] args) {
        //1.设置应用名
        ApplicationConfig applicationConfig = new ApplicationConfig("simple-consumer");
        //2.创建引用
        ReferenceConfig<Object> referenceConfig = new ReferenceConfig<>();
        //2.1设置引用的接口，以及暴露接口的url
        referenceConfig.setInterface(UserService.class);
        referenceConfig.setUrl("dubbo://10.230.52.194:20880/org.example.service.UserService?anyhost=true&application=simple-provider&bind.ip=10.230.52.194&bind.port=20880&deprecated=false&dubbo=2.0.2&dynamic=true&generic=false&interface=org.example.service.UserService&methods=getUser&pid=26580&release=2.7.4.1&side=provider&timestamp=1685864368887");
        //2.2将应用设置进引用
        referenceConfig.setApplication(applicationConfig);

        //3.设置好引用后，就可以使用暴露的接口了
        UserService userService = (UserService) referenceConfig.get();
        System.out.println(userService.getUser(1L));
    }*/
    //注册到zookeeper里的那个
    public static void main(String[] args) {
        //1.设置应用名
        ApplicationConfig applicationConfig = new ApplicationConfig("simple-consumer");
        //2.创建引用
        ReferenceConfig<Object> referenceConfig = new ReferenceConfig<>();
        //3.建立注册器，并将注册注册器注册到引用里
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");
        referenceConfig.setRegistry(registryConfig);
        //3.1设置调用的接口,应用
        referenceConfig.setInterface(UserService.class);
        referenceConfig.setApplication(applicationConfig);


        //4.设置好引用后就可以直接使用了
        UserService userService = (UserService) referenceConfig.get();
        System.out.println(userService.getUser(2L));
    }
}