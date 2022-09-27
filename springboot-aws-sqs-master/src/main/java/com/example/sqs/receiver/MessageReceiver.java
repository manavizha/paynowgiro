package com.example.sqs.receiver;


import java.util.Map;

import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MessageReceiver{

    @SqsListener(value = "testQueue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receive(String message){
        log.info("Message received {}", message);
    }
    
    @SqsListener("https://sqs.ap-southeast-1.amazonaws.com/330277625446/SimpleQueue")
    public void processOrder(@Payload ObjectNode payload, @Headers Map<String, Object> payloadHeaders) {
    	log.info("Incoming order payload {} with headers {}", payload, payloadHeaders);

      
    }
}
