
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.Objects;

/**
 * This is a model class for V1TimecardEvent type.
 */
public class V1TimecardEvent {
    private HttpContext httpContext;
    private final String id;
    private final String eventType;
    private final String clockinTime;
    private final String clockoutTime;
    private final String createdAt;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param eventType String value for eventType.
     * @param clockinTime String value for clockinTime.
     * @param clockoutTime String value for clockoutTime.
     * @param createdAt String value for createdAt.
     */
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The event's unique ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for EventType.
     * Actions that resulted in a change to a timecard. All timecard events created with the Connect
     * API have an event type that begins with `API`.
     * @return Returns the String
     */
    @JsonGetter("event_type")
    public String getEventType() {
        return this.eventType;
    }

    /**
     * Getter for ClockinTime.
     * The time the employee clocked in, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("clockin_time")
    public String getClockinTime() {
        return this.clockinTime;
    }

    /**
     * Getter for ClockoutTime.
     * The time the employee clocked out, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("clockout_time")
    public String getClockoutTime() {
        return this.clockoutTime;
    }

    /**
     * Getter for CreatedAt.
     * The time when the event was created, in ISO 8601 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, clockinTime, clockoutTime, createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1TimecardEvent)) {
            return false;
        }
        V1TimecardEvent other = (V1TimecardEvent) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(eventType, other.eventType)
            && Objects.equals(clockinTime, other.clockinTime)
            && Objects.equals(clockoutTime, other.clockoutTime)
            && Objects.equals(createdAt, other.createdAt);
    }

    /**
     * Converts this V1TimecardEvent into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1TimecardEvent [" + "id=" + id + ", eventType=" + eventType + ", clockinTime="
                + clockinTime + ", clockoutTime=" + clockoutTime + ", createdAt=" + createdAt + "]";
    }

    /**
     * Builds a new {@link V1TimecardEvent.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1TimecardEvent.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .eventType(getEventType())
                .clockinTime(getClockinTime())
                .clockoutTime(getClockoutTime())
                .createdAt(getCreatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link V1TimecardEvent}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String eventType;
        private String clockinTime;
        private String clockoutTime;
        private String createdAt;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for eventType.
         * @param eventType String value for eventType.
         * @return Builder
         */
        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        /**
         * Setter for clockinTime.
         * @param clockinTime String value for clockinTime.
         * @return Builder
         */
        public Builder clockinTime(String clockinTime) {
            this.clockinTime = clockinTime;
            return this;
        }

        /**
         * Setter for clockoutTime.
         * @param clockoutTime String value for clockoutTime.
         * @return Builder
         */
        public Builder clockoutTime(String clockoutTime) {
            this.clockoutTime = clockoutTime;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param createdAt String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Builds a new {@link V1TimecardEvent} object using the set fields.
         * @return {@link V1TimecardEvent}
         */
        public V1TimecardEvent build() {
            V1TimecardEvent model =
                    new V1TimecardEvent(id, eventType, clockinTime, clockoutTime, createdAt);
            model.httpContext = httpContext;
            return model;
        }
    }
}
