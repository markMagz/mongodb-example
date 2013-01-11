package com.mongo.sample.link;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class SampleService {
    private static String DBNAME = "mongo_sample_morphia";
    private static Mongo MONGO;
    private static Morphia MORPHIA;
    private static final int PORT = 27017;
    private static final String HOST = "localhost";

    private SampleDao sampleDao;

    private JobTitleDao jobTitleDao;

    public SampleService() {
        if (sampleDao == null) {
            if (MONGO == null) {
                // open connection
                try {
                    MONGO = new Mongo(HOST, PORT);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (MongoException e) {
                    e.printStackTrace();
                }

                // doing this have a clean database
                MONGO.dropDatabase(DBNAME);
            }

            if (MORPHIA == null) {
                MORPHIA = new Morphia();
                MORPHIA.map(SampleModel.class);
                MORPHIA.map(JobTitle.class);
            }

            sampleDao = new SampleDao(MONGO, MORPHIA, DBNAME);
        }
    }

    public SampleModel createSampleModel(SampleModel sampleModel) {
        sampleDao.save(sampleModel);
        return sampleModel;
    }

    public SampleModel updateSampleModel(SampleModel sampleModel) {
        sampleDao.save(sampleModel);
        return sampleModel;
    }

    public void deleteSampleModel(SampleModel sampleModel) {
        sampleDao.delete(sampleModel);
    }

    public void deleteSampleModel(String name) {
        SampleModel sampleModel = findSampleModelWithName(name);
        if (sampleModel != null) {
            sampleDao.delete(sampleModel);
        }
    }

    public long countSampleModel() {
        return sampleDao.count();
    }

    public List<SampleModel> findAllSampleModel() {
        Query<SampleModel> query = sampleDao.createQuery();
        List<SampleModel> sampleModels = sampleDao.find(query).asList();
        return sampleModels;
    }

    public SampleModel findSampleModelWithName(String name) {
        return sampleDao.findOne(SampleModel.NAME, name);
    }

    public JobTitle preCreatedJobTitle(JobTitle jobTitle) {

        if (jobTitleDao == null) {
            jobTitleDao = new JobTitleDao(MONGO, MORPHIA, DBNAME);
        }

        jobTitleDao.save(jobTitle);
        return jobTitle;
    }
}
