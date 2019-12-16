package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderFulfillmentShipmentDetails {

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

    @Override
    public int hashCode() {
        return Objects.hash(recipient, carrier, shippingNote, shippingType, trackingNumber, trackingUrl, placedAt, inProgressAt, packagedAt, expectedShippedAt, shippedAt, canceledAt, cancelReason, failedAt, failureReason);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderFulfillmentShipmentDetails)) {
            return false;
        }
        OrderFulfillmentShipmentDetails orderFulfillmentShipmentDetails = (OrderFulfillmentShipmentDetails) o;
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
     * requested. Must be in RFC3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("placed_at")
    public String getPlacedAt() { 
        return this.placedAt;
    }

    /**
     * Getter for InProgressAt.
     * The [timestamp](#workingwithdates) indicating when this fulfillment was
     * moved to the `RESERVED` state. Indicates that preparation of this shipment has begun.
     * Must be in RFC3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("in_progress_at")
    public String getInProgressAt() { 
        return this.inProgressAt;
    }

    /**
     * Getter for PackagedAt.
     * The [timestamp](#workingwithdates) indicating when this fulfillment
     * was moved to the `PREPARED` state. Indicates that the fulfillment is packaged.
     * Must be in RFC3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("packaged_at")
    public String getPackagedAt() { 
        return this.packagedAt;
    }

    /**
     * Getter for ExpectedShippedAt.
     * The [timestamp](#workingwithdates) indicating when the shipment is
     * expected to be delivered to the shipping carrier. Must be in RFC3339 timestamp
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
     * to the shipping carrier. Must be in RFC3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("shipped_at")
    public String getShippedAt() { 
        return this.shippedAt;
    }

    /**
     * Getter for CanceledAt.
     * The [timestamp](#workingwithdates) indicating the shipment was canceled.
     * Must be in RFC3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z".
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
     * failed to be completed. Must be in RFC3339 timestamp format, e.g.,
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

        public Builder() { }

        public Builder recipient(OrderFulfillmentRecipient value) {
            recipient = value;
            return this;
        }
        public Builder carrier(String value) {
            carrier = value;
            return this;
        }
        public Builder shippingNote(String value) {
            shippingNote = value;
            return this;
        }
        public Builder shippingType(String value) {
            shippingType = value;
            return this;
        }
        public Builder trackingNumber(String value) {
            trackingNumber = value;
            return this;
        }
        public Builder trackingUrl(String value) {
            trackingUrl = value;
            return this;
        }
        public Builder placedAt(String value) {
            placedAt = value;
            return this;
        }
        public Builder inProgressAt(String value) {
            inProgressAt = value;
            return this;
        }
        public Builder packagedAt(String value) {
            packagedAt = value;
            return this;
        }
        public Builder expectedShippedAt(String value) {
            expectedShippedAt = value;
            return this;
        }
        public Builder shippedAt(String value) {
            shippedAt = value;
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
        public Builder failedAt(String value) {
            failedAt = value;
            return this;
        }
        public Builder failureReason(String value) {
            failureReason = value;
            return this;
        }

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
