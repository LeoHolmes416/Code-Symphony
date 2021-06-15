package com.example.demo.Tools;


import com.example.demo.Entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
public class FunctionController {

    //登录
    @CrossOrigin
    @PostMapping("api/login")
    @ResponseBody
    public User login(@RequestBody User user, ModelMap modelMap){

        User user1=new User();
        user1.setUsername(user.userid);
        user1.setPassword(user.password);
        user1.setType(user.type);
        String userid=user1.getUsername();
        System.out.println("connnect success");
        System.out.println(user.userid+" "+user.password+" a"+user1.getPassword());
        if(user1.getType().equals("个人")){
            Student student=new Student();
            student.readdata();
            if(student.studentlogin(user1.getUsername(),user1.getPassword())){
                modelMap.addAttribute("userid",userid);
                System.out.println(Student.getStudentlogin().nickname);
                return Student.getStudentlogin();
            }else{
                return null;
            }
        }
        else if(user1.getType().equals("官方")){
            Official official=new Official();
            official.readdata();
            if(official.officiallogin(user1.getUsername(), user1.getPassword())){
                return Official.officiallogin;
            }else{
                return null;
            }
        }
        else{
            return null;
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
        String username=user.userid;
        String nickname=user.nickname;
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
    public int addlike(@RequestParam("stu_content_id") String stu_content_id){
        Stu_contents stu_contents=new Stu_contents();
        stu_contents.readdata();
        return stu_contents.addlike(stu_content_id);
    }

    @CrossOrigin
    @GetMapping("api/addDislike")
    @ResponseBody
    public int addDislike(@RequestParam("stu_content_id") String stu_content_id){
        Stu_contents stu_contents=new Stu_contents();
        stu_contents.readdata();
        return stu_contents.adddislike(stu_content_id);
    }

    @CrossOrigin
    @PostMapping("api/addTreeHole")
    @ResponseBody
    public Stu_contents addtreehole(@RequestBody Stu_contents stu_contents){
        Stu_contents stu_contents1=Stu_contents.addnewstu_contents(stu_contents.nickname,stu_contents.contents, stu_contents.tag);
        return stu_contents1;
    }

    @CrossOrigin
    @GetMapping("api/showMyTreeHoles")
    @ResponseBody
    public List<Stu_contents> showmytreeholes(@RequestParam("nickname") String nickname){
        Stu_contents stu_contents=new Stu_contents();
        stu_contents.readdata();
        List<Stu_contents> mycontents=stu_contents.showmycontents(nickname);
        return mycontents;
    }

    //显示指定树洞的所有评论
    @CrossOrigin
    @GetMapping("api/showTreeHoleComment")
    @ResponseBody
    public List<Comments> showcomment(@RequestParam("stu_content_id") String stu_content_id){
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

    //进行评论
    @CrossOrigin
    @PostMapping("api/treeHoleComment")
    @ResponseBody
    public Comments makecomments(@RequestBody Comments comments){
        System.out.println("1111111");
        String stu_content_id=comments.stu_content_id;
        String nickname= comments.nickname;
        String commentmessage=comments.com_contents;
        System.out.println(commentmessage);
        Comments comments1=Comments.makecomments(stu_content_id,nickname,commentmessage);
        return comments1;
    }

    //随机展示8个用户
    @CrossOrigin
    @GetMapping("api/showActiveStuUsers")
    @ResponseBody
    public List<Student> showactivestuusers(){
        List<Student> activeusers=new ArrayList<Student>();
        Student student=new Student();
        student.readdata();
        Iterator<Student> it=student.studentlist.iterator();
        int i=0;
        while(it.hasNext()){
            Student student1=it.next();
            if(i<8){
                activeusers.add(student1);
            }
            i++;
        }
        return activeusers;
    }

    //展示3个最新的官方内容
    @CrossOrigin
    @GetMapping("api/showNewOfcContents")
    @ResponseBody
    public List<Ofc_contents> shownewofccontents(){
        List<Ofc_contents> newofccontents=new ArrayList<Ofc_contents>();
        Ofc_contents ofc_contents=new Ofc_contents();
        ofc_contents.readdata();
        Iterator<Ofc_contents> it=ofc_contents.ofc_contentsList.iterator();
        int i=0;
        while(it.hasNext()){
            Ofc_contents ofc_contents1=it.next();
            if(i<3){
                newofccontents.add(ofc_contents1);
            }
            i++;
        }
        return newofccontents;
    }

}
