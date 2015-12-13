package com.cloud.plagiarism.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by guitte_a on 11/12/15.
 */

@Entity
public class SentenceSchema {
    //@Parent
    //private  String docId;

    @Id private String Id;

    //private String docId;

    private String sentence;
    private Boolean isPlag;


    /*public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }*/


    public String getId() {
        return Id;
    }

    public void setId(String sentId) {
        this.Id = sentId;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Boolean getIsPlag() {
        return isPlag;
    }

    public void setIsPlag(Boolean isPlag) {
        this.isPlag = isPlag;
    }
}

