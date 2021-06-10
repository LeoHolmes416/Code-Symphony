package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student_course {

    public String stu_user_id;
    public String course_id;
    public String create_at;
    public List<Student_course> student_courseList=new ArrayList<Student_course>();

    public String getStu_user_id() {
        return stu_user_id;
    }

    public void setStu_user_id(String stu_user_id) {
        this.stu_user_id = stu_user_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCreat_at() {
        return create_at;
    }

    public void setCreat_at(String creat_at) {
        this.create_at = creat_at;
    }

    public List<Student_course> getStudent_courseList() {
        return student_courseList;
    }

    public void setStudent_courseList(List<Student_course> student_courseList) {
        this.student_courseList = student_courseList;
    }

    public void readdata(){
        String sql="SELECT * FROM student-course";
        try{
            ResultSet rs= Connectsql.getConnectsql().conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Student_course student_course=new Student_course();
                student_course.stu_user_id=rs.getString("stu_user_id");
                student_course.course_id=rs.getString("course_id");
                student_course.create_at=rs.getString("create_at");
                this.student_courseList.add(student_course);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

    public List<String> getcourseid(String stu_user_id){
        List<String> courseids=new ArrayList<String>();
        Iterator<Student_course> it= student_courseList.iterator();
        while(it.hasNext()){
            Student_course st_co=it.next();
            if(st_co.getStu_user_id().equals(stu_user_id)){
                courseids.add(st_co.getCourse_id());
            }
        }
        return courseids;
    }

}
