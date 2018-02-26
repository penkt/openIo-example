package com.pengkey.hello;

import cn.openlo.gear.test.GearContextConfiguration;
import cn.openlo.gear.test.GearTestBase;
import cn.openlo.protocol.Protocol;
import cn.openlo.service.LOSClient;
import cn.openlo.service.LOServiceClient;
import cn.openlo.service.ServiceResponse;
import com.pengkey.hello.request.HelloRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@GearContextConfiguration(boxName = "box01", boxHome = "${user.dir}/src/test/resources/box01/", gearName = "helloword", gearStartTimeout = 10000)
public class HelloWordServiceTest extends GearTestBase {
    @Test
    public void startUp() throws Exception {
        System.in.read();
    }

    @Autowired
    private HelloWordService service;
    @Test
    public void testBeanService() {
        HelloRequest req = new HelloRequest();
        req.setName("gaozhi");
        Assert.assertEquals("Welcome gaozhi!", service.sayHello(req));
        req.setName(null);
        Assert.assertEquals("No name!", service.sayHello(req));
    }
    @LOSClient(calleename = "helloword.sayHello", protocol = Protocol.HTTP)
    private LOServiceClient losClient;
    @Test
    public void testLOSService() {
        HashMap<String, String> request = new HashMap<>();
        ServiceResponse response = losClient.sendRequest(request);
        Assert.assertEquals("No name!", response.getModel());
        request.put("name", "gaozhi");
        response = losClient.sendRequest(request);
        Assert.assertEquals("Welcome gaozhi!", response.getModel());
    }
}
