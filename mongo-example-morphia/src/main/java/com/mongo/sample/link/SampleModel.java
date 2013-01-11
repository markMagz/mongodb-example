package com.mongo.sample.link;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;
import com.google.code.morphia.annotations.Reference;

@Entity(value = SampleModel.COLLECTION_NAME, noClassnameStored = true)
public class SampleModel {

    // ENTITY PROPERTIES; start
    public static final String ID = "_id";
    public static final String COLLECTION_NAME = "sample_collection_reference";
    public static final String NAME = "name";
    public static final String AGE = "age";

    // ENTITY PROPERTIES; end

    @Id
    @Property(ID)
    private ObjectId id;

    @Property(NAME)
    private String name;

    @Reference
    private JobTitle jobTitle;

    @Property(AGE)
    private int age;

    public SampleModel() {
    }

    public SampleModel(String name, JobTitle jobTitle, int age) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.age = age;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[SampleModel : {name : " + name + ", jobTitle : " + jobTitle + " , age : " + age + "}]";
    }
}
