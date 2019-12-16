package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderFulfillmentPickupDetails {

    @JsonCreator
    public OrderFulfillmentPickupDetails(
            @JsonProperty("recipient") OrderFulfillmentRecipient recipient,
            @JsonProperty("expires_at") String expiresAt,
            @JsonProperty("auto_complete_duration") String autoCompleteDuration,
            @JsonProperty("schedule_type") String scheduleType,
            @JsonProperty("pickup_at") String pickupAt,
            @JsonProperty("pickup_window_duration") String pickupWindowDuration,
            @JsonProperty("prep_time_duration") String prepTimeDuration,
            @JsonProperty("note") String note,
            @JsonProperty("placed_at") String placedAt,
            @JsonProperty("accepted_at") String acceptedAt,
            @JsonProperty("rejected_at") String rejectedAt,
            @JsonProperty("ready_at") String readyAt,
            @JsonProperty("expired_at") String expiredAt,
            @JsonProperty("picked_up_at") String pickedUpAt,
            @JsonProperty("canceled_at") String canceledAt,
            @JsonProperty("cancel_reason") String cancelReason) {
        this.recipient = recipient;
        this.expiresAt = expiresAt;
        this.autoCompleteDuration = autoCompleteDuration;
        this.scheduleType = scheduleType;
        this.pickupAt = pickupAt;
        this.pickupWindowDuration = pickupWindowDuration;
        this.prepTimeDuration = prepTimeDuration;
        this.note = note;
        this.placedAt = placedAt;
        this.acceptedAt = acceptedAt;
        this.rejectedAt = rejectedAt;
        this.readyAt = readyAt;
        this.expiredAt = expiredAt;
        this.pickedUpAt = pickedUpAt;
        this.canceledAt = canceledAt;
        this.cancelReason = cancelReason;
    }

    private final OrderFulfillmentRecipient recipient;
    private final String expiresAt;
    private final String autoCompleteDuration;
    private final String scheduleType;
    private final String pickupAt;
    private final String pickupWindowDuration;
    private final String prepTimeDuration;
    private final String note;
    private final String placedAt;
    private final String acceptedAt;
    private final String rejectedAt;
    private final String readyAt;
    private final String expiredAt;
    private final String pickedUpAt;
    private final String canceledAt;
    private final String cancelReason;

    @Override
    public int hashCode() {
        return Objects.hash(recipient, expiresAt, autoCompleteDuration, scheduleType, pickupAt, pickupWindowDuration, prepTimeDuration, note, placedAt, acceptedAt, rejectedAt, readyAt, expiredAt, pickedUpAt, canceledAt, cancelReason);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderFulfillmentPickupDetails)) {
            return false;
        }
        OrderFulfillmentPickupDetails orderFulfillmentPickupDetails = (OrderFulfillmentPickupDetails) o;
        return Objects.equals(recipient, orderFulfillmentPickupDetails.recipient) &&
            Objects.equals(expiresAt, orderFulfillmentPickupDetails.expiresAt) &&
            Objects.equals(autoCompleteDuration, orderFulfillmentPickupDetails.autoCompleteDuration) &&
            Objects.equals(scheduleType, orderFulfillmentPickupDetails.scheduleType) &&
            Objects.equals(pickupAt, orderFulfillmentPickupDetails.pickupAt) &&
            Objects.equals(pickupWindowDuration, orderFulfillmentPickupDetails.pickupWindowDuration) &&
            Objects.equals(prepTimeDuration, orderFulfillmentPickupDetails.prepTimeDuration) &&
            Objects.equals(note, orderFulfillmentPickupDetails.note) &&
            Objects.equals(placedAt, orderFulfillmentPickupDetails.placedAt) &&
            Objects.equals(acceptedAt, orderFulfillmentPickupDetails.acceptedAt) &&
            Objects.equals(rejectedAt, orderFulfillmentPickupDetails.rejectedAt) &&
            Objects.equals(readyAt, orderFulfillmentPickupDetails.readyAt) &&
            Objects.equals(expiredAt, orderFulfillmentPickupDetails.expiredAt) &&
            Objects.equals(pickedUpAt, orderFulfillmentPickupDetails.pickedUpAt) &&
            Objects.equals(canceledAt, orderFulfillmentPickupDetails.canceledAt) &&
            Objects.equals(cancelReason, orderFulfillmentPickupDetails.cancelReason);
    }

    /**
     * Getter for Recipient.
     * Contains information on the recipient of a fulfillment.
     */
    @JsonGetter("recipient")
    public OrderFulfillmentRecipient getRecipient() { 
        return this.recipient;
    }

    /**
     * Getter for ExpiresAt.
     * The [timestamp](#workingwithdates) indicating when this fulfillment
     * will expire if it is not accepted. Must be in RFC 3339 format
     * e.g., "2016-09-04T23:59:33.123Z". Expiration time can only be set up to 7
     * days in the future. If `expires_at` is not set, this pickup fulfillment
     * will be automatically accepted when placed.
     */
    @JsonGetter("expires_at")
    public String getExpiresAt() { 
        return this.expiresAt;
    }

    /**
     * Getter for AutoCompleteDuration.
     * The duration of time after which an open and accepted pickup fulfillment
     * will automatically move to the `COMPLETED` state. Must be in RFC3339
     * duration format e.g., "P1W3D".
     * If not set, this pickup fulfillment will remain accepted until it is canceled or completed.
     */
    @JsonGetter("auto_complete_duration")
    public String getAutoCompleteDuration() { 
        return this.autoCompleteDuration;
    }

    /**
     * Getter for ScheduleType.
     * The schedule type of the pickup fulfillment.
     */
    @JsonGetter("schedule_type")
    public String getScheduleType() { 
        return this.scheduleType;
    }

    /**
     * Getter for PickupAt.
     * The [timestamp](#workingwithdates) that represents the start of the pickup window.
     * Must be in RFC3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     * For fulfillments with the schedule type `ASAP`, this is automatically set
     * to the current time plus the expected duration to prepare the fulfillment.
     */
    @JsonGetter("pickup_at")
    public String getPickupAt() { 
        return this.pickupAt;
    }

    /**
     * Getter for PickupWindowDuration.
     * The window of time in which the order should be picked up after the `pickup_at` timestamp.
     * Must be in RFC3339 duration format, e.g., "P1W3D". Can be used as an
     * informational guideline for merchants.
     */
    @JsonGetter("pickup_window_duration")
    public String getPickupWindowDuration() { 
        return this.pickupWindowDuration;
    }

    /**
     * Getter for PrepTimeDuration.
     * The duration of time it takes to prepare this fulfillment.
     * Must be in RFC3339 duration format, e.g., "P1W3D".
     */
    @JsonGetter("prep_time_duration")
    public String getPrepTimeDuration() { 
        return this.prepTimeDuration;
    }

    /**
     * Getter for Note.
     * A note meant to provide additional instructions about the pickup
     * fulfillment displayed in the Square Point of Sale and set by the API.
     */
    @JsonGetter("note")
    public String getNote() { 
        return this.note;
    }

    /**
     * Getter for PlacedAt.
     * The [timestamp](#workingwithdates) indicating when the fulfillment
     * was placed. Must be in RFC3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("placed_at")
    public String getPlacedAt() { 
        return this.placedAt;
    }

    /**
     * Getter for AcceptedAt.
     * The [timestamp](#workingwithdates) indicating when the fulfillment
     * was accepted. In RFC3339 timestamp format,
     * e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("accepted_at")
    public String getAcceptedAt() { 
        return this.acceptedAt;
    }

    /**
     * Getter for RejectedAt.
     * The [timestamp](#workingwithdates) indicating when the fulfillment
     * was rejected. In RFC3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("rejected_at")
    public String getRejectedAt() { 
        return this.rejectedAt;
    }

    /**
     * Getter for ReadyAt.
     * The [timestamp](#workingwithdates) indicating when the fulfillment is
     * marked as ready for pickup. In RFC3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("ready_at")
    public String getReadyAt() { 
        return this.readyAt;
    }

    /**
     * Getter for ExpiredAt.
     * The [timestamp](#workingwithdates) indicating when the fulfillment expired.
     * In RFC3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("expired_at")
    public String getExpiredAt() { 
        return this.expiredAt;
    }

    /**
     * Getter for PickedUpAt.
     * The [timestamp](#workingwithdates) indicating when the fulfillment
     * was picked up by the recipient. In RFC3339 timestamp format,
     * e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("picked_up_at")
    public String getPickedUpAt() { 
        return this.pickedUpAt;
    }

    /**
     * Getter for CanceledAt.
     * The [timestamp](#workingwithdates) in RFC3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z",
     * indicating when the fulfillment was canceled.
     */
    @JsonGetter("canceled_at")
    public String getCanceledAt() { 
        return this.canceledAt;
    }

    /**
     * Getter for CancelReason.
     * A description of why the pickup was canceled. Max length: 100 characters.
     */
    @JsonGetter("cancel_reason")
    public String getCancelReason() { 
        return this.cancelReason;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .recipient(getRecipient())
            .expiresAt(getExpiresAt())
            .autoCompleteDuration(getAutoCompleteDuration())
            .scheduleType(getScheduleType())
            .pickupAt(getPickupAt())
            .pickupWindowDuration(getPickupWindowDuration())
            .prepTimeDuration(getPrepTimeDuration())
            .note(getNote())
            .placedAt(getPlacedAt())
            .acceptedAt(getAcceptedAt())
            .rejectedAt(getRejectedAt())
            .readyAt(getReadyAt())
            .expiredAt(getExpiredAt())
            .pickedUpAt(getPickedUpAt())
            .canceledAt(getCanceledAt())
            .cancelReason(getCancelReason());
            return builder;
    }

    public static class Builder {
        private OrderFulfillmentRecipient recipient;
        private String expiresAt;
        private String autoCompleteDuration;
        private String scheduleType;
        private String pickupAt;
        private String pickupWindowDuration;
        private String prepTimeDuration;
        private String note;
        private String placedAt;
        private String acceptedAt;
        private String rejectedAt;
        private String readyAt;
        private String expiredAt;
        private String pickedUpAt;
        private String canceledAt;
        private String cancelReason;

        public Builder() { }

        public Builder recipient(OrderFulfillmentRecipient value) {
            recipient = value;
            return this;
        }
        public Builder expiresAt(String value) {
            expiresAt = value;
            return this;
        }
        public Builder autoCompleteDuration(String value) {
            autoCompleteDuration = value;
            return this;
        }
        public Builder scheduleType(String value) {
            scheduleType = value;
            return this;
        }
        public Builder pickupAt(String value) {
            pickupAt = value;
            return this;
        }
        public Builder pickupWindowDuration(String value) {
            pickupWindowDuration = value;
            return this;
        }
        public Builder prepTimeDuration(String value) {
            prepTimeDuration = value;
            return this;
        }
        public Builder note(String value) {
            note = value;
            return this;
        }
        public Builder placedAt(String value) {
            placedAt = value;
            return this;
        }
        public Builder acceptedAt(String value) {
            acceptedAt = value;
            return this;
        }
        public Builder rejectedAt(String value) {
            rejectedAt = value;
            return this;
        }
        public Builder readyAt(String value) {
            readyAt = value;
            return this;
        }
        public Builder expiredAt(String value) {
            expiredAt = value;
            return this;
        }
        public Builder pickedUpAt(String value) {
            pickedUpAt = value;
            return this;
        }
        public Builder canceledAt(String value) {
            canceledAt = value;
            return this;
        }
        public Builder cancelReason(String value) {
            cancelReason = value;
            return this;
        }

        public OrderFulfillmentPickupDetails build() {
            return new OrderFulfillmentPickupDetails(recipient,
                expiresAt,
                autoCompleteDuration,
                scheduleType,
                pickupAt,
                pickupWindowDuration,
                prepTimeDuration,
                note,
                placedAt,
                acceptedAt,
                rejectedAt,
                readyAt,
                expiredAt,
                pickedUpAt,
                canceledAt,
                cancelReason);
        }
    }
}
