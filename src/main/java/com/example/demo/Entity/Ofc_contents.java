package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ofc_contents {
    public String ofc_content_id;
    public String group_id;
    public String title;
    public String contents;
    public String pub_time;
    public String update_at;
    public int views;

    public List<Ofc_contents> ofc_contentsList= new ArrayList<>();

    public String getOfc_content_id() {
        return ofc_content_id;
    }

    public void setOfc_content_id(String ofc_content_id) {
        this.ofc_content_id = ofc_content_id;
    }

    public String getGroupid() {
        return group_id;
    }

    public void setGroupid(String groupid) {
        this.group_id = groupid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getPub_time() {
        return pub_time;
    }

    public void setPub_time(String pub_time) {
        this.pub_time = pub_time;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public List<Ofc_contents> getOfc_contentsList() {
        return ofc_contentsList;
    }

    public void setOfc_contentsList(List<Ofc_contents> ofc_contentsList) {
        this.ofc_contentsList = ofc_contentsList;
    }

    public void readdata(){
        String sql="SELECT * FROM ofc_contents";
        try{
            ResultSet rs= Connectsql.getConnectsql().conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Ofc_contents ofc_contents=new Ofc_contents();
                ofc_contents.ofc_content_id=rs.getString("stu_content_id");
                ofc_contents.group_id=rs.getString("group_id");
                ofc_contents.title=rs.getString("title");
                ofc_contents.contents=rs.getString("contents");
                ofc_contents.pub_time=rs.getString("pub_time");
                ofc_contents.update_at=rs.getString("update_at");
                ofc_contents.views=rs.getInt("views");
                this.ofc_contentsList.add(ofc_contents);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

    public String viewgroupcontents(String groupid){
        Iterator<Ofc_contents> it= ofc_contentsList.iterator();
        String contents=null;
        while(it.hasNext()){
            Ofc_contents ofc=it.next();
            if(ofc.getGroupid().equals(groupid)){
                contents=ofc.getContents();
            }
        }
        return contents;
    }

}
