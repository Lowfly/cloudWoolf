package com.cloud.plagiarism.Models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by guitte_a on 11/12/15.
 */

@Entity
public class SentenceSchema {

    @Id private String id;
    private String sentence;
    //private Boolean isPlag;

    public String getId() {
        return id;
    }

    public void setId(String sentId) {
        this.id = sentId;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    //public Boolean getIsPlag() {
    //    return isPlag;
    //}

    //public void setIsPlag(Boolean isPlag) {
    //    this.isPlag = isPlag;
    //}
}

