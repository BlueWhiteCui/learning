package org.example;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.example.impl.UserServiceImpl;
import org.example.service.UserService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //1.应用名称
        ApplicationConfig applicationConfig = new ApplicationConfig("simple-provider");

        //2.应用协议，端口
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);

        //3.注册应用，这个是直连，不需要注册到nacos，zk等应用
        RegistryConfig registryConfig = new RegistryConfig(RegistryConfig.NO_AVAILABLE);

        //4.配置服务
        ServiceConfig<Object> serviceConfig = new ServiceConfig<>();

        //4.1设置代理的接口,以及代理接口的实现
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(new UserServiceImpl());

        //4.2将application,protocol,registry添加进service
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setRegistry(registryConfig);
        //4.3将服务接口暴露
        serviceConfig.export();

        System.out.println("UserService接口已经暴露.......");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException("dubbo-provider  中  system.in.read()方法出问题了"+e);
        }
    }
}