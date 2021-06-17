package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stu_contents {

    public String stu_content_id;
    public String nickname;
    public String title;
    public String contents;
    public String pub_time; //发表时间
    public String update_at;
    public String tag;
    public int good;
    public int dislike;
    public List<Stu_contents> stu_contentsList=new ArrayList<Stu_contents>();

    public String getStu_content_id() {
        return stu_content_id;
    }

    public void setStu_content_id(String stu_content_id) {
        this.stu_content_id = stu_content_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
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

    public void readdata(){
        String sql="SELECT * FROM stu_contents";
        try{
            ResultSet rs= Connectsql.getConnectsql().conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Stu_contents stu_contents=new Stu_contents();
                stu_contents.stu_content_id=rs.getString("stu_content_id");
                stu_contents.nickname=rs.getString("nickname");
                stu_contents.title=rs.getString("title");
                stu_contents.contents=rs.getString("contents");
                stu_contents.pub_time=rs.getString("pub_time");
                stu_contents.update_at=rs.getString("update_at");
                stu_contents.tag=rs.getString("tag");
                stu_contents.good=rs.getInt("good");
                stu_contents.dislike=rs.getInt("dislike");
                this.stu_contentsList.add(stu_contents);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

    //发表新树洞
    public static Stu_contents addnewstu_contents(String nickname,String contents,String tag){
        Stu_contents newst_con=new Stu_contents();
        newst_con.readdata();
        //生成一个新的content_id
        int conid;
        here:for(conid=1;conid<1000;conid++){
            Iterator<Stu_contents> it1= newst_con.stu_contentsList.iterator();
            while(it1.hasNext()){
                Stu_contents stu_contents=it1.next();
                if(stu_contents.getStu_content_id().equals(Integer.toString(conid))){
                    System.out.println("same");
                    continue here;
                }
            }
            break;
        }

        //获取系统当前时间
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());

        newst_con.setStu_content_id(Integer.toString(conid));
        newst_con.setNickname(nickname);
        newst_con.setContents(contents);
        newst_con.setPub_time(datetime);
        newst_con.setTag(tag);

        String sql="insert into  stu_contents values(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pr= Connectsql.getConnectsql().conn.prepareStatement(sql);
            pr.setString(1,Integer.toString(conid));
            pr.setString(2,nickname);
            pr.setString(3,null);
            pr.setString(4,contents);
            pr.setString(5,datetime);
            pr.setString(6,null);
            pr.setString(7,tag);
            pr.setInt(8,0);
            pr.setInt(9,0);
            int row=pr.executeUpdate();
            if(row>0){
                return newst_con;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    //点赞
    public int addlike(String stu_content_id){
        Iterator<Stu_contents> it=stu_contentsList.iterator();
        int likenum=0;
        while(it.hasNext()){
            Stu_contents stu_contents=it.next();
            if(stu_contents.getStu_content_id().equals(stu_content_id)){
                System.out.println("goodnum:"+stu_contents.good);
                stu_contents.good++;
                likenum=stu_contents.good;
                break;
            }
        }
        String sql = "update stu_contents set good =? where stu_content_id =?";
        try{

            PreparedStatement pr= Connectsql.getConnectsql().conn.prepareStatement(sql);
            pr.setInt(1,likenum);
            pr.setString(2,stu_content_id);
            int row=pr.executeUpdate();
            if(row>0){
                return likenum;
            }else{
                return -1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    //点踩
    public int adddislike(String stu_content_id){
        Iterator<Stu_contents> it=stu_contentsList.iterator();
        int dislikenum=0;
        while(it.hasNext()){
            Stu_contents stu_contents=it.next();
            if(stu_contents.getStu_content_id().equals(stu_content_id)){
                stu_contents.dislike++;
                dislikenum=stu_contents.dislike;
                break;
            }
        }
        String sql = "update stu_contents set dislike =? where stu_content_id =?";
        try{
            PreparedStatement pr= Connectsql.getConnectsql().conn.prepareStatement(sql);
            pr.setInt(1,dislikenum);
            pr.setString(2,stu_content_id);
            int row=pr.executeUpdate();
            if(row>0){
                return dislikenum;
            }else{
                return -1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    //展示我的所有评论
    public  List<Stu_contents> showmycontents(String nickname){
        Iterator<Stu_contents> it=stu_contentsList.iterator();
        List<Stu_contents> mycontents=new ArrayList<Stu_contents>();
        while(it.hasNext()){
            Stu_contents stu_contents=it.next();
            if(stu_contents.getNickname().equals(nickname)){
                mycontents.add(stu_contents);
            }
        }
        return mycontents;
    }

    //展示指定树洞的所有信息
    public Stu_contents showdetails(String stu_content_id){
        Iterator<Stu_contents> it=stu_contentsList.iterator();
        while(it.hasNext()){
            Stu_contents stu_contents=it.next();
            if(stu_contents.getStu_content_id().equals(stu_content_id)){
                return stu_contents;
            }
        }
        return null;
    }

}
