/**
 * Copyright 2014-2015 Google Inc. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//[START all]
package com.cloud.plagiarism;

import com.cloud.parser.PDFParser;
import com.cloud.parser.ParsingTools;
import com.google.appengine.api.blobstore.*;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class ParseServlet extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private BlobInfoFactory blobInfoFactory = new BlobInfoFactory();


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));
        BlobInfo blobInfo = blobInfoFactory.loadBlobInfo(blobKey);

        String fileName = blobInfo.getFilename();

        byte[] fileBytes = blobstoreService.fetchData(blobKey, 0, blobInfo.getSize());
        String fileString = new String(fileBytes, req.getParameter("encoding"));


        ParsingTools parsingTools = new ParsingTools(fileString);
        parsingTools.toLowerCase();
        parsingTools.replaceToSpace();
        fileString = parsingTools.getText();
        String outputTextStr = fileString;
        List<String> outputTextList = parsingTools.textToList(outputTextStr);



        DocumentController documentController = new DocumentController(blobInfo.getCreation().toString(), outputTextStr);
        documentController.putToStore();

        System.out.println(documentController.getFromStore(documentController.getDocument().getDocId()));

        SentenceController sentenceController = new SentenceController(documentController.getDocument().getDocId());

        for(String sentence : outputTextList) {
            if(sentence.split("\\s+").length > 7){
                sentenceController.getSentence().setSentence(sentence);
                sentenceController.putToStore();
            }
        }




        System.out.println(sentenceController.getFromStore(sentenceController.getSentence().getId()));

//        InputStream fileIn = new BlobstoreInputStream(blobKey);
//
//        File file = new File(fileIn);

//        PDFParser pdfParser = new PDFParser(fileIn);
//        blobstoreService.serve(blobKey, res);
    }

}
//[END all]
