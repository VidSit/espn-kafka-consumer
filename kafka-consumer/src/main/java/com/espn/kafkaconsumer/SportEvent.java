package com.espn.kafkaconsumer;

public class SportEvent {
    private String eventId;
    private String sport;
    private String description;
    private long timestamp;

    public SportEvent() {}

    public SportEvent(String eventId, String sport, String description, long timestamp) {
        this.eventId = eventId;
        this.sport = sport;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getEventId() { return eventId; }
    public void setEventId(String eventId) { this.eventId = eventId; }
    public String getSport() { return sport; }
    public void setSport(String sport) { this.sport = sport; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "SportEvent{eventId='" + eventId + "', sport='" + sport + 
               "', description='" + description + "', timestamp=" + timestamp + "}";
    }
}
