package com.pengkey.hello.service.impl;

import com.pengkey.hello.request.HelloRequest;
import com.pengkey.hello.response.HelloResponse;
import com.pengkey.hello.service.HelloService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public HelloResponse sayHello(HelloRequest request) {
        HelloResponse response=new HelloResponse();
        if(StringUtils.isBlank(request.getName())){
            response.setHello("Hello world!");
        }else{
            response.setHello("Hello "+request.getName());
        }
        return response;
    }
}
