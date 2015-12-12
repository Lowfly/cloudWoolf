package com.example.guestbook;

import com.cloud.models.DocumentSchema;
import com.googlecode.objectify.ObjectifyService;

import java.util.UUID;

/**
 * Created by guitte_a on 11/12/15.
 */

public class DocumentController {

    private DocumentSchema document;


    /**** todo : replace by datetype ****/
    public DocumentController (String date, String content) {
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

    public void uploadDocument() {
        ObjectifyService.ofy().save().entity(document).now();
    }

    public void downloadDocument(String ID) {
        //ObjectifyService.ofy()
        /*ObjectifyService.ofy()
                .load()
                .type(DocumentSchema.class) // We want only Greetings
                .ancestor(theBook)    // Anyone in this book
                .order("-date")       // Most recent first - date is indexed.
                .limit(5)             // Only show 5 of them.
                .list();*/

    }



}