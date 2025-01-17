package com.sicredi.votingapi.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VotingResultsProducer {

    @Value("${voting.topic.producer.name}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        log.info("Payload sent: {}", message);
        kafkaTemplate.send(topicName, message);
    }

}

