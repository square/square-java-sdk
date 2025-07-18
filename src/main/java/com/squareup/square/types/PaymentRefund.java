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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PaymentRefund.Builder.class)
public final class PaymentRefund {
    private final String id;

    private final Optional<String> status;

    private final Optional<String> locationId;

    private final Optional<Boolean> unlinked;

    private final Optional<String> destinationType;

    private final Optional<DestinationDetails> destinationDetails;

    private final Money amountMoney;

    private final Optional<Money> appFeeMoney;

    private final Optional<List<ProcessingFee>> processingFee;

    private final Optional<String> paymentId;

    private final Optional<String> orderId;

    private final Optional<String> reason;

    private final Optional<String> createdAt;

    private final Optional<String> updatedAt;

    private final Optional<String> teamMemberId;

    private final Optional<String> terminalRefundId;

    private final Map<String, Object> additionalProperties;

    private PaymentRefund(
            String id,
            Optional<String> status,
            Optional<String> locationId,
            Optional<Boolean> unlinked,
            Optional<String> destinationType,
            Optional<DestinationDetails> destinationDetails,
            Money amountMoney,
            Optional<Money> appFeeMoney,
            Optional<List<ProcessingFee>> processingFee,
            Optional<String> paymentId,
            Optional<String> orderId,
            Optional<String> reason,
            Optional<String> createdAt,
            Optional<String> updatedAt,
            Optional<String> teamMemberId,
            Optional<String> terminalRefundId,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.status = status;
        this.locationId = locationId;
        this.unlinked = unlinked;
        this.destinationType = destinationType;
        this.destinationDetails = destinationDetails;
        this.amountMoney = amountMoney;
        this.appFeeMoney = appFeeMoney;
        this.processingFee = processingFee;
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.reason = reason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.teamMemberId = teamMemberId;
        this.terminalRefundId = terminalRefundId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The unique ID for this refund, generated by Square.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The refund's status:
     * <ul>
     * <li><code>PENDING</code> - Awaiting approval.</li>
     * <li><code>COMPLETED</code> - Successfully completed.</li>
     * <li><code>REJECTED</code> - The refund was rejected.</li>
     * <li><code>FAILED</code> - An error occurred.</li>
     * </ul>
     */
    @JsonIgnore
    public Optional<String> getStatus() {
        if (status == null) {
            return Optional.empty();
        }
        return status;
    }

    /**
     * @return The location ID associated with the payment this refund is attached to.
     */
    @JsonIgnore
    public Optional<String> getLocationId() {
        if (locationId == null) {
            return Optional.empty();
        }
        return locationId;
    }

    /**
     * @return Flag indicating whether or not the refund is linked to an existing payment in Square.
     */
    @JsonProperty("unlinked")
    public Optional<Boolean> getUnlinked() {
        return unlinked;
    }

    /**
     * @return The destination type for this refund.
     * <p>Current values include <code>CARD</code>, <code>BANK_ACCOUNT</code>, <code>WALLET</code>, <code>BUY_NOW_PAY_LATER</code>, <code>CASH</code>,
     * <code>EXTERNAL</code>, and <code>SQUARE_ACCOUNT</code>.</p>
     */
    @JsonIgnore
    public Optional<String> getDestinationType() {
        if (destinationType == null) {
            return Optional.empty();
        }
        return destinationType;
    }

    /**
     * @return Contains information about the refund destination. This field is populated only if
     * <code>destination_id</code> is defined in the <code>RefundPayment</code> request.
     */
    @JsonProperty("destination_details")
    public Optional<DestinationDetails> getDestinationDetails() {
        return destinationDetails;
    }

    /**
     * @return The amount of money refunded. This amount is specified in the smallest denomination
     * of the applicable currency (for example, US dollar amounts are specified in cents).
     */
    @JsonProperty("amount_money")
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * @return The amount of money the application developer contributed to help cover the refunded amount.
     * This amount is specified in the smallest denomination of the applicable currency (for example,
     * US dollar amounts are specified in cents). For more information, see
     * <a href="https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts">Working with Monetary Amounts</a>.
     */
    @JsonProperty("app_fee_money")
    public Optional<Money> getAppFeeMoney() {
        return appFeeMoney;
    }

    /**
     * @return Processing fees and fee adjustments assessed by Square for this refund.
     */
    @JsonIgnore
    public Optional<List<ProcessingFee>> getProcessingFee() {
        if (processingFee == null) {
            return Optional.empty();
        }
        return processingFee;
    }

    /**
     * @return The ID of the payment associated with this refund.
     */
    @JsonIgnore
    public Optional<String> getPaymentId() {
        if (paymentId == null) {
            return Optional.empty();
        }
        return paymentId;
    }

    /**
     * @return The ID of the order associated with the refund.
     */
    @JsonIgnore
    public Optional<String> getOrderId() {
        if (orderId == null) {
            return Optional.empty();
        }
        return orderId;
    }

    /**
     * @return The reason for the refund.
     */
    @JsonIgnore
    public Optional<String> getReason() {
        if (reason == null) {
            return Optional.empty();
        }
        return reason;
    }

    /**
     * @return The timestamp of when the refund was created, in RFC 3339 format.
     */
    @JsonProperty("created_at")
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The timestamp of when the refund was last updated, in RFC 3339 format.
     */
    @JsonProperty("updated_at")
    public Optional<String> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return An optional ID of the team member associated with taking the payment.
     */
    @JsonProperty("team_member_id")
    public Optional<String> getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * @return An optional ID for a Terminal refund.
     */
    @JsonProperty("terminal_refund_id")
    public Optional<String> getTerminalRefundId() {
        return terminalRefundId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("status")
    private Optional<String> _getStatus() {
        return status;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("location_id")
    private Optional<String> _getLocationId() {
        return locationId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("destination_type")
    private Optional<String> _getDestinationType() {
        return destinationType;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("processing_fee")
    private Optional<List<ProcessingFee>> _getProcessingFee() {
        return processingFee;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("payment_id")
    private Optional<String> _getPaymentId() {
        return paymentId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("order_id")
    private Optional<String> _getOrderId() {
        return orderId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("reason")
    private Optional<String> _getReason() {
        return reason;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PaymentRefund && equalTo((PaymentRefund) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PaymentRefund other) {
        return id.equals(other.id)
                && status.equals(other.status)
                && locationId.equals(other.locationId)
                && unlinked.equals(other.unlinked)
                && destinationType.equals(other.destinationType)
                && destinationDetails.equals(other.destinationDetails)
                && amountMoney.equals(other.amountMoney)
                && appFeeMoney.equals(other.appFeeMoney)
                && processingFee.equals(other.processingFee)
                && paymentId.equals(other.paymentId)
                && orderId.equals(other.orderId)
                && reason.equals(other.reason)
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt)
                && teamMemberId.equals(other.teamMemberId)
                && terminalRefundId.equals(other.terminalRefundId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.status,
                this.locationId,
                this.unlinked,
                this.destinationType,
                this.destinationDetails,
                this.amountMoney,
                this.appFeeMoney,
                this.processingFee,
                this.paymentId,
                this.orderId,
                this.reason,
                this.createdAt,
                this.updatedAt,
                this.teamMemberId,
                this.terminalRefundId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        /**
         * <p>The unique ID for this refund, generated by Square.</p>
         */
        AmountMoneyStage id(@NotNull String id);

        Builder from(PaymentRefund other);
    }

    public interface AmountMoneyStage {
        /**
         * <p>The amount of money refunded. This amount is specified in the smallest denomination
         * of the applicable currency (for example, US dollar amounts are specified in cents).</p>
         */
        _FinalStage amountMoney(@NotNull Money amountMoney);
    }

    public interface _FinalStage {
        PaymentRefund build();

        /**
         * <p>The refund's status:</p>
         * <ul>
         * <li><code>PENDING</code> - Awaiting approval.</li>
         * <li><code>COMPLETED</code> - Successfully completed.</li>
         * <li><code>REJECTED</code> - The refund was rejected.</li>
         * <li><code>FAILED</code> - An error occurred.</li>
         * </ul>
         */
        _FinalStage status(Optional<String> status);

        _FinalStage status(String status);

        _FinalStage status(Nullable<String> status);

        /**
         * <p>The location ID associated with the payment this refund is attached to.</p>
         */
        _FinalStage locationId(Optional<String> locationId);

        _FinalStage locationId(String locationId);

        _FinalStage locationId(Nullable<String> locationId);

        /**
         * <p>Flag indicating whether or not the refund is linked to an existing payment in Square.</p>
         */
        _FinalStage unlinked(Optional<Boolean> unlinked);

        _FinalStage unlinked(Boolean unlinked);

        /**
         * <p>The destination type for this refund.</p>
         * <p>Current values include <code>CARD</code>, <code>BANK_ACCOUNT</code>, <code>WALLET</code>, <code>BUY_NOW_PAY_LATER</code>, <code>CASH</code>,
         * <code>EXTERNAL</code>, and <code>SQUARE_ACCOUNT</code>.</p>
         */
        _FinalStage destinationType(Optional<String> destinationType);

        _FinalStage destinationType(String destinationType);

        _FinalStage destinationType(Nullable<String> destinationType);

        /**
         * <p>Contains information about the refund destination. This field is populated only if
         * <code>destination_id</code> is defined in the <code>RefundPayment</code> request.</p>
         */
        _FinalStage destinationDetails(Optional<DestinationDetails> destinationDetails);

        _FinalStage destinationDetails(DestinationDetails destinationDetails);

        /**
         * <p>The amount of money the application developer contributed to help cover the refunded amount.
         * This amount is specified in the smallest denomination of the applicable currency (for example,
         * US dollar amounts are specified in cents). For more information, see
         * <a href="https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts">Working with Monetary Amounts</a>.</p>
         */
        _FinalStage appFeeMoney(Optional<Money> appFeeMoney);

        _FinalStage appFeeMoney(Money appFeeMoney);

        /**
         * <p>Processing fees and fee adjustments assessed by Square for this refund.</p>
         */
        _FinalStage processingFee(Optional<List<ProcessingFee>> processingFee);

        _FinalStage processingFee(List<ProcessingFee> processingFee);

        _FinalStage processingFee(Nullable<List<ProcessingFee>> processingFee);

        /**
         * <p>The ID of the payment associated with this refund.</p>
         */
        _FinalStage paymentId(Optional<String> paymentId);

        _FinalStage paymentId(String paymentId);

        _FinalStage paymentId(Nullable<String> paymentId);

        /**
         * <p>The ID of the order associated with the refund.</p>
         */
        _FinalStage orderId(Optional<String> orderId);

        _FinalStage orderId(String orderId);

        _FinalStage orderId(Nullable<String> orderId);

        /**
         * <p>The reason for the refund.</p>
         */
        _FinalStage reason(Optional<String> reason);

        _FinalStage reason(String reason);

        _FinalStage reason(Nullable<String> reason);

        /**
         * <p>The timestamp of when the refund was created, in RFC 3339 format.</p>
         */
        _FinalStage createdAt(Optional<String> createdAt);

        _FinalStage createdAt(String createdAt);

        /**
         * <p>The timestamp of when the refund was last updated, in RFC 3339 format.</p>
         */
        _FinalStage updatedAt(Optional<String> updatedAt);

        _FinalStage updatedAt(String updatedAt);

        /**
         * <p>An optional ID of the team member associated with taking the payment.</p>
         */
        _FinalStage teamMemberId(Optional<String> teamMemberId);

        _FinalStage teamMemberId(String teamMemberId);

        /**
         * <p>An optional ID for a Terminal refund.</p>
         */
        _FinalStage terminalRefundId(Optional<String> terminalRefundId);

        _FinalStage terminalRefundId(String terminalRefundId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, AmountMoneyStage, _FinalStage {
        private String id;

        private Money amountMoney;

        private Optional<String> terminalRefundId = Optional.empty();

        private Optional<String> teamMemberId = Optional.empty();

        private Optional<String> updatedAt = Optional.empty();

        private Optional<String> createdAt = Optional.empty();

        private Optional<String> reason = Optional.empty();

        private Optional<String> orderId = Optional.empty();

        private Optional<String> paymentId = Optional.empty();

        private Optional<List<ProcessingFee>> processingFee = Optional.empty();

        private Optional<Money> appFeeMoney = Optional.empty();

        private Optional<DestinationDetails> destinationDetails = Optional.empty();

        private Optional<String> destinationType = Optional.empty();

        private Optional<Boolean> unlinked = Optional.empty();

        private Optional<String> locationId = Optional.empty();

        private Optional<String> status = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(PaymentRefund other) {
            id(other.getId());
            status(other.getStatus());
            locationId(other.getLocationId());
            unlinked(other.getUnlinked());
            destinationType(other.getDestinationType());
            destinationDetails(other.getDestinationDetails());
            amountMoney(other.getAmountMoney());
            appFeeMoney(other.getAppFeeMoney());
            processingFee(other.getProcessingFee());
            paymentId(other.getPaymentId());
            orderId(other.getOrderId());
            reason(other.getReason());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            teamMemberId(other.getTeamMemberId());
            terminalRefundId(other.getTerminalRefundId());
            return this;
        }

        /**
         * <p>The unique ID for this refund, generated by Square.</p>
         * <p>The unique ID for this refund, generated by Square.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("id")
        public AmountMoneyStage id(@NotNull String id) {
            this.id = Objects.requireNonNull(id, "id must not be null");
            return this;
        }

        /**
         * <p>The amount of money refunded. This amount is specified in the smallest denomination
         * of the applicable currency (for example, US dollar amounts are specified in cents).</p>
         * <p>The amount of money refunded. This amount is specified in the smallest denomination
         * of the applicable currency (for example, US dollar amounts are specified in cents).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("amount_money")
        public _FinalStage amountMoney(@NotNull Money amountMoney) {
            this.amountMoney = Objects.requireNonNull(amountMoney, "amountMoney must not be null");
            return this;
        }

        /**
         * <p>An optional ID for a Terminal refund.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage terminalRefundId(String terminalRefundId) {
            this.terminalRefundId = Optional.ofNullable(terminalRefundId);
            return this;
        }

        /**
         * <p>An optional ID for a Terminal refund.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "terminal_refund_id", nulls = Nulls.SKIP)
        public _FinalStage terminalRefundId(Optional<String> terminalRefundId) {
            this.terminalRefundId = terminalRefundId;
            return this;
        }

        /**
         * <p>An optional ID of the team member associated with taking the payment.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage teamMemberId(String teamMemberId) {
            this.teamMemberId = Optional.ofNullable(teamMemberId);
            return this;
        }

        /**
         * <p>An optional ID of the team member associated with taking the payment.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "team_member_id", nulls = Nulls.SKIP)
        public _FinalStage teamMemberId(Optional<String> teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * <p>The timestamp of when the refund was last updated, in RFC 3339 format.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage updatedAt(String updatedAt) {
            this.updatedAt = Optional.ofNullable(updatedAt);
            return this;
        }

        /**
         * <p>The timestamp of when the refund was last updated, in RFC 3339 format.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "updated_at", nulls = Nulls.SKIP)
        public _FinalStage updatedAt(Optional<String> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * <p>The timestamp of when the refund was created, in RFC 3339 format.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage createdAt(String createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        /**
         * <p>The timestamp of when the refund was created, in RFC 3339 format.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public _FinalStage createdAt(Optional<String> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * <p>The reason for the refund.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage reason(Nullable<String> reason) {
            if (reason.isNull()) {
                this.reason = null;
            } else if (reason.isEmpty()) {
                this.reason = Optional.empty();
            } else {
                this.reason = Optional.of(reason.get());
            }
            return this;
        }

        /**
         * <p>The reason for the refund.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage reason(String reason) {
            this.reason = Optional.ofNullable(reason);
            return this;
        }

        /**
         * <p>The reason for the refund.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "reason", nulls = Nulls.SKIP)
        public _FinalStage reason(Optional<String> reason) {
            this.reason = reason;
            return this;
        }

        /**
         * <p>The ID of the order associated with the refund.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage orderId(Nullable<String> orderId) {
            if (orderId.isNull()) {
                this.orderId = null;
            } else if (orderId.isEmpty()) {
                this.orderId = Optional.empty();
            } else {
                this.orderId = Optional.of(orderId.get());
            }
            return this;
        }

        /**
         * <p>The ID of the order associated with the refund.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage orderId(String orderId) {
            this.orderId = Optional.ofNullable(orderId);
            return this;
        }

        /**
         * <p>The ID of the order associated with the refund.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "order_id", nulls = Nulls.SKIP)
        public _FinalStage orderId(Optional<String> orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * <p>The ID of the payment associated with this refund.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage paymentId(Nullable<String> paymentId) {
            if (paymentId.isNull()) {
                this.paymentId = null;
            } else if (paymentId.isEmpty()) {
                this.paymentId = Optional.empty();
            } else {
                this.paymentId = Optional.of(paymentId.get());
            }
            return this;
        }

        /**
         * <p>The ID of the payment associated with this refund.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage paymentId(String paymentId) {
            this.paymentId = Optional.ofNullable(paymentId);
            return this;
        }

        /**
         * <p>The ID of the payment associated with this refund.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "payment_id", nulls = Nulls.SKIP)
        public _FinalStage paymentId(Optional<String> paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        /**
         * <p>Processing fees and fee adjustments assessed by Square for this refund.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage processingFee(Nullable<List<ProcessingFee>> processingFee) {
            if (processingFee.isNull()) {
                this.processingFee = null;
            } else if (processingFee.isEmpty()) {
                this.processingFee = Optional.empty();
            } else {
                this.processingFee = Optional.of(processingFee.get());
            }
            return this;
        }

        /**
         * <p>Processing fees and fee adjustments assessed by Square for this refund.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage processingFee(List<ProcessingFee> processingFee) {
            this.processingFee = Optional.ofNullable(processingFee);
            return this;
        }

        /**
         * <p>Processing fees and fee adjustments assessed by Square for this refund.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "processing_fee", nulls = Nulls.SKIP)
        public _FinalStage processingFee(Optional<List<ProcessingFee>> processingFee) {
            this.processingFee = processingFee;
            return this;
        }

        /**
         * <p>The amount of money the application developer contributed to help cover the refunded amount.
         * This amount is specified in the smallest denomination of the applicable currency (for example,
         * US dollar amounts are specified in cents). For more information, see
         * <a href="https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts">Working with Monetary Amounts</a>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage appFeeMoney(Money appFeeMoney) {
            this.appFeeMoney = Optional.ofNullable(appFeeMoney);
            return this;
        }

        /**
         * <p>The amount of money the application developer contributed to help cover the refunded amount.
         * This amount is specified in the smallest denomination of the applicable currency (for example,
         * US dollar amounts are specified in cents). For more information, see
         * <a href="https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts">Working with Monetary Amounts</a>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "app_fee_money", nulls = Nulls.SKIP)
        public _FinalStage appFeeMoney(Optional<Money> appFeeMoney) {
            this.appFeeMoney = appFeeMoney;
            return this;
        }

        /**
         * <p>Contains information about the refund destination. This field is populated only if
         * <code>destination_id</code> is defined in the <code>RefundPayment</code> request.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage destinationDetails(DestinationDetails destinationDetails) {
            this.destinationDetails = Optional.ofNullable(destinationDetails);
            return this;
        }

        /**
         * <p>Contains information about the refund destination. This field is populated only if
         * <code>destination_id</code> is defined in the <code>RefundPayment</code> request.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "destination_details", nulls = Nulls.SKIP)
        public _FinalStage destinationDetails(Optional<DestinationDetails> destinationDetails) {
            this.destinationDetails = destinationDetails;
            return this;
        }

        /**
         * <p>The destination type for this refund.</p>
         * <p>Current values include <code>CARD</code>, <code>BANK_ACCOUNT</code>, <code>WALLET</code>, <code>BUY_NOW_PAY_LATER</code>, <code>CASH</code>,
         * <code>EXTERNAL</code>, and <code>SQUARE_ACCOUNT</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage destinationType(Nullable<String> destinationType) {
            if (destinationType.isNull()) {
                this.destinationType = null;
            } else if (destinationType.isEmpty()) {
                this.destinationType = Optional.empty();
            } else {
                this.destinationType = Optional.of(destinationType.get());
            }
            return this;
        }

        /**
         * <p>The destination type for this refund.</p>
         * <p>Current values include <code>CARD</code>, <code>BANK_ACCOUNT</code>, <code>WALLET</code>, <code>BUY_NOW_PAY_LATER</code>, <code>CASH</code>,
         * <code>EXTERNAL</code>, and <code>SQUARE_ACCOUNT</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage destinationType(String destinationType) {
            this.destinationType = Optional.ofNullable(destinationType);
            return this;
        }

        /**
         * <p>The destination type for this refund.</p>
         * <p>Current values include <code>CARD</code>, <code>BANK_ACCOUNT</code>, <code>WALLET</code>, <code>BUY_NOW_PAY_LATER</code>, <code>CASH</code>,
         * <code>EXTERNAL</code>, and <code>SQUARE_ACCOUNT</code>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "destination_type", nulls = Nulls.SKIP)
        public _FinalStage destinationType(Optional<String> destinationType) {
            this.destinationType = destinationType;
            return this;
        }

        /**
         * <p>Flag indicating whether or not the refund is linked to an existing payment in Square.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage unlinked(Boolean unlinked) {
            this.unlinked = Optional.ofNullable(unlinked);
            return this;
        }

        /**
         * <p>Flag indicating whether or not the refund is linked to an existing payment in Square.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "unlinked", nulls = Nulls.SKIP)
        public _FinalStage unlinked(Optional<Boolean> unlinked) {
            this.unlinked = unlinked;
            return this;
        }

        /**
         * <p>The location ID associated with the payment this refund is attached to.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage locationId(Nullable<String> locationId) {
            if (locationId.isNull()) {
                this.locationId = null;
            } else if (locationId.isEmpty()) {
                this.locationId = Optional.empty();
            } else {
                this.locationId = Optional.of(locationId.get());
            }
            return this;
        }

        /**
         * <p>The location ID associated with the payment this refund is attached to.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage locationId(String locationId) {
            this.locationId = Optional.ofNullable(locationId);
            return this;
        }

        /**
         * <p>The location ID associated with the payment this refund is attached to.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "location_id", nulls = Nulls.SKIP)
        public _FinalStage locationId(Optional<String> locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * <p>The refund's status:</p>
         * <ul>
         * <li><code>PENDING</code> - Awaiting approval.</li>
         * <li><code>COMPLETED</code> - Successfully completed.</li>
         * <li><code>REJECTED</code> - The refund was rejected.</li>
         * <li><code>FAILED</code> - An error occurred.</li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage status(Nullable<String> status) {
            if (status.isNull()) {
                this.status = null;
            } else if (status.isEmpty()) {
                this.status = Optional.empty();
            } else {
                this.status = Optional.of(status.get());
            }
            return this;
        }

        /**
         * <p>The refund's status:</p>
         * <ul>
         * <li><code>PENDING</code> - Awaiting approval.</li>
         * <li><code>COMPLETED</code> - Successfully completed.</li>
         * <li><code>REJECTED</code> - The refund was rejected.</li>
         * <li><code>FAILED</code> - An error occurred.</li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage status(String status) {
            this.status = Optional.ofNullable(status);
            return this;
        }

        /**
         * <p>The refund's status:</p>
         * <ul>
         * <li><code>PENDING</code> - Awaiting approval.</li>
         * <li><code>COMPLETED</code> - Successfully completed.</li>
         * <li><code>REJECTED</code> - The refund was rejected.</li>
         * <li><code>FAILED</code> - An error occurred.</li>
         * </ul>
         */
        @java.lang.Override
        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public _FinalStage status(Optional<String> status) {
            this.status = status;
            return this;
        }

        @java.lang.Override
        public PaymentRefund build() {
            return new PaymentRefund(
                    id,
                    status,
                    locationId,
                    unlinked,
                    destinationType,
                    destinationDetails,
                    amountMoney,
                    appFeeMoney,
                    processingFee,
                    paymentId,
                    orderId,
                    reason,
                    createdAt,
                    updatedAt,
                    teamMemberId,
                    terminalRefundId,
                    additionalProperties);
        }
    }
}
