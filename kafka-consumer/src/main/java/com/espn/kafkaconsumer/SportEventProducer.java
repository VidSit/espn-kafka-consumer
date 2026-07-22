package com.espn.kafkaconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SportEventProducer {

    private static final Logger log = LoggerFactory.getLogger(SportEventProducer.class);
    private static final String TOPIC = "sport-events";

    @Autowired
    private KafkaTemplate<String, SportEvent> kafkaTemplate;

    public void sendEvent(SportEvent event) {
        kafkaTemplate.send(TOPIC, event.getEventId(), event)
            .whenComplete((result, ex) -> {
                if (ex == null) {
                    log.info("Sent event: {} to partition: {} at offset: {}",
                            event.getEventId(),
                            result.getRecordMetadata().partition(),
                            result.getRecordMetadata().offset());
                } else {
                    log.error("Failed to send event: {}", event.getEventId(), ex);
                }
            });
    }
}
