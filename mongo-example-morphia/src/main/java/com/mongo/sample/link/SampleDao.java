package com.mongo.sample.link;

import org.bson.types.ObjectId;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;

public class SampleDao extends BasicDAO<SampleModel, ObjectId> {

    public SampleDao(Mongo mongo, Morphia morphia, String dbName) {
        super(SampleModel.class, mongo, morphia, dbName);
        super.ensureIndexes();
    }

}
