package com.example.demo.Tools;


import com.example.demo.Entity.Official;
import com.example.demo.Entity.Student;
import com.example.demo.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


@Controller
public class FunctionController {

    //登录
    @CrossOrigin
    @PostMapping("api/login")
    @ResponseBody
    public Responsecode login(@RequestBody User user){

        User user1=new User();
        user1.setUsername(user.username);
        user1.setPassword(user.password);
        user1.setType(user.type);
        System.out.println("connnect success");
        if(user1.getType().equals("个人")){
            Student.readdata();
            if(Student.studentlogin(user1.getUsername(),user1.getPassword())){
                return new Responsecode("666");
            }else{
                return new Responsecode("404");
            }
        }
        else if(user1.getType().equals("official")){
            if(Official.officiallogin(user1.getUsername(), user1.getPassword())){
                return new Responsecode("666");
            }else{
                return new Responsecode("404");
            }
        }
        else{
            return new Responsecode("404");
        }
    }


    //发送验证码
    @CrossOrigin
    @PostMapping("api/sendValidateNum")
    @ResponseBody
    public Responsecode sendvalidatenum(@RequestParam("mail") String email){
        String code="8E707";
        if(Sendemail.sendEmail(email,code)){
            return new Responsecode(code);
        }else{
            return new Responsecode("404");
        }
    }

//    //注册
//    @CrossOrigin
//    @GetMapping("api/register")
//    @ResponseBody
//    public Responsecode register(@RequestParam("username") String username,
//                                 @RequestParam("type") String type,
//                                 @RequestParam("nick_name") String nickname,
//                                 @RequestParam("password") String password){
//        if(type.equals("student")){
//            if(Student.addnewstudent(username,nickname,password)){
//                return new Responsecode("666");
//            }else{
//                return new Responsecode("404");
//            }
//        }
//        else if(type.equals("official")){
//
//        }
//    }


}
