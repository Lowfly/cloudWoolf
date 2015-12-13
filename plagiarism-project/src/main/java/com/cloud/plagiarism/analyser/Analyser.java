package com.cloud.plagiarism.analyser;

import java.util.List;

/**
 * CO846 Cloud
 * @author Nick
 */

public class Analyser {

    private List<String> sentences;
    private double simIndex;
    private DB db;
    
    public Analyser(DB db) {   
        this(null,db);
    }
    
    public Analyser(List<String> sent, DB db) {
        simIndex = -1;
        this.db = db;
        setSentences(sent);
    }
    
    public final void setSentences(List<String> sent) {
        this.sentences = sent;
    }
    
    public double getSimilarityIndex() {
        if( simIndex < 0 )
            simIndex = computeSimilarityIndex();
        return simIndex;
    }
        
    private double computeSimilarityIndex() {
        int c = 0;
        for(String s : sentences) {
            if( db.isPresent(s) )
                c++;
        }
        return c / sentences.size();
    }

}
