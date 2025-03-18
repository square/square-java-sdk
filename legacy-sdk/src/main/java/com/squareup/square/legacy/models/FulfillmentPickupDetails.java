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
 * This is a model class for FulfillmentPickupDetails type.
 */
public class FulfillmentPickupDetails {
    private final FulfillmentRecipient recipient;
    private final OptionalNullable<String> expiresAt;
    private final OptionalNullable<String> autoCompleteDuration;
    private final String scheduleType;
    private final OptionalNullable<String> pickupAt;
    private final OptionalNullable<String> pickupWindowDuration;
    private final OptionalNullable<String> prepTimeDuration;
    private final OptionalNullable<String> note;
    private final String placedAt;
    private final String acceptedAt;
    private final String rejectedAt;
    private final String readyAt;
    private final String expiredAt;
    private final String pickedUpAt;
    private final String canceledAt;
    private final OptionalNullable<String> cancelReason;
    private final OptionalNullable<Boolean> isCurbsidePickup;
    private final FulfillmentPickupDetailsCurbsidePickupDetails curbsidePickupDetails;

    /**
     * Initialization constructor.
     * @param  recipient  FulfillmentRecipient value for recipient.
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
     * @param  curbsidePickupDetails  FulfillmentPickupDetailsCurbsidePickupDetails value for
     *         curbsidePickupDetails.
     */
    @JsonCreator
    public FulfillmentPickupDetails(
            @JsonProperty("recipient") FulfillmentRecipient recipient,
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
            @JsonProperty("curbside_pickup_details")
                    FulfillmentPickupDetailsCurbsidePickupDetails curbsidePickupDetails) {
        this.recipient = recipient;
        this.expiresAt = OptionalNullable.of(expiresAt);
        this.autoCompleteDuration = OptionalNullable.of(autoCompleteDuration);
        this.scheduleType = scheduleType;
        this.pickupAt = OptionalNullable.of(pickupAt);
        this.pickupWindowDuration = OptionalNullable.of(pickupWindowDuration);
        this.prepTimeDuration = OptionalNullable.of(prepTimeDuration);
        this.note = OptionalNullable.of(note);
        this.placedAt = placedAt;
        this.acceptedAt = acceptedAt;
        this.rejectedAt = rejectedAt;
        this.readyAt = readyAt;
        this.expiredAt = expiredAt;
        this.pickedUpAt = pickedUpAt;
        this.canceledAt = canceledAt;
        this.cancelReason = OptionalNullable.of(cancelReason);
        this.isCurbsidePickup = OptionalNullable.of(isCurbsidePickup);
        this.curbsidePickupDetails = curbsidePickupDetails;
    }

    /**
     * Initialization constructor.
     * @param  recipient  FulfillmentRecipient value for recipient.
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
     * @param  curbsidePickupDetails  FulfillmentPickupDetailsCurbsidePickupDetails value for
     *         curbsidePickupDetails.
     */
    protected FulfillmentPickupDetails(
            FulfillmentRecipient recipient,
            OptionalNullable<String> expiresAt,
            OptionalNullable<String> autoCompleteDuration,
            String scheduleType,
            OptionalNullable<String> pickupAt,
            OptionalNullable<String> pickupWindowDuration,
            OptionalNullable<String> prepTimeDuration,
            OptionalNullable<String> note,
            String placedAt,
            String acceptedAt,
            String rejectedAt,
            String readyAt,
            String expiredAt,
            String pickedUpAt,
            String canceledAt,
            OptionalNullable<String> cancelReason,
            OptionalNullable<Boolean> isCurbsidePickup,
            FulfillmentPickupDetailsCurbsidePickupDetails curbsidePickupDetails) {
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
     * Information about the fulfillment recipient.
     * @return Returns the FulfillmentRecipient
     */
    @JsonGetter("recipient")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public FulfillmentRecipient getRecipient() {
        return recipient;
    }

    /**
     * Internal Getter for ExpiresAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when this fulfillment expires if it is not marked in progress. The timestamp must
     * be in RFC 3339 format (for example, "2016-09-04T23:59:33.123Z"). The expiration time can only
     * be set up to 7 days in the future. If `expires_at` is not set, any new payments attached to
     * the order are automatically completed.
     * @return Returns the Internal String
     */
    @JsonGetter("expires_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetExpiresAt() {
        return this.expiresAt;
    }

    /**
     * Getter for ExpiresAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when this fulfillment expires if it is not marked in progress. The timestamp must
     * be in RFC 3339 format (for example, "2016-09-04T23:59:33.123Z"). The expiration time can only
     * be set up to 7 days in the future. If `expires_at` is not set, any new payments attached to
     * the order are automatically completed.
     * @return Returns the String
     */
    @JsonIgnore
    public String getExpiresAt() {
        return OptionalNullable.getFrom(expiresAt);
    }

    /**
     * Internal Getter for AutoCompleteDuration.
     * The duration of time after which an in progress pickup fulfillment is automatically moved to
     * the `COMPLETED` state. The duration must be in RFC 3339 format (for example, "P1W3D"). If not
     * set, this pickup fulfillment remains in progress until it is canceled or completed.
     * @return Returns the Internal String
     */
    @JsonGetter("auto_complete_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetAutoCompleteDuration() {
        return this.autoCompleteDuration;
    }

    /**
     * Getter for AutoCompleteDuration.
     * The duration of time after which an in progress pickup fulfillment is automatically moved to
     * the `COMPLETED` state. The duration must be in RFC 3339 format (for example, "P1W3D"). If not
     * set, this pickup fulfillment remains in progress until it is canceled or completed.
     * @return Returns the String
     */
    @JsonIgnore
    public String getAutoCompleteDuration() {
        return OptionalNullable.getFrom(autoCompleteDuration);
    }

    /**
     * Getter for ScheduleType.
     * The schedule type of the pickup fulfillment.
     * @return Returns the String
     */
    @JsonGetter("schedule_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getScheduleType() {
        return scheduleType;
    }

    /**
     * Internal Getter for PickupAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) that
     * represents the start of the pickup window. Must be in RFC 3339 timestamp format, e.g.,
     * "2016-09-04T23:59:33.123Z". For fulfillments with the schedule type `ASAP`, this is
     * automatically set to the current time plus the expected duration to prepare the fulfillment.
     * @return Returns the Internal String
     */
    @JsonGetter("pickup_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPickupAt() {
        return this.pickupAt;
    }

    /**
     * Getter for PickupAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) that
     * represents the start of the pickup window. Must be in RFC 3339 timestamp format, e.g.,
     * "2016-09-04T23:59:33.123Z". For fulfillments with the schedule type `ASAP`, this is
     * automatically set to the current time plus the expected duration to prepare the fulfillment.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPickupAt() {
        return OptionalNullable.getFrom(pickupAt);
    }

    /**
     * Internal Getter for PickupWindowDuration.
     * The window of time in which the order should be picked up after the `pickup_at` timestamp.
     * Must be in RFC 3339 duration format, e.g., "P1W3D". Can be used as an informational guideline
     * for merchants.
     * @return Returns the Internal String
     */
    @JsonGetter("pickup_window_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPickupWindowDuration() {
        return this.pickupWindowDuration;
    }

    /**
     * Getter for PickupWindowDuration.
     * The window of time in which the order should be picked up after the `pickup_at` timestamp.
     * Must be in RFC 3339 duration format, e.g., "P1W3D". Can be used as an informational guideline
     * for merchants.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPickupWindowDuration() {
        return OptionalNullable.getFrom(pickupWindowDuration);
    }

    /**
     * Internal Getter for PrepTimeDuration.
     * The duration of time it takes to prepare this fulfillment. The duration must be in RFC 3339
     * format (for example, "P1W3D").
     * @return Returns the Internal String
     */
    @JsonGetter("prep_time_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPrepTimeDuration() {
        return this.prepTimeDuration;
    }

    /**
     * Getter for PrepTimeDuration.
     * The duration of time it takes to prepare this fulfillment. The duration must be in RFC 3339
     * format (for example, "P1W3D").
     * @return Returns the String
     */
    @JsonIgnore
    public String getPrepTimeDuration() {
        return OptionalNullable.getFrom(prepTimeDuration);
    }

    /**
     * Internal Getter for Note.
     * A note to provide additional instructions about the pickup fulfillment displayed in the
     * Square Point of Sale application and set by the API.
     * @return Returns the Internal String
     */
    @JsonGetter("note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetNote() {
        return this.note;
    }

    /**
     * Getter for Note.
     * A note to provide additional instructions about the pickup fulfillment displayed in the
     * Square Point of Sale application and set by the API.
     * @return Returns the String
     */
    @JsonIgnore
    public String getNote() {
        return OptionalNullable.getFrom(note);
    }

    /**
     * Getter for PlacedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was placed. The timestamp must be in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("placed_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPlacedAt() {
        return placedAt;
    }

    /**
     * Getter for AcceptedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was marked in progress. The timestamp must be in RFC 3339
     * format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("accepted_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAcceptedAt() {
        return acceptedAt;
    }

    /**
     * Getter for RejectedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was rejected. The timestamp must be in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("rejected_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRejectedAt() {
        return rejectedAt;
    }

    /**
     * Getter for ReadyAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment is marked as ready for pickup. The timestamp must be in RFC
     * 3339 format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("ready_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getReadyAt() {
        return readyAt;
    }

    /**
     * Getter for ExpiredAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment expired. The timestamp must be in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("expired_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getExpiredAt() {
        return expiredAt;
    }

    /**
     * Getter for PickedUpAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was picked up by the recipient. The timestamp must be in RFC
     * 3339 format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("picked_up_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPickedUpAt() {
        return pickedUpAt;
    }

    /**
     * Getter for CanceledAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the fulfillment was canceled. The timestamp must be in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("canceled_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCanceledAt() {
        return canceledAt;
    }

    /**
     * Internal Getter for CancelReason.
     * A description of why the pickup was canceled. The maximum length: 100 characters.
     * @return Returns the Internal String
     */
    @JsonGetter("cancel_reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCancelReason() {
        return this.cancelReason;
    }

    /**
     * Getter for CancelReason.
     * A description of why the pickup was canceled. The maximum length: 100 characters.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCancelReason() {
        return OptionalNullable.getFrom(cancelReason);
    }

    /**
     * Internal Getter for IsCurbsidePickup.
     * If set to `true`, indicates that this pickup order is for curbside pickup, not in-store
     * pickup.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("is_curbside_pickup")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetIsCurbsidePickup() {
        return this.isCurbsidePickup;
    }

    /**
     * Getter for IsCurbsidePickup.
     * If set to `true`, indicates that this pickup order is for curbside pickup, not in-store
     * pickup.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getIsCurbsidePickup() {
        return OptionalNullable.getFrom(isCurbsidePickup);
    }

    /**
     * Getter for CurbsidePickupDetails.
     * Specific details for curbside pickup.
     * @return Returns the FulfillmentPickupDetailsCurbsidePickupDetails
     */
    @JsonGetter("curbside_pickup_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public FulfillmentPickupDetailsCurbsidePickupDetails getCurbsidePickupDetails() {
        return curbsidePickupDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                recipient,
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
                cancelReason,
                isCurbsidePickup,
                curbsidePickupDetails);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FulfillmentPickupDetails)) {
            return false;
        }
        FulfillmentPickupDetails other = (FulfillmentPickupDetails) obj;
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
     * Converts this FulfillmentPickupDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "FulfillmentPickupDetails [" + "recipient=" + recipient + ", expiresAt=" + expiresAt
                + ", autoCompleteDuration=" + autoCompleteDuration + ", scheduleType="
                + scheduleType + ", pickupAt=" + pickupAt + ", pickupWindowDuration="
                + pickupWindowDuration + ", prepTimeDuration=" + prepTimeDuration + ", note=" + note
                + ", placedAt=" + placedAt + ", acceptedAt=" + acceptedAt + ", rejectedAt="
                + rejectedAt + ", readyAt=" + readyAt + ", expiredAt=" + expiredAt + ", pickedUpAt="
                + pickedUpAt + ", canceledAt=" + canceledAt + ", cancelReason=" + cancelReason
                + ", isCurbsidePickup=" + isCurbsidePickup + ", curbsidePickupDetails="
                + curbsidePickupDetails + "]";
    }

    /**
     * Builds a new {@link FulfillmentPickupDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link FulfillmentPickupDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .recipient(getRecipient())
                .scheduleType(getScheduleType())
                .placedAt(getPlacedAt())
                .acceptedAt(getAcceptedAt())
                .rejectedAt(getRejectedAt())
                .readyAt(getReadyAt())
                .expiredAt(getExpiredAt())
                .pickedUpAt(getPickedUpAt())
                .canceledAt(getCanceledAt())
                .curbsidePickupDetails(getCurbsidePickupDetails());
        builder.expiresAt = internalGetExpiresAt();
        builder.autoCompleteDuration = internalGetAutoCompleteDuration();
        builder.pickupAt = internalGetPickupAt();
        builder.pickupWindowDuration = internalGetPickupWindowDuration();
        builder.prepTimeDuration = internalGetPrepTimeDuration();
        builder.note = internalGetNote();
        builder.cancelReason = internalGetCancelReason();
        builder.isCurbsidePickup = internalGetIsCurbsidePickup();
        return builder;
    }

    /**
     * Class to build instances of {@link FulfillmentPickupDetails}.
     */
    public static class Builder {
        private FulfillmentRecipient recipient;
        private OptionalNullable<String> expiresAt;
        private OptionalNullable<String> autoCompleteDuration;
        private String scheduleType;
        private OptionalNullable<String> pickupAt;
        private OptionalNullable<String> pickupWindowDuration;
        private OptionalNullable<String> prepTimeDuration;
        private OptionalNullable<String> note;
        private String placedAt;
        private String acceptedAt;
        private String rejectedAt;
        private String readyAt;
        private String expiredAt;
        private String pickedUpAt;
        private String canceledAt;
        private OptionalNullable<String> cancelReason;
        private OptionalNullable<Boolean> isCurbsidePickup;
        private FulfillmentPickupDetailsCurbsidePickupDetails curbsidePickupDetails;

        /**
         * Setter for recipient.
         * @param  recipient  FulfillmentRecipient value for recipient.
         * @return Builder
         */
        public Builder recipient(FulfillmentRecipient recipient) {
            this.recipient = recipient;
            return this;
        }

        /**
         * Setter for expiresAt.
         * @param  expiresAt  String value for expiresAt.
         * @return Builder
         */
        public Builder expiresAt(String expiresAt) {
            this.expiresAt = OptionalNullable.of(expiresAt);
            return this;
        }

        /**
         * UnSetter for expiresAt.
         * @return Builder
         */
        public Builder unsetExpiresAt() {
            expiresAt = null;
            return this;
        }

        /**
         * Setter for autoCompleteDuration.
         * @param  autoCompleteDuration  String value for autoCompleteDuration.
         * @return Builder
         */
        public Builder autoCompleteDuration(String autoCompleteDuration) {
            this.autoCompleteDuration = OptionalNullable.of(autoCompleteDuration);
            return this;
        }

        /**
         * UnSetter for autoCompleteDuration.
         * @return Builder
         */
        public Builder unsetAutoCompleteDuration() {
            autoCompleteDuration = null;
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
            this.pickupAt = OptionalNullable.of(pickupAt);
            return this;
        }

        /**
         * UnSetter for pickupAt.
         * @return Builder
         */
        public Builder unsetPickupAt() {
            pickupAt = null;
            return this;
        }

        /**
         * Setter for pickupWindowDuration.
         * @param  pickupWindowDuration  String value for pickupWindowDuration.
         * @return Builder
         */
        public Builder pickupWindowDuration(String pickupWindowDuration) {
            this.pickupWindowDuration = OptionalNullable.of(pickupWindowDuration);
            return this;
        }

        /**
         * UnSetter for pickupWindowDuration.
         * @return Builder
         */
        public Builder unsetPickupWindowDuration() {
            pickupWindowDuration = null;
            return this;
        }

        /**
         * Setter for prepTimeDuration.
         * @param  prepTimeDuration  String value for prepTimeDuration.
         * @return Builder
         */
        public Builder prepTimeDuration(String prepTimeDuration) {
            this.prepTimeDuration = OptionalNullable.of(prepTimeDuration);
            return this;
        }

        /**
         * UnSetter for prepTimeDuration.
         * @return Builder
         */
        public Builder unsetPrepTimeDuration() {
            prepTimeDuration = null;
            return this;
        }

        /**
         * Setter for note.
         * @param  note  String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = OptionalNullable.of(note);
            return this;
        }

        /**
         * UnSetter for note.
         * @return Builder
         */
        public Builder unsetNote() {
            note = null;
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
            this.cancelReason = OptionalNullable.of(cancelReason);
            return this;
        }

        /**
         * UnSetter for cancelReason.
         * @return Builder
         */
        public Builder unsetCancelReason() {
            cancelReason = null;
            return this;
        }

        /**
         * Setter for isCurbsidePickup.
         * @param  isCurbsidePickup  Boolean value for isCurbsidePickup.
         * @return Builder
         */
        public Builder isCurbsidePickup(Boolean isCurbsidePickup) {
            this.isCurbsidePickup = OptionalNullable.of(isCurbsidePickup);
            return this;
        }

        /**
         * UnSetter for isCurbsidePickup.
         * @return Builder
         */
        public Builder unsetIsCurbsidePickup() {
            isCurbsidePickup = null;
            return this;
        }

        /**
         * Setter for curbsidePickupDetails.
         * @param  curbsidePickupDetails  FulfillmentPickupDetailsCurbsidePickupDetails value for
         *         curbsidePickupDetails.
         * @return Builder
         */
        public Builder curbsidePickupDetails(FulfillmentPickupDetailsCurbsidePickupDetails curbsidePickupDetails) {
            this.curbsidePickupDetails = curbsidePickupDetails;
            return this;
        }

        /**
         * Builds a new {@link FulfillmentPickupDetails} object using the set fields.
         * @return {@link FulfillmentPickupDetails}
         */
        public FulfillmentPickupDetails build() {
            return new FulfillmentPickupDetails(
                    recipient,
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
                    cancelReason,
                    isCurbsidePickup,
                    curbsidePickupDetails);
        }
    }
}
