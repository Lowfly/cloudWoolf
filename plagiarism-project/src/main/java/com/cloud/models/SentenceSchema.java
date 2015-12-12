package com.cloud.models;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

/**
 * Created by guitte_a on 11/12/15.
 */

@Entity
public class SentenceSchema {
    @Parent private  Key<DocumentSchema> originalDocument;
    @Id private Long sentId;
    private String sentence;
    private Boolean isPlag;

}

