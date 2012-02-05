package com.mongo.sample;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class SampleUsingDriver {

    private static final int PORT = 27017;
    private static final String HOST = "localhost";
    private static final String DATABASE_NAME = "mongo_sample";

    public static void main(String args[]) {

        Mongo mongoConnection = null;

        // open connection
        try {
            mongoConnection = new Mongo(HOST, PORT);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }

        // dropping database to have a clean one for the sample
        mongoConnection.dropDatabase(DATABASE_NAME);

        // setting database to use
        DB db = mongoConnection.getDB(DATABASE_NAME);

        DBCollection coll = db.getCollection("sample_1");
        int x = 0;
        for (x = 0; x < 5; x++) {
            BasicDBObject doc = new BasicDBObject();
            doc.put("name", "MongoDB");
            doc.put("type", "database");
            doc.put("count", x);
            coll.insert(doc);
        }

        BasicDBObject doc = new BasicDBObject();
        doc.put("name", "MongoDB");
        doc.put("type", "database");
        doc.put("count", 4);
        coll.save(doc);

        // return first one found
        System.out.println("return first one found");
        DBObject myDoc = coll.findOne();
        System.out.println(myDoc);

        // return all
        System.out.println("return all");
        for (DBObject val : coll.find()) {
            System.out.println(val);
        }

        // find return match
        System.out.println("return match from query");
        DBObject query = new BasicDBObject();
        query.put("count", 4);

        for (DBObject val : coll.find(query)) {
            System.out.println(val);
        }

        // remove
        query = new BasicDBObject();
        query.put("count", 2);
        coll.remove(query);

        // return all
        System.out.println("return all");
        for (DBObject val : coll.find()) {
            System.out.println(val);
        }

        // update
        query = new BasicDBObject();
        query.put("type", "database");
        query.put("count", 3);

        DBObject valToUpdate = coll.findOne(query);

        valToUpdate.put("type", "no sql");

        coll.save(valToUpdate);

        // return all
        System.out.println("return all");
        for (DBObject val : coll.find()) {
            System.out.println(val);
        }

        // close connection
        mongoConnection.close();
    }
}
