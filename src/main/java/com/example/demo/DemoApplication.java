package com.example.demo;

import com.example.demo.Tools.Connectsql;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        Connectsql.getConnectsql();
//        if(Sendemail.sendEmail("894631772@qq.com","8E303")){
//            System.out.println("true");
//        }else{
//            System.out.println("false");
//        }
        System.out.println(SpringVersion.getVersion());
        SpringApplication.run(DemoApplication.class, args);
    }

}
