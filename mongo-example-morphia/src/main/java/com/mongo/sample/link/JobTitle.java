package com.mongo.sample.link;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

@Entity(value = JobTitle.COLLECTION_NAME, noClassnameStored = true)
public class JobTitle {

    // ENTITY PROPERTIES; start
    public static final String COLLECTION_NAME = "sample_collection_reference_job";
    public static final String POSITION = "position";
    public static final String LEVEL = "level";
    // ENTITY PROPERTIES; end

    @Id
    private ObjectId id;

    @Property(POSITION)
    private String position;

    @Property(LEVEL)
    private String level;

    public JobTitle() {
    }

    public JobTitle(String position, String level) {
        this.position = position;
        this.level = level;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "[position : " + position + ", level : " + level + " ]";
    }
}
