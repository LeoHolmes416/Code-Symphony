package com.example.demo.Tools;


import com.example.demo.Entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Iterator;
import java.util.List;


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
        System.out.println(user.username+" "+user.password+" a"+user1.getPassword());
        if(user1.getType().equals("个人")){
            Student student=new Student();
            student.readdata();
            if(student.studentlogin(user1.getUsername(),user1.getPassword())){
                return new Responsecode("666");
            }else{
                return new Responsecode("404");
            }
        }
        else if(user1.getType().equals("官方")){
            Official official=new Official();
            official.readdata();
            if(official.officiallogin(user1.getUsername(), user1.getPassword())){
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
    public Responsecode sendvalidatenum(@RequestBody Sendemail email){
        String mail= email.mail;
        System.out.println(mail);
        String code="8E707";
        if(Sendemail.sendEmail(mail,code)){
            return new Responsecode(code);
        }else{
            return new Responsecode("404");
        }
    }

    //注册
    @CrossOrigin
    @PostMapping("api/register")
    @ResponseBody
    public Responsecode register(@RequestBody User user){
        String type=user.type;
        String username=user.username;
        String nickname=user.nick_name;
        String password=user.password;
        String ofcname=user.ofc_name;
        if(type.equals("个人")){
            Student student=new Student();
            if(student.addnewstudent(username,nickname,password)){
                return new Responsecode("666");
            }else{
                return new Responsecode("404");
            }
        }
        else if(type.equals("官方")){
            Official official=new Official();
            if(official.addnewofficial(username,ofcname,password)){
                return new Responsecode("666");
            }
            else{
                return new Responsecode("404");
            }
        }
        else{
            return new Responsecode("404");
        }
    }

    //展示所有树洞信息
    @CrossOrigin
    @GetMapping("api/showAllTreeHoles")
    @ResponseBody
    public List<Stu_contents> getalltreeholes(){
        Stu_contents stu_contents=new Stu_contents();
        stu_contents.readdata();
        List<Stu_contents> stu_contentsList=stu_contents.stu_contentsList;
        return stu_contentsList;
    }

    @CrossOrigin
    @GetMapping("api/addlike")
    @ResponseBody
    public Responsecode addlike(@RequestParam("stu_content_id") String stu_content_id){
        Stu_contents stu_contents=new Stu_contents();
        stu_contents.readdata();
        if(stu_contents.addlike(stu_content_id)){
            return new Responsecode("666");
        }else{
            return new Responsecode("404");
        }
    }

    @CrossOrigin
    @GetMapping("api/addDislike")
    @ResponseBody
    public Responsecode addDislike(@RequestParam("stu_content_id") String stu_content_id){
        System.out.println("hhh"+stu_content_id);
        Stu_contents stu_contents=new Stu_contents();
        stu_contents.readdata();
        if(stu_contents.adddislike(stu_content_id)){
            return new Responsecode("666");
        }else{
            return new Responsecode("404");
        }
    }

    @CrossOrigin
    @PostMapping("api/addTreeHole")
    @ResponseBody
    public Responsecode addtreehole(@RequestBody Stu_contents stu_contents){
        if(stu_contents.addnewstu_contents(stu_contents.stu_user_id,stu_contents.title, stu_contents.contents, stu_contents.tag)){
            return new Responsecode("666");
        }else {
            return new Responsecode("404");
        }
    }

    @CrossOrigin
    @GetMapping("api/showMyTreeHoles")
    @ResponseBody
    public List<Stu_contents> showmytreeholes(@RequestParam("stu_user_id") String stu_user_id){
        Stu_contents stu_contents=new Stu_contents();
        List<Stu_contents> mycontents=stu_contents.showmycontents(stu_user_id);
        return mycontents;
    }

    //显示指定树洞的所有评论
    @CrossOrigin
    @GetMapping("api/showTreeHoleComment")
    @ResponseBody
    public List<Comments> showcomment(@RequestParam("stu_content)_id") String stu_content_id){
        String contentid=stu_content_id;
        Comments comments1=new Comments();
        comments1.readdata();
        return comments1.showthiscomments(contentid);
    }

    //查看此条树洞的详细内容
    @CrossOrigin
    @GetMapping("api/showTreeHoleDetails")
    @ResponseBody
    public Stu_contents showtreeholedetails(@RequestParam("stu_content_id") String stu_content_id){
        Stu_contents stu_contents=new Stu_contents();
        stu_contents.readdata();
        return stu_contents.showdetails(stu_content_id);
    }

}
