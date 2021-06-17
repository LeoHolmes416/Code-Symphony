package com.example.demo.Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connectsql {

    public Connection conn=null;
    public Statement stmt=null;
    public ResultSet rs=null;

    private static Connectsql connectsql=new Connectsql();

    public Connectsql(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            long start=System.currentTimeMillis();
            conn= DriverManager.getConnection("jdbc:mysql://rm-2zel590ug920zx2n6io.mysql.rds.aliyuncs.com:3306/treehole","leo","Zfl2000!");
            stmt= conn.createStatement();
            long end=System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("spend time: "+(end-start)+"ms ");
            System.out.println("connect db successfully");

        }catch (Exception p){
            p.printStackTrace();
        }
    }

    public static Connectsql getConnectsql(){
        return connectsql;
    }

}
