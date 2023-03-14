
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for SquareEvent type.
 */
public class SquareEvent {
    private final OptionalNullable<String> merchantId;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<String> type;
    private final OptionalNullable<String> eventId;
    private final String createdAt;
    private final SquareEventData data;

    /**
     * Initialization constructor.
     * @param  merchantId  String value for merchantId.
     * @param  locationId  String value for locationId.
     * @param  type  String value for type.
     * @param  eventId  String value for eventId.
     * @param  createdAt  String value for createdAt.
     * @param  data  SquareEventData value for data.
     */
    @JsonCreator
    public SquareEvent(
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("type") String type,
            @JsonProperty("event_id") String eventId,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("data") SquareEventData data) {
        this.merchantId = OptionalNullable.of(merchantId);
        this.locationId = OptionalNullable.of(locationId);
        this.type = OptionalNullable.of(type);
        this.eventId = OptionalNullable.of(eventId);
        this.createdAt = createdAt;
        this.data = data;
    }

    /**
     * Internal initialization constructor.
     */
    protected SquareEvent(OptionalNullable<String> merchantId, OptionalNullable<String> locationId,
            OptionalNullable<String> type, OptionalNullable<String> eventId, String createdAt,
            SquareEventData data) {
        this.merchantId = merchantId;
        this.locationId = locationId;
        this.type = type;
        this.eventId = eventId;
        this.createdAt = createdAt;
        this.data = data;
    }

    /**
     * Internal Getter for MerchantId.
     * The ID of the target merchant associated with the event.
     * @return Returns the Internal String
     */
    @JsonGetter("merchant_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMerchantId() {
        return this.merchantId;
    }

    /**
     * Getter for MerchantId.
     * The ID of the target merchant associated with the event.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMerchantId() {
        return OptionalNullable.getFrom(merchantId);
    }

    /**
     * Internal Getter for LocationId.
     * The ID of the location associated with the event.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * The ID of the location associated with the event.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for Type.
     * The type of event this represents.
     * @return Returns the Internal String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetType() {
        return this.type;
    }

    /**
     * Getter for Type.
     * The type of event this represents.
     * @return Returns the String
     */
    @JsonIgnore
    public String getType() {
        return OptionalNullable.getFrom(type);
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
     * Getter for CreatedAt.
     * Timestamp of when the event was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for Data.
     * @return Returns the SquareEventData
     */
    @JsonGetter("data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SquareEventData getData() {
        return data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantId, locationId, type, eventId, createdAt, data);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SquareEvent)) {
            return false;
        }
        SquareEvent other = (SquareEvent) obj;
        return Objects.equals(merchantId, other.merchantId)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(type, other.type)
            && Objects.equals(eventId, other.eventId)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(data, other.data);
    }

    /**
     * Converts this SquareEvent into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SquareEvent [" + "merchantId=" + merchantId + ", locationId=" + locationId
                + ", type=" + type + ", eventId=" + eventId + ", createdAt=" + createdAt + ", data="
                + data + "]";
    }

    /**
     * Builds a new {@link SquareEvent.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SquareEvent.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .createdAt(getCreatedAt())
                .data(getData());
        builder.merchantId = internalGetMerchantId();
        builder.locationId = internalGetLocationId();
        builder.type = internalGetType();
        builder.eventId = internalGetEventId();
        return builder;
    }

    /**
     * Class to build instances of {@link SquareEvent}.
     */
    public static class Builder {
        private OptionalNullable<String> merchantId;
        private OptionalNullable<String> locationId;
        private OptionalNullable<String> type;
        private OptionalNullable<String> eventId;
        private String createdAt;
        private SquareEventData data;



        /**
         * Setter for merchantId.
         * @param  merchantId  String value for merchantId.
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = OptionalNullable.of(merchantId);
            return this;
        }

        /**
         * UnSetter for merchantId.
         * @return Builder
         */
        public Builder unsetMerchantId() {
            merchantId = null;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = OptionalNullable.of(type);
            return this;
        }

        /**
         * UnSetter for type.
         * @return Builder
         */
        public Builder unsetType() {
            type = null;
            return this;
        }

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
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for data.
         * @param  data  SquareEventData value for data.
         * @return Builder
         */
        public Builder data(SquareEventData data) {
            this.data = data;
            return this;
        }

        /**
         * Builds a new {@link SquareEvent} object using the set fields.
         * @return {@link SquareEvent}
         */
        public SquareEvent build() {
            return new SquareEvent(merchantId, locationId, type, eventId, createdAt, data);
        }
    }
}
