package com.espn.kafkaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class SportEventController {

    @Autowired
    private SportEventProducer producer;

    @PostMapping
    public ResponseEntity<String> publishEvent(@RequestBody SportEvent event) {
        event.setTimestamp(System.currentTimeMillis());
        producer.sendEvent(event);
        return ResponseEntity.ok("Event published: " + event.getEventId());
    }
}
