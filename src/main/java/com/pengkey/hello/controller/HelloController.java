package com.pengkey.hello.controller;

import cn.openlo.protocol.Protocol;
import cn.openlo.service.LOS;
import com.pengkey.hello.request.HelloRequest;
import com.pengkey.hello.response.HelloResponse;
import com.pengkey.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @LOS(name = "hello-world.sayHello",enableProtocols = Protocol.HTTP)
    public HelloResponse sayHello(HelloRequest request){
        return helloService.sayHello(request);
    }
}
