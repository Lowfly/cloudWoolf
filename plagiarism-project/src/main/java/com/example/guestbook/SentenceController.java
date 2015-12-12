package com.example.guestbook;

import com.cloud.models.DocumentSchema;

import java.util.UUID;

/**
 * Created by guitte_a on 11/12/15.
 */

public class SentenceController {

    private DocumentSchema document;


    /**** todo : replace by datetype ****/
    public SentenceController(String date, String content) {
        document = new DocumentSchema();
        document.setDocumentStr(content);
        document.setPublicationDate(date);
        document.setDocId(UUID.randomUUID().toString());
       // document.setDocId();
    };

    public DocumentSchema getDocument() {
        return document;
    }

    public void setDocument(DocumentSchema document) {
        this.document = document;
    }


}