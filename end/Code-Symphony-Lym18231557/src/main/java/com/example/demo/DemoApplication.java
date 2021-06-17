package com.example.demo;

import com.example.demo.Entity.Stu_contents;
import com.example.demo.Entity.Student;
import com.example.demo.Tools.Connectsql;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        Connectsql.getConnectsql();
//        if(Sendemail.sendEmail("894631772@qq.com","8E303")){
//            System.out.println("true");
//        }else{
//            System.out.println("false");
//        }
//
//        Student student=new Student();
//        student.readdata();
//        student.studentlogin("1263193656@qq.com","123456");
//        System.out.println("aa"+Student.getStudentlogin().stu_user_id);

        SpringApplication.run(DemoApplication.class, args);
    }

}
