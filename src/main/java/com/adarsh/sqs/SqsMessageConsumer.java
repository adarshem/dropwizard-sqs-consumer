package com.adarsh.sqs;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.List;

public class SqsMessageConsumer {
    private final String queueUrl;

    public SqsMessageConsumer(String queueUrl) {
        this.queueUrl = queueUrl;
    }

    public void start() {
        SqsClient sqsClient = SqsClient.builder()
                .region(Region.US_WEST_2) // Use your region
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();

        ReceiveMessageRequest receiveRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(5)
                .waitTimeSeconds(10)
                .build();

        System.out.println("Polling for messages...");

        while (true) {
            List<Message> messages = sqsClient.receiveMessage(receiveRequest).messages();
            for (Message message : messages) {
                System.out.println("Received message: " + message.body());

                // Delete message after processing
                DeleteMessageRequest deleteRequest = DeleteMessageRequest.builder()
                        .queueUrl(queueUrl)
                        .receiptHandle(message.receiptHandle())
                        .build();
                sqsClient.deleteMessage(deleteRequest);
            }

            try {
                Thread.sleep(5000); // Poll every 5 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}