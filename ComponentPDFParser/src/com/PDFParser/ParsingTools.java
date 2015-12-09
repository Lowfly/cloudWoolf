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

        cleanText = text.replaceAll("[\\d[^\\w\\s]]+", " ").replaceAll("[\n\r]+", " ").replaceAll("(\\s{2,})", " ");

        this.text = cleanText;

        return (this.text);
    }

    public Map textToMap() {
        return (textToMap(this.text));
    }

    public Map textToMap(String text) {

        Map map  = new HashMap<>();
        String cleanText;

        String[] sentences = text.split("[\\.\\!\\?]");
        for (int i=0;i<sentences.length;i++){
            System.out.println(i);
            System.out.println(sentences[i]);
        }


/*
        final Map<String, String> m = new HashMap<String, String>();
        int i = 0;
        for (String key : sentences)
            m.put(key, sentences[i++]);

        System.out.println(m);
*/
        return (map);
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
