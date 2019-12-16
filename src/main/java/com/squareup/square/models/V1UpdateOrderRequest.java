package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1UpdateOrderRequest {

    @JsonCreator
    public V1UpdateOrderRequest(
            @JsonProperty("action") String action,
            @JsonProperty("shipped_tracking_number") String shippedTrackingNumber,
            @JsonProperty("completed_note") String completedNote,
            @JsonProperty("refunded_note") String refundedNote,
            @JsonProperty("canceled_note") String canceledNote) {
        this.action = action;
        this.shippedTrackingNumber = shippedTrackingNumber;
        this.completedNote = completedNote;
        this.refundedNote = refundedNote;
        this.canceledNote = canceledNote;
    }

    private final String action;
    private final String shippedTrackingNumber;
    private final String completedNote;
    private final String refundedNote;
    private final String canceledNote;

    @Override
    public int hashCode() {
        return Objects.hash(action, shippedTrackingNumber, completedNote, refundedNote, canceledNote);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1UpdateOrderRequest)) {
            return false;
        }
        V1UpdateOrderRequest v1UpdateOrderRequest = (V1UpdateOrderRequest) o;
        return Objects.equals(action, v1UpdateOrderRequest.action) &&
            Objects.equals(shippedTrackingNumber, v1UpdateOrderRequest.shippedTrackingNumber) &&
            Objects.equals(completedNote, v1UpdateOrderRequest.completedNote) &&
            Objects.equals(refundedNote, v1UpdateOrderRequest.refundedNote) &&
            Objects.equals(canceledNote, v1UpdateOrderRequest.canceledNote);
    }

    /**
     * Getter for Action.
     */
    @JsonGetter("action")
    public String getAction() { 
        return this.action;
    }

    /**
     * Getter for ShippedTrackingNumber.
     * The tracking number of the shipment associated with the order. Only valid if action is COMPLETE.
     */
    @JsonGetter("shipped_tracking_number")
    public String getShippedTrackingNumber() { 
        return this.shippedTrackingNumber;
    }

    /**
     * Getter for CompletedNote.
     * A merchant-specified note about the completion of the order. Only valid if action is COMPLETE.
     */
    @JsonGetter("completed_note")
    public String getCompletedNote() { 
        return this.completedNote;
    }

    /**
     * Getter for RefundedNote.
     * A merchant-specified note about the refunding of the order. Only valid if action is REFUND.
     */
    @JsonGetter("refunded_note")
    public String getRefundedNote() { 
        return this.refundedNote;
    }

    /**
     * Getter for CanceledNote.
     * A merchant-specified note about the canceling of the order. Only valid if action is CANCEL.
     */
    @JsonGetter("canceled_note")
    public String getCanceledNote() { 
        return this.canceledNote;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(action)
            .shippedTrackingNumber(getShippedTrackingNumber())
            .completedNote(getCompletedNote())
            .refundedNote(getRefundedNote())
            .canceledNote(getCanceledNote());
            return builder;
    }

    public static class Builder {
        private String action;
        private String shippedTrackingNumber;
        private String completedNote;
        private String refundedNote;
        private String canceledNote;

        public Builder(String action) {
            this.action = action;
        }

        public Builder action(String value) {
            action = value;
            return this;
        }
        public Builder shippedTrackingNumber(String value) {
            shippedTrackingNumber = value;
            return this;
        }
        public Builder completedNote(String value) {
            completedNote = value;
            return this;
        }
        public Builder refundedNote(String value) {
            refundedNote = value;
            return this;
        }
        public Builder canceledNote(String value) {
            canceledNote = value;
            return this;
        }

        public V1UpdateOrderRequest build() {
            return new V1UpdateOrderRequest(action,
                shippedTrackingNumber,
                completedNote,
                refundedNote,
                canceledNote);
        }
    }
}
