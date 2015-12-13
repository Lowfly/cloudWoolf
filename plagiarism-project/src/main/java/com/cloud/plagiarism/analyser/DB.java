package com.cloud.plagiarism.analyser;

import com.cloud.plagiarism.Controllers.SentenceController;
import com.cloud.plagiarism.Models.SentenceSchema;

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

        //List<SentenceSchema> listSentence;

        //listSentence = getAll();
       // System.out.println(listSentence);
        //System.out.println(listSentence.contains("Office of the Privacy Commissioner of Canada"));
        /* SentenceController sentenceController = new SentenceController();
        SentenceSchema sentenceSchema = new SentenceSchema();
        sentenceSchema.setSentence(null);
        System.out.println("//////////////////////////");
        System.out.println(s);
        sentenceSchema = sentenceController.getFromStore(s);*/
        // System.out.println(sentenceSchema.getSentence());
        /*if (sentenceSchema.getSentence() == null)
            System.out.println("No sentence");
        else
            System.out.println("*********************PRESENT***********************");
*/

        /*try {
           /* ResultSet res = conn.createStatement().executeQuery(
                    "SELECT content FROM sentences WHERE content='" + s + "'");
            return (res.next() ? true : false);
        } catch (Exception e) {
            return false;
        }*/



        return false;
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
