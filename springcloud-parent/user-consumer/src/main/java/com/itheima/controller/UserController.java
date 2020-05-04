package com.itheima.controller;

import com.itheima.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * com.itheima.controller
 * Created on 2020/3/13.
 */
@RestController
@RequestMapping("/consumer")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;


    @HystrixCommand
    @RequestMapping("/{id}")
    public User queryById(@PathVariable(value = "id")Integer id){
        //String url = "http://localhost:18081/user/find/"+id;
        //return restTemplate.getForObject(url,User.class);

        /*//获取指定实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-provider");

        //获取第一个实例
        ServiceInstance serviceInstance = instances.get(0);

        //拼接服务地址
        String instanceUrl = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/find/"+id;
        return restTemplate.getForObject(instanceUrl,User.class);*/

        String url = "http://user-provider/user/find/"+id;
        return restTemplate.getForObject(url,User.class);
    }

    //服务降级处理方法
    public User failBack(Integer id){
        User user = new User();
        user.setUsername("服务降级,默认处理！");
        return  user;
    }
}
