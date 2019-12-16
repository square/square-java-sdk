package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1TimecardEvent {

    @JsonCreator
    public V1TimecardEvent(
            @JsonProperty("id") String id,
            @JsonProperty("event_type") String eventType,
            @JsonProperty("clockin_time") String clockinTime,
            @JsonProperty("clockout_time") String clockoutTime,
            @JsonProperty("created_at") String createdAt) {
        this.id = id;
        this.eventType = eventType;
        this.clockinTime = clockinTime;
        this.clockoutTime = clockoutTime;
        this.createdAt = createdAt;
    }

    private HttpContext httpContext;
    private final String id;
    private final String eventType;
    private final String clockinTime;
    private final String clockoutTime;
    private final String createdAt;

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, clockinTime, clockoutTime, createdAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1TimecardEvent)) {
            return false;
        }
        V1TimecardEvent v1TimecardEvent = (V1TimecardEvent) o;
        return Objects.equals(id, v1TimecardEvent.id) &&
            Objects.equals(eventType, v1TimecardEvent.eventType) &&
            Objects.equals(clockinTime, v1TimecardEvent.clockinTime) &&
            Objects.equals(clockoutTime, v1TimecardEvent.clockoutTime) &&
            Objects.equals(createdAt, v1TimecardEvent.createdAt);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The event's unique ID.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for EventType.
     * Actions that resulted in a change to a timecard. All timecard
     * events created with the Connect API have an event type that begins with
     * `API`.
     */
    @JsonGetter("event_type")
    public String getEventType() { 
        return this.eventType;
    }

    /**
     * Getter for ClockinTime.
     * The time the employee clocked in, in ISO 8601 format.
     */
    @JsonGetter("clockin_time")
    public String getClockinTime() { 
        return this.clockinTime;
    }

    /**
     * Getter for ClockoutTime.
     * The time the employee clocked out, in ISO 8601 format.
     */
    @JsonGetter("clockout_time")
    public String getClockoutTime() { 
        return this.clockoutTime;
    }

    /**
     * Getter for CreatedAt.
     * The time when the event was created, in ISO 8601 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .eventType(getEventType())
            .clockinTime(getClockinTime())
            .clockoutTime(getClockoutTime())
            .createdAt(getCreatedAt());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String eventType;
        private String clockinTime;
        private String clockoutTime;
        private String createdAt;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder eventType(String value) {
            eventType = value;
            return this;
        }
        public Builder clockinTime(String value) {
            clockinTime = value;
            return this;
        }
        public Builder clockoutTime(String value) {
            clockoutTime = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }

        public V1TimecardEvent build() {
            V1TimecardEvent model = new V1TimecardEvent(id,
                eventType,
                clockinTime,
                clockoutTime,
                createdAt);
            model.httpContext = httpContext;
            return model;
        }
    }
}
