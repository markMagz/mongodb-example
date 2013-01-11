package com.mongo.sample.embeded;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;

@Entity(value = SampleModel.COLLECTION_NAME, noClassnameStored = true)
public class SampleModel {

    // ENTITY PROPERTIES; start
    public static final String ID = "_id";
    public static final String COLLECTION_NAME = "sample_collection_embeded";
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String AGE = "age";

    // ENTITY PROPERTIES; end

    @Id
    @Property(ID)
    private ObjectId id;

    @Property(NAME)
    private String name;

    @Embedded(ADDRESS)
    private Address address;

    @Property(AGE)
    private int age;

    public SampleModel() {
    }

    public SampleModel(String name, Address address, int age) {
        this.name = name;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[SampleModel : {name : " + name + ", address : " + address + " , age : " + age + "}]";
    }
}
