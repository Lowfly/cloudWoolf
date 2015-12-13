package com.cloud.plagiarism.analyser;

import com.cloud.plagiarism.Controllers.SentenceController;
import com.cloud.plagiarism.Models.SentenceSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * CO846 Cloud
 *
 * @author Nick
 */


public class DB {

    private String error;
    private List<SentenceSchema> list;

    public DB() {

        try {
        } catch (Exception e) {
        }
    }

    public String hasError() {
        return error;
    }

    public List getAll() {
        SentenceController sentenceController = new SentenceController();
        try {
            list = sentenceController.getAllFromStore();

            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isPresent(String s) {

        List<String> DBContentString = new ArrayList<>();

        for (SentenceSchema tmp : list) {
            DBContentString.add(tmp.getSentence());
        }
        if (DBContentString.contains(s)) {
            return true;
        } else {
            return false;

        }
    }

    public void insertAll(List<String> rows) {
        SentenceController sentenceController;
        for (String r : rows) {
            try {
                sentenceController = new SentenceController(r);
                sentenceController.putToStore();
                /**** TODO: Compare if it's already not in DB****/
//                conn.createStatement().executeQuery(
//                    "INSERT INTO sentences (content) VALUES ('"+r+"');");
            } catch (Exception e) {
            }
        }
    }
}
