package com.PDFParser;

import java.io.IOException;

/**
 * Created by guitte_a on 09/12/15.
 */
public class PDFParser {

    private String text;

    public PDFParser(String path) throws IOException {

        PDFToString PDFToString = new PDFToString();
        PDFToString.setFilePath(path);
        System.out.println("\n//////////////////\n");
        System.out.println("\nExtracted from PDF : \n");
        text = PDFToString.ToText();
        System.out.println(text);
        System.out.println("\n//////////////////\n");
        System.out.println("\nLowerCase : \n");
        ParsingTools parsingTools = new ParsingTools(text);
        text = parsingTools.toLowerCase();
        System.out.println(text);
        System.out.println("\n//////////////////\n");
        System.out.println("\nWithout newline : \n");
        text = parsingTools.replaceToSpace();
        System.out.println(text);
        System.out.println("\n//////////////////\n");
        System.out.println("\nArray of sentences: \n");
        parsingTools.textToMap();
    }

}
