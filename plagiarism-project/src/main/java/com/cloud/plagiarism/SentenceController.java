package com.cloud.plagiarism;

import com.cloud.models.SentenceSchema;
import com.googlecode.objectify.ObjectifyService;

import java.util.List;
import java.util.UUID;

/**
 * Created by guitte_a on 11/12/15.
 */

public class SentenceController {

    private SentenceSchema sentence;


    /****
     * todo : replace by datetype
     ****/
    public SentenceController(String docId) {
        sentence = new SentenceSchema();
        //sentence.setDocId(content);
        sentence.setId(UUID.randomUUID().toString());

        //document.setPublicationDate(date);
    };
    public SentenceController(String docId, String content) {
        sentence = new SentenceSchema();
        sentence.setSentence(content);
        //sentence.setDocId(content);
        sentence.setId(UUID.randomUUID().toString());

        //document.setPublicationDate(date);
    };

    public SentenceSchema getSentence() {
        return sentence;
    }

    public void setSentence(SentenceSchema sentence) {
        this.sentence = sentence;
    }

    public void putToStore() {
        ObjectifyService.ofy().save().entity(sentence).now();
    }

    public SentenceSchema getFromStore(String Id) {
        SentenceSchema shema = ObjectifyService.ofy().load().type(SentenceSchema.class).id(Id).now();
        return (shema);
    }

    public boolean isPlag(String sentence) {
        List<SentenceSchema> listInQuery = ObjectifyService.ofy().load().type(SentenceSchema.class).filter("sentence in", sentence).list();
        return listInQuery.size() > 0;
    }

    /*public List<SentenceSchema> getAllFromStore(String docId) {
        List<SentenceSchema> listSent = ObjectifyService.ofy().load().type(SentenceSchema.class).ancestor(docId).list();
        return (listSent);
    }*/


}