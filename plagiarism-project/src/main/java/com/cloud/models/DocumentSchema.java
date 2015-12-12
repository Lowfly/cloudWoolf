package com.cloud.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by guitte_a on 11/12/15.
 */

@Entity
public class DocumentSchema {
    @Id public String docId;
    public String documentStr;
    public String  publicationDate;
    //public String documentPdf;
    //public Date   publicationDate;


    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocumentStr() {
        return documentStr;
    }

    public void setDocumentStr(String documentStr) {
        this.documentStr = documentStr;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}
