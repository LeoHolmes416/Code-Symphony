package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student extends User{

    public String stu_user_id;
    public String user_nickname;
    public String password;
    public int user_state;   //0未认证1已认证
    public String register_date;
    public String sex;
    public int age;
    public String school;
    public String stu_tag;
    public String city;
    public String update_at;   //更新时间

    public static List<Student> studentlist=new ArrayList<Student>();

    private static Student studentlogin;

    public Student(){
        this.stu_user_id=super.getUsername();
        this.password=super.getPassword();
    }

    public static void readdata(){
        String sql="SELECT * FROM student";
        try{
            ResultSet rs= Connectsql.getConnectsql().conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Student student=new Student();
                student.stu_user_id=rs.getString("stu_user_id");
                student.user_nickname=rs.getString("user_nickname");
                student.password=rs.getString("user_password");
                student.user_state=rs.getInt("user_state");
                student.register_date=rs.getString("register_date");
                student.sex=rs.getString("sex");
                student.age=rs.getInt("age");
                student.school=rs.getString("school");
                student.stu_tag=rs.getString("stu_tag");
                student.city=rs.getString("city");
                student.update_at=rs.getString("update_at");
                student.studentlist.add(student);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

    public List<Student> getStudentlist() {
        return studentlist;
    }

    public void setStudentlist(List<Student> studentlist) {
        this.studentlist = studentlist;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_state() {
        return user_state;
    }

    public void setUser_state(int user_state) {
        this.user_state = user_state;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSty_tag() {
        return stu_tag;
    }

    public void setSty_tag(String sty_tag) {
        this.stu_tag = sty_tag;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getStu_user_id() {
        return stu_user_id;
    }

    public void setStu_user_id(String stu_user_id) {
        this.stu_user_id = stu_user_id;
    }

    public String getStu_tag() {
        return stu_tag;
    }

    public void setStu_tag(String stu_tag) {
        this.stu_tag = stu_tag;
    }

    public static boolean studentlogin(String userid,String password){
        Iterator<Student> iterator=studentlist.iterator();
        while(iterator.hasNext()){
            Student student= iterator.next();
            if(student.getStu_user_id().equals(userid)&&student.getPassword().equals(password)){
                studentlogin=student;
                return true;
            }
        }
        return false;
    }

    public static boolean addnewstudent(String username,String nickname,String password){
        Student student=new Student();
        student.setStu_user_id(username);
        student.setUser_nickname(nickname);
        student.setPassword(password);
        studentlist.add(student);
        String sql="insert into student values(?,?,?,?,?,?,?,?,?,?,?)";
        //获取系统当前时间
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = tempDate.format(new java.util.Date());

        try{
            PreparedStatement pr=Connectsql.getConnectsql().conn.prepareStatement(sql);
            pr.setString(1,username);
            pr.setString(2,nickname);
            pr.setString(3,password);
            pr.setInt(4,0);
            pr.setString(5,datetime);
            pr.setString(6,null);
            pr.setString(7,null);
            pr.setString(8,null);
            pr.setString(9,null);
            pr.setString(10,null);
            pr.setString(11,null);
            int row=pr.executeUpdate();
            if(row>0){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public Student matching(String stutags){
        Iterator<Student> it1=studentlist.iterator();
        Student choosedstu=new Student();
        Student firststu=new Student();
        while(it1.hasNext()){
            Student stu=it1.next();
            if(firststu.getStu_user_id()==null&&stu!=studentlogin){
                firststu=stu;
            }
            if(stu.getStu_tag().equals(stutags)&&stu!=studentlogin){
                choosedstu=stu;
                break;
            }
        }

        if(choosedstu.getStu_user_id()!=null){
            return choosedstu;
        }else{
            return firststu;
        }

    }

}
