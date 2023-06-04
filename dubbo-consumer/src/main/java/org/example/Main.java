package org.example;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.example.service.UserService;

public class Main {
    public static void main(String[] args) {
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
    }
}