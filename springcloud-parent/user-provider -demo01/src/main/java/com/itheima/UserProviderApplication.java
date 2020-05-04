package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * com.itheima
 * Created on 2020/3/13.
 */
@SpringBootApplication
//@EnableDiscoveryClient   //开启Eureka客服端发现功能
@EnableEurekaClient    //
public class UserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class,args);
    }
}
