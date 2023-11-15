
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for OrderFulfillmentShipmentDetails type.
 */
public class OrderFulfillmentShipmentDetails {
    private final OrderFulfillmentRecipient recipient;
    private final OptionalNullable<String> carrier;
    private final OptionalNullable<String> shippingNote;
    private final OptionalNullable<String> shippingType;
    private final OptionalNullable<String> trackingNumber;
    private final OptionalNullable<String> trackingUrl;
    private final String placedAt;
    private final String inProgressAt;
    private final String packagedAt;
    private final OptionalNullable<String> expectedShippedAt;
    private final String shippedAt;
    private final OptionalNullable<String> canceledAt;
    private final OptionalNullable<String> cancelReason;
    private final String failedAt;
    private final OptionalNullable<String> failureReason;

    /**
     * Initialization constructor.
     * @param  recipient  OrderFulfillmentRecipient value for recipient.
     * @param  carrier  String value for carrier.
     * @param  shippingNote  String value for shippingNote.
     * @param  shippingType  String value for shippingType.
     * @param  trackingNumber  String value for trackingNumber.
     * @param  trackingUrl  String value for trackingUrl.
     * @param  placedAt  String value for placedAt.
     * @param  inProgressAt  String value for inProgressAt.
     * @param  packagedAt  String value for packagedAt.
     * @param  expectedShippedAt  String value for expectedShippedAt.
     * @param  shippedAt  String value for shippedAt.
     * @param  canceledAt  String value for canceledAt.
     * @param  cancelReason  String value for cancelReason.
     * @param  failedAt  String value for failedAt.
     * @param  failureReason  String value for failureReason.
     */
    @JsonCreator
    public OrderFulfillmentShipmentDetails(
            @JsonProperty("recipient") OrderFulfillmentRecipient recipient,
            @JsonProperty("carrier") String carrier,
            @JsonProperty("shipping_note") String shippingNote,
            @JsonProperty("shipping_type") String shippingType,
            @JsonProperty("tracking_number") String trackingNumber,
            @JsonProperty("tracking_url") String trackingUrl,
            @JsonProperty("placed_at") String placedAt,
            @JsonProperty("in_progress_at") String inProgressAt,
            @JsonProperty("packaged_at") String packagedAt,
            @JsonProperty("expected_shipped_at") String expectedShippedAt,
            @JsonProperty("shipped_at") String shippedAt,
            @JsonProperty("canceled_at") String canceledAt,
            @JsonProperty("cancel_reason") String cancelReason,
            @JsonProperty("failed_at") String failedAt,
            @JsonProperty("failure_reason") String failureReason) {
        this.recipient = recipient;
        this.carrier = OptionalNullable.of(carrier);
        this.shippingNote = OptionalNullable.of(shippingNote);
        this.shippingType = OptionalNullable.of(shippingType);
        this.trackingNumber = OptionalNullable.of(trackingNumber);
        this.trackingUrl = OptionalNullable.of(trackingUrl);
        this.placedAt = placedAt;
        this.inProgressAt = inProgressAt;
        this.packagedAt = packagedAt;
        this.expectedShippedAt = OptionalNullable.of(expectedShippedAt);
        this.shippedAt = shippedAt;
        this.canceledAt = OptionalNullable.of(canceledAt);
        this.cancelReason = OptionalNullable.of(cancelReason);
        this.failedAt = failedAt;
        this.failureReason = OptionalNullable.of(failureReason);
    }

    /**
     * Initialization constructor.
     * @param  recipient  OrderFulfillmentRecipient value for recipient.
     * @param  carrier  String value for carrier.
     * @param  shippingNote  String value for shippingNote.
     * @param  shippingType  String value for shippingType.
     * @param  trackingNumber  String value for trackingNumber.
     * @param  trackingUrl  String value for trackingUrl.
     * @param  placedAt  String value for placedAt.
     * @param  inProgressAt  String value for inProgressAt.
     * @param  packagedAt  String value for packagedAt.
     * @param  expectedShippedAt  String value for expectedShippedAt.
     * @param  shippedAt  String value for shippedAt.
     * @param  canceledAt  String value for canceledAt.
     * @param  cancelReason  String value for cancelReason.
     * @param  failedAt  String value for failedAt.
     * @param  failureReason  String value for failureReason.
     */

    protected OrderFulfillmentShipmentDetails(OrderFulfillmentRecipient recipient,
            OptionalNullable<String> carrier, OptionalNullable<String> shippingNote,
            OptionalNullable<String> shippingType, OptionalNullable<String> trackingNumber,
            OptionalNullable<String> trackingUrl, String placedAt, String inProgressAt,
            String packagedAt, OptionalNullable<String> expectedShippedAt, String shippedAt,
            OptionalNullable<String> canceledAt, OptionalNullable<String> cancelReason,
            String failedAt, OptionalNullable<String> failureReason) {
        this.recipient = recipient;
        this.carrier = carrier;
        this.shippingNote = shippingNote;
        this.shippingType = shippingType;
        this.trackingNumber = trackingNumber;
        this.trackingUrl = trackingUrl;
        this.placedAt = placedAt;
        this.inProgressAt = inProgressAt;
        this.packagedAt = packagedAt;
        this.expectedShippedAt = expectedShippedAt;
        this.shippedAt = shippedAt;
        this.canceledAt = canceledAt;
        this.cancelReason = cancelReason;
        this.failedAt = failedAt;
        this.failureReason = failureReason;
    }

    /**
     * Getter for Recipient.
     * Information about the fulfillment recipient.
     * @return Returns the OrderFulfillmentRecipient
     */
    @JsonGetter("recipient")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderFulfillmentRecipient getRecipient() {
        return recipient;
    }

    /**
     * Internal Getter for Carrier.
     * The shipping carrier being used to ship this fulfillment (such as UPS, FedEx, or USPS).
     * @return Returns the Internal String
     */
    @JsonGetter("carrier")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCarrier() {
        return this.carrier;
    }

    /**
     * Getter for Carrier.
     * The shipping carrier being used to ship this fulfillment (such as UPS, FedEx, or USPS).
     * @return Returns the String
     */
    @JsonIgnore
    public String getCarrier() {
        return OptionalNullable.getFrom(carrier);
    }

    /**
     * Internal Getter for ShippingNote.
     * A note with additional information for the shipping carrier.
     * @return Returns the Internal String
     */
    @JsonGetter("shipping_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetShippingNote() {
        return this.shippingNote;
    }

    /**
     * Getter for ShippingNote.
     * A note with additional information for the shipping carrier.
     * @return Returns the String
     */
    @JsonIgnore
    public String getShippingNote() {
        return OptionalNullable.getFrom(shippingNote);
    }

    /**
     * Internal Getter for ShippingType.
     * A description of the type of shipping product purchased from the carrier (such as First
     * Class, Priority, or Express).
     * @return Returns the Internal String
     */
    @JsonGetter("shipping_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetShippingType() {
        return this.shippingType;
    }

    /**
     * Getter for ShippingType.
     * A description of the type of shipping product purchased from the carrier (such as First
     * Class, Priority, or Express).
     * @return Returns the String
     */
    @JsonIgnore
    public String getShippingType() {
        return OptionalNullable.getFrom(shippingType);
    }

    /**
     * Internal Getter for TrackingNumber.
     * The reference number provided by the carrier to track the shipment's progress.
     * @return Returns the Internal String
     */
    @JsonGetter("tracking_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTrackingNumber() {
        return this.trackingNumber;
    }

    /**
     * Getter for TrackingNumber.
     * The reference number provided by the carrier to track the shipment's progress.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTrackingNumber() {
        return OptionalNullable.getFrom(trackingNumber);
    }

    /**
     * Internal Getter for TrackingUrl.
     * A link to the tracking webpage on the carrier's website.
     * @return Returns the Internal String
     */
    @JsonGetter("tracking_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTrackingUrl() {
        return this.trackingUrl;
    }

    /**
     * Getter for TrackingUrl.
     * A link to the tracking webpage on the carrier's website.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTrackingUrl() {
        return OptionalNullable.getFrom(trackingUrl);
    }

    /**
     * Getter for PlacedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the shipment was requested. The timestamp must be in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("placed_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPlacedAt() {
        return placedAt;
    }

    /**
     * Getter for InProgressAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when this fulfillment was moved to the `RESERVED` state, which indicates that
     * preparation of this shipment has begun. The timestamp must be in RFC 3339 format (for
     * example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("in_progress_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getInProgressAt() {
        return inProgressAt;
    }

    /**
     * Getter for PackagedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when this fulfillment was moved to the `PREPARED` state, which indicates that the
     * fulfillment is packaged. The timestamp must be in RFC 3339 format (for example,
     * "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("packaged_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPackagedAt() {
        return packagedAt;
    }

    /**
     * Internal Getter for ExpectedShippedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the shipment is expected to be delivered to the shipping carrier. The
     * timestamp must be in RFC 3339 format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the Internal String
     */
    @JsonGetter("expected_shipped_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetExpectedShippedAt() {
        return this.expectedShippedAt;
    }

    /**
     * Getter for ExpectedShippedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the shipment is expected to be delivered to the shipping carrier. The
     * timestamp must be in RFC 3339 format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonIgnore
    public String getExpectedShippedAt() {
        return OptionalNullable.getFrom(expectedShippedAt);
    }

    /**
     * Getter for ShippedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when this fulfillment was moved to the `COMPLETED` state, which indicates that the
     * fulfillment has been given to the shipping carrier. The timestamp must be in RFC 3339 format
     * (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("shipped_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getShippedAt() {
        return shippedAt;
    }

    /**
     * Internal Getter for CanceledAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating the shipment was canceled. The timestamp must be in RFC 3339 format (for example,
     * "2016-09-04T23:59:33.123Z").
     * @return Returns the Internal String
     */
    @JsonGetter("canceled_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCanceledAt() {
        return this.canceledAt;
    }

    /**
     * Getter for CanceledAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating the shipment was canceled. The timestamp must be in RFC 3339 format (for example,
     * "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonIgnore
    public String getCanceledAt() {
        return OptionalNullable.getFrom(canceledAt);
    }

    /**
     * Internal Getter for CancelReason.
     * A description of why the shipment was canceled.
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
     * A description of why the shipment was canceled.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCancelReason() {
        return OptionalNullable.getFrom(cancelReason);
    }

    /**
     * Getter for FailedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the shipment failed to be completed. The timestamp must be in RFC 3339 format
     * (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("failed_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFailedAt() {
        return failedAt;
    }

    /**
     * Internal Getter for FailureReason.
     * A description of why the shipment failed to be completed.
     * @return Returns the Internal String
     */
    @JsonGetter("failure_reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetFailureReason() {
        return this.failureReason;
    }

    /**
     * Getter for FailureReason.
     * A description of why the shipment failed to be completed.
     * @return Returns the String
     */
    @JsonIgnore
    public String getFailureReason() {
        return OptionalNullable.getFrom(failureReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipient, carrier, shippingNote, shippingType, trackingNumber,
                trackingUrl, placedAt, inProgressAt, packagedAt, expectedShippedAt, shippedAt,
                canceledAt, cancelReason, failedAt, failureReason);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderFulfillmentShipmentDetails)) {
            return false;
        }
        OrderFulfillmentShipmentDetails other = (OrderFulfillmentShipmentDetails) obj;
        return Objects.equals(recipient, other.recipient)
            && Objects.equals(carrier, other.carrier)
            && Objects.equals(shippingNote, other.shippingNote)
            && Objects.equals(shippingType, other.shippingType)
            && Objects.equals(trackingNumber, other.trackingNumber)
            && Objects.equals(trackingUrl, other.trackingUrl)
            && Objects.equals(placedAt, other.placedAt)
            && Objects.equals(inProgressAt, other.inProgressAt)
            && Objects.equals(packagedAt, other.packagedAt)
            && Objects.equals(expectedShippedAt, other.expectedShippedAt)
            && Objects.equals(shippedAt, other.shippedAt)
            && Objects.equals(canceledAt, other.canceledAt)
            && Objects.equals(cancelReason, other.cancelReason)
            && Objects.equals(failedAt, other.failedAt)
            && Objects.equals(failureReason, other.failureReason);
    }

    /**
     * Converts this OrderFulfillmentShipmentDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OrderFulfillmentShipmentDetails [" + "recipient=" + recipient + ", carrier="
                + carrier + ", shippingNote=" + shippingNote + ", shippingType=" + shippingType
                + ", trackingNumber=" + trackingNumber + ", trackingUrl=" + trackingUrl
                + ", placedAt=" + placedAt + ", inProgressAt=" + inProgressAt + ", packagedAt="
                + packagedAt + ", expectedShippedAt=" + expectedShippedAt + ", shippedAt="
                + shippedAt + ", canceledAt=" + canceledAt + ", cancelReason=" + cancelReason
                + ", failedAt=" + failedAt + ", failureReason=" + failureReason + "]";
    }

    /**
     * Builds a new {@link OrderFulfillmentShipmentDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderFulfillmentShipmentDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .recipient(getRecipient())
                .placedAt(getPlacedAt())
                .inProgressAt(getInProgressAt())
                .packagedAt(getPackagedAt())
                .shippedAt(getShippedAt())
                .failedAt(getFailedAt());
        builder.carrier = internalGetCarrier();
        builder.shippingNote = internalGetShippingNote();
        builder.shippingType = internalGetShippingType();
        builder.trackingNumber = internalGetTrackingNumber();
        builder.trackingUrl = internalGetTrackingUrl();
        builder.expectedShippedAt = internalGetExpectedShippedAt();
        builder.canceledAt = internalGetCanceledAt();
        builder.cancelReason = internalGetCancelReason();
        builder.failureReason = internalGetFailureReason();
        return builder;
    }

    /**
     * Class to build instances of {@link OrderFulfillmentShipmentDetails}.
     */
    public static class Builder {
        private OrderFulfillmentRecipient recipient;
        private OptionalNullable<String> carrier;
        private OptionalNullable<String> shippingNote;
        private OptionalNullable<String> shippingType;
        private OptionalNullable<String> trackingNumber;
        private OptionalNullable<String> trackingUrl;
        private String placedAt;
        private String inProgressAt;
        private String packagedAt;
        private OptionalNullable<String> expectedShippedAt;
        private String shippedAt;
        private OptionalNullable<String> canceledAt;
        private OptionalNullable<String> cancelReason;
        private String failedAt;
        private OptionalNullable<String> failureReason;



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
         * Setter for carrier.
         * @param  carrier  String value for carrier.
         * @return Builder
         */
        public Builder carrier(String carrier) {
            this.carrier = OptionalNullable.of(carrier);
            return this;
        }

        /**
         * UnSetter for carrier.
         * @return Builder
         */
        public Builder unsetCarrier() {
            carrier = null;
            return this;
        }

        /**
         * Setter for shippingNote.
         * @param  shippingNote  String value for shippingNote.
         * @return Builder
         */
        public Builder shippingNote(String shippingNote) {
            this.shippingNote = OptionalNullable.of(shippingNote);
            return this;
        }

        /**
         * UnSetter for shippingNote.
         * @return Builder
         */
        public Builder unsetShippingNote() {
            shippingNote = null;
            return this;
        }

        /**
         * Setter for shippingType.
         * @param  shippingType  String value for shippingType.
         * @return Builder
         */
        public Builder shippingType(String shippingType) {
            this.shippingType = OptionalNullable.of(shippingType);
            return this;
        }

        /**
         * UnSetter for shippingType.
         * @return Builder
         */
        public Builder unsetShippingType() {
            shippingType = null;
            return this;
        }

        /**
         * Setter for trackingNumber.
         * @param  trackingNumber  String value for trackingNumber.
         * @return Builder
         */
        public Builder trackingNumber(String trackingNumber) {
            this.trackingNumber = OptionalNullable.of(trackingNumber);
            return this;
        }

        /**
         * UnSetter for trackingNumber.
         * @return Builder
         */
        public Builder unsetTrackingNumber() {
            trackingNumber = null;
            return this;
        }

        /**
         * Setter for trackingUrl.
         * @param  trackingUrl  String value for trackingUrl.
         * @return Builder
         */
        public Builder trackingUrl(String trackingUrl) {
            this.trackingUrl = OptionalNullable.of(trackingUrl);
            return this;
        }

        /**
         * UnSetter for trackingUrl.
         * @return Builder
         */
        public Builder unsetTrackingUrl() {
            trackingUrl = null;
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
         * Setter for inProgressAt.
         * @param  inProgressAt  String value for inProgressAt.
         * @return Builder
         */
        public Builder inProgressAt(String inProgressAt) {
            this.inProgressAt = inProgressAt;
            return this;
        }

        /**
         * Setter for packagedAt.
         * @param  packagedAt  String value for packagedAt.
         * @return Builder
         */
        public Builder packagedAt(String packagedAt) {
            this.packagedAt = packagedAt;
            return this;
        }

        /**
         * Setter for expectedShippedAt.
         * @param  expectedShippedAt  String value for expectedShippedAt.
         * @return Builder
         */
        public Builder expectedShippedAt(String expectedShippedAt) {
            this.expectedShippedAt = OptionalNullable.of(expectedShippedAt);
            return this;
        }

        /**
         * UnSetter for expectedShippedAt.
         * @return Builder
         */
        public Builder unsetExpectedShippedAt() {
            expectedShippedAt = null;
            return this;
        }

        /**
         * Setter for shippedAt.
         * @param  shippedAt  String value for shippedAt.
         * @return Builder
         */
        public Builder shippedAt(String shippedAt) {
            this.shippedAt = shippedAt;
            return this;
        }

        /**
         * Setter for canceledAt.
         * @param  canceledAt  String value for canceledAt.
         * @return Builder
         */
        public Builder canceledAt(String canceledAt) {
            this.canceledAt = OptionalNullable.of(canceledAt);
            return this;
        }

        /**
         * UnSetter for canceledAt.
         * @return Builder
         */
        public Builder unsetCanceledAt() {
            canceledAt = null;
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
         * Setter for failedAt.
         * @param  failedAt  String value for failedAt.
         * @return Builder
         */
        public Builder failedAt(String failedAt) {
            this.failedAt = failedAt;
            return this;
        }

        /**
         * Setter for failureReason.
         * @param  failureReason  String value for failureReason.
         * @return Builder
         */
        public Builder failureReason(String failureReason) {
            this.failureReason = OptionalNullable.of(failureReason);
            return this;
        }

        /**
         * UnSetter for failureReason.
         * @return Builder
         */
        public Builder unsetFailureReason() {
            failureReason = null;
            return this;
        }

        /**
         * Builds a new {@link OrderFulfillmentShipmentDetails} object using the set fields.
         * @return {@link OrderFulfillmentShipmentDetails}
         */
        public OrderFulfillmentShipmentDetails build() {
            return new OrderFulfillmentShipmentDetails(recipient, carrier, shippingNote,
                    shippingType, trackingNumber, trackingUrl, placedAt, inProgressAt, packagedAt,
                    expectedShippedAt, shippedAt, canceledAt, cancelReason, failedAt,
                    failureReason);
        }
    }
}
