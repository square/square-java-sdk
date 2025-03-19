package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for InvoicePaymentRequest type.
 */
public class InvoicePaymentRequest {
    private final OptionalNullable<String> uid;
    private final String requestMethod;
    private final String requestType;
    private final OptionalNullable<String> dueDate;
    private final Money fixedAmountRequestedMoney;
    private final OptionalNullable<String> percentageRequested;
    private final OptionalNullable<Boolean> tippingEnabled;
    private final String automaticPaymentSource;
    private final OptionalNullable<String> cardId;
    private final OptionalNullable<List<InvoicePaymentReminder>> reminders;
    private final Money computedAmountMoney;
    private final Money totalCompletedAmountMoney;
    private final Money roundingAdjustmentIncludedMoney;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  requestMethod  String value for requestMethod.
     * @param  requestType  String value for requestType.
     * @param  dueDate  String value for dueDate.
     * @param  fixedAmountRequestedMoney  Money value for fixedAmountRequestedMoney.
     * @param  percentageRequested  String value for percentageRequested.
     * @param  tippingEnabled  Boolean value for tippingEnabled.
     * @param  automaticPaymentSource  String value for automaticPaymentSource.
     * @param  cardId  String value for cardId.
     * @param  reminders  List of InvoicePaymentReminder value for reminders.
     * @param  computedAmountMoney  Money value for computedAmountMoney.
     * @param  totalCompletedAmountMoney  Money value for totalCompletedAmountMoney.
     * @param  roundingAdjustmentIncludedMoney  Money value for roundingAdjustmentIncludedMoney.
     */
    @JsonCreator
    public InvoicePaymentRequest(
            @JsonProperty("uid") String uid,
            @JsonProperty("request_method") String requestMethod,
            @JsonProperty("request_type") String requestType,
            @JsonProperty("due_date") String dueDate,
            @JsonProperty("fixed_amount_requested_money") Money fixedAmountRequestedMoney,
            @JsonProperty("percentage_requested") String percentageRequested,
            @JsonProperty("tipping_enabled") Boolean tippingEnabled,
            @JsonProperty("automatic_payment_source") String automaticPaymentSource,
            @JsonProperty("card_id") String cardId,
            @JsonProperty("reminders") List<InvoicePaymentReminder> reminders,
            @JsonProperty("computed_amount_money") Money computedAmountMoney,
            @JsonProperty("total_completed_amount_money") Money totalCompletedAmountMoney,
            @JsonProperty("rounding_adjustment_included_money") Money roundingAdjustmentIncludedMoney) {
        this.uid = OptionalNullable.of(uid);
        this.requestMethod = requestMethod;
        this.requestType = requestType;
        this.dueDate = OptionalNullable.of(dueDate);
        this.fixedAmountRequestedMoney = fixedAmountRequestedMoney;
        this.percentageRequested = OptionalNullable.of(percentageRequested);
        this.tippingEnabled = OptionalNullable.of(tippingEnabled);
        this.automaticPaymentSource = automaticPaymentSource;
        this.cardId = OptionalNullable.of(cardId);
        this.reminders = OptionalNullable.of(reminders);
        this.computedAmountMoney = computedAmountMoney;
        this.totalCompletedAmountMoney = totalCompletedAmountMoney;
        this.roundingAdjustmentIncludedMoney = roundingAdjustmentIncludedMoney;
    }

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  requestMethod  String value for requestMethod.
     * @param  requestType  String value for requestType.
     * @param  dueDate  String value for dueDate.
     * @param  fixedAmountRequestedMoney  Money value for fixedAmountRequestedMoney.
     * @param  percentageRequested  String value for percentageRequested.
     * @param  tippingEnabled  Boolean value for tippingEnabled.
     * @param  automaticPaymentSource  String value for automaticPaymentSource.
     * @param  cardId  String value for cardId.
     * @param  reminders  List of InvoicePaymentReminder value for reminders.
     * @param  computedAmountMoney  Money value for computedAmountMoney.
     * @param  totalCompletedAmountMoney  Money value for totalCompletedAmountMoney.
     * @param  roundingAdjustmentIncludedMoney  Money value for roundingAdjustmentIncludedMoney.
     */
    protected InvoicePaymentRequest(
            OptionalNullable<String> uid,
            String requestMethod,
            String requestType,
            OptionalNullable<String> dueDate,
            Money fixedAmountRequestedMoney,
            OptionalNullable<String> percentageRequested,
            OptionalNullable<Boolean> tippingEnabled,
            String automaticPaymentSource,
            OptionalNullable<String> cardId,
            OptionalNullable<List<InvoicePaymentReminder>> reminders,
            Money computedAmountMoney,
            Money totalCompletedAmountMoney,
            Money roundingAdjustmentIncludedMoney) {
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
    }

    /**
     * Internal Getter for Uid.
     * The Square-generated ID of the payment request in an [invoice](entity:Invoice).
     * @return Returns the Internal String
     */
    @JsonGetter("uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetUid() {
        return this.uid;
    }

    /**
     * Getter for Uid.
     * The Square-generated ID of the payment request in an [invoice](entity:Invoice).
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Getter for RequestMethod.
     * Specifies the action for Square to take for processing the invoice. For example, email the
     * invoice, charge a customer's card on file, or do nothing. DEPRECATED at version 2021-01-21.
     * The corresponding `request_method` field is replaced by the `Invoice.delivery_method` and
     * `InvoicePaymentRequest.automatic_payment_source` fields.
     * @return Returns the String
     */
    @JsonGetter("request_method")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRequestMethod() {
        return requestMethod;
    }

    /**
     * Getter for RequestType.
     * Indicates the type of the payment request. For more information, see [Configuring payment
     * requests](https://developer.squareup.com/docs/invoices-api/create-publish-invoices#payment-requests).
     * @return Returns the String
     */
    @JsonGetter("request_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRequestType() {
        return requestType;
    }

    /**
     * Internal Getter for DueDate.
     * The due date (in the invoice's time zone) for the payment request, in `YYYY-MM-DD` format.
     * This field is required to create a payment request. If an `automatic_payment_source` is
     * defined for the request, Square charges the payment source on this date. After this date, the
     * invoice becomes overdue. For example, a payment `due_date` of 2021-03-09 with a `timezone` of
     * America/Los\\_Angeles becomes overdue at midnight on March 9 in America/Los\\_Angeles (which
     * equals a UTC timestamp of 2021-03-10T08:00:00Z).
     * @return Returns the Internal String
     */
    @JsonGetter("due_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDueDate() {
        return this.dueDate;
    }

    /**
     * Getter for DueDate.
     * The due date (in the invoice's time zone) for the payment request, in `YYYY-MM-DD` format.
     * This field is required to create a payment request. If an `automatic_payment_source` is
     * defined for the request, Square charges the payment source on this date. After this date, the
     * invoice becomes overdue. For example, a payment `due_date` of 2021-03-09 with a `timezone` of
     * America/Los\\_Angeles becomes overdue at midnight on March 9 in America/Los\\_Angeles (which
     * equals a UTC timestamp of 2021-03-10T08:00:00Z).
     * @return Returns the String
     */
    @JsonIgnore
    public String getDueDate() {
        return OptionalNullable.getFrom(dueDate);
    }

    /**
     * Getter for FixedAmountRequestedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("fixed_amount_requested_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getFixedAmountRequestedMoney() {
        return fixedAmountRequestedMoney;
    }

    /**
     * Internal Getter for PercentageRequested.
     * Specifies the amount for the payment request in percentage: - When the payment `request_type`
     * is `DEPOSIT`, it is the percentage of the order's total amount. - When the payment
     * `request_type` is `INSTALLMENT`, it is the percentage of the order's total less the deposit,
     * if requested. The sum of the `percentage_requested` in all installment payment requests must
     * be equal to 100. You cannot specify this when the payment `request_type` is `BALANCE` or when
     * the payment request specifies the `fixed_amount_requested_money` field.
     * @return Returns the Internal String
     */
    @JsonGetter("percentage_requested")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPercentageRequested() {
        return this.percentageRequested;
    }

    /**
     * Getter for PercentageRequested.
     * Specifies the amount for the payment request in percentage: - When the payment `request_type`
     * is `DEPOSIT`, it is the percentage of the order's total amount. - When the payment
     * `request_type` is `INSTALLMENT`, it is the percentage of the order's total less the deposit,
     * if requested. The sum of the `percentage_requested` in all installment payment requests must
     * be equal to 100. You cannot specify this when the payment `request_type` is `BALANCE` or when
     * the payment request specifies the `fixed_amount_requested_money` field.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPercentageRequested() {
        return OptionalNullable.getFrom(percentageRequested);
    }

    /**
     * Internal Getter for TippingEnabled.
     * If set to true, the Square-hosted invoice page (the `public_url` field of the invoice)
     * provides a place for the customer to pay a tip. This field is allowed only on the final
     * payment request and the payment `request_type` must be `BALANCE` or `INSTALLMENT`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("tipping_enabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetTippingEnabled() {
        return this.tippingEnabled;
    }

    /**
     * Getter for TippingEnabled.
     * If set to true, the Square-hosted invoice page (the `public_url` field of the invoice)
     * provides a place for the customer to pay a tip. This field is allowed only on the final
     * payment request and the payment `request_type` must be `BALANCE` or `INSTALLMENT`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getTippingEnabled() {
        return OptionalNullable.getFrom(tippingEnabled);
    }

    /**
     * Getter for AutomaticPaymentSource.
     * Indicates the automatic payment method for an [invoice payment
     * request]($m/InvoicePaymentRequest).
     * @return Returns the String
     */
    @JsonGetter("automatic_payment_source")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAutomaticPaymentSource() {
        return automaticPaymentSource;
    }

    /**
     * Internal Getter for CardId.
     * The ID of the credit or debit card on file to charge for the payment request. To get the
     * cards on file for a customer, call [ListCards](api-endpoint:Cards-ListCards) and include the
     * `customer_id` of the invoice recipient.
     * @return Returns the Internal String
     */
    @JsonGetter("card_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCardId() {
        return this.cardId;
    }

    /**
     * Getter for CardId.
     * The ID of the credit or debit card on file to charge for the payment request. To get the
     * cards on file for a customer, call [ListCards](api-endpoint:Cards-ListCards) and include the
     * `customer_id` of the invoice recipient.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCardId() {
        return OptionalNullable.getFrom(cardId);
    }

    /**
     * Internal Getter for Reminders.
     * A list of one or more reminders to send for the payment request.
     * @return Returns the Internal List of InvoicePaymentReminder
     */
    @JsonGetter("reminders")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<InvoicePaymentReminder>> internalGetReminders() {
        return this.reminders;
    }

    /**
     * Getter for Reminders.
     * A list of one or more reminders to send for the payment request.
     * @return Returns the List of InvoicePaymentReminder
     */
    @JsonIgnore
    public List<InvoicePaymentReminder> getReminders() {
        return OptionalNullable.getFrom(reminders);
    }

    /**
     * Getter for ComputedAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("computed_amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getComputedAmountMoney() {
        return computedAmountMoney;
    }

    /**
     * Getter for TotalCompletedAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("total_completed_amount_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getTotalCompletedAmountMoney() {
        return totalCompletedAmountMoney;
    }

    /**
     * Getter for RoundingAdjustmentIncludedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("rounding_adjustment_included_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getRoundingAdjustmentIncludedMoney() {
        return roundingAdjustmentIncludedMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
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
                roundingAdjustmentIncludedMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InvoicePaymentRequest)) {
            return false;
        }
        InvoicePaymentRequest other = (InvoicePaymentRequest) obj;
        return Objects.equals(uid, other.uid)
                && Objects.equals(requestMethod, other.requestMethod)
                && Objects.equals(requestType, other.requestType)
                && Objects.equals(dueDate, other.dueDate)
                && Objects.equals(fixedAmountRequestedMoney, other.fixedAmountRequestedMoney)
                && Objects.equals(percentageRequested, other.percentageRequested)
                && Objects.equals(tippingEnabled, other.tippingEnabled)
                && Objects.equals(automaticPaymentSource, other.automaticPaymentSource)
                && Objects.equals(cardId, other.cardId)
                && Objects.equals(reminders, other.reminders)
                && Objects.equals(computedAmountMoney, other.computedAmountMoney)
                && Objects.equals(totalCompletedAmountMoney, other.totalCompletedAmountMoney)
                && Objects.equals(roundingAdjustmentIncludedMoney, other.roundingAdjustmentIncludedMoney);
    }

    /**
     * Converts this InvoicePaymentRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InvoicePaymentRequest [" + "uid=" + uid + ", requestMethod=" + requestMethod
                + ", requestType=" + requestType + ", dueDate=" + dueDate
                + ", fixedAmountRequestedMoney=" + fixedAmountRequestedMoney
                + ", percentageRequested=" + percentageRequested + ", tippingEnabled="
                + tippingEnabled + ", automaticPaymentSource=" + automaticPaymentSource
                + ", cardId=" + cardId + ", reminders=" + reminders + ", computedAmountMoney="
                + computedAmountMoney + ", totalCompletedAmountMoney=" + totalCompletedAmountMoney
                + ", roundingAdjustmentIncludedMoney=" + roundingAdjustmentIncludedMoney + "]";
    }

    /**
     * Builds a new {@link InvoicePaymentRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoicePaymentRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .requestMethod(getRequestMethod())
                .requestType(getRequestType())
                .fixedAmountRequestedMoney(getFixedAmountRequestedMoney())
                .automaticPaymentSource(getAutomaticPaymentSource())
                .computedAmountMoney(getComputedAmountMoney())
                .totalCompletedAmountMoney(getTotalCompletedAmountMoney())
                .roundingAdjustmentIncludedMoney(getRoundingAdjustmentIncludedMoney());
        builder.uid = internalGetUid();
        builder.dueDate = internalGetDueDate();
        builder.percentageRequested = internalGetPercentageRequested();
        builder.tippingEnabled = internalGetTippingEnabled();
        builder.cardId = internalGetCardId();
        builder.reminders = internalGetReminders();
        return builder;
    }

    /**
     * Class to build instances of {@link InvoicePaymentRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private String requestMethod;
        private String requestType;
        private OptionalNullable<String> dueDate;
        private Money fixedAmountRequestedMoney;
        private OptionalNullable<String> percentageRequested;
        private OptionalNullable<Boolean> tippingEnabled;
        private String automaticPaymentSource;
        private OptionalNullable<String> cardId;
        private OptionalNullable<List<InvoicePaymentReminder>> reminders;
        private Money computedAmountMoney;
        private Money totalCompletedAmountMoney;
        private Money roundingAdjustmentIncludedMoney;

        /**
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = OptionalNullable.of(uid);
            return this;
        }

        /**
         * UnSetter for uid.
         * @return Builder
         */
        public Builder unsetUid() {
            uid = null;
            return this;
        }

        /**
         * Setter for requestMethod.
         * @param  requestMethod  String value for requestMethod.
         * @return Builder
         */
        public Builder requestMethod(String requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }

        /**
         * Setter for requestType.
         * @param  requestType  String value for requestType.
         * @return Builder
         */
        public Builder requestType(String requestType) {
            this.requestType = requestType;
            return this;
        }

        /**
         * Setter for dueDate.
         * @param  dueDate  String value for dueDate.
         * @return Builder
         */
        public Builder dueDate(String dueDate) {
            this.dueDate = OptionalNullable.of(dueDate);
            return this;
        }

        /**
         * UnSetter for dueDate.
         * @return Builder
         */
        public Builder unsetDueDate() {
            dueDate = null;
            return this;
        }

        /**
         * Setter for fixedAmountRequestedMoney.
         * @param  fixedAmountRequestedMoney  Money value for fixedAmountRequestedMoney.
         * @return Builder
         */
        public Builder fixedAmountRequestedMoney(Money fixedAmountRequestedMoney) {
            this.fixedAmountRequestedMoney = fixedAmountRequestedMoney;
            return this;
        }

        /**
         * Setter for percentageRequested.
         * @param  percentageRequested  String value for percentageRequested.
         * @return Builder
         */
        public Builder percentageRequested(String percentageRequested) {
            this.percentageRequested = OptionalNullable.of(percentageRequested);
            return this;
        }

        /**
         * UnSetter for percentageRequested.
         * @return Builder
         */
        public Builder unsetPercentageRequested() {
            percentageRequested = null;
            return this;
        }

        /**
         * Setter for tippingEnabled.
         * @param  tippingEnabled  Boolean value for tippingEnabled.
         * @return Builder
         */
        public Builder tippingEnabled(Boolean tippingEnabled) {
            this.tippingEnabled = OptionalNullable.of(tippingEnabled);
            return this;
        }

        /**
         * UnSetter for tippingEnabled.
         * @return Builder
         */
        public Builder unsetTippingEnabled() {
            tippingEnabled = null;
            return this;
        }

        /**
         * Setter for automaticPaymentSource.
         * @param  automaticPaymentSource  String value for automaticPaymentSource.
         * @return Builder
         */
        public Builder automaticPaymentSource(String automaticPaymentSource) {
            this.automaticPaymentSource = automaticPaymentSource;
            return this;
        }

        /**
         * Setter for cardId.
         * @param  cardId  String value for cardId.
         * @return Builder
         */
        public Builder cardId(String cardId) {
            this.cardId = OptionalNullable.of(cardId);
            return this;
        }

        /**
         * UnSetter for cardId.
         * @return Builder
         */
        public Builder unsetCardId() {
            cardId = null;
            return this;
        }

        /**
         * Setter for reminders.
         * @param  reminders  List of InvoicePaymentReminder value for reminders.
         * @return Builder
         */
        public Builder reminders(List<InvoicePaymentReminder> reminders) {
            this.reminders = OptionalNullable.of(reminders);
            return this;
        }

        /**
         * UnSetter for reminders.
         * @return Builder
         */
        public Builder unsetReminders() {
            reminders = null;
            return this;
        }

        /**
         * Setter for computedAmountMoney.
         * @param  computedAmountMoney  Money value for computedAmountMoney.
         * @return Builder
         */
        public Builder computedAmountMoney(Money computedAmountMoney) {
            this.computedAmountMoney = computedAmountMoney;
            return this;
        }

        /**
         * Setter for totalCompletedAmountMoney.
         * @param  totalCompletedAmountMoney  Money value for totalCompletedAmountMoney.
         * @return Builder
         */
        public Builder totalCompletedAmountMoney(Money totalCompletedAmountMoney) {
            this.totalCompletedAmountMoney = totalCompletedAmountMoney;
            return this;
        }

        /**
         * Setter for roundingAdjustmentIncludedMoney.
         * @param  roundingAdjustmentIncludedMoney  Money value for roundingAdjustmentIncludedMoney.
         * @return Builder
         */
        public Builder roundingAdjustmentIncludedMoney(Money roundingAdjustmentIncludedMoney) {
            this.roundingAdjustmentIncludedMoney = roundingAdjustmentIncludedMoney;
            return this;
        }

        /**
         * Builds a new {@link InvoicePaymentRequest} object using the set fields.
         * @return {@link InvoicePaymentRequest}
         */
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
                    roundingAdjustmentIncludedMoney);
        }
    }
}
