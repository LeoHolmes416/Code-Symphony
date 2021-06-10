package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

public class Stu_friends {

    public String stu_user_id_a;
    public String stu_user_id_b;
    public String start_time;
    public String update_at;
    public int friend_level;
    List<Stu_friends> stu_friendsList=new ArrayList<Stu_friends>();

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
}
