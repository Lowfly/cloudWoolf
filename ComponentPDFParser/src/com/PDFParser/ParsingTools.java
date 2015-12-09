package com.PDFParser;

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
        return (lowerText);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
