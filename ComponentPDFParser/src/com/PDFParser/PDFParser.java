package com.PDFParser;

import java.io.IOException;
import java.util.Map;

/**
 * Created by guitte_a on 09/12/15.
 */

public class PDFParser {

    private String inputText;
    private Map outputText;

    public PDFParser(String path) throws IOException {

        PDFToString PDFToString = new PDFToString();
        PDFToString.setFilePath(path);
        //System.out.println("\n//////////////////\n");
        //System.out.println("\nExtracted from PDF : \n");
        inputText = PDFToString.ToText();
        //System.out.println(text);
        //System.out.println("\n//////////////////\n");
        //System.out.println("\nLowerCase : \n");
        ParsingTools parsingTools = new ParsingTools(inputText);
        inputText = parsingTools.toLowerCase();
        //System.out.println(text);
        //System.out.println("\n//////////////////\n");
        //System.out.println("\nWithout newline : \n");
        inputText = parsingTools.replaceToSpace();
        //System.out.println(text);
        //System.out.println("\n//////////////////\n");
        //System.out.println("\nArray of sentences: \n");
        outputText = parsingTools.textToMap();
        System.out.println(outputText);
    }

}
