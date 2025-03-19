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
 * This is a model class for PaymentRefund type.
 */
public class PaymentRefund {
    private final String id;
    private final OptionalNullable<String> status;
    private final OptionalNullable<String> locationId;
    private final Boolean unlinked;
    private final OptionalNullable<String> destinationType;
    private final DestinationDetails destinationDetails;
    private final Money amountMoney;
    private final Money appFeeMoney;
    private final OptionalNullable<List<ProcessingFee>> processingFee;
    private final OptionalNullable<String> paymentId;
    private final OptionalNullable<String> orderId;
    private final OptionalNullable<String> reason;
    private final String createdAt;
    private final String updatedAt;
    private final String teamMemberId;
    private final String terminalRefundId;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  amountMoney  Money value for amountMoney.
     * @param  status  String value for status.
     * @param  locationId  String value for locationId.
     * @param  unlinked  Boolean value for unlinked.
     * @param  destinationType  String value for destinationType.
     * @param  destinationDetails  DestinationDetails value for destinationDetails.
     * @param  appFeeMoney  Money value for appFeeMoney.
     * @param  processingFee  List of ProcessingFee value for processingFee.
     * @param  paymentId  String value for paymentId.
     * @param  orderId  String value for orderId.
     * @param  reason  String value for reason.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  terminalRefundId  String value for terminalRefundId.
     */
    @JsonCreator
    public PaymentRefund(
            @JsonProperty("id") String id,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("status") String status,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("unlinked") Boolean unlinked,
            @JsonProperty("destination_type") String destinationType,
            @JsonProperty("destination_details") DestinationDetails destinationDetails,
            @JsonProperty("app_fee_money") Money appFeeMoney,
            @JsonProperty("processing_fee") List<ProcessingFee> processingFee,
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("reason") String reason,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("terminal_refund_id") String terminalRefundId) {
        this.id = id;
        this.status = OptionalNullable.of(status);
        this.locationId = OptionalNullable.of(locationId);
        this.unlinked = unlinked;
        this.destinationType = OptionalNullable.of(destinationType);
        this.destinationDetails = destinationDetails;
        this.amountMoney = amountMoney;
        this.appFeeMoney = appFeeMoney;
        this.processingFee = OptionalNullable.of(processingFee);
        this.paymentId = OptionalNullable.of(paymentId);
        this.orderId = OptionalNullable.of(orderId);
        this.reason = OptionalNullable.of(reason);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.teamMemberId = teamMemberId;
        this.terminalRefundId = terminalRefundId;
    }

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  amountMoney  Money value for amountMoney.
     * @param  status  String value for status.
     * @param  locationId  String value for locationId.
     * @param  unlinked  Boolean value for unlinked.
     * @param  destinationType  String value for destinationType.
     * @param  destinationDetails  DestinationDetails value for destinationDetails.
     * @param  appFeeMoney  Money value for appFeeMoney.
     * @param  processingFee  List of ProcessingFee value for processingFee.
     * @param  paymentId  String value for paymentId.
     * @param  orderId  String value for orderId.
     * @param  reason  String value for reason.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  terminalRefundId  String value for terminalRefundId.
     */
    protected PaymentRefund(
            String id,
            Money amountMoney,
            OptionalNullable<String> status,
            OptionalNullable<String> locationId,
            Boolean unlinked,
            OptionalNullable<String> destinationType,
            DestinationDetails destinationDetails,
            Money appFeeMoney,
            OptionalNullable<List<ProcessingFee>> processingFee,
            OptionalNullable<String> paymentId,
            OptionalNullable<String> orderId,
            OptionalNullable<String> reason,
            String createdAt,
            String updatedAt,
            String teamMemberId,
            String terminalRefundId) {
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
    }

    /**
     * Getter for Id.
     * The unique ID for this refund, generated by Square.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Internal Getter for Status.
     * The refund's status: - `PENDING` - Awaiting approval. - `COMPLETED` - Successfully completed.
     * - `REJECTED` - The refund was rejected. - `FAILED` - An error occurred.
     * @return Returns the Internal String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStatus() {
        return this.status;
    }

    /**
     * Getter for Status.
     * The refund's status: - `PENDING` - Awaiting approval. - `COMPLETED` - Successfully completed.
     * - `REJECTED` - The refund was rejected. - `FAILED` - An error occurred.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStatus() {
        return OptionalNullable.getFrom(status);
    }

    /**
     * Internal Getter for LocationId.
     * The location ID associated with the payment this refund is attached to.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * The location ID associated with the payment this refund is attached to.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Getter for Unlinked.
     * Flag indicating whether or not the refund is linked to an existing payment in Square.
     * @return Returns the Boolean
     */
    @JsonGetter("unlinked")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getUnlinked() {
        return unlinked;
    }

    /**
     * Internal Getter for DestinationType.
     * The destination type for this refund. Current values include `CARD`, `BANK_ACCOUNT`,
     * `WALLET`, `BUY_NOW_PAY_LATER`, `CASH`, `EXTERNAL`, and `SQUARE_ACCOUNT`.
     * @return Returns the Internal String
     */
    @JsonGetter("destination_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDestinationType() {
        return this.destinationType;
    }

    /**
     * Getter for DestinationType.
     * The destination type for this refund. Current values include `CARD`, `BANK_ACCOUNT`,
     * `WALLET`, `BUY_NOW_PAY_LATER`, `CASH`, `EXTERNAL`, and `SQUARE_ACCOUNT`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDestinationType() {
        return OptionalNullable.getFrom(destinationType);
    }

    /**
     * Getter for DestinationDetails.
     * Details about a refund's destination.
     * @return Returns the DestinationDetails
     */
    @JsonGetter("destination_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DestinationDetails getDestinationDetails() {
        return destinationDetails;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() {
        return amountMoney;
    }

    /**
     * Getter for AppFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("app_fee_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getAppFeeMoney() {
        return appFeeMoney;
    }

    /**
     * Internal Getter for ProcessingFee.
     * Processing fees and fee adjustments assessed by Square for this refund.
     * @return Returns the Internal List of ProcessingFee
     */
    @JsonGetter("processing_fee")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<ProcessingFee>> internalGetProcessingFee() {
        return this.processingFee;
    }

    /**
     * Getter for ProcessingFee.
     * Processing fees and fee adjustments assessed by Square for this refund.
     * @return Returns the List of ProcessingFee
     */
    @JsonIgnore
    public List<ProcessingFee> getProcessingFee() {
        return OptionalNullable.getFrom(processingFee);
    }

    /**
     * Internal Getter for PaymentId.
     * The ID of the payment associated with this refund.
     * @return Returns the Internal String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPaymentId() {
        return this.paymentId;
    }

    /**
     * Getter for PaymentId.
     * The ID of the payment associated with this refund.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPaymentId() {
        return OptionalNullable.getFrom(paymentId);
    }

    /**
     * Internal Getter for OrderId.
     * The ID of the order associated with the refund.
     * @return Returns the Internal String
     */
    @JsonGetter("order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOrderId() {
        return this.orderId;
    }

    /**
     * Getter for OrderId.
     * The ID of the order associated with the refund.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOrderId() {
        return OptionalNullable.getFrom(orderId);
    }

    /**
     * Internal Getter for Reason.
     * The reason for the refund.
     * @return Returns the Internal String
     */
    @JsonGetter("reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetReason() {
        return this.reason;
    }

    /**
     * Getter for Reason.
     * The reason for the refund.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReason() {
        return OptionalNullable.getFrom(reason);
    }

    /**
     * Getter for CreatedAt.
     * The timestamp of when the refund was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp of when the refund was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for TeamMemberId.
     * An optional ID of the team member associated with taking the payment.
     * @return Returns the String
     */
    @JsonGetter("team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Getter for TerminalRefundId.
     * An optional ID for a Terminal refund.
     * @return Returns the String
     */
    @JsonGetter("terminal_refund_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTerminalRefundId() {
        return terminalRefundId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
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
                terminalRefundId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentRefund)) {
            return false;
        }
        PaymentRefund other = (PaymentRefund) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(status, other.status)
                && Objects.equals(locationId, other.locationId)
                && Objects.equals(unlinked, other.unlinked)
                && Objects.equals(destinationType, other.destinationType)
                && Objects.equals(destinationDetails, other.destinationDetails)
                && Objects.equals(amountMoney, other.amountMoney)
                && Objects.equals(appFeeMoney, other.appFeeMoney)
                && Objects.equals(processingFee, other.processingFee)
                && Objects.equals(paymentId, other.paymentId)
                && Objects.equals(orderId, other.orderId)
                && Objects.equals(reason, other.reason)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(updatedAt, other.updatedAt)
                && Objects.equals(teamMemberId, other.teamMemberId)
                && Objects.equals(terminalRefundId, other.terminalRefundId);
    }

    /**
     * Converts this PaymentRefund into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentRefund [" + "id=" + id + ", amountMoney=" + amountMoney + ", status="
                + status + ", locationId=" + locationId + ", unlinked=" + unlinked
                + ", destinationType=" + destinationType + ", destinationDetails="
                + destinationDetails + ", appFeeMoney=" + appFeeMoney + ", processingFee="
                + processingFee + ", paymentId=" + paymentId + ", orderId=" + orderId + ", reason="
                + reason + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", teamMemberId=" + teamMemberId + ", terminalRefundId=" + terminalRefundId + "]";
    }

    /**
     * Builds a new {@link PaymentRefund.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentRefund.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id, amountMoney)
                .unlinked(getUnlinked())
                .destinationDetails(getDestinationDetails())
                .appFeeMoney(getAppFeeMoney())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .teamMemberId(getTeamMemberId())
                .terminalRefundId(getTerminalRefundId());
        builder.status = internalGetStatus();
        builder.locationId = internalGetLocationId();
        builder.destinationType = internalGetDestinationType();
        builder.processingFee = internalGetProcessingFee();
        builder.paymentId = internalGetPaymentId();
        builder.orderId = internalGetOrderId();
        builder.reason = internalGetReason();
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentRefund}.
     */
    public static class Builder {
        private String id;
        private Money amountMoney;
        private OptionalNullable<String> status;
        private OptionalNullable<String> locationId;
        private Boolean unlinked;
        private OptionalNullable<String> destinationType;
        private DestinationDetails destinationDetails;
        private Money appFeeMoney;
        private OptionalNullable<List<ProcessingFee>> processingFee;
        private OptionalNullable<String> paymentId;
        private OptionalNullable<String> orderId;
        private OptionalNullable<String> reason;
        private String createdAt;
        private String updatedAt;
        private String teamMemberId;
        private String terminalRefundId;

        /**
         * Initialization constructor.
         * @param  id  String value for id.
         * @param  amountMoney  Money value for amountMoney.
         */
        public Builder(String id, Money amountMoney) {
            this.id = id;
            this.amountMoney = amountMoney;
        }

        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for amountMoney.
         * @param  amountMoney  Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = OptionalNullable.of(status);
            return this;
        }

        /**
         * UnSetter for status.
         * @return Builder
         */
        public Builder unsetStatus() {
            status = null;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Setter for unlinked.
         * @param  unlinked  Boolean value for unlinked.
         * @return Builder
         */
        public Builder unlinked(Boolean unlinked) {
            this.unlinked = unlinked;
            return this;
        }

        /**
         * Setter for destinationType.
         * @param  destinationType  String value for destinationType.
         * @return Builder
         */
        public Builder destinationType(String destinationType) {
            this.destinationType = OptionalNullable.of(destinationType);
            return this;
        }

        /**
         * UnSetter for destinationType.
         * @return Builder
         */
        public Builder unsetDestinationType() {
            destinationType = null;
            return this;
        }

        /**
         * Setter for destinationDetails.
         * @param  destinationDetails  DestinationDetails value for destinationDetails.
         * @return Builder
         */
        public Builder destinationDetails(DestinationDetails destinationDetails) {
            this.destinationDetails = destinationDetails;
            return this;
        }

        /**
         * Setter for appFeeMoney.
         * @param  appFeeMoney  Money value for appFeeMoney.
         * @return Builder
         */
        public Builder appFeeMoney(Money appFeeMoney) {
            this.appFeeMoney = appFeeMoney;
            return this;
        }

        /**
         * Setter for processingFee.
         * @param  processingFee  List of ProcessingFee value for processingFee.
         * @return Builder
         */
        public Builder processingFee(List<ProcessingFee> processingFee) {
            this.processingFee = OptionalNullable.of(processingFee);
            return this;
        }

        /**
         * UnSetter for processingFee.
         * @return Builder
         */
        public Builder unsetProcessingFee() {
            processingFee = null;
            return this;
        }

        /**
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = OptionalNullable.of(paymentId);
            return this;
        }

        /**
         * UnSetter for paymentId.
         * @return Builder
         */
        public Builder unsetPaymentId() {
            paymentId = null;
            return this;
        }

        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = OptionalNullable.of(orderId);
            return this;
        }

        /**
         * UnSetter for orderId.
         * @return Builder
         */
        public Builder unsetOrderId() {
            orderId = null;
            return this;
        }

        /**
         * Setter for reason.
         * @param  reason  String value for reason.
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = OptionalNullable.of(reason);
            return this;
        }

        /**
         * UnSetter for reason.
         * @return Builder
         */
        public Builder unsetReason() {
            reason = null;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for teamMemberId.
         * @param  teamMemberId  String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * Setter for terminalRefundId.
         * @param  terminalRefundId  String value for terminalRefundId.
         * @return Builder
         */
        public Builder terminalRefundId(String terminalRefundId) {
            this.terminalRefundId = terminalRefundId;
            return this;
        }

        /**
         * Builds a new {@link PaymentRefund} object using the set fields.
         * @return {@link PaymentRefund}
         */
        public PaymentRefund build() {
            return new PaymentRefund(
                    id,
                    amountMoney,
                    status,
                    locationId,
                    unlinked,
                    destinationType,
                    destinationDetails,
                    appFeeMoney,
                    processingFee,
                    paymentId,
                    orderId,
                    reason,
                    createdAt,
                    updatedAt,
                    teamMemberId,
                    terminalRefundId);
        }
    }
}
