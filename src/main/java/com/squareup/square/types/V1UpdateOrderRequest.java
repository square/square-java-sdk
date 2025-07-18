/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = V1UpdateOrderRequest.Builder.class)
public final class V1UpdateOrderRequest {
    private final String locationId;

    private final String orderId;

    private final V1UpdateOrderRequestAction action;

    private final Optional<String> shippedTrackingNumber;

    private final Optional<String> completedNote;

    private final Optional<String> refundedNote;

    private final Optional<String> canceledNote;

    private final Map<String, Object> additionalProperties;

    private V1UpdateOrderRequest(
            String locationId,
            String orderId,
            V1UpdateOrderRequestAction action,
            Optional<String> shippedTrackingNumber,
            Optional<String> completedNote,
            Optional<String> refundedNote,
            Optional<String> canceledNote,
            Map<String, Object> additionalProperties) {
        this.locationId = locationId;
        this.orderId = orderId;
        this.action = action;
        this.shippedTrackingNumber = shippedTrackingNumber;
        this.completedNote = completedNote;
        this.refundedNote = refundedNote;
        this.canceledNote = canceledNote;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the order's associated location.
     */
    @JsonProperty("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * @return The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint
     */
    @JsonProperty("order_id")
    public String getOrderId() {
        return orderId;
    }

    /**
     * @return The action to perform on the order (COMPLETE, CANCEL, or REFUND).
     * See <a href="#type-v1updateorderrequestaction">V1UpdateOrderRequestAction</a> for possible values
     */
    @JsonProperty("action")
    public V1UpdateOrderRequestAction getAction() {
        return action;
    }

    /**
     * @return The tracking number of the shipment associated with the order. Only valid if action is COMPLETE.
     */
    @JsonIgnore
    public Optional<String> getShippedTrackingNumber() {
        if (shippedTrackingNumber == null) {
            return Optional.empty();
        }
        return shippedTrackingNumber;
    }

    /**
     * @return A merchant-specified note about the completion of the order. Only valid if action is COMPLETE.
     */
    @JsonIgnore
    public Optional<String> getCompletedNote() {
        if (completedNote == null) {
            return Optional.empty();
        }
        return completedNote;
    }

    /**
     * @return A merchant-specified note about the refunding of the order. Only valid if action is REFUND.
     */
    @JsonIgnore
    public Optional<String> getRefundedNote() {
        if (refundedNote == null) {
            return Optional.empty();
        }
        return refundedNote;
    }

    /**
     * @return A merchant-specified note about the canceling of the order. Only valid if action is CANCEL.
     */
    @JsonIgnore
    public Optional<String> getCanceledNote() {
        if (canceledNote == null) {
            return Optional.empty();
        }
        return canceledNote;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("shipped_tracking_number")
    private Optional<String> _getShippedTrackingNumber() {
        return shippedTrackingNumber;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("completed_note")
    private Optional<String> _getCompletedNote() {
        return completedNote;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("refunded_note")
    private Optional<String> _getRefundedNote() {
        return refundedNote;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("canceled_note")
    private Optional<String> _getCanceledNote() {
        return canceledNote;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V1UpdateOrderRequest && equalTo((V1UpdateOrderRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(V1UpdateOrderRequest other) {
        return locationId.equals(other.locationId)
                && orderId.equals(other.orderId)
                && action.equals(other.action)
                && shippedTrackingNumber.equals(other.shippedTrackingNumber)
                && completedNote.equals(other.completedNote)
                && refundedNote.equals(other.refundedNote)
                && canceledNote.equals(other.canceledNote);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.locationId,
                this.orderId,
                this.action,
                this.shippedTrackingNumber,
                this.completedNote,
                this.refundedNote,
                this.canceledNote);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LocationIdStage builder() {
        return new Builder();
    }

    public interface LocationIdStage {
        /**
         * <p>The ID of the order's associated location.</p>
         */
        OrderIdStage locationId(@NotNull String locationId);

        Builder from(V1UpdateOrderRequest other);
    }

    public interface OrderIdStage {
        /**
         * <p>The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint</p>
         */
        ActionStage orderId(@NotNull String orderId);
    }

    public interface ActionStage {
        /**
         * <p>The action to perform on the order (COMPLETE, CANCEL, or REFUND).
         * See <a href="#type-v1updateorderrequestaction">V1UpdateOrderRequestAction</a> for possible values</p>
         */
        _FinalStage action(@NotNull V1UpdateOrderRequestAction action);
    }

    public interface _FinalStage {
        V1UpdateOrderRequest build();

        /**
         * <p>The tracking number of the shipment associated with the order. Only valid if action is COMPLETE.</p>
         */
        _FinalStage shippedTrackingNumber(Optional<String> shippedTrackingNumber);

        _FinalStage shippedTrackingNumber(String shippedTrackingNumber);

        _FinalStage shippedTrackingNumber(Nullable<String> shippedTrackingNumber);

        /**
         * <p>A merchant-specified note about the completion of the order. Only valid if action is COMPLETE.</p>
         */
        _FinalStage completedNote(Optional<String> completedNote);

        _FinalStage completedNote(String completedNote);

        _FinalStage completedNote(Nullable<String> completedNote);

        /**
         * <p>A merchant-specified note about the refunding of the order. Only valid if action is REFUND.</p>
         */
        _FinalStage refundedNote(Optional<String> refundedNote);

        _FinalStage refundedNote(String refundedNote);

        _FinalStage refundedNote(Nullable<String> refundedNote);

        /**
         * <p>A merchant-specified note about the canceling of the order. Only valid if action is CANCEL.</p>
         */
        _FinalStage canceledNote(Optional<String> canceledNote);

        _FinalStage canceledNote(String canceledNote);

        _FinalStage canceledNote(Nullable<String> canceledNote);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LocationIdStage, OrderIdStage, ActionStage, _FinalStage {
        private String locationId;

        private String orderId;

        private V1UpdateOrderRequestAction action;

        private Optional<String> canceledNote = Optional.empty();

        private Optional<String> refundedNote = Optional.empty();

        private Optional<String> completedNote = Optional.empty();

        private Optional<String> shippedTrackingNumber = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(V1UpdateOrderRequest other) {
            locationId(other.getLocationId());
            orderId(other.getOrderId());
            action(other.getAction());
            shippedTrackingNumber(other.getShippedTrackingNumber());
            completedNote(other.getCompletedNote());
            refundedNote(other.getRefundedNote());
            canceledNote(other.getCanceledNote());
            return this;
        }

        /**
         * <p>The ID of the order's associated location.</p>
         * <p>The ID of the order's associated location.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("location_id")
        public OrderIdStage locationId(@NotNull String locationId) {
            this.locationId = Objects.requireNonNull(locationId, "locationId must not be null");
            return this;
        }

        /**
         * <p>The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint</p>
         * <p>The order's Square-issued ID. You obtain this value from Order objects returned by the List Orders endpoint</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("order_id")
        public ActionStage orderId(@NotNull String orderId) {
            this.orderId = Objects.requireNonNull(orderId, "orderId must not be null");
            return this;
        }

        /**
         * <p>The action to perform on the order (COMPLETE, CANCEL, or REFUND).
         * See <a href="#type-v1updateorderrequestaction">V1UpdateOrderRequestAction</a> for possible values</p>
         * <p>The action to perform on the order (COMPLETE, CANCEL, or REFUND).
         * See <a href="#type-v1updateorderrequestaction">V1UpdateOrderRequestAction</a> for possible values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("action")
        public _FinalStage action(@NotNull V1UpdateOrderRequestAction action) {
            this.action = Objects.requireNonNull(action, "action must not be null");
            return this;
        }

        /**
         * <p>A merchant-specified note about the canceling of the order. Only valid if action is CANCEL.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage canceledNote(Nullable<String> canceledNote) {
            if (canceledNote.isNull()) {
                this.canceledNote = null;
            } else if (canceledNote.isEmpty()) {
                this.canceledNote = Optional.empty();
            } else {
                this.canceledNote = Optional.of(canceledNote.get());
            }
            return this;
        }

        /**
         * <p>A merchant-specified note about the canceling of the order. Only valid if action is CANCEL.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage canceledNote(String canceledNote) {
            this.canceledNote = Optional.ofNullable(canceledNote);
            return this;
        }

        /**
         * <p>A merchant-specified note about the canceling of the order. Only valid if action is CANCEL.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "canceled_note", nulls = Nulls.SKIP)
        public _FinalStage canceledNote(Optional<String> canceledNote) {
            this.canceledNote = canceledNote;
            return this;
        }

        /**
         * <p>A merchant-specified note about the refunding of the order. Only valid if action is REFUND.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage refundedNote(Nullable<String> refundedNote) {
            if (refundedNote.isNull()) {
                this.refundedNote = null;
            } else if (refundedNote.isEmpty()) {
                this.refundedNote = Optional.empty();
            } else {
                this.refundedNote = Optional.of(refundedNote.get());
            }
            return this;
        }

        /**
         * <p>A merchant-specified note about the refunding of the order. Only valid if action is REFUND.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage refundedNote(String refundedNote) {
            this.refundedNote = Optional.ofNullable(refundedNote);
            return this;
        }

        /**
         * <p>A merchant-specified note about the refunding of the order. Only valid if action is REFUND.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "refunded_note", nulls = Nulls.SKIP)
        public _FinalStage refundedNote(Optional<String> refundedNote) {
            this.refundedNote = refundedNote;
            return this;
        }

        /**
         * <p>A merchant-specified note about the completion of the order. Only valid if action is COMPLETE.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage completedNote(Nullable<String> completedNote) {
            if (completedNote.isNull()) {
                this.completedNote = null;
            } else if (completedNote.isEmpty()) {
                this.completedNote = Optional.empty();
            } else {
                this.completedNote = Optional.of(completedNote.get());
            }
            return this;
        }

        /**
         * <p>A merchant-specified note about the completion of the order. Only valid if action is COMPLETE.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage completedNote(String completedNote) {
            this.completedNote = Optional.ofNullable(completedNote);
            return this;
        }

        /**
         * <p>A merchant-specified note about the completion of the order. Only valid if action is COMPLETE.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "completed_note", nulls = Nulls.SKIP)
        public _FinalStage completedNote(Optional<String> completedNote) {
            this.completedNote = completedNote;
            return this;
        }

        /**
         * <p>The tracking number of the shipment associated with the order. Only valid if action is COMPLETE.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage shippedTrackingNumber(Nullable<String> shippedTrackingNumber) {
            if (shippedTrackingNumber.isNull()) {
                this.shippedTrackingNumber = null;
            } else if (shippedTrackingNumber.isEmpty()) {
                this.shippedTrackingNumber = Optional.empty();
            } else {
                this.shippedTrackingNumber = Optional.of(shippedTrackingNumber.get());
            }
            return this;
        }

        /**
         * <p>The tracking number of the shipment associated with the order. Only valid if action is COMPLETE.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage shippedTrackingNumber(String shippedTrackingNumber) {
            this.shippedTrackingNumber = Optional.ofNullable(shippedTrackingNumber);
            return this;
        }

        /**
         * <p>The tracking number of the shipment associated with the order. Only valid if action is COMPLETE.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "shipped_tracking_number", nulls = Nulls.SKIP)
        public _FinalStage shippedTrackingNumber(Optional<String> shippedTrackingNumber) {
            this.shippedTrackingNumber = shippedTrackingNumber;
            return this;
        }

        @java.lang.Override
        public V1UpdateOrderRequest build() {
            return new V1UpdateOrderRequest(
                    locationId,
                    orderId,
                    action,
                    shippedTrackingNumber,
                    completedNote,
                    refundedNote,
                    canceledNote,
                    additionalProperties);
        }
    }
}
