package com.example.demo.Entity;

public class User {

    public String type;
    public String userid;
    public String password;
    public String nickname;
    public String ofc_name;

    public String getNick_name() {
        return nickname;
    }

    public void setNick_name(String nick_name) {
        this.nickname = nick_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return userid;
    }

    public void setUsername(String username) {
        this.userid = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
