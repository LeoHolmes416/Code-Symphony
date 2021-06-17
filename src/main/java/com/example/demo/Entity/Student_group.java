package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student_group {

    public String stu_user_id;
    public String ofc_user_id;
    public String join_at;

    public List<Student_group> student_groupList=new ArrayList<Student_group>();

    public String getOfc_user_id() {
        return ofc_user_id;
    }

    public void setOfc_user_id(String ofc_user_id) {
        this.ofc_user_id = ofc_user_id;
    }


    public String getStu_user_id() {
        return stu_user_id;
    }

    public void setStu_user_id(String stu_user_id) {
        this.stu_user_id = stu_user_id;
    }



    public String getJoin_at() {
        return join_at;
    }

    public void setJoin_at(String join_at) {
        this.join_at = join_at;
    }

    public List<Student_group> getStudent_groupList() {
        return student_groupList;
    }

    public void setStudent_groupList(List<Student_group> student_groupList) {
        this.student_groupList = student_groupList;
    }

    public  void readdata(){
        String sql="SELECT * FROM student_group";
        try{
            ResultSet rs= Connectsql.getConnectsql().conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Student_group student_group=new Student_group();
                student_group.stu_user_id=rs.getString("stu_user_id");
                student_group.ofc_user_id=rs.getString("ofc_user_id");
                student_group.join_at=rs.getString("join_at");
                this.student_groupList.add(student_group);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

    //学生关注官方
    public boolean followofc(String stu_user_id,String ofc_user_id){
        String sql="insert into student_group values(?,?,?)";
        //获取系统当前时间
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());

        try{
            PreparedStatement pr=Connectsql.getConnectsql().conn.prepareStatement(sql);
            pr.setString(1,stu_user_id);
            pr.setString(2,ofc_user_id);
            pr.setString(3,datetime);

            int row=pr.executeUpdate();
            if(row>0){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //展示指定student关注的所有官方
    public List<Official> getmyofficial(String stu_user_id){
        List<Official> myofficial=new ArrayList<Official>();
        Iterator<Student_group> it1=student_groupList.iterator();
        Official official=new Official();
        official.readdata();
        while (it1.hasNext()){
            Student_group student_group=it1.next();
            if(student_group.stu_user_id.equals(stu_user_id)){
                Iterator<Official> it2=official.officialList.iterator();
                while(it2.hasNext()){
                    Official official1=it2.next();
                    if(official1.getOfc_user_id().equals(student_group.ofc_user_id)){
                        myofficial.add(official1);
                    }
                }
            }
        }
        return myofficial;
    }

    //展示关注指定ofc的所有student
    public List<Student> getmystudent(String ofc_user_id){
        List<Student> mystudent=new ArrayList<Student>();
        Iterator<Student_group> it1= student_groupList.iterator();
        Student student=new Student();
        student.readdata();
        while(it1.hasNext()){
            Student_group student_group=it1.next();
            if(student_group.getOfc_user_id().equals(ofc_user_id)){
                Iterator<Student> it2=student.studentlist.iterator();
                while(it2.hasNext()){
                    Student student1=it2.next();
                    if(student1.getStu_user_id().equals(student_group.getStu_user_id())){
                        mystudent.add(student1);
                    }
                }
            }
        }
        return mystudent;
    }


}
