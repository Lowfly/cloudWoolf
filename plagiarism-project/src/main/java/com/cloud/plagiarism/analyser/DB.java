package com.cloud.plagiarism.analyser;

import java.util.List;

/**
 * CO846 Cloud
 * @author Nick
 */


public class DB {

    private String error;

    public DB() {

        try {
        } catch(Exception e) {
        }
    }

    public String hasError() {
        return error;
    }

    public String getAll() {
//        String o = "";
//        try{
//            ResultSet res = conn.createStatement().executeQuery(
//                    "SELECT * FROM sentences;");
//            return "done";
//        } catch(Exception e) {
            return "error loosers";
//        }
    }

    public boolean isPresent(String s) {
//        try {
//            ResultSet res = conn.createStatement().executeQuery(
//                    "SELECT content FROM sentences WHERE content='" + s + "'");
//            return (res.next() ? true : false);
//        } catch(Exception e) {
            return false;
//         }
    }

    public void insertAll(List<String> rows) {
//        for(String r : rows) {
//            try {
//                conn.createStatement().executeQuery(
//                    "INSERT INTO sentences (content) VALUES ('"+r+"');");
//            } catch(Exception e) {}
//        }
    }
}
