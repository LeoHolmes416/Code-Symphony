package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Course {

    public String course_id;
    public String course_name;
    public String classroom;
    public String time;
    public List<Course> courseList=new ArrayList<Course>();

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setDatetime(String datetime) {
        this.time = datetime;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getDatetime() {
        return time;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void readdata(){
        String sql="SELECT * FROM course";
        try{
            ResultSet rs= Connectsql.getConnectsql().conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Course course=new Course();
                course.course_id=rs.getString("course_id");
                course.course_name=rs.getString("course_name");
                course.classroom=rs.getString("classroom");
                course.time=rs.getString("time");
                this.courseList.add(course);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

    public List<Course> getcourses(ArrayList<String> courseids){
        Iterator<String> courseit=courseids.iterator();
        Iterator<Course> coursesit=courseList.iterator();
        List<Course> stucourse=new ArrayList<Course>();
        while(courseit.hasNext()){
            String cid=courseit.next();
            while(coursesit.hasNext()){
                Course c=coursesit.next();
                if(c.getCourse_id().equals(cid)){
                    stucourse.add(c);
                }
            }
        }
        return stucourse;
    }


}
