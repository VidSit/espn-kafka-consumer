package com.espn.kafkaconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class SportEventConsumer {

    private static final Logger log = LoggerFactory.getLogger(SportEventConsumer.class);

    @KafkaListener(
        topics = "sport-events",
        groupId = "espn-consumer-group"
    )
    public void consume(
            @Payload SportEvent event,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) long offset) {

        log.info("Received event: {} from partition: {} at offset: {}",
                event, partition, offset);
        processEvent(event);
    }

    private void processEvent(SportEvent event) {
        log.info("Processing sport: {} - {}", event.getSport(), event.getDescription());
    }
}
