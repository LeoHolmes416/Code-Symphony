package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ofc_contents {
    public String ofc_content_id;
    public String ofc_name;
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
                ofc_contents.ofc_content_id=rs.getString("ofc_content_id");
                ofc_contents.ofc_name=rs.getString("ofc_name");
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

    //根据指定nickname返回该用户下所有的contents
    public List<Ofc_contents> getthiscontents(String ofc_name){
        List<Ofc_contents> thiscontents=new ArrayList<Ofc_contents>();
        Iterator<Ofc_contents> iterator= ofc_contentsList.iterator();
        while(iterator.hasNext()){
            Ofc_contents ofc_contents= iterator.next();
            if(ofc_contents.ofc_name.equals(ofc_name)){
                thiscontents.add(ofc_contents);
            }
        }
        return thiscontents;
    }

    public boolean addnewofc_contents(String ofc_name,String title,String contents){
        Ofc_contents newofc_contents=new Ofc_contents();
        newofc_contents.readdata();

        //生成一个新的content_id
        int conid;
        here:for(conid=1;conid<1000;conid++){
            Iterator<Ofc_contents> it1= newofc_contents.ofc_contentsList.iterator();
            while(it1.hasNext()){
                Ofc_contents ofc_contents=it1.next();
                if(ofc_contents.getOfc_content_id().equals(Integer.toString(conid))){
                    continue here;
                }
            }
            break;
        }

        //获取系统当前时间
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());

        String sql="insert into  ofc_contents values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement pr= Connectsql.getConnectsql().conn.prepareStatement(sql);
            pr.setString(1,Integer.toString(conid));
            pr.setString(2,ofc_name);
            pr.setString(3,title);
            pr.setString(4,contents);
            pr.setString(5,datetime);
            pr.setString(6,null);
            pr.setInt(7,105);
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
