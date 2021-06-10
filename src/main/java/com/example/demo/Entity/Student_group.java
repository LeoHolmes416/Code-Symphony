package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Student_group {

    public String stu_user_id;
    public String group_id;
    public String join_at;
    public List<Student_group> student_groupList=new ArrayList<Student_group>();

    public String getStu_user_id() {
        return stu_user_id;
    }

    public void setStu_user_id(String stu_user_id) {
        this.stu_user_id = stu_user_id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
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
        String sql="SELECT * FROM student-group";
        try{
            ResultSet rs= Connectsql.getConnectsql().conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Student_group student_group=new Student_group();
                student_group.stu_user_id=rs.getString("stu_user_id");
                student_group.group_id=rs.getString("group_id");
                student_group.join_at=rs.getString("join_at");
                this.student_groupList.add(student_group);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

}
