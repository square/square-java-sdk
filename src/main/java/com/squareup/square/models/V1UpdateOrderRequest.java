
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
 * This is a model class for V1UpdateOrderRequest type.
 */
public class V1UpdateOrderRequest {
    private final String action;
    private final OptionalNullable<String> shippedTrackingNumber;
    private final OptionalNullable<String> completedNote;
    private final OptionalNullable<String> refundedNote;
    private final OptionalNullable<String> canceledNote;

    /**
     * Initialization constructor.
     * @param  action  String value for action.
     * @param  shippedTrackingNumber  String value for shippedTrackingNumber.
     * @param  completedNote  String value for completedNote.
     * @param  refundedNote  String value for refundedNote.
     * @param  canceledNote  String value for canceledNote.
     */
    @JsonCreator
    public V1UpdateOrderRequest(
            @JsonProperty("action") String action,
            @JsonProperty("shipped_tracking_number") String shippedTrackingNumber,
            @JsonProperty("completed_note") String completedNote,
            @JsonProperty("refunded_note") String refundedNote,
            @JsonProperty("canceled_note") String canceledNote) {
        this.action = action;
        this.shippedTrackingNumber = OptionalNullable.of(shippedTrackingNumber);
        this.completedNote = OptionalNullable.of(completedNote);
        this.refundedNote = OptionalNullable.of(refundedNote);
        this.canceledNote = OptionalNullable.of(canceledNote);
    }

    /**
     * Internal initialization constructor.
     */
    protected V1UpdateOrderRequest(String action, OptionalNullable<String> shippedTrackingNumber,
            OptionalNullable<String> completedNote, OptionalNullable<String> refundedNote,
            OptionalNullable<String> canceledNote) {
        this.action = action;
        this.shippedTrackingNumber = shippedTrackingNumber;
        this.completedNote = completedNote;
        this.refundedNote = refundedNote;
        this.canceledNote = canceledNote;
    }

    /**
     * Getter for Action.
     * @return Returns the String
     */
    @JsonGetter("action")
    public String getAction() {
        return action;
    }

    /**
     * Internal Getter for ShippedTrackingNumber.
     * The tracking number of the shipment associated with the order. Only valid if action is
     * COMPLETE.
     * @return Returns the Internal String
     */
    @JsonGetter("shipped_tracking_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetShippedTrackingNumber() {
        return this.shippedTrackingNumber;
    }

    /**
     * Getter for ShippedTrackingNumber.
     * The tracking number of the shipment associated with the order. Only valid if action is
     * COMPLETE.
     * @return Returns the String
     */
    @JsonIgnore
    public String getShippedTrackingNumber() {
        return OptionalNullable.getFrom(shippedTrackingNumber);
    }

    /**
     * Internal Getter for CompletedNote.
     * A merchant-specified note about the completion of the order. Only valid if action is
     * COMPLETE.
     * @return Returns the Internal String
     */
    @JsonGetter("completed_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCompletedNote() {
        return this.completedNote;
    }

    /**
     * Getter for CompletedNote.
     * A merchant-specified note about the completion of the order. Only valid if action is
     * COMPLETE.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCompletedNote() {
        return OptionalNullable.getFrom(completedNote);
    }

    /**
     * Internal Getter for RefundedNote.
     * A merchant-specified note about the refunding of the order. Only valid if action is REFUND.
     * @return Returns the Internal String
     */
    @JsonGetter("refunded_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetRefundedNote() {
        return this.refundedNote;
    }

    /**
     * Getter for RefundedNote.
     * A merchant-specified note about the refunding of the order. Only valid if action is REFUND.
     * @return Returns the String
     */
    @JsonIgnore
    public String getRefundedNote() {
        return OptionalNullable.getFrom(refundedNote);
    }

    /**
     * Internal Getter for CanceledNote.
     * A merchant-specified note about the canceling of the order. Only valid if action is CANCEL.
     * @return Returns the Internal String
     */
    @JsonGetter("canceled_note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCanceledNote() {
        return this.canceledNote;
    }

    /**
     * Getter for CanceledNote.
     * A merchant-specified note about the canceling of the order. Only valid if action is CANCEL.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCanceledNote() {
        return OptionalNullable.getFrom(canceledNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, shippedTrackingNumber, completedNote, refundedNote,
                canceledNote);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1UpdateOrderRequest)) {
            return false;
        }
        V1UpdateOrderRequest other = (V1UpdateOrderRequest) obj;
        return Objects.equals(action, other.action)
            && Objects.equals(shippedTrackingNumber, other.shippedTrackingNumber)
            && Objects.equals(completedNote, other.completedNote)
            && Objects.equals(refundedNote, other.refundedNote)
            && Objects.equals(canceledNote, other.canceledNote);
    }

    /**
     * Converts this V1UpdateOrderRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1UpdateOrderRequest [" + "action=" + action + ", shippedTrackingNumber="
                + shippedTrackingNumber + ", completedNote=" + completedNote + ", refundedNote="
                + refundedNote + ", canceledNote=" + canceledNote + "]";
    }

    /**
     * Builds a new {@link V1UpdateOrderRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdateOrderRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(action);
        builder.shippedTrackingNumber = internalGetShippedTrackingNumber();
        builder.completedNote = internalGetCompletedNote();
        builder.refundedNote = internalGetRefundedNote();
        builder.canceledNote = internalGetCanceledNote();
        return builder;
    }

    /**
     * Class to build instances of {@link V1UpdateOrderRequest}.
     */
    public static class Builder {
        private String action;
        private OptionalNullable<String> shippedTrackingNumber;
        private OptionalNullable<String> completedNote;
        private OptionalNullable<String> refundedNote;
        private OptionalNullable<String> canceledNote;

        /**
         * Initialization constructor.
         * @param  action  String value for action.
         */
        public Builder(String action) {
            this.action = action;
        }

        /**
         * Setter for action.
         * @param  action  String value for action.
         * @return Builder
         */
        public Builder action(String action) {
            this.action = action;
            return this;
        }

        /**
         * Setter for shippedTrackingNumber.
         * @param  shippedTrackingNumber  String value for shippedTrackingNumber.
         * @return Builder
         */
        public Builder shippedTrackingNumber(String shippedTrackingNumber) {
            this.shippedTrackingNumber = OptionalNullable.of(shippedTrackingNumber);
            return this;
        }

        /**
         * UnSetter for shippedTrackingNumber.
         * @return Builder
         */
        public Builder unsetShippedTrackingNumber() {
            shippedTrackingNumber = null;
            return this;
        }

        /**
         * Setter for completedNote.
         * @param  completedNote  String value for completedNote.
         * @return Builder
         */
        public Builder completedNote(String completedNote) {
            this.completedNote = OptionalNullable.of(completedNote);
            return this;
        }

        /**
         * UnSetter for completedNote.
         * @return Builder
         */
        public Builder unsetCompletedNote() {
            completedNote = null;
            return this;
        }

        /**
         * Setter for refundedNote.
         * @param  refundedNote  String value for refundedNote.
         * @return Builder
         */
        public Builder refundedNote(String refundedNote) {
            this.refundedNote = OptionalNullable.of(refundedNote);
            return this;
        }

        /**
         * UnSetter for refundedNote.
         * @return Builder
         */
        public Builder unsetRefundedNote() {
            refundedNote = null;
            return this;
        }

        /**
         * Setter for canceledNote.
         * @param  canceledNote  String value for canceledNote.
         * @return Builder
         */
        public Builder canceledNote(String canceledNote) {
            this.canceledNote = OptionalNullable.of(canceledNote);
            return this;
        }

        /**
         * UnSetter for canceledNote.
         * @return Builder
         */
        public Builder unsetCanceledNote() {
            canceledNote = null;
            return this;
        }

        /**
         * Builds a new {@link V1UpdateOrderRequest} object using the set fields.
         * @return {@link V1UpdateOrderRequest}
         */
        public V1UpdateOrderRequest build() {
            return new V1UpdateOrderRequest(action, shippedTrackingNumber, completedNote,
                    refundedNote, canceledNote);
        }
    }
}
