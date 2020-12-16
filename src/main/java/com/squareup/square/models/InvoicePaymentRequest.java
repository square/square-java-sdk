
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for InvoicePaymentRequest type.
 */
public class InvoicePaymentRequest {
    private final String uid;
    private final String requestMethod;
    private final String requestType;
    private final String dueDate;
    private final Money fixedAmountRequestedMoney;
    private final String percentageRequested;
    private final Boolean tippingEnabled;
    private final String cardId;
    private final List<InvoicePaymentReminder> reminders;
    private final Money computedAmountMoney;
    private final Money totalCompletedAmountMoney;
    private final Money roundingAdjustmentIncludedMoney;

    /**
     * Initialization constructor.
     * @param uid String value for uid.
     * @param requestMethod String value for requestMethod.
     * @param requestType String value for requestType.
     * @param dueDate String value for dueDate.
     * @param fixedAmountRequestedMoney Money value for fixedAmountRequestedMoney.
     * @param percentageRequested String value for percentageRequested.
     * @param tippingEnabled Boolean value for tippingEnabled.
     * @param cardId String value for cardId.
     * @param reminders List of InvoicePaymentReminder value for reminders.
     * @param computedAmountMoney Money value for computedAmountMoney.
     * @param totalCompletedAmountMoney Money value for totalCompletedAmountMoney.
     * @param roundingAdjustmentIncludedMoney Money value for roundingAdjustmentIncludedMoney.
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
            @JsonProperty("card_id") String cardId,
            @JsonProperty("reminders") List<InvoicePaymentReminder> reminders,
            @JsonProperty("computed_amount_money") Money computedAmountMoney,
            @JsonProperty("total_completed_amount_money") Money totalCompletedAmountMoney,
            @JsonProperty("rounding_adjustment_included_money") Money roundingAdjustmentIncludedMoney) {
        this.uid = uid;
        this.requestMethod = requestMethod;
        this.requestType = requestType;
        this.dueDate = dueDate;
        this.fixedAmountRequestedMoney = fixedAmountRequestedMoney;
        this.percentageRequested = percentageRequested;
        this.tippingEnabled = tippingEnabled;
        this.cardId = cardId;
        this.reminders = reminders;
        this.computedAmountMoney = computedAmountMoney;
        this.totalCompletedAmountMoney = totalCompletedAmountMoney;
        this.roundingAdjustmentIncludedMoney = roundingAdjustmentIncludedMoney;
    }

    /**
     * Getter for Uid.
     * The Square-generated ID of the payment request in an [invoice](#type-invoice).
     * @return Returns the String
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for RequestMethod.
     * Specifies the action for Square to take for processing the invoice. For example, email the
     * invoice, charge a customer's card on file, or do nothing.
     * @return Returns the String
     */
    @JsonGetter("request_method")
    public String getRequestMethod() {
        return this.requestMethod;
    }

    /**
     * Getter for RequestType.
     * Indicates the type of the payment request. An invoice supports the following payment request
     * combinations: - 1 balance - 1 deposit with 1 balance - 2 - 12 installments - 1 deposit with 2
     * - 12 installments For more information, see [Payment
     * requests](https://developer.squareup.com/docs/invoices-api/overview#payment-requests).
     * @return Returns the String
     */
    @JsonGetter("request_type")
    public String getRequestType() {
        return this.requestType;
    }

    /**
     * Getter for DueDate.
     * The due date (in the invoice location's time zone) for the payment request. After this date,
     * the invoice becomes overdue.
     * @return Returns the String
     */
    @JsonGetter("due_date")
    public String getDueDate() {
        return this.dueDate;
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
    public Money getFixedAmountRequestedMoney() {
        return this.fixedAmountRequestedMoney;
    }

    /**
     * Getter for PercentageRequested.
     * Specifies the amount for the payment request in percentage: - When the payment `request_type`
     * is `DEPOSIT`, it is the percentage of the order total amount. - When the payment
     * `request_type` is `INSTALLMENT`, it is the percentage of the order total less the deposit, if
     * requested. The sum of the `percentage_requested` in all installment payment requests must be
     * equal to 100. You cannot specify this when the payment `request_type` is `BALANCE` or when
     * the payment request specifies the `fixed_amount_requested_money` field.
     * @return Returns the String
     */
    @JsonGetter("percentage_requested")
    public String getPercentageRequested() {
        return this.percentageRequested;
    }

    /**
     * Getter for TippingEnabled.
     * If set to true, the Square-hosted invoice page (the `public_url` field of the invoice)
     * provides a place for the customer to pay a tip. This field is allowed only on the final
     * payment request and the payment `request_type` must be `BALANCE` or `INSTALLMENT`.
     * @return Returns the Boolean
     */
    @JsonGetter("tipping_enabled")
    public Boolean getTippingEnabled() {
        return this.tippingEnabled;
    }

    /**
     * Getter for CardId.
     * The ID of the card on file to charge for the payment request. To get the customer’s card on
     * file, use the `customer_id` of the invoice recipient to call
     * [RetrieveCustomer](#endpoint-Customers-RetrieveCustomer) in the Customers API. Then, get the
     * ID of the target card from the `cards` field in the response.
     * @return Returns the String
     */
    @JsonGetter("card_id")
    public String getCardId() {
        return this.cardId;
    }

    /**
     * Getter for Reminders.
     * A list of one or more reminders to send for the payment request.
     * @return Returns the List of InvoicePaymentReminder
     */
    @JsonGetter("reminders")
    public List<InvoicePaymentReminder> getReminders() {
        return this.reminders;
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
    public Money getComputedAmountMoney() {
        return this.computedAmountMoney;
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
    public Money getTotalCompletedAmountMoney() {
        return this.totalCompletedAmountMoney;
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
    public Money getRoundingAdjustmentIncludedMoney() {
        return this.roundingAdjustmentIncludedMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, requestMethod, requestType, dueDate, fixedAmountRequestedMoney,
                percentageRequested, tippingEnabled, cardId, reminders, computedAmountMoney,
                totalCompletedAmountMoney, roundingAdjustmentIncludedMoney);
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
            && Objects.equals(cardId, other.cardId)
            && Objects.equals(reminders, other.reminders)
            && Objects.equals(computedAmountMoney, other.computedAmountMoney)
            && Objects.equals(totalCompletedAmountMoney, other.totalCompletedAmountMoney)
            && Objects.equals(roundingAdjustmentIncludedMoney,
                    other.roundingAdjustmentIncludedMoney);
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
                + tippingEnabled + ", cardId=" + cardId + ", reminders=" + reminders
                + ", computedAmountMoney=" + computedAmountMoney + ", totalCompletedAmountMoney="
                + totalCompletedAmountMoney + ", roundingAdjustmentIncludedMoney="
                + roundingAdjustmentIncludedMoney + "]";
    }

    /**
     * Builds a new {@link InvoicePaymentRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoicePaymentRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .uid(getUid())
                .requestMethod(getRequestMethod())
                .requestType(getRequestType())
                .dueDate(getDueDate())
                .fixedAmountRequestedMoney(getFixedAmountRequestedMoney())
                .percentageRequested(getPercentageRequested())
                .tippingEnabled(getTippingEnabled())
                .cardId(getCardId())
                .reminders(getReminders())
                .computedAmountMoney(getComputedAmountMoney())
                .totalCompletedAmountMoney(getTotalCompletedAmountMoney())
                .roundingAdjustmentIncludedMoney(getRoundingAdjustmentIncludedMoney());
        return builder;
    }

    /**
     * Class to build instances of {@link InvoicePaymentRequest}.
     */
    public static class Builder {
        private String uid;
        private String requestMethod;
        private String requestType;
        private String dueDate;
        private Money fixedAmountRequestedMoney;
        private String percentageRequested;
        private Boolean tippingEnabled;
        private String cardId;
        private List<InvoicePaymentReminder> reminders;
        private Money computedAmountMoney;
        private Money totalCompletedAmountMoney;
        private Money roundingAdjustmentIncludedMoney;



        /**
         * Setter for uid.
         * @param uid String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }

        /**
         * Setter for requestMethod.
         * @param requestMethod String value for requestMethod.
         * @return Builder
         */
        public Builder requestMethod(String requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }

        /**
         * Setter for requestType.
         * @param requestType String value for requestType.
         * @return Builder
         */
        public Builder requestType(String requestType) {
            this.requestType = requestType;
            return this;
        }

        /**
         * Setter for dueDate.
         * @param dueDate String value for dueDate.
         * @return Builder
         */
        public Builder dueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        /**
         * Setter for fixedAmountRequestedMoney.
         * @param fixedAmountRequestedMoney Money value for fixedAmountRequestedMoney.
         * @return Builder
         */
        public Builder fixedAmountRequestedMoney(Money fixedAmountRequestedMoney) {
            this.fixedAmountRequestedMoney = fixedAmountRequestedMoney;
            return this;
        }

        /**
         * Setter for percentageRequested.
         * @param percentageRequested String value for percentageRequested.
         * @return Builder
         */
        public Builder percentageRequested(String percentageRequested) {
            this.percentageRequested = percentageRequested;
            return this;
        }

        /**
         * Setter for tippingEnabled.
         * @param tippingEnabled Boolean value for tippingEnabled.
         * @return Builder
         */
        public Builder tippingEnabled(Boolean tippingEnabled) {
            this.tippingEnabled = tippingEnabled;
            return this;
        }

        /**
         * Setter for cardId.
         * @param cardId String value for cardId.
         * @return Builder
         */
        public Builder cardId(String cardId) {
            this.cardId = cardId;
            return this;
        }

        /**
         * Setter for reminders.
         * @param reminders List of InvoicePaymentReminder value for reminders.
         * @return Builder
         */
        public Builder reminders(List<InvoicePaymentReminder> reminders) {
            this.reminders = reminders;
            return this;
        }

        /**
         * Setter for computedAmountMoney.
         * @param computedAmountMoney Money value for computedAmountMoney.
         * @return Builder
         */
        public Builder computedAmountMoney(Money computedAmountMoney) {
            this.computedAmountMoney = computedAmountMoney;
            return this;
        }

        /**
         * Setter for totalCompletedAmountMoney.
         * @param totalCompletedAmountMoney Money value for totalCompletedAmountMoney.
         * @return Builder
         */
        public Builder totalCompletedAmountMoney(Money totalCompletedAmountMoney) {
            this.totalCompletedAmountMoney = totalCompletedAmountMoney;
            return this;
        }

        /**
         * Setter for roundingAdjustmentIncludedMoney.
         * @param roundingAdjustmentIncludedMoney Money value for roundingAdjustmentIncludedMoney.
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
            return new InvoicePaymentRequest(uid, requestMethod, requestType, dueDate,
                    fixedAmountRequestedMoney, percentageRequested, tippingEnabled, cardId,
                    reminders, computedAmountMoney, totalCompletedAmountMoney,
                    roundingAdjustmentIncludedMoney);
        }
    }
}
