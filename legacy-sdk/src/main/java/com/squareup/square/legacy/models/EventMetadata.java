package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for EventMetadata type.
 */
public class EventMetadata {
    private final OptionalNullable<String> eventId;
    private final OptionalNullable<String> apiVersion;

    /**
     * Initialization constructor.
     * @param  eventId  String value for eventId.
     * @param  apiVersion  String value for apiVersion.
     */
    @JsonCreator
    public EventMetadata(@JsonProperty("event_id") String eventId, @JsonProperty("api_version") String apiVersion) {
        this.eventId = OptionalNullable.of(eventId);
        this.apiVersion = OptionalNullable.of(apiVersion);
    }

    /**
     * Initialization constructor.
     * @param  eventId  String value for eventId.
     * @param  apiVersion  String value for apiVersion.
     */
    protected EventMetadata(OptionalNullable<String> eventId, OptionalNullable<String> apiVersion) {
        this.eventId = eventId;
        this.apiVersion = apiVersion;
    }

    /**
     * Internal Getter for EventId.
     * A unique ID for the event.
     * @return Returns the Internal String
     */
    @JsonGetter("event_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEventId() {
        return this.eventId;
    }

    /**
     * Getter for EventId.
     * A unique ID for the event.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEventId() {
        return OptionalNullable.getFrom(eventId);
    }

    /**
     * Internal Getter for ApiVersion.
     * The API version of the event. This corresponds to the default API version of the developer
     * application at the time when the event was created.
     * @return Returns the Internal String
     */
    @JsonGetter("api_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetApiVersion() {
        return this.apiVersion;
    }

    /**
     * Getter for ApiVersion.
     * The API version of the event. This corresponds to the default API version of the developer
     * application at the time when the event was created.
     * @return Returns the String
     */
    @JsonIgnore
    public String getApiVersion() {
        return OptionalNullable.getFrom(apiVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, apiVersion);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventMetadata)) {
            return false;
        }
        EventMetadata other = (EventMetadata) obj;
        return Objects.equals(eventId, other.eventId) && Objects.equals(apiVersion, other.apiVersion);
    }

    /**
     * Converts this EventMetadata into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "EventMetadata [" + "eventId=" + eventId + ", apiVersion=" + apiVersion + "]";
    }

    /**
     * Builds a new {@link EventMetadata.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link EventMetadata.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.eventId = internalGetEventId();
        builder.apiVersion = internalGetApiVersion();
        return builder;
    }

    /**
     * Class to build instances of {@link EventMetadata}.
     */
    public static class Builder {
        private OptionalNullable<String> eventId;
        private OptionalNullable<String> apiVersion;

        /**
         * Setter for eventId.
         * @param  eventId  String value for eventId.
         * @return Builder
         */
        public Builder eventId(String eventId) {
            this.eventId = OptionalNullable.of(eventId);
            return this;
        }

        /**
         * UnSetter for eventId.
         * @return Builder
         */
        public Builder unsetEventId() {
            eventId = null;
            return this;
        }

        /**
         * Setter for apiVersion.
         * @param  apiVersion  String value for apiVersion.
         * @return Builder
         */
        public Builder apiVersion(String apiVersion) {
            this.apiVersion = OptionalNullable.of(apiVersion);
            return this;
        }

        /**
         * UnSetter for apiVersion.
         * @return Builder
         */
        public Builder unsetApiVersion() {
            apiVersion = null;
            return this;
        }

        /**
         * Builds a new {@link EventMetadata} object using the set fields.
         * @return {@link EventMetadata}
         */
        public EventMetadata build() {
            return new EventMetadata(eventId, apiVersion);
        }
    }
}
