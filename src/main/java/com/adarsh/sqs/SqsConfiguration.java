package com.adarsh.sqs;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SqsConfiguration extends Configuration {
    @JsonProperty
    private String queueUrl;

    public String getQueueUrl() {
        return queueUrl;
    }

    public void setQueueUrl(String queueUrl) {
        this.queueUrl = queueUrl;
    }
}