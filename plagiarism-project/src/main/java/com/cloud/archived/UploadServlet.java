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
package com.cloud.archived;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class UploadServlet extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();


    // Process the http POST of the form
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

//        System.out.println("\n/**** Request ****/\n");
//        System.out.println(req.getParameterMap());
//        System.out.println("\n/**** Upload Document ****/\n");
//        DocumentController documentController = new DocumentController("17/12/94", "Ceci est le content de mon PDF");
//        documentController.putToStore();
//        System.out.println("\n/**** Download Document ****/\n");
//        System.out.println(documentController.getFromStore(documentController.getDocument().getDocId()));
//        System.out.println("\n/**** Upload Sentence ****/\n");
//        SentenceController sentenceController = new SentenceController(documentController.getDocument().getDocId(), "Content1");
//        sentenceController.putToStore();
//        sentenceController.getSentence().setSentence("Content2");
//        sentenceController.putToStore();
//        sentenceController.getSentence().setSentence("Content3");
//        sentenceController.putToStore();
//        sentenceController.getSentence().setSentence("Content4");
//        sentenceController.putToStore();
//        sentenceController.getSentence().setSentence("Content5");
//        sentenceController.putToStore();
//
//
//
//        System.out.println(sentenceController.getFromStore(sentenceController.getSentence().getId()));

        //System.out.println(sentenceController.getAllFromStore(documentController.getDocument().getDocId()));


        //String fil
        // epath = getUploadFilePath();
        //PDFParser parser = new PDFParser(filepath);

        System.out.println("\n/**** Analyser ****/\n");

        /*ArrayList<String> sentencesList = new ArrayList<>();
        sentencesList.add("Content1");
        sentencesList.add("Content2");
        sentencesList.add("Content4");
        sentencesList.add("FakeContent");*/


        //DB db = new DB(db_connection_details);


        /*Thread t1 = new Thread(new Runnable() {
            public void run() {
                Analyser analyser = new Analyser( sentences, db );
                analyser.getSimilarityIndex();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                db.insertAll( sentences );
            }
        });

        t1.start();
        t2.start();

*/

        Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKeys = blobs.get("file");

        if (blobKeys == null || blobKeys.isEmpty()) {
            resp.sendRedirect("/");
        } else {
            resp.sendRedirect("/parse?blob-key=" + blobKeys.get(0).getKeyString() + "&encoding=" + req.getParameter("encoding"));
        }

//        resp.sendRedirect("/upload.jsp");
    }
}
//[END all]
