package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Official extends User{

    public String ofc_user_id;
    public String user_nickname;
    public String user_password;
    public int user_state;
    public String register_date;
    public String ofc_name;
    public String type;
    public String update_at;
    public List<Official> officialList=new ArrayList<>();

    public static Official officiallogin;

    public Official(){
        this.ofc_user_id=super.getUsername();
        this.user_password=super.getPassword();
    }

    public String getOfc_user_id() {
        return ofc_user_id;
    }
    public void setOfc_user_id(String ofc_user_id) {
        this.ofc_user_id = ofc_user_id;
    }
    public String getUser_nickname() {
        return user_nickname;
    }
    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }
    public String getUser_password() {
        return user_password;
    }
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    public int getUser_state() {
        return user_state;
    }
    public void setUser_state(int user_state) {
        this.user_state = user_state;
    }
    public String getRegister_date() {
        return register_date;
    }
    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }
    public String getOfc_name() {
        return ofc_name;
    }
    public void setOfc_name(String ofc_name) {
        this.ofc_name = ofc_name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUpdate_at() {
        return update_at;
    }
    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }
    public List<Official> getOfficialList() {
        return officialList;
    }
    public void setOfficialList(List<Official> officialList) {
        this.officialList = officialList;
    }

    public void readdata(){
        String sql="SELECT * FROM official";
        try{
            ResultSet rs= Connectsql.getConnectsql().conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Official official=new Official();
                official.ofc_user_id=rs.getString("ofc_user_id");
                official.user_nickname=rs.getString("user_nickname");
                official.user_password=rs.getString("user_password");
                official.user_state=rs.getInt("user_state");
                official.register_date=rs.getString("register_date");
                official.ofc_name=rs.getString("ofc_name");
                official.type=rs.getString("type");
                official.update_at=rs.getString("update_at");
                this.officialList.add(official);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

    public boolean officiallogin(String userid,String password){
        Iterator<Official> iterator=officialList.iterator();
        while(iterator.hasNext()){
            Official official= iterator.next();
            System.out.println("adb");
            System.out.println(official.ofc_user_id+" "+official.user_password);
            if(official.getOfc_user_id().equals(userid)&&official.getUser_password().equals(password)){
                officiallogin=official;
                return true;
            }
        }
        return false;
    }

    public  boolean addnewofficial(String username,String ofc_name,String password){
        Official official=new Official();
        official.setOfc_user_id(username);
        official.setOfc_name(ofc_name);
        official.setPassword(password);
        officialList.add(official);

        //获取系统当前时间
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());

        String sql="insert into official values(?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pr=Connectsql.getConnectsql().conn.prepareStatement(sql);
            pr.setString(1,username);
            pr.setString(2,null);
            pr.setString(3,password);
            pr.setInt(4,0);
            pr.setString(5,datetime);
            pr.setString(6,ofc_name);
            pr.setString(7,null);
            pr.setString(8,null);
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
