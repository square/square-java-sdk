package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderFulfillmentShipmentDetails type.
 */
public class OrderFulfillmentShipmentDetails {

    /**
     * Initialization constructor.
     * @param recipient
     * @param carrier
     * @param shippingNote
     * @param shippingType
     * @param trackingNumber
     * @param trackingUrl
     * @param placedAt
     * @param inProgressAt
     * @param packagedAt
     * @param expectedShippedAt
     * @param shippedAt
     * @param canceledAt
     * @param cancelReason
     * @param failedAt
     * @param failureReason
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
     * Getter for Recipient.
     * Contains information on the recipient of a fulfillment.
     */
    @JsonGetter("recipient")
    public OrderFulfillmentRecipient getRecipient() {
        return this.recipient;
    }

    /**
     * Getter for Carrier.
     * The shipping carrier being used to ship this fulfillment
     * e.g. UPS, FedEx, USPS, etc.
     */
    @JsonGetter("carrier")
    public String getCarrier() {
        return this.carrier;
    }

    /**
     * Getter for ShippingNote.
     * A note with additional information for the shipping carrier.
     */
    @JsonGetter("shipping_note")
    public String getShippingNote() {
        return this.shippingNote;
    }

    /**
     * Getter for ShippingType.
     * A description of the type of shipping product purchased from the carrier.
     * e.g. First Class, Priority, Express
     */
    @JsonGetter("shipping_type")
    public String getShippingType() {
        return this.shippingType;
    }

    /**
     * Getter for TrackingNumber.
     * The reference number provided by the carrier to track the shipment's progress.
     */
    @JsonGetter("tracking_number")
    public String getTrackingNumber() {
        return this.trackingNumber;
    }

    /**
     * Getter for TrackingUrl.
     * A link to the tracking webpage on the carrier's website.
     */
    @JsonGetter("tracking_url")
    public String getTrackingUrl() {
        return this.trackingUrl;
    }

    /**
     * Getter for PlacedAt.
     * The [timestamp](#workingwithdates) indicating when the shipment was
     * requested. Must be in RFC 3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("placed_at")
    public String getPlacedAt() {
        return this.placedAt;
    }

    /**
     * Getter for InProgressAt.
     * The [timestamp](#workingwithdates) indicating when this fulfillment was
     * moved to the `RESERVED` state. Indicates that preparation of this shipment has begun.
     * Must be in RFC 3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("in_progress_at")
    public String getInProgressAt() {
        return this.inProgressAt;
    }

    /**
     * Getter for PackagedAt.
     * The [timestamp](#workingwithdates) indicating when this fulfillment
     * was moved to the `PREPARED` state. Indicates that the fulfillment is packaged.
     * Must be in RFC 3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("packaged_at")
    public String getPackagedAt() {
        return this.packagedAt;
    }

    /**
     * Getter for ExpectedShippedAt.
     * The [timestamp](#workingwithdates) indicating when the shipment is
     * expected to be delivered to the shipping carrier. Must be in RFC 3339 timestamp
     * format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("expected_shipped_at")
    public String getExpectedShippedAt() {
        return this.expectedShippedAt;
    }

    /**
     * Getter for ShippedAt.
     * The [timestamp](#workingwithdates) indicating when this fulfillment
     * was moved to the `COMPLETED`state. Indicates that the fulfillment has been given
     * to the shipping carrier. Must be in RFC 3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("shipped_at")
    public String getShippedAt() {
        return this.shippedAt;
    }

    /**
     * Getter for CanceledAt.
     * The [timestamp](#workingwithdates) indicating the shipment was canceled.
     * Must be in RFC 3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("canceled_at")
    public String getCanceledAt() {
        return this.canceledAt;
    }

    /**
     * Getter for CancelReason.
     * A description of why the shipment was canceled.
     */
    @JsonGetter("cancel_reason")
    public String getCancelReason() {
        return this.cancelReason;
    }

    /**
     * Getter for FailedAt.
     * The [timestamp](#workingwithdates) indicating when the shipment
     * failed to be completed. Must be in RFC 3339 timestamp format, e.g.,
     * "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("failed_at")
    public String getFailedAt() {
        return this.failedAt;
    }

    /**
     * Getter for FailureReason.
     * A description of why the shipment failed to be completed.
     */
    @JsonGetter("failure_reason")
    public String getFailureReason() {
        return this.failureReason;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(recipient, carrier, shippingNote, shippingType, trackingNumber,
            trackingUrl, placedAt, inProgressAt, packagedAt, expectedShippedAt, shippedAt,
            canceledAt, cancelReason, failedAt, failureReason);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderFulfillmentShipmentDetails)) {
            return false;
        }
        OrderFulfillmentShipmentDetails orderFulfillmentShipmentDetails = (OrderFulfillmentShipmentDetails) obj;
        return Objects.equals(recipient, orderFulfillmentShipmentDetails.recipient) &&
            Objects.equals(carrier, orderFulfillmentShipmentDetails.carrier) &&
            Objects.equals(shippingNote, orderFulfillmentShipmentDetails.shippingNote) &&
            Objects.equals(shippingType, orderFulfillmentShipmentDetails.shippingType) &&
            Objects.equals(trackingNumber, orderFulfillmentShipmentDetails.trackingNumber) &&
            Objects.equals(trackingUrl, orderFulfillmentShipmentDetails.trackingUrl) &&
            Objects.equals(placedAt, orderFulfillmentShipmentDetails.placedAt) &&
            Objects.equals(inProgressAt, orderFulfillmentShipmentDetails.inProgressAt) &&
            Objects.equals(packagedAt, orderFulfillmentShipmentDetails.packagedAt) &&
            Objects.equals(expectedShippedAt, orderFulfillmentShipmentDetails.expectedShippedAt) &&
            Objects.equals(shippedAt, orderFulfillmentShipmentDetails.shippedAt) &&
            Objects.equals(canceledAt, orderFulfillmentShipmentDetails.canceledAt) &&
            Objects.equals(cancelReason, orderFulfillmentShipmentDetails.cancelReason) &&
            Objects.equals(failedAt, orderFulfillmentShipmentDetails.failedAt) &&
            Objects.equals(failureReason, orderFulfillmentShipmentDetails.failureReason);
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
     * Class to build instances of {@link OrderFulfillmentShipmentDetails}
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
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for recipient
         * @param recipient
         * @return Builder
         */
        public Builder recipient(OrderFulfillmentRecipient recipient) {
            this.recipient = recipient;
            return this;
        }
        /**
         * Setter for carrier
         * @param carrier
         * @return Builder
         */
        public Builder carrier(String carrier) {
            this.carrier = carrier;
            return this;
        }
        /**
         * Setter for shippingNote
         * @param shippingNote
         * @return Builder
         */
        public Builder shippingNote(String shippingNote) {
            this.shippingNote = shippingNote;
            return this;
        }
        /**
         * Setter for shippingType
         * @param shippingType
         * @return Builder
         */
        public Builder shippingType(String shippingType) {
            this.shippingType = shippingType;
            return this;
        }
        /**
         * Setter for trackingNumber
         * @param trackingNumber
         * @return Builder
         */
        public Builder trackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
            return this;
        }
        /**
         * Setter for trackingUrl
         * @param trackingUrl
         * @return Builder
         */
        public Builder trackingUrl(String trackingUrl) {
            this.trackingUrl = trackingUrl;
            return this;
        }
        /**
         * Setter for placedAt
         * @param placedAt
         * @return Builder
         */
        public Builder placedAt(String placedAt) {
            this.placedAt = placedAt;
            return this;
        }
        /**
         * Setter for inProgressAt
         * @param inProgressAt
         * @return Builder
         */
        public Builder inProgressAt(String inProgressAt) {
            this.inProgressAt = inProgressAt;
            return this;
        }
        /**
         * Setter for packagedAt
         * @param packagedAt
         * @return Builder
         */
        public Builder packagedAt(String packagedAt) {
            this.packagedAt = packagedAt;
            return this;
        }
        /**
         * Setter for expectedShippedAt
         * @param expectedShippedAt
         * @return Builder
         */
        public Builder expectedShippedAt(String expectedShippedAt) {
            this.expectedShippedAt = expectedShippedAt;
            return this;
        }
        /**
         * Setter for shippedAt
         * @param shippedAt
         * @return Builder
         */
        public Builder shippedAt(String shippedAt) {
            this.shippedAt = shippedAt;
            return this;
        }
        /**
         * Setter for canceledAt
         * @param canceledAt
         * @return Builder
         */
        public Builder canceledAt(String canceledAt) {
            this.canceledAt = canceledAt;
            return this;
        }
        /**
         * Setter for cancelReason
         * @param cancelReason
         * @return Builder
         */
        public Builder cancelReason(String cancelReason) {
            this.cancelReason = cancelReason;
            return this;
        }
        /**
         * Setter for failedAt
         * @param failedAt
         * @return Builder
         */
        public Builder failedAt(String failedAt) {
            this.failedAt = failedAt;
            return this;
        }
        /**
         * Setter for failureReason
         * @param failureReason
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
            return new OrderFulfillmentShipmentDetails(recipient,
                carrier,
                shippingNote,
                shippingType,
                trackingNumber,
                trackingUrl,
                placedAt,
                inProgressAt,
                packagedAt,
                expectedShippedAt,
                shippedAt,
                canceledAt,
                cancelReason,
                failedAt,
                failureReason);
        }
    }
}
