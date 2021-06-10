package com.example.demo.Entity;

import com.example.demo.Tools.Connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Chat_records {

    public String stu_user_id_send;
    public String stu_user_id_receive;
    public String message;
    public String send_time;
    public List<Chat_records> chat_recordsList=new ArrayList<Chat_records>();

    public List<Chat_records> getChat_recordsList() {
        return chat_recordsList;
    }

    public void setChat_recordsList(List<Chat_records> chat_recordsList) {
        this.chat_recordsList = chat_recordsList;
    }

    public String getStu_user_id_send() {
        return stu_user_id_send;
    }

    public void setStu_user_id_send(String stu_user_id_send) {
        this.stu_user_id_send = stu_user_id_send;
    }

    public String getStu_user_id_receive() {
        return stu_user_id_receive;
    }

    public void setStu_user_id_receive(String stu_user_id_receive) {
        this.stu_user_id_receive = stu_user_id_receive;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public void readdata(){
        String sql="SELECT * FROM chat_records";
        try{
            ResultSet rs= Connectsql.getConnectsql().conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Chat_records chat_records=new Chat_records();
                chat_records.stu_user_id_send=rs.getString("stu_user_id_send");
                chat_records.stu_user_id_receive=rs.getString("stu_user_id_receive");
                chat_records.message=rs.getString("message");
                chat_records.send_time=rs.getString("send_time");
                this.chat_recordsList.add(chat_records);
            }
        }catch (Exception p){
            p.printStackTrace();
        }
    }

    public boolean addnewmessage(String stu_user_id_send,String stu_user_id_receive,String message){

        Chat_records chat_records=new Chat_records();
        chat_records.stu_user_id_send=stu_user_id_send;
        chat_records.stu_user_id_receive=stu_user_id_receive;
        chat_records.message=message;

        //获取系统当前时间
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = tempDate.format(new java.util.Date());

        String sql="insert into official values(?,?,?,?)";
        try{
            PreparedStatement pr= Connectsql.getConnectsql().conn.prepareStatement(sql);
            pr.setString(1,stu_user_id_send);
            pr.setString(2,stu_user_id_receive);
            pr.setString(3,message);
            pr.setString(4,datetime);
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
