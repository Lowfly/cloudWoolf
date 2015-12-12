package com.example.guestbook;

import com.cloud.models.DocumentSchema;
import com.googlecode.objectify.ObjectifyService;

import java.util.UUID;

/**
 * Created by guitte_a on 11/12/15.
 */

public class DocumentController {

    private DocumentSchema document;


    /****
     * todo : replace by datetype
     ****/
    public DocumentController(String date, String content) {
        document = new DocumentSchema();
        document.setDocumentStr(content);
        document.setPublicationDate(date);
        document.setDocId(UUID.randomUUID().toString());
        // document.setDocId();
    }

    ;

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
        DocumentSchema shema = ObjectifyService.ofy().load().type(DocumentSchema.class).id(ID).now();
    }


}