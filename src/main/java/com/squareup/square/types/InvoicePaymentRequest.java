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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = InvoicePaymentRequest.Builder.class)
public final class InvoicePaymentRequest {
    private final Optional<String> uid;

    private final Optional<InvoiceRequestMethod> requestMethod;

    private final Optional<InvoiceRequestType> requestType;

    private final Optional<String> dueDate;

    private final Optional<Money> fixedAmountRequestedMoney;

    private final Optional<String> percentageRequested;

    private final Optional<Boolean> tippingEnabled;

    private final Optional<InvoiceAutomaticPaymentSource> automaticPaymentSource;

    private final Optional<String> cardId;

    private final Optional<List<InvoicePaymentReminder>> reminders;

    private final Optional<Money> computedAmountMoney;

    private final Optional<Money> totalCompletedAmountMoney;

    private final Optional<Money> roundingAdjustmentIncludedMoney;

    private final Map<String, Object> additionalProperties;

    private InvoicePaymentRequest(
            Optional<String> uid,
            Optional<InvoiceRequestMethod> requestMethod,
            Optional<InvoiceRequestType> requestType,
            Optional<String> dueDate,
            Optional<Money> fixedAmountRequestedMoney,
            Optional<String> percentageRequested,
            Optional<Boolean> tippingEnabled,
            Optional<InvoiceAutomaticPaymentSource> automaticPaymentSource,
            Optional<String> cardId,
            Optional<List<InvoicePaymentReminder>> reminders,
            Optional<Money> computedAmountMoney,
            Optional<Money> totalCompletedAmountMoney,
            Optional<Money> roundingAdjustmentIncludedMoney,
            Map<String, Object> additionalProperties) {
        this.uid = uid;
        this.requestMethod = requestMethod;
        this.requestType = requestType;
        this.dueDate = dueDate;
        this.fixedAmountRequestedMoney = fixedAmountRequestedMoney;
        this.percentageRequested = percentageRequested;
        this.tippingEnabled = tippingEnabled;
        this.automaticPaymentSource = automaticPaymentSource;
        this.cardId = cardId;
        this.reminders = reminders;
        this.computedAmountMoney = computedAmountMoney;
        this.totalCompletedAmountMoney = totalCompletedAmountMoney;
        this.roundingAdjustmentIncludedMoney = roundingAdjustmentIncludedMoney;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The Square-generated ID of the payment request in an <a href="entity:Invoice">invoice</a>.
     */
    @JsonIgnore
    public Optional<String> getUid() {
        if (uid == null) {
            return Optional.empty();
        }
        return uid;
    }

    /**
     * @return Indicates how Square processes the payment request. DEPRECATED at version 2021-01-21. Replaced by the
     * <code>Invoice.delivery_method</code> and <code>InvoicePaymentRequest.automatic_payment_source</code> fields.
     * <p>One of the following is required when creating an invoice:</p>
     * <ul>
     * <li>(Recommended) The <code>delivery_method</code> field of the invoice. To configure an automatic payment, the
     * <code>automatic_payment_source</code> field of the payment request is also required.</li>
     * <li>This <code>request_method</code> field. Note that <code>invoice</code> objects returned in responses do not include <code>request_method</code>.
     * See <a href="#type-invoicerequestmethod">InvoiceRequestMethod</a> for possible values</li>
     * </ul>
     */
    @JsonProperty("request_method")
    public Optional<InvoiceRequestMethod> getRequestMethod() {
        return requestMethod;
    }

    /**
     * @return Identifies the payment request type. This type defines how the payment request amount is determined.
     * This field is required to create a payment request.
     * See <a href="#type-invoicerequesttype">InvoiceRequestType</a> for possible values
     */
    @JsonProperty("request_type")
    public Optional<InvoiceRequestType> getRequestType() {
        return requestType;
    }

    /**
     * @return The due date (in the invoice's time zone) for the payment request, in <code>YYYY-MM-DD</code> format. This field
     * is required to create a payment request. If an <code>automatic_payment_source</code> is defined for the request, Square
     * charges the payment source on this date.
     * <p>After this date, the invoice becomes overdue. For example, a payment <code>due_date</code> of 2021-03-09 with a <code>timezone</code>
     * of America/Los_Angeles becomes overdue at midnight on March 9 in America/Los_Angeles (which equals a UTC
     * timestamp of 2021-03-10T08:00:00Z).</p>
     */
    @JsonIgnore
    public Optional<String> getDueDate() {
        if (dueDate == null) {
            return Optional.empty();
        }
        return dueDate;
    }

    /**
     * @return If the payment request specifies <code>DEPOSIT</code> or <code>INSTALLMENT</code> as the <code>request_type</code>,
     * this indicates the request amount.
     * You cannot specify this when <code>request_type</code> is <code>BALANCE</code> or when the
     * payment request includes the <code>percentage_requested</code> field.
     */
    @JsonProperty("fixed_amount_requested_money")
    public Optional<Money> getFixedAmountRequestedMoney() {
        return fixedAmountRequestedMoney;
    }

    /**
     * @return Specifies the amount for the payment request in percentage:
     * <ul>
     * <li>When the payment <code>request_type</code> is <code>DEPOSIT</code>, it is the percentage of the order's total amount.</li>
     * <li>When the payment <code>request_type</code> is <code>INSTALLMENT</code>, it is the percentage of the order's total less
     * the deposit, if requested. The sum of the <code>percentage_requested</code> in all installment
     * payment requests must be equal to 100.</li>
     * </ul>
     * <p>You cannot specify this when the payment <code>request_type</code> is <code>BALANCE</code> or when the
     * payment request specifies the <code>fixed_amount_requested_money</code> field.</p>
     */
    @JsonIgnore
    public Optional<String> getPercentageRequested() {
        if (percentageRequested == null) {
            return Optional.empty();
        }
        return percentageRequested;
    }

    /**
     * @return If set to true, the Square-hosted invoice page (the <code>public_url</code> field of the invoice)
     * provides a place for the customer to pay a tip.
     * <p>This field is allowed only on the final payment request
     * and the payment <code>request_type</code> must be <code>BALANCE</code> or <code>INSTALLMENT</code>.</p>
     */
    @JsonIgnore
    public Optional<Boolean> getTippingEnabled() {
        if (tippingEnabled == null) {
            return Optional.empty();
        }
        return tippingEnabled;
    }

    /**
     * @return The payment method for an automatic payment.
     * <p>The default value is <code>NONE</code>.
     * See <a href="#type-invoiceautomaticpaymentsource">InvoiceAutomaticPaymentSource</a> for possible values</p>
     */
    @JsonProperty("automatic_payment_source")
    public Optional<InvoiceAutomaticPaymentSource> getAutomaticPaymentSource() {
        return automaticPaymentSource;
    }

    /**
     * @return The ID of the credit or debit card on file to charge for the payment request. To get the cards on file for a customer,
     * call <a href="api-endpoint:Cards-ListCards">ListCards</a> and include the <code>customer_id</code> of the invoice recipient.
     */
    @JsonIgnore
    public Optional<String> getCardId() {
        if (cardId == null) {
            return Optional.empty();
        }
        return cardId;
    }

    /**
     * @return A list of one or more reminders to send for the payment request.
     */
    @JsonIgnore
    public Optional<List<InvoicePaymentReminder>> getReminders() {
        if (reminders == null) {
            return Optional.empty();
        }
        return reminders;
    }

    /**
     * @return The amount of the payment request, computed using the order amount and information from the various payment
     * request fields (<code>request_type</code>, <code>fixed_amount_requested_money</code>, and <code>percentage_requested</code>).
     */
    @JsonProperty("computed_amount_money")
    public Optional<Money> getComputedAmountMoney() {
        return computedAmountMoney;
    }

    /**
     * @return The amount of money already paid for the specific payment request.
     * This amount might include a rounding adjustment if the most recent invoice payment
     * was in cash in a currency that rounds cash payments (such as, <code>CAD</code> or <code>AUD</code>).
     */
    @JsonProperty("total_completed_amount_money")
    public Optional<Money> getTotalCompletedAmountMoney() {
        return totalCompletedAmountMoney;
    }

    /**
     * @return If the most recent payment was a cash payment
     * in a currency that rounds cash payments (such as, <code>CAD</code> or <code>AUD</code>) and the payment
     * is rounded from <code>computed_amount_money</code> in the payment request, then this
     * field specifies the rounding adjustment applied. This amount
     * might be negative.
     */
    @JsonProperty("rounding_adjustment_included_money")
    public Optional<Money> getRoundingAdjustmentIncludedMoney() {
        return roundingAdjustmentIncludedMoney;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("uid")
    private Optional<String> _getUid() {
        return uid;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("due_date")
    private Optional<String> _getDueDate() {
        return dueDate;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("percentage_requested")
    private Optional<String> _getPercentageRequested() {
        return percentageRequested;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("tipping_enabled")
    private Optional<Boolean> _getTippingEnabled() {
        return tippingEnabled;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("card_id")
    private Optional<String> _getCardId() {
        return cardId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("reminders")
    private Optional<List<InvoicePaymentReminder>> _getReminders() {
        return reminders;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof InvoicePaymentRequest && equalTo((InvoicePaymentRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(InvoicePaymentRequest other) {
        return uid.equals(other.uid)
                && requestMethod.equals(other.requestMethod)
                && requestType.equals(other.requestType)
                && dueDate.equals(other.dueDate)
                && fixedAmountRequestedMoney.equals(other.fixedAmountRequestedMoney)
                && percentageRequested.equals(other.percentageRequested)
                && tippingEnabled.equals(other.tippingEnabled)
                && automaticPaymentSource.equals(other.automaticPaymentSource)
                && cardId.equals(other.cardId)
                && reminders.equals(other.reminders)
                && computedAmountMoney.equals(other.computedAmountMoney)
                && totalCompletedAmountMoney.equals(other.totalCompletedAmountMoney)
                && roundingAdjustmentIncludedMoney.equals(other.roundingAdjustmentIncludedMoney);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.uid,
                this.requestMethod,
                this.requestType,
                this.dueDate,
                this.fixedAmountRequestedMoney,
                this.percentageRequested,
                this.tippingEnabled,
                this.automaticPaymentSource,
                this.cardId,
                this.reminders,
                this.computedAmountMoney,
                this.totalCompletedAmountMoney,
                this.roundingAdjustmentIncludedMoney);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> uid = Optional.empty();

        private Optional<InvoiceRequestMethod> requestMethod = Optional.empty();

        private Optional<InvoiceRequestType> requestType = Optional.empty();

        private Optional<String> dueDate = Optional.empty();

        private Optional<Money> fixedAmountRequestedMoney = Optional.empty();

        private Optional<String> percentageRequested = Optional.empty();

        private Optional<Boolean> tippingEnabled = Optional.empty();

        private Optional<InvoiceAutomaticPaymentSource> automaticPaymentSource = Optional.empty();

        private Optional<String> cardId = Optional.empty();

        private Optional<List<InvoicePaymentReminder>> reminders = Optional.empty();

        private Optional<Money> computedAmountMoney = Optional.empty();

        private Optional<Money> totalCompletedAmountMoney = Optional.empty();

        private Optional<Money> roundingAdjustmentIncludedMoney = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(InvoicePaymentRequest other) {
            uid(other.getUid());
            requestMethod(other.getRequestMethod());
            requestType(other.getRequestType());
            dueDate(other.getDueDate());
            fixedAmountRequestedMoney(other.getFixedAmountRequestedMoney());
            percentageRequested(other.getPercentageRequested());
            tippingEnabled(other.getTippingEnabled());
            automaticPaymentSource(other.getAutomaticPaymentSource());
            cardId(other.getCardId());
            reminders(other.getReminders());
            computedAmountMoney(other.getComputedAmountMoney());
            totalCompletedAmountMoney(other.getTotalCompletedAmountMoney());
            roundingAdjustmentIncludedMoney(other.getRoundingAdjustmentIncludedMoney());
            return this;
        }

        /**
         * <p>The Square-generated ID of the payment request in an <a href="entity:Invoice">invoice</a>.</p>
         */
        @JsonSetter(value = "uid", nulls = Nulls.SKIP)
        public Builder uid(Optional<String> uid) {
            this.uid = uid;
            return this;
        }

        public Builder uid(String uid) {
            this.uid = Optional.ofNullable(uid);
            return this;
        }

        public Builder uid(Nullable<String> uid) {
            if (uid.isNull()) {
                this.uid = null;
            } else if (uid.isEmpty()) {
                this.uid = Optional.empty();
            } else {
                this.uid = Optional.of(uid.get());
            }
            return this;
        }

        /**
         * <p>Indicates how Square processes the payment request. DEPRECATED at version 2021-01-21. Replaced by the
         * <code>Invoice.delivery_method</code> and <code>InvoicePaymentRequest.automatic_payment_source</code> fields.</p>
         * <p>One of the following is required when creating an invoice:</p>
         * <ul>
         * <li>(Recommended) The <code>delivery_method</code> field of the invoice. To configure an automatic payment, the
         * <code>automatic_payment_source</code> field of the payment request is also required.</li>
         * <li>This <code>request_method</code> field. Note that <code>invoice</code> objects returned in responses do not include <code>request_method</code>.
         * See <a href="#type-invoicerequestmethod">InvoiceRequestMethod</a> for possible values</li>
         * </ul>
         */
        @JsonSetter(value = "request_method", nulls = Nulls.SKIP)
        public Builder requestMethod(Optional<InvoiceRequestMethod> requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }

        public Builder requestMethod(InvoiceRequestMethod requestMethod) {
            this.requestMethod = Optional.ofNullable(requestMethod);
            return this;
        }

        /**
         * <p>Identifies the payment request type. This type defines how the payment request amount is determined.
         * This field is required to create a payment request.
         * See <a href="#type-invoicerequesttype">InvoiceRequestType</a> for possible values</p>
         */
        @JsonSetter(value = "request_type", nulls = Nulls.SKIP)
        public Builder requestType(Optional<InvoiceRequestType> requestType) {
            this.requestType = requestType;
            return this;
        }

        public Builder requestType(InvoiceRequestType requestType) {
            this.requestType = Optional.ofNullable(requestType);
            return this;
        }

        /**
         * <p>The due date (in the invoice's time zone) for the payment request, in <code>YYYY-MM-DD</code> format. This field
         * is required to create a payment request. If an <code>automatic_payment_source</code> is defined for the request, Square
         * charges the payment source on this date.</p>
         * <p>After this date, the invoice becomes overdue. For example, a payment <code>due_date</code> of 2021-03-09 with a <code>timezone</code>
         * of America/Los_Angeles becomes overdue at midnight on March 9 in America/Los_Angeles (which equals a UTC
         * timestamp of 2021-03-10T08:00:00Z).</p>
         */
        @JsonSetter(value = "due_date", nulls = Nulls.SKIP)
        public Builder dueDate(Optional<String> dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder dueDate(String dueDate) {
            this.dueDate = Optional.ofNullable(dueDate);
            return this;
        }

        public Builder dueDate(Nullable<String> dueDate) {
            if (dueDate.isNull()) {
                this.dueDate = null;
            } else if (dueDate.isEmpty()) {
                this.dueDate = Optional.empty();
            } else {
                this.dueDate = Optional.of(dueDate.get());
            }
            return this;
        }

        /**
         * <p>If the payment request specifies <code>DEPOSIT</code> or <code>INSTALLMENT</code> as the <code>request_type</code>,
         * this indicates the request amount.
         * You cannot specify this when <code>request_type</code> is <code>BALANCE</code> or when the
         * payment request includes the <code>percentage_requested</code> field.</p>
         */
        @JsonSetter(value = "fixed_amount_requested_money", nulls = Nulls.SKIP)
        public Builder fixedAmountRequestedMoney(Optional<Money> fixedAmountRequestedMoney) {
            this.fixedAmountRequestedMoney = fixedAmountRequestedMoney;
            return this;
        }

        public Builder fixedAmountRequestedMoney(Money fixedAmountRequestedMoney) {
            this.fixedAmountRequestedMoney = Optional.ofNullable(fixedAmountRequestedMoney);
            return this;
        }

        /**
         * <p>Specifies the amount for the payment request in percentage:</p>
         * <ul>
         * <li>When the payment <code>request_type</code> is <code>DEPOSIT</code>, it is the percentage of the order's total amount.</li>
         * <li>When the payment <code>request_type</code> is <code>INSTALLMENT</code>, it is the percentage of the order's total less
         * the deposit, if requested. The sum of the <code>percentage_requested</code> in all installment
         * payment requests must be equal to 100.</li>
         * </ul>
         * <p>You cannot specify this when the payment <code>request_type</code> is <code>BALANCE</code> or when the
         * payment request specifies the <code>fixed_amount_requested_money</code> field.</p>
         */
        @JsonSetter(value = "percentage_requested", nulls = Nulls.SKIP)
        public Builder percentageRequested(Optional<String> percentageRequested) {
            this.percentageRequested = percentageRequested;
            return this;
        }

        public Builder percentageRequested(String percentageRequested) {
            this.percentageRequested = Optional.ofNullable(percentageRequested);
            return this;
        }

        public Builder percentageRequested(Nullable<String> percentageRequested) {
            if (percentageRequested.isNull()) {
                this.percentageRequested = null;
            } else if (percentageRequested.isEmpty()) {
                this.percentageRequested = Optional.empty();
            } else {
                this.percentageRequested = Optional.of(percentageRequested.get());
            }
            return this;
        }

        /**
         * <p>If set to true, the Square-hosted invoice page (the <code>public_url</code> field of the invoice)
         * provides a place for the customer to pay a tip.</p>
         * <p>This field is allowed only on the final payment request
         * and the payment <code>request_type</code> must be <code>BALANCE</code> or <code>INSTALLMENT</code>.</p>
         */
        @JsonSetter(value = "tipping_enabled", nulls = Nulls.SKIP)
        public Builder tippingEnabled(Optional<Boolean> tippingEnabled) {
            this.tippingEnabled = tippingEnabled;
            return this;
        }

        public Builder tippingEnabled(Boolean tippingEnabled) {
            this.tippingEnabled = Optional.ofNullable(tippingEnabled);
            return this;
        }

        public Builder tippingEnabled(Nullable<Boolean> tippingEnabled) {
            if (tippingEnabled.isNull()) {
                this.tippingEnabled = null;
            } else if (tippingEnabled.isEmpty()) {
                this.tippingEnabled = Optional.empty();
            } else {
                this.tippingEnabled = Optional.of(tippingEnabled.get());
            }
            return this;
        }

        /**
         * <p>The payment method for an automatic payment.</p>
         * <p>The default value is <code>NONE</code>.
         * See <a href="#type-invoiceautomaticpaymentsource">InvoiceAutomaticPaymentSource</a> for possible values</p>
         */
        @JsonSetter(value = "automatic_payment_source", nulls = Nulls.SKIP)
        public Builder automaticPaymentSource(Optional<InvoiceAutomaticPaymentSource> automaticPaymentSource) {
            this.automaticPaymentSource = automaticPaymentSource;
            return this;
        }

        public Builder automaticPaymentSource(InvoiceAutomaticPaymentSource automaticPaymentSource) {
            this.automaticPaymentSource = Optional.ofNullable(automaticPaymentSource);
            return this;
        }

        /**
         * <p>The ID of the credit or debit card on file to charge for the payment request. To get the cards on file for a customer,
         * call <a href="api-endpoint:Cards-ListCards">ListCards</a> and include the <code>customer_id</code> of the invoice recipient.</p>
         */
        @JsonSetter(value = "card_id", nulls = Nulls.SKIP)
        public Builder cardId(Optional<String> cardId) {
            this.cardId = cardId;
            return this;
        }

        public Builder cardId(String cardId) {
            this.cardId = Optional.ofNullable(cardId);
            return this;
        }

        public Builder cardId(Nullable<String> cardId) {
            if (cardId.isNull()) {
                this.cardId = null;
            } else if (cardId.isEmpty()) {
                this.cardId = Optional.empty();
            } else {
                this.cardId = Optional.of(cardId.get());
            }
            return this;
        }

        /**
         * <p>A list of one or more reminders to send for the payment request.</p>
         */
        @JsonSetter(value = "reminders", nulls = Nulls.SKIP)
        public Builder reminders(Optional<List<InvoicePaymentReminder>> reminders) {
            this.reminders = reminders;
            return this;
        }

        public Builder reminders(List<InvoicePaymentReminder> reminders) {
            this.reminders = Optional.ofNullable(reminders);
            return this;
        }

        public Builder reminders(Nullable<List<InvoicePaymentReminder>> reminders) {
            if (reminders.isNull()) {
                this.reminders = null;
            } else if (reminders.isEmpty()) {
                this.reminders = Optional.empty();
            } else {
                this.reminders = Optional.of(reminders.get());
            }
            return this;
        }

        /**
         * <p>The amount of the payment request, computed using the order amount and information from the various payment
         * request fields (<code>request_type</code>, <code>fixed_amount_requested_money</code>, and <code>percentage_requested</code>).</p>
         */
        @JsonSetter(value = "computed_amount_money", nulls = Nulls.SKIP)
        public Builder computedAmountMoney(Optional<Money> computedAmountMoney) {
            this.computedAmountMoney = computedAmountMoney;
            return this;
        }

        public Builder computedAmountMoney(Money computedAmountMoney) {
            this.computedAmountMoney = Optional.ofNullable(computedAmountMoney);
            return this;
        }

        /**
         * <p>The amount of money already paid for the specific payment request.
         * This amount might include a rounding adjustment if the most recent invoice payment
         * was in cash in a currency that rounds cash payments (such as, <code>CAD</code> or <code>AUD</code>).</p>
         */
        @JsonSetter(value = "total_completed_amount_money", nulls = Nulls.SKIP)
        public Builder totalCompletedAmountMoney(Optional<Money> totalCompletedAmountMoney) {
            this.totalCompletedAmountMoney = totalCompletedAmountMoney;
            return this;
        }

        public Builder totalCompletedAmountMoney(Money totalCompletedAmountMoney) {
            this.totalCompletedAmountMoney = Optional.ofNullable(totalCompletedAmountMoney);
            return this;
        }

        /**
         * <p>If the most recent payment was a cash payment
         * in a currency that rounds cash payments (such as, <code>CAD</code> or <code>AUD</code>) and the payment
         * is rounded from <code>computed_amount_money</code> in the payment request, then this
         * field specifies the rounding adjustment applied. This amount
         * might be negative.</p>
         */
        @JsonSetter(value = "rounding_adjustment_included_money", nulls = Nulls.SKIP)
        public Builder roundingAdjustmentIncludedMoney(Optional<Money> roundingAdjustmentIncludedMoney) {
            this.roundingAdjustmentIncludedMoney = roundingAdjustmentIncludedMoney;
            return this;
        }

        public Builder roundingAdjustmentIncludedMoney(Money roundingAdjustmentIncludedMoney) {
            this.roundingAdjustmentIncludedMoney = Optional.ofNullable(roundingAdjustmentIncludedMoney);
            return this;
        }

        public InvoicePaymentRequest build() {
            return new InvoicePaymentRequest(
                    uid,
                    requestMethod,
                    requestType,
                    dueDate,
                    fixedAmountRequestedMoney,
                    percentageRequested,
                    tippingEnabled,
                    automaticPaymentSource,
                    cardId,
                    reminders,
                    computedAmountMoney,
                    totalCompletedAmountMoney,
                    roundingAdjustmentIncludedMoney,
                    additionalProperties);
        }
    }
}
