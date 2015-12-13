package com.cloud.plagiarism.analyser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nick on 12/12/2015.
 */
public class TextParser {

    private String text;

    public TextParser(String text) {
        this.text = text;
        clean();
    }

    private void clean() {
        text = text.toLowerCase();
        text = text.replaceAll("[\\d[^\\w\\s.!?]]+", " ")
                .replaceAll("[\n\r]+", " ")
                .replaceAll("(\\s{2,})", " ");
    }

    public List<String> getSentencesList() {
        List<String> l0 = Arrays.asList( text.split("[\\.\\!\\?]") );
        List<String> l1 = new ArrayList<>();
        for(String s : l0)
            if(s.split("\\s+").length > 7)
                l1.add(s);
        return l1;
    }
}
