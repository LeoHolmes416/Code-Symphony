package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Comments {
    public String stu_content_id;
    public String stu_user_id;
    public String com_contents;
    public String pub_time;
    public List<Comments> commentsList=new ArrayList<Comments>();

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

    public String getCom_contents() {
        return com_contents;
    }

    public void setCom_contents(String com_contents) {
        this.com_contents = com_contents;
    }

    public String getPub_time() {
        return pub_time;
    }

    public void setPub_time(String pub_time) {
        this.pub_time = pub_time;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public void readdata(){
        String sql="SELECT * FROM comments";
        try{
            ResultSet rs= Connectsql.getConnectsql().conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Comments comments=new Comments();
                comments.stu_content_id=rs.getString("stu_content_id");
                comments.stu_user_id=rs.getString("stu_uer_id");
                comments.com_contents=rs.getString("com_contents");
                comments.pub_time=rs.getString("pub_time");
                this.commentsList.add(comments);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

    public List<Comments> showthiscomments(String stu_content_id){
        Iterator<Comments> it=commentsList.iterator();
        List<Comments> thiscommments=new ArrayList<Comments>();
        while(it.hasNext()){
            Comments c=it.next();
            if(c.getStu_content_id().equals(stu_content_id)){
                thiscommments.add(c);
            }
        }
        return thiscommments;
    }


}
