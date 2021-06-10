package com.example.demo.Tools;

import org.apache.commons.mail.HtmlEmail;

public class Sendemail {

    public String code;

    public Sendemail(String code){
        this.code=code;
    }

    public static boolean sendEmail(String emailaddress,String code){
        try{
            HtmlEmail email=new HtmlEmail();
            email.setHostName("smtp.qq.com");
            email.setCharset("UTF-8");
            email.addTo(emailaddress);
            email.setFrom("894631772@qq.com","");
            email.setAuthentication("894631772@qq.com","rpgmtooecrjibebc");
            email.setSubject("[Lime]验证码:"+code);
            email.setMsg("[Lime]您用于登录Lime的邮箱验证码是"+code+"此校验码24小时内有效，为保障账户安全，请不要泄露给他人");
            email.send();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
