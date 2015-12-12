package com.cloud.parser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by guitte_a on 09/12/15.
 */

public class PDFParser {

    private String inputText;
    private Map outputTextMap;
    private List outputTextList;
    private String outputTextStr;


    public PDFParser(String path) throws IOException {

        PDFToString PDFToString = new PDFToString();
        PDFToString.setFilePath(path);
        //System.out.println("\n//////////////////\n");
        System.out.println("\nExtracted from PDF : \n");
        inputText = PDFToString.ToText();
        System.out.println(inputText);
        //System.out.println("\n//////////////////\n");
        //System.out.println("\nLowerCase : \n");
        ParsingTools parsingTools = new ParsingTools(inputText);
        inputText = parsingTools.toLowerCase();
        //System.out.println(inputText);
        //System.out.println("\n//////////////////\n");
        //System.out.println("\nWithout newline : \n");
        inputText = parsingTools.replaceToSpace();
        outputTextStr = inputText;
        //System.out.println(inputText);
        System.out.println("\n//////////////////\n");
        System.out.println("\nMap of sentences: \n");
        outputTextMap = parsingTools.textToMap();
        System.out.println(outputTextMap);
    }

    public Map getSentencesMap() {
        return outputTextMap;
    }

    /**** Todo: Create list ****/

    /*public List getSentencesList() {
        return outputText;
    }*/

    public String getSentencesString() {
        return outputTextStr;
    }


}
