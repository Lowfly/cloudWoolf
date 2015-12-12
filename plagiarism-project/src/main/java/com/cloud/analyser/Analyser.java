package com.cloud.analyser;

import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public class Analyser {

   private List<String> sent;
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
        this.sent = sent;
    }
    
    public double getSimilarityIndex() {
        if( simIndex < 0 )
            simIndex = computeSimilarityIndex();
        return simIndex;
    }
        
    private double computeSimilarityIndex() {
        int c = 0;
        for(String s : sent) {
            if( db.isPresent(s) )
                c++;
        }
        return c / sent.size();
    }

}
