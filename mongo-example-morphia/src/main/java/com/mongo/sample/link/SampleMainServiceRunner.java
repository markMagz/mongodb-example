package com.mongo.sample.link;

public class SampleMainServiceRunner {

    public static void main(String... args) {
        SampleService sampleService = new SampleService();

        JobTitle jobTitle = sampleService.preCreatedJobTitle(new JobTitle("Soft engineer", "1"));

        System.out.println(jobTitle);

        sampleService.updateSampleModel(new SampleModel("dave", jobTitle, 44));
        System.out.println(sampleService.findSampleModelWithName("dave"));
    }
}
