package com.PDFParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guitte_a on 09/12/15.
 */
public class ParsingTools {

    private String text = null;

    public ParsingTools (String text) {
        this.text = text;
    }

    public String toLowerCase() {
        return (toLowerCase(this.text));
    }

    public String toLowerCase(String text) {
        String lowerText = null;

        lowerText = text.toLowerCase();
        this.text = lowerText;
        return (this.text);
    }

    public String replaceToSpace() {

        return (replaceToSpace(this.text));
    }

    public String replaceToSpace(String text) {
        String cleanText = null;

        cleanText = text.replaceAll("[\\d[^\\w\\s.!?]]+", " ").replaceAll("[\n\r]+", " ").replaceAll("(\\s{2,})", " ");

        this.text = cleanText;

        return (this.text);
    }

    public Map textToMap() {
        return (textToMap(this.text));
    }

    public Map textToMap(String text) {

        String cleanText;

        String[] sentences = text.split("[\\.\\!\\?]");
        int nbSentences = 0;
        for (int i=0; i<sentences.length; i++){
            nbSentences = i;
        }

        Map<Integer, String> map = new HashMap<Integer, String>(); // I use HashMap because it is the most generic

        for(int i = 0; i < nbSentences; i++) {
            map.put(i, sentences[i]); //Add each object, os[i], to the map at position str[i]
        }

        return (map);
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
