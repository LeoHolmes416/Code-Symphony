package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stu_contents {

    public String stu_content_id;
    public String stu_user_id;
    public String title;
    public String contents;
    public String pub_time; //发表时间
    public String update_at;
    public String tag;
    public int like;
    public int dislike;
    List<Stu_contents> stu_contentsList=new ArrayList<Stu_contents>();

    public String getStu_content_id() {
        return stu_content_id;
    }

    public void setStu_content_id(String stu_content_id) {
        this.stu_content_id = stu_content_id;
    }

    public String getStu_user_id() {
        return stu_user_id;
    }

    public void setStu_user_id(String stu_user_id) {
        this.stu_user_id = stu_user_id;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public List<Stu_contents> getStu_contentsList() {
        return stu_contentsList;
    }

    public void setStu_contentsList(List<Stu_contents> stu_contentsList) {
        this.stu_contentsList = stu_contentsList;
    }

    public boolean addnewstu_contents(String stu_user_id,String title,String contents,String tag){
        Stu_contents newst_con=new Stu_contents();
        int conid;
        for(conid=1;conid<1000;conid++){
            Iterator<Stu_contents> it1= stu_contentsList.iterator();
            while(it1.hasNext()){
                Stu_contents stu_contents=it1.next();
                if(stu_contents.getStu_content_id().equals(Integer.toString(conid))){
                    continue;
                }
            }
            break;
        }

        //获取系统当前时间
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = tempDate.format(new java.util.Date());

        newst_con.setStu_content_id(Integer.toString(conid));
        newst_con.setStu_user_id(stu_user_id);
        newst_con.setTitle(title);
        newst_con.setContents(contents);
        newst_con.setPub_time(datetime);
        newst_con.setTag(tag);
        stu_contentsList.add(newst_con);

        String sql="insert into official stu_contents(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pr= Connectsql.getConnectsql().conn.prepareStatement(sql);
            pr.setString(1,Integer.toString(conid));
            pr.setString(2,stu_user_id);
            pr.setString(3,title);
            pr.setString(4,contents);
            pr.setString(5,datetime);
            pr.setString(6,null);
            pr.setString(7,tag);
            pr.setInt(8,0);
            pr.setInt(9,0);
            int row=pr.executeUpdate();
            if(row>0){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;

    }

}
