package com.mongo.sample.link;

import org.bson.types.ObjectId;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;

public class JobTitleDao extends BasicDAO<JobTitle, ObjectId> {

    public JobTitleDao(Mongo mongo, Morphia morphia, String dbName) {
        super(JobTitle.class, mongo, morphia, dbName);
        super.ensureIndexes();
    }
}
