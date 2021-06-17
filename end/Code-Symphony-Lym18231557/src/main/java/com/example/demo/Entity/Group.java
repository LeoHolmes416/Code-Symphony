package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Group {
    public String group_id;
    public String group_name;
    public String create_at;
    public int group_capacity;
    public List<Group> groupList=new ArrayList<>();

    public String getGroup_id() {
        return group_id;
    }
    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }
    public String getCreate_at() {
        return create_at;
    }
    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }
    public String getGroup_name() {
        return group_name;
    }
    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
    public int getGroup_capacity() {
        return group_capacity;
    }
    public void setGroup_capacity(int group_capacity) {
        this.group_capacity = group_capacity;
    }
    public List<Group> getGroupList() {
        return groupList;
    }
    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public void readdata(){
        String sql="SELECT * FROM group";
        try{
            ResultSet rs= Connectsql.getConnectsql().conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Group group=new Group();
                group.group_id=rs.getString("group_id");
                group.group_name=rs.getString("group_name");
                group.create_at=rs.getString("create_at");
                group.group_capacity=rs.getInt("group_capacity");
                this.groupList.add(group);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

}
