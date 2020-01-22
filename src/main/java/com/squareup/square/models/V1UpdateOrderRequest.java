package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1UpdateOrderRequest type.
 */
public class V1UpdateOrderRequest {

    /**
     * Initialization constructor.
     * @param action
     * @param shippedTrackingNumber
     * @param completedNote
     * @param refundedNote
     * @param canceledNote
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(action, shippedTrackingNumber, completedNote, refundedNote, canceledNote);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1UpdateOrderRequest)) {
            return false;
        }
        V1UpdateOrderRequest v1UpdateOrderRequest = (V1UpdateOrderRequest) obj;
        return Objects.equals(action, v1UpdateOrderRequest.action) &&
            Objects.equals(shippedTrackingNumber, v1UpdateOrderRequest.shippedTrackingNumber) &&
            Objects.equals(completedNote, v1UpdateOrderRequest.completedNote) &&
            Objects.equals(refundedNote, v1UpdateOrderRequest.refundedNote) &&
            Objects.equals(canceledNote, v1UpdateOrderRequest.canceledNote);
    }

    /**
     * Builds a new {@link V1UpdateOrderRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdateOrderRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(action)
            .shippedTrackingNumber(getShippedTrackingNumber())
            .completedNote(getCompletedNote())
            .refundedNote(getRefundedNote())
            .canceledNote(getCanceledNote());
            return builder;
    }

    /**
     * Class to build instances of {@link V1UpdateOrderRequest}
     */
    public static class Builder {
        private String action;
        private String shippedTrackingNumber;
        private String completedNote;
        private String refundedNote;
        private String canceledNote;

        /**
         * Initialization constructor
         */
        public Builder(String action) {
            this.action = action;
        }

        /**
         * Setter for action
         * @param action
         * @return Builder
         */
        public Builder action(String action) {
            this.action = action;
            return this;
        }
        /**
         * Setter for shippedTrackingNumber
         * @param shippedTrackingNumber
         * @return Builder
         */
        public Builder shippedTrackingNumber(String shippedTrackingNumber) {
            this.shippedTrackingNumber = shippedTrackingNumber;
            return this;
        }
        /**
         * Setter for completedNote
         * @param completedNote
         * @return Builder
         */
        public Builder completedNote(String completedNote) {
            this.completedNote = completedNote;
            return this;
        }
        /**
         * Setter for refundedNote
         * @param refundedNote
         * @return Builder
         */
        public Builder refundedNote(String refundedNote) {
            this.refundedNote = refundedNote;
            return this;
        }
        /**
         * Setter for canceledNote
         * @param canceledNote
         * @return Builder
         */
        public Builder canceledNote(String canceledNote) {
            this.canceledNote = canceledNote;
            return this;
        }

        /**
         * Builds a new {@link V1UpdateOrderRequest} object using the set fields.
         * @return {@link V1UpdateOrderRequest}
         */
        public V1UpdateOrderRequest build() {
            return new V1UpdateOrderRequest(action,
                shippedTrackingNumber,
                completedNote,
                refundedNote,
                canceledNote);
        }
    }
}
