package com.adarsh.sqs;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class App extends Application<SqsConfiguration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(SqsConfiguration configuration, Environment environment) {
        SqsMessageConsumer consumer = new SqsMessageConsumer(configuration.getQueueUrl());
        consumer.start();
    }
}