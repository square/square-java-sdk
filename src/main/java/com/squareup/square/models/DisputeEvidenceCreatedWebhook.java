
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DisputeEvidenceCreatedWebhook type.
 */
public class DisputeEvidenceCreatedWebhook {
    private final String merchantId;
    private final String locationId;
    private final String type;
    private final String eventId;
    private final String createdAt;
    private final DisputeEvidenceCreatedWebhookData data;

    /**
     * Initialization constructor.
     * @param  merchantId  String value for merchantId.
     * @param  locationId  String value for locationId.
     * @param  type  String value for type.
     * @param  eventId  String value for eventId.
     * @param  createdAt  String value for createdAt.
     * @param  data  DisputeEvidenceCreatedWebhookData value for data.
     */
    @JsonCreator
    public DisputeEvidenceCreatedWebhook(
            @JsonProperty("merchant_id") String merchantId,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("type") String type,
            @JsonProperty("event_id") String eventId,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("data") DisputeEvidenceCreatedWebhookData data) {
        this.merchantId = merchantId;
        this.locationId = locationId;
        this.type = type;
        this.eventId = eventId;
        this.createdAt = createdAt;
        this.data = data;
    }

    /**
     * Getter for MerchantId.
     * The ID of the target merchant associated with the event.
     * @return Returns the String
     */
    @JsonGetter("merchant_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Getter for LocationId.
     * The ID of the target location associated with the event.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for Type.
     * The type of event this represents.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Getter for EventId.
     * A unique ID for the webhook event.
     * @return Returns the String
     */
    @JsonGetter("event_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEventId() {
        return eventId;
    }

    /**
     * Getter for CreatedAt.
     * Timestamp of when the webhook event was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for Data.
     * @return Returns the DisputeEvidenceCreatedWebhookData
     */
    @JsonGetter("data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DisputeEvidenceCreatedWebhookData getData() {
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
        if (!(obj instanceof DisputeEvidenceCreatedWebhook)) {
            return false;
        }
        DisputeEvidenceCreatedWebhook other = (DisputeEvidenceCreatedWebhook) obj;
        return Objects.equals(merchantId, other.merchantId)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(type, other.type)
            && Objects.equals(eventId, other.eventId)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(data, other.data);
    }

    /**
     * Converts this DisputeEvidenceCreatedWebhook into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DisputeEvidenceCreatedWebhook [" + "merchantId=" + merchantId + ", locationId="
                + locationId + ", type=" + type + ", eventId=" + eventId + ", createdAt="
                + createdAt + ", data=" + data + "]";
    }

    /**
     * Builds a new {@link DisputeEvidenceCreatedWebhook.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DisputeEvidenceCreatedWebhook.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .merchantId(getMerchantId())
                .locationId(getLocationId())
                .type(getType())
                .eventId(getEventId())
                .createdAt(getCreatedAt())
                .data(getData());
        return builder;
    }

    /**
     * Class to build instances of {@link DisputeEvidenceCreatedWebhook}.
     */
    public static class Builder {
        private String merchantId;
        private String locationId;
        private String type;
        private String eventId;
        private String createdAt;
        private DisputeEvidenceCreatedWebhookData data;



        /**
         * Setter for merchantId.
         * @param  merchantId  String value for merchantId.
         * @return Builder
         */
        public Builder merchantId(String merchantId) {
            this.merchantId = merchantId;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for eventId.
         * @param  eventId  String value for eventId.
         * @return Builder
         */
        public Builder eventId(String eventId) {
            this.eventId = eventId;
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
         * @param  data  DisputeEvidenceCreatedWebhookData value for data.
         * @return Builder
         */
        public Builder data(DisputeEvidenceCreatedWebhookData data) {
            this.data = data;
            return this;
        }

        /**
         * Builds a new {@link DisputeEvidenceCreatedWebhook} object using the set fields.
         * @return {@link DisputeEvidenceCreatedWebhook}
         */
        public DisputeEvidenceCreatedWebhook build() {
            return new DisputeEvidenceCreatedWebhook(merchantId, locationId, type, eventId,
                    createdAt, data);
        }
    }
}
