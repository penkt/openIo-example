package com.pengkey.hello;

import cn.openlo.protocol.Protocol;
import cn.openlo.service.LOS;
import com.pengkey.hello.request.HelloRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloWordService {
    @LOS(name = "helloword.sayHello", enableProtocols = { Protocol.HTTP })
    public String sayHello(HelloRequest req) {
        if (req != null && StringUtils.hasText(req.getName())) {
            return "Welcome " + req.getName() + "!";
        }
        return "No name!";
    }
}
