
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OrderFulfillmentShipmentDetails type.
 */
public class OrderFulfillmentShipmentDetails {
    private final OrderFulfillmentRecipient recipient;
    private final String carrier;
    private final String shippingNote;
    private final String shippingType;
    private final String trackingNumber;
    private final String trackingUrl;
    private final String placedAt;
    private final String inProgressAt;
    private final String packagedAt;
    private final String expectedShippedAt;
    private final String shippedAt;
    private final String canceledAt;
    private final String cancelReason;
    private final String failedAt;
    private final String failureReason;

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
     * Contains information about the recipient of a fulfillment.
     * @return Returns the OrderFulfillmentRecipient
     */
    @JsonGetter("recipient")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public OrderFulfillmentRecipient getRecipient() {
        return recipient;
    }

    /**
     * Getter for Carrier.
     * The shipping carrier being used to ship this fulfillment (such as UPS, FedEx, or USPS).
     * @return Returns the String
     */
    @JsonGetter("carrier")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCarrier() {
        return carrier;
    }

    /**
     * Getter for ShippingNote.
     * A note with additional information for the shipping carrier.
     * @return Returns the String
     */
    @JsonGetter("shipping_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getShippingNote() {
        return shippingNote;
    }

    /**
     * Getter for ShippingType.
     * A description of the type of shipping product purchased from the carrier (such as First
     * Class, Priority, or Express).
     * @return Returns the String
     */
    @JsonGetter("shipping_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getShippingType() {
        return shippingType;
    }

    /**
     * Getter for TrackingNumber.
     * The reference number provided by the carrier to track the shipment's progress.
     * @return Returns the String
     */
    @JsonGetter("tracking_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Getter for TrackingUrl.
     * A link to the tracking webpage on the carrier's website.
     * @return Returns the String
     */
    @JsonGetter("tracking_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTrackingUrl() {
        return trackingUrl;
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
     * Getter for ExpectedShippedAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating when the shipment is expected to be delivered to the shipping carrier. The
     * timestamp must be in RFC 3339 format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("expected_shipped_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getExpectedShippedAt() {
        return expectedShippedAt;
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
     * Getter for CanceledAt.
     * The [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * indicating the shipment was canceled. The timestamp must be in RFC 3339 format (for example,
     * "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("canceled_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCanceledAt() {
        return canceledAt;
    }

    /**
     * Getter for CancelReason.
     * A description of why the shipment was canceled.
     * @return Returns the String
     */
    @JsonGetter("cancel_reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCancelReason() {
        return cancelReason;
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
     * Getter for FailureReason.
     * A description of why the shipment failed to be completed.
     * @return Returns the String
     */
    @JsonGetter("failure_reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFailureReason() {
        return failureReason;
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
                .carrier(getCarrier())
                .shippingNote(getShippingNote())
                .shippingType(getShippingType())
                .trackingNumber(getTrackingNumber())
                .trackingUrl(getTrackingUrl())
                .placedAt(getPlacedAt())
                .inProgressAt(getInProgressAt())
                .packagedAt(getPackagedAt())
                .expectedShippedAt(getExpectedShippedAt())
                .shippedAt(getShippedAt())
                .canceledAt(getCanceledAt())
                .cancelReason(getCancelReason())
                .failedAt(getFailedAt())
                .failureReason(getFailureReason());
        return builder;
    }

    /**
     * Class to build instances of {@link OrderFulfillmentShipmentDetails}.
     */
    public static class Builder {
        private OrderFulfillmentRecipient recipient;
        private String carrier;
        private String shippingNote;
        private String shippingType;
        private String trackingNumber;
        private String trackingUrl;
        private String placedAt;
        private String inProgressAt;
        private String packagedAt;
        private String expectedShippedAt;
        private String shippedAt;
        private String canceledAt;
        private String cancelReason;
        private String failedAt;
        private String failureReason;



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
            this.carrier = carrier;
            return this;
        }

        /**
         * Setter for shippingNote.
         * @param  shippingNote  String value for shippingNote.
         * @return Builder
         */
        public Builder shippingNote(String shippingNote) {
            this.shippingNote = shippingNote;
            return this;
        }

        /**
         * Setter for shippingType.
         * @param  shippingType  String value for shippingType.
         * @return Builder
         */
        public Builder shippingType(String shippingType) {
            this.shippingType = shippingType;
            return this;
        }

        /**
         * Setter for trackingNumber.
         * @param  trackingNumber  String value for trackingNumber.
         * @return Builder
         */
        public Builder trackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
            return this;
        }

        /**
         * Setter for trackingUrl.
         * @param  trackingUrl  String value for trackingUrl.
         * @return Builder
         */
        public Builder trackingUrl(String trackingUrl) {
            this.trackingUrl = trackingUrl;
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
            this.expectedShippedAt = expectedShippedAt;
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
            this.failureReason = failureReason;
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
