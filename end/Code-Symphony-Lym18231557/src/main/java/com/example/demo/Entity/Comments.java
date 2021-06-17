package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Comments {
    public String stu_content_id;
    public String nickname;
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
        return nickname;
    }

    public void setStu_user_id(String nickname) {
        this.nickname = nickname;
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
                comments.nickname=rs.getString("nickname");
                comments.com_contents=rs.getString("com_contents");
                comments.pub_time=rs.getString("pub_time");
                this.commentsList.add(comments);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

    //根据指定的树洞id返回所有的评论
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

    //发表评论
    public static Comments makecomments(String stu_content_id,String nickname,String com_contents){

        Comments comments=new Comments();
        comments.setStu_content_id(stu_content_id);
        comments.setStu_user_id(nickname);
        comments.setCom_contents(com_contents);
        String sql="insert into comments values(?,?,?,?)";
        //获取系统当前时间
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());
        comments.setPub_time(datetime);
        try{
            PreparedStatement pr=Connectsql.getConnectsql().conn.prepareStatement(sql);
            pr.setString(1,stu_content_id);
            pr.setString(2,nickname);
            pr.setString(3,com_contents);
            pr.setString(4,datetime);
            int row=pr.executeUpdate();
            if(row>0){
                return comments;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
