package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Course {

    String course_id;
    String course_name;
    String classroom;
    String datetime;
    List<Course> courseList=new ArrayList<Course>();

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
        this.datetime = datetime;
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
        return datetime;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
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
