package com.pengkey.hello;

import cn.openlo.gear.test.GearContextConfiguration;
import cn.openlo.gear.test.GearTestBase;
import org.junit.Test;

import java.io.IOException;

@GearContextConfiguration(boxName = "box01", boxHome = "${user.dir}/src/test/resources/box01/", gearName = "hello-world", gearStartTimeout = 200000)
public class StartUp extends GearTestBase{

    @Test
    public void startup() throws IOException {
        System.in.read();
    }

}
