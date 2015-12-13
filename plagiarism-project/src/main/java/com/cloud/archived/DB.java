package com.cloud.archived;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

/**
 * CO846 Cloud
 * @author Nick
 */


public class DB {

    private Connection conn;
    private String error;
//    private static final String url = "jdbc:google:mysql://co846-cloud:sql01/simildb?user=root";

    public DB(Connection conn) {
        this.conn = conn;
    }

    public DB() {
        String url = null;

        try {
            /*//Class.forName("com.mysql.jdbc.GoogleDriver");
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("com.google.appengine.api.rdbms.AppEngineDrive");

            // url = "jdbc:google:mysql://sql01?user=root";
            //url = "jdbc:google:mysql://sql01/simildb";

            //Connection conn = DriverManager.getConnection(url);

            conn = DriverManager.getConnection(
                    "jdbc:mysql://109.168.126.31/klvpjymy_co846",
                    "klvpjymy_co846", "U_X%uv9T#A}{");*/

            url = "jdbc:google:rdbms://sql01/simildb";
            Connection conn = DriverManager.getConnection(url);
        } catch(Exception e) {
            error = url+"<br>"+e.getMessage();
        }

        try {

            ResultSet rs = conn.createStatement().executeQuery(
                    "SELECT 1 + 1");
            error += ";no error";
        } catch(Exception e) {
            error += ";"+url+"<br>"+e.getMessage();
        }
    }

    public String hasError() {
        return error;
    }

    public String getAll() {
        String o = "";
        try{
            ResultSet res = conn.createStatement().executeQuery(
                    "SELECT * FROM sentences;");
/*            while( res.next() ) {
                o = "<li>"+res.getString("content")+"</li>";
            }
            return "<ul>"+o+"</ul>";*/
            return "done";
        } catch(Exception e) {
            return "error loosers";
        }
    }

    public boolean isPresent(String s) {
        try {
            ResultSet res = conn.createStatement().executeQuery(
                    "SELECT content FROM sentences WHERE content='" + s + "'");
            return (res.next() ? true : false);
        } catch(Exception e) {return false;}
    }
    
    public void insertAll(List<String> rows) {
        try {
            conn.createStatement().executeQuery(
                    "INSERT INTO sentences (content) VALUES ('ciao');");
        } catch (Exception e) {}
        /*
        for(String r : rows) {
            try {
                conn.createStatement().executeQuery(
                    "INSERT INTO sentences (content) VALUES ('"+r+"');");
            } catch(Exception e) {}
        }*/
    }
}
