
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for EventTypeMetadata type.
 */
public class EventTypeMetadata {
    private final String eventType;
    private final String apiVersionIntroduced;
    private final String releaseStatus;

    /**
     * Initialization constructor.
     * @param  eventType  String value for eventType.
     * @param  apiVersionIntroduced  String value for apiVersionIntroduced.
     * @param  releaseStatus  String value for releaseStatus.
     */
    @JsonCreator
    public EventTypeMetadata(
            @JsonProperty("event_type") String eventType,
            @JsonProperty("api_version_introduced") String apiVersionIntroduced,
            @JsonProperty("release_status") String releaseStatus) {
        this.eventType = eventType;
        this.apiVersionIntroduced = apiVersionIntroduced;
        this.releaseStatus = releaseStatus;
    }

    /**
     * Getter for EventType.
     * The event type.
     * @return Returns the String
     */
    @JsonGetter("event_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEventType() {
        return eventType;
    }

    /**
     * Getter for ApiVersionIntroduced.
     * The API version at which the event type was introduced.
     * @return Returns the String
     */
    @JsonGetter("api_version_introduced")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getApiVersionIntroduced() {
        return apiVersionIntroduced;
    }

    /**
     * Getter for ReleaseStatus.
     * The release status of the event type.
     * @return Returns the String
     */
    @JsonGetter("release_status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReleaseStatus() {
        return releaseStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventType, apiVersionIntroduced, releaseStatus);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventTypeMetadata)) {
            return false;
        }
        EventTypeMetadata other = (EventTypeMetadata) obj;
        return Objects.equals(eventType, other.eventType)
            && Objects.equals(apiVersionIntroduced, other.apiVersionIntroduced)
            && Objects.equals(releaseStatus, other.releaseStatus);
    }

    /**
     * Converts this EventTypeMetadata into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "EventTypeMetadata [" + "eventType=" + eventType + ", apiVersionIntroduced="
                + apiVersionIntroduced + ", releaseStatus=" + releaseStatus + "]";
    }

    /**
     * Builds a new {@link EventTypeMetadata.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link EventTypeMetadata.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .eventType(getEventType())
                .apiVersionIntroduced(getApiVersionIntroduced())
                .releaseStatus(getReleaseStatus());
        return builder;
    }

    /**
     * Class to build instances of {@link EventTypeMetadata}.
     */
    public static class Builder {
        private String eventType;
        private String apiVersionIntroduced;
        private String releaseStatus;



        /**
         * Setter for eventType.
         * @param  eventType  String value for eventType.
         * @return Builder
         */
        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        /**
         * Setter for apiVersionIntroduced.
         * @param  apiVersionIntroduced  String value for apiVersionIntroduced.
         * @return Builder
         */
        public Builder apiVersionIntroduced(String apiVersionIntroduced) {
            this.apiVersionIntroduced = apiVersionIntroduced;
            return this;
        }

        /**
         * Setter for releaseStatus.
         * @param  releaseStatus  String value for releaseStatus.
         * @return Builder
         */
        public Builder releaseStatus(String releaseStatus) {
            this.releaseStatus = releaseStatus;
            return this;
        }

        /**
         * Builds a new {@link EventTypeMetadata} object using the set fields.
         * @return {@link EventTypeMetadata}
         */
        public EventTypeMetadata build() {
            return new EventTypeMetadata(eventType, apiVersionIntroduced, releaseStatus);
        }
    }
}
