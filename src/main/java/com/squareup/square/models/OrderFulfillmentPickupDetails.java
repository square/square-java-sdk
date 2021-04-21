
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderFulfillmentPickupDetails type.
 */
public class OrderFulfillmentPickupDetails {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final OrderFulfillmentRecipient recipient;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String expiresAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String autoCompleteDuration;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String scheduleType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String pickupAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String pickupWindowDuration;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String prepTimeDuration;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String note;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String placedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String acceptedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String rejectedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String readyAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String expiredAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String pickedUpAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String canceledAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cancelReason;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean isCurbsidePickup;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final OrderFulfillmentPickupDetailsCurbsidePickupDetails curbsidePickupDetails;

    /**
     * Initialization constructor.
     * @param  recipient  OrderFulfillmentRecipient value for recipient.
     * @param  expiresAt  String value for expiresAt.
     * @param  autoCompleteDuration  String value for autoCompleteDuration.
     * @param  scheduleType  String value for scheduleType.
     * @param  pickupAt  String value for pickupAt.
     * @param  pickupWindowDuration  String value for pickupWindowDuration.
     * @param  prepTimeDuration  String value for prepTimeDuration.
     * @param  note  String value for note.
     * @param  placedAt  String value for placedAt.
     * @param  acceptedAt  String value for acceptedAt.
     * @param  rejectedAt  String value for rejectedAt.
     * @param  readyAt  String value for readyAt.
     * @param  expiredAt  String value for expiredAt.
     * @param  pickedUpAt  String value for pickedUpAt.
     * @param  canceledAt  String value for canceledAt.
     * @param  cancelReason  String value for cancelReason.
     * @param  isCurbsidePickup  Boolean value for isCurbsidePickup.
     * @param  curbsidePickupDetails  OrderFulfillmentPickupDetailsCurbsidePickupDetails value for
     *         curbsidePickupDetails.
     */
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
            @JsonProperty("cancel_reason") String cancelReason,
            @JsonProperty("is_curbside_pickup") Boolean isCurbsidePickup,
            @JsonProperty("curbside_pickup_details") OrderFulfillmentPickupDetailsCurbsidePickupDetails curbsidePickupDetails) {
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
        this.isCurbsidePickup = isCurbsidePickup;
        this.curbsidePickupDetails = curbsidePickupDetails;
    }

    /**
     * Getter for Recipient.
     * Contains information on the recipient of a fulfillment.
     * @return Returns the OrderFulfillmentRecipient
     */
    @JsonGetter("recipient")
    public OrderFulfillmentRecipient getRecipient() {
        return recipient;
    }

    /**
     * Getter for ExpiresAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when this fulfillment will expire if it is not accepted. Must be in RFC 3339
     * format e.g., "2016-09-04T23:59:33.123Z". Expiration time can only be set up to 7 days in the
     * future. If `expires_at` is not set, this pickup fulfillment will be automatically accepted
     * when placed.
     * @return Returns the String
     */
    @JsonGetter("expires_at")
    public String getExpiresAt() {
        return expiresAt;
    }

    /**
     * Getter for AutoCompleteDuration.
     * The duration of time after which an open and accepted pickup fulfillment will automatically
     * move to the `COMPLETED` state. Must be in RFC3339 duration format e.g., "P1W3D". If not set,
     * this pickup fulfillment will remain accepted until it is canceled or completed.
     * @return Returns the String
     */
    @JsonGetter("auto_complete_duration")
    public String getAutoCompleteDuration() {
        return autoCompleteDuration;
    }

    /**
     * Getter for ScheduleType.
     * The schedule type of the pickup fulfillment.
     * @return Returns the String
     */
    @JsonGetter("schedule_type")
    public String getScheduleType() {
        return scheduleType;
    }

    /**
     * Getter for PickupAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) that
     * represents the start of the pickup window. Must be in RFC3339 timestamp format, e.g.,
     * "2016-09-04T23:59:33.123Z". For fulfillments with the schedule type `ASAP`, this is
     * automatically set to the current time plus the expected duration to prepare the fulfillment.
     * @return Returns the String
     */
    @JsonGetter("pickup_at")
    public String getPickupAt() {
        return pickupAt;
    }

    /**
     * Getter for PickupWindowDuration.
     * The window of time in which the order should be picked up after the `pickup_at` timestamp.
     * Must be in RFC3339 duration format, e.g., "P1W3D". Can be used as an informational guideline
     * for merchants.
     * @return Returns the String
     */
    @JsonGetter("pickup_window_duration")
    public String getPickupWindowDuration() {
        return pickupWindowDuration;
    }

    /**
     * Getter for PrepTimeDuration.
     * The duration of time it takes to prepare this fulfillment. Must be in RFC3339 duration
     * format, e.g., "P1W3D".
     * @return Returns the String
     */
    @JsonGetter("prep_time_duration")
    public String getPrepTimeDuration() {
        return prepTimeDuration;
    }

    /**
     * Getter for Note.
     * A note meant to provide additional instructions about the pickup fulfillment displayed in the
     * Square Point of Sale and set by the API.
     * @return Returns the String
     */
    @JsonGetter("note")
    public String getNote() {
        return note;
    }

    /**
     * Getter for PlacedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was placed. Must be in RFC3339 timestamp format, e.g.,
     * "2016-09-04T23:59:33.123Z".
     * @return Returns the String
     */
    @JsonGetter("placed_at")
    public String getPlacedAt() {
        return placedAt;
    }

    /**
     * Getter for AcceptedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was accepted. In RFC3339 timestamp format, e.g.,
     * "2016-09-04T23:59:33.123Z".
     * @return Returns the String
     */
    @JsonGetter("accepted_at")
    public String getAcceptedAt() {
        return acceptedAt;
    }

    /**
     * Getter for RejectedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was rejected. In RFC3339 timestamp format, e.g.,
     * "2016-09-04T23:59:33.123Z".
     * @return Returns the String
     */
    @JsonGetter("rejected_at")
    public String getRejectedAt() {
        return rejectedAt;
    }

    /**
     * Getter for ReadyAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment is marked as ready for pickup. In RFC3339 timestamp format,
     * e.g., "2016-09-04T23:59:33.123Z".
     * @return Returns the String
     */
    @JsonGetter("ready_at")
    public String getReadyAt() {
        return readyAt;
    }

    /**
     * Getter for ExpiredAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment expired. In RFC3339 timestamp format, e.g.,
     * "2016-09-04T23:59:33.123Z".
     * @return Returns the String
     */
    @JsonGetter("expired_at")
    public String getExpiredAt() {
        return expiredAt;
    }

    /**
     * Getter for PickedUpAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was picked up by the recipient. In RFC3339 timestamp format,
     * e.g., "2016-09-04T23:59:33.123Z".
     * @return Returns the String
     */
    @JsonGetter("picked_up_at")
    public String getPickedUpAt() {
        return pickedUpAt;
    }

    /**
     * Getter for CanceledAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) in
     * RFC3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z", indicating when the fulfillment
     * was canceled.
     * @return Returns the String
     */
    @JsonGetter("canceled_at")
    public String getCanceledAt() {
        return canceledAt;
    }

    /**
     * Getter for CancelReason.
     * A description of why the pickup was canceled. Max length: 100 characters.
     * @return Returns the String
     */
    @JsonGetter("cancel_reason")
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * Getter for IsCurbsidePickup.
     * If true, indicates this pickup order is for curbside pickup, not in-store pickup.
     * @return Returns the Boolean
     */
    @JsonGetter("is_curbside_pickup")
    public Boolean getIsCurbsidePickup() {
        return isCurbsidePickup;
    }

    /**
     * Getter for CurbsidePickupDetails.
     * Specific details for curbside pickup.
     * @return Returns the OrderFulfillmentPickupDetailsCurbsidePickupDetails
     */
    @JsonGetter("curbside_pickup_details")
    public OrderFulfillmentPickupDetailsCurbsidePickupDetails getCurbsidePickupDetails() {
        return curbsidePickupDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipient, expiresAt, autoCompleteDuration, scheduleType, pickupAt,
                pickupWindowDuration, prepTimeDuration, note, placedAt, acceptedAt, rejectedAt,
                readyAt, expiredAt, pickedUpAt, canceledAt, cancelReason, isCurbsidePickup,
                curbsidePickupDetails);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderFulfillmentPickupDetails)) {
            return false;
        }
        OrderFulfillmentPickupDetails other = (OrderFulfillmentPickupDetails) obj;
        return Objects.equals(recipient, other.recipient)
            && Objects.equals(expiresAt, other.expiresAt)
            && Objects.equals(autoCompleteDuration, other.autoCompleteDuration)
            && Objects.equals(scheduleType, other.scheduleType)
            && Objects.equals(pickupAt, other.pickupAt)
            && Objects.equals(pickupWindowDuration, other.pickupWindowDuration)
            && Objects.equals(prepTimeDuration, other.prepTimeDuration)
            && Objects.equals(note, other.note)
            && Objects.equals(placedAt, other.placedAt)
            && Objects.equals(acceptedAt, other.acceptedAt)
            && Objects.equals(rejectedAt, other.rejectedAt)
            && Objects.equals(readyAt, other.readyAt)
            && Objects.equals(expiredAt, other.expiredAt)
            && Objects.equals(pickedUpAt, other.pickedUpAt)
            && Objects.equals(canceledAt, other.canceledAt)
            && Objects.equals(cancelReason, other.cancelReason)
            && Objects.equals(isCurbsidePickup, other.isCurbsidePickup)
            && Objects.equals(curbsidePickupDetails, other.curbsidePickupDetails);
    }

    /**
     * Converts this OrderFulfillmentPickupDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderFulfillmentPickupDetails [" + "recipient=" + recipient + ", expiresAt="
                + expiresAt + ", autoCompleteDuration=" + autoCompleteDuration + ", scheduleType="
                + scheduleType + ", pickupAt=" + pickupAt + ", pickupWindowDuration="
                + pickupWindowDuration + ", prepTimeDuration=" + prepTimeDuration + ", note=" + note
                + ", placedAt=" + placedAt + ", acceptedAt=" + acceptedAt + ", rejectedAt="
                + rejectedAt + ", readyAt=" + readyAt + ", expiredAt=" + expiredAt + ", pickedUpAt="
                + pickedUpAt + ", canceledAt=" + canceledAt + ", cancelReason=" + cancelReason
                + ", isCurbsidePickup=" + isCurbsidePickup + ", curbsidePickupDetails="
                + curbsidePickupDetails + "]";
    }

    /**
     * Builds a new {@link OrderFulfillmentPickupDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderFulfillmentPickupDetails.Builder} object
     */
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
                .cancelReason(getCancelReason())
                .isCurbsidePickup(getIsCurbsidePickup())
                .curbsidePickupDetails(getCurbsidePickupDetails());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderFulfillmentPickupDetails}.
     */
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
        private Boolean isCurbsidePickup;
        private OrderFulfillmentPickupDetailsCurbsidePickupDetails curbsidePickupDetails;



        /**
         * Setter for recipient.
         * @param  recipient  OrderFulfillmentRecipient value for recipient.
         * @return Builder
         */
        public Builder recipient(OrderFulfillmentRecipient recipient) {
            this.recipient = recipient;
            return this;
        }

        /**
         * Setter for expiresAt.
         * @param  expiresAt  String value for expiresAt.
         * @return Builder
         */
        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        /**
         * Setter for autoCompleteDuration.
         * @param  autoCompleteDuration  String value for autoCompleteDuration.
         * @return Builder
         */
        public Builder autoCompleteDuration(String autoCompleteDuration) {
            this.autoCompleteDuration = autoCompleteDuration;
            return this;
        }

        /**
         * Setter for scheduleType.
         * @param  scheduleType  String value for scheduleType.
         * @return Builder
         */
        public Builder scheduleType(String scheduleType) {
            this.scheduleType = scheduleType;
            return this;
        }

        /**
         * Setter for pickupAt.
         * @param  pickupAt  String value for pickupAt.
         * @return Builder
         */
        public Builder pickupAt(String pickupAt) {
            this.pickupAt = pickupAt;
            return this;
        }

        /**
         * Setter for pickupWindowDuration.
         * @param  pickupWindowDuration  String value for pickupWindowDuration.
         * @return Builder
         */
        public Builder pickupWindowDuration(String pickupWindowDuration) {
            this.pickupWindowDuration = pickupWindowDuration;
            return this;
        }

        /**
         * Setter for prepTimeDuration.
         * @param  prepTimeDuration  String value for prepTimeDuration.
         * @return Builder
         */
        public Builder prepTimeDuration(String prepTimeDuration) {
            this.prepTimeDuration = prepTimeDuration;
            return this;
        }

        /**
         * Setter for note.
         * @param  note  String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = note;
            return this;
        }

        /**
         * Setter for placedAt.
         * @param  placedAt  String value for placedAt.
         * @return Builder
         */
        public Builder placedAt(String placedAt) {
            this.placedAt = placedAt;
            return this;
        }

        /**
         * Setter for acceptedAt.
         * @param  acceptedAt  String value for acceptedAt.
         * @return Builder
         */
        public Builder acceptedAt(String acceptedAt) {
            this.acceptedAt = acceptedAt;
            return this;
        }

        /**
         * Setter for rejectedAt.
         * @param  rejectedAt  String value for rejectedAt.
         * @return Builder
         */
        public Builder rejectedAt(String rejectedAt) {
            this.rejectedAt = rejectedAt;
            return this;
        }

        /**
         * Setter for readyAt.
         * @param  readyAt  String value for readyAt.
         * @return Builder
         */
        public Builder readyAt(String readyAt) {
            this.readyAt = readyAt;
            return this;
        }

        /**
         * Setter for expiredAt.
         * @param  expiredAt  String value for expiredAt.
         * @return Builder
         */
        public Builder expiredAt(String expiredAt) {
            this.expiredAt = expiredAt;
            return this;
        }

        /**
         * Setter for pickedUpAt.
         * @param  pickedUpAt  String value for pickedUpAt.
         * @return Builder
         */
        public Builder pickedUpAt(String pickedUpAt) {
            this.pickedUpAt = pickedUpAt;
            return this;
        }

        /**
         * Setter for canceledAt.
         * @param  canceledAt  String value for canceledAt.
         * @return Builder
         */
        public Builder canceledAt(String canceledAt) {
            this.canceledAt = canceledAt;
            return this;
        }

        /**
         * Setter for cancelReason.
         * @param  cancelReason  String value for cancelReason.
         * @return Builder
         */
        public Builder cancelReason(String cancelReason) {
            this.cancelReason = cancelReason;
            return this;
        }

        /**
         * Setter for isCurbsidePickup.
         * @param  isCurbsidePickup  Boolean value for isCurbsidePickup.
         * @return Builder
         */
        public Builder isCurbsidePickup(Boolean isCurbsidePickup) {
            this.isCurbsidePickup = isCurbsidePickup;
            return this;
        }

        /**
         * Setter for curbsidePickupDetails.
         * @param  curbsidePickupDetails  OrderFulfillmentPickupDetailsCurbsidePickupDetails value
         *         for curbsidePickupDetails.
         * @return Builder
         */
        public Builder curbsidePickupDetails(
                OrderFulfillmentPickupDetailsCurbsidePickupDetails curbsidePickupDetails) {
            this.curbsidePickupDetails = curbsidePickupDetails;
            return this;
        }

        /**
         * Builds a new {@link OrderFulfillmentPickupDetails} object using the set fields.
         * @return {@link OrderFulfillmentPickupDetails}
         */
        public OrderFulfillmentPickupDetails build() {
            return new OrderFulfillmentPickupDetails(recipient, expiresAt, autoCompleteDuration,
                    scheduleType, pickupAt, pickupWindowDuration, prepTimeDuration, note, placedAt,
                    acceptedAt, rejectedAt, readyAt, expiredAt, pickedUpAt, canceledAt,
                    cancelReason, isCurbsidePickup, curbsidePickupDetails);
        }
    }
}
