package com.cloud.plagiarism.Controllers;

import com.cloud.plagiarism.Models.SentenceSchema;
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
    public SentenceController() {
        sentence = new SentenceSchema();
        sentence.setId(UUID.randomUUID().toString());
    };
    public SentenceController(String content) {
        sentence = new SentenceSchema();
        sentence.setSentence(content);
        sentence.setId(UUID.randomUUID().toString());
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

    public SentenceSchema getFromStore(String sentence) {

        System.out.println(sentence);
        SentenceSchema schema = new SentenceSchema();
        /*SentenceSchema shema = ObjectifyService.ofy().load().type(SentenceSchema.class).filter("sentence", sentence).first().now();
        System.out.println(shema);*/
        ObjectifyService.ofy().delete().type(SentenceSchema.class); // synchronous

        return (schema);
    }

    public List getAllFromStore() {
        List<SentenceSchema> shemaList = ObjectifyService.ofy().load().type(SentenceSchema.class).list();
        return (shemaList);
    }

}