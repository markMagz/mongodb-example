package com.mongo.sample.embeded;

public class SampleMainServiceRunner {

    public static void main(String... args) {
        SampleService sampleService = new SampleService();

        // create
        sampleService.createSampleModel(new SampleModel("mark", new Address("cebu city", "phil"), 16));

        // find by name
        SampleModel model = sampleService.findSampleModelWithName("mark");
        System.out.println("create test");
        System.out.println(model);

        // update
        System.out.println("update test");
        model.setAge(12);
        model.setAddress(new Address("mandaue city", "phil"));
        sampleService.updateSampleModel(model);
        System.out.println(sampleService.findSampleModelWithName("mark"));

        // create 5 more sample
        sampleService.createSampleModel(new SampleModel("matthew", new Address("naga city", "phil"), 26));
        sampleService.createSampleModel(new SampleModel("john", new Address("carcar city", "phil"), 31));
        sampleService.createSampleModel(new SampleModel("peter", new Address("argao city", "phil"), 22));
        sampleService.createSampleModel(new SampleModel("dave", new Address("oslob city", "phil"), 44));
        sampleService.createSampleModel(new SampleModel("eric", new Address("liloan city", "phil"), 72));

        // find all
        System.out.println("display all test");
        for (SampleModel mod : sampleService.findAllSampleModel()) {
            System.out.println(mod);
        }

        // count all
        System.out.println("count all test");
        System.out.println(sampleService.countSampleModel());

        // delete 1 test
        System.out.println("delete 1 test");
        sampleService.deleteSampleModel(model);
        System.out.println(sampleService.countSampleModel());

        // find all
        System.out.println("display all test");
        for (SampleModel mod : sampleService.findAllSampleModel()) {
            System.out.println(mod);
        }

        // delete 1 by name
        System.out.println("delete 1 by name test");
        sampleService.deleteSampleModel("john");
        System.out.println(sampleService.countSampleModel());

        // find all
        System.out.println("delete 1 by name test");
        for (SampleModel mod : sampleService.findAllSampleModel()) {
            System.out.println(mod);
        }
    }

}
