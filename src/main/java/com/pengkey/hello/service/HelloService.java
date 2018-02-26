package com.pengkey.hello.service;


import com.pengkey.hello.request.HelloRequest;
import com.pengkey.hello.response.HelloResponse;

public interface HelloService {
    HelloResponse sayHello(HelloRequest request);
}
