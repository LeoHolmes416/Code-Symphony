package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stu_friends {

    public String stu_user_id_a;
    public String stu_user_id_b;
    public String start_time;
    public String update_at;
    public int friend_level;
    public List<Stu_friends> stu_friendsList=new ArrayList<Stu_friends>();

    public String getStu_user_id_a() {
        return stu_user_id_a;
    }

    public void setStu_user_id_a(String stu_user_id_a) {
        this.stu_user_id_a = stu_user_id_a;
    }

    public String getStu_user_id_b() {
        return stu_user_id_b;
    }

    public void setStu_user_id_b(String stu_user_id_b) {
        this.stu_user_id_b = stu_user_id_b;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public int getFriend_level() {
        return friend_level;
    }

    public void setFriend_level(int friend_level) {
        this.friend_level = friend_level;
    }

    public List<Stu_friends> getStu_friendsList() {
        return stu_friendsList;
    }

    public void setStu_friendsList(List<Stu_friends> stu_friendsList) {
        this.stu_friendsList = stu_friendsList;
    }

    public void readdata(){
        String sql="SELECT * FROM stu_friends";
        try{
            ResultSet rs= Connectsql.getConnectsql().conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Stu_friends stu_friends=new Stu_friends();
                stu_friends.stu_user_id_a=rs.getString("stu_user_id_a");
                stu_friends.stu_user_id_b=rs.getString("stu_user_id_b");
                stu_friends.start_time=rs.getString("start_time");
                stu_friends.update_at=rs.getString("update_at");
                stu_friends.friend_level=rs.getInt("friend_level");
                this.stu_friendsList.add(stu_friends);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

    //获取全部的好友列表
    public List<Student> getfriendlist(String mystuid){
        List<Student> friends=new ArrayList<Student>();
        Iterator<Stu_friends> it=stu_friendsList.iterator();
        Student student=new Student();
        student.readdata();
        while(it.hasNext()){
            Stu_friends stu_friends=it.next();
            if(stu_friends.getStu_user_id_a().equals(mystuid)){
                Iterator<Student> itstudent=student.getStudentlist().iterator();
                while(itstudent.hasNext()){
                    Student student1= itstudent.next();
                    if(student1.getStu_user_id().equals(stu_friends.getStu_user_id_b())){
                        friends.add(student1);
                    }
                }
            }
        }
        return friends;
    }

}
