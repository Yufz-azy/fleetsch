package com.jeethink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author jeethink www.jeethink.vip
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class FleetSchApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(FleetSchApplication.class, args);
        System.out.println("**********车队调度系统启动成功********** \n");
    }
}