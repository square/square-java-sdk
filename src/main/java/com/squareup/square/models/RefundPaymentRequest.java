
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
 * This is a model class for RefundPaymentRequest type.
 */
public class RefundPaymentRequest {
    private final String idempotencyKey;
    private final Money amountMoney;
    private final Money appFeeMoney;
    private final OptionalNullable<String> paymentId;
    private final OptionalNullable<String> destinationId;
    private final OptionalNullable<Boolean> unlinked;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<String> customerId;
    private final OptionalNullable<String> reason;
    private final OptionalNullable<String> paymentVersionToken;
    private final OptionalNullable<String> teamMemberId;
    private final DestinationDetailsCashRefundDetails cashDetails;
    private final DestinationDetailsExternalRefundDetails externalDetails;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  amountMoney  Money value for amountMoney.
     * @param  appFeeMoney  Money value for appFeeMoney.
     * @param  paymentId  String value for paymentId.
     * @param  destinationId  String value for destinationId.
     * @param  unlinked  Boolean value for unlinked.
     * @param  locationId  String value for locationId.
     * @param  customerId  String value for customerId.
     * @param  reason  String value for reason.
     * @param  paymentVersionToken  String value for paymentVersionToken.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  cashDetails  DestinationDetailsCashRefundDetails value for cashDetails.
     * @param  externalDetails  DestinationDetailsExternalRefundDetails value for externalDetails.
     */
    @JsonCreator
    public RefundPaymentRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("app_fee_money") Money appFeeMoney,
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("destination_id") String destinationId,
            @JsonProperty("unlinked") Boolean unlinked,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("reason") String reason,
            @JsonProperty("payment_version_token") String paymentVersionToken,
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("cash_details") DestinationDetailsCashRefundDetails cashDetails,
            @JsonProperty("external_details") DestinationDetailsExternalRefundDetails externalDetails) {
        this.idempotencyKey = idempotencyKey;
        this.amountMoney = amountMoney;
        this.appFeeMoney = appFeeMoney;
        this.paymentId = OptionalNullable.of(paymentId);
        this.destinationId = OptionalNullable.of(destinationId);
        this.unlinked = OptionalNullable.of(unlinked);
        this.locationId = OptionalNullable.of(locationId);
        this.customerId = OptionalNullable.of(customerId);
        this.reason = OptionalNullable.of(reason);
        this.paymentVersionToken = OptionalNullable.of(paymentVersionToken);
        this.teamMemberId = OptionalNullable.of(teamMemberId);
        this.cashDetails = cashDetails;
        this.externalDetails = externalDetails;
    }

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  amountMoney  Money value for amountMoney.
     * @param  appFeeMoney  Money value for appFeeMoney.
     * @param  paymentId  String value for paymentId.
     * @param  destinationId  String value for destinationId.
     * @param  unlinked  Boolean value for unlinked.
     * @param  locationId  String value for locationId.
     * @param  customerId  String value for customerId.
     * @param  reason  String value for reason.
     * @param  paymentVersionToken  String value for paymentVersionToken.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  cashDetails  DestinationDetailsCashRefundDetails value for cashDetails.
     * @param  externalDetails  DestinationDetailsExternalRefundDetails value for externalDetails.
     */

    protected RefundPaymentRequest(String idempotencyKey, Money amountMoney, Money appFeeMoney,
            OptionalNullable<String> paymentId, OptionalNullable<String> destinationId,
            OptionalNullable<Boolean> unlinked, OptionalNullable<String> locationId,
            OptionalNullable<String> customerId, OptionalNullable<String> reason,
            OptionalNullable<String> paymentVersionToken, OptionalNullable<String> teamMemberId,
            DestinationDetailsCashRefundDetails cashDetails,
            DestinationDetailsExternalRefundDetails externalDetails) {
        this.idempotencyKey = idempotencyKey;
        this.amountMoney = amountMoney;
        this.appFeeMoney = appFeeMoney;
        this.paymentId = paymentId;
        this.destinationId = destinationId;
        this.unlinked = unlinked;
        this.locationId = locationId;
        this.customerId = customerId;
        this.reason = reason;
        this.paymentVersionToken = paymentVersionToken;
        this.teamMemberId = teamMemberId;
        this.cashDetails = cashDetails;
        this.externalDetails = externalDetails;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `RefundPayment` request. The key can be any valid string
     * but must be unique for every `RefundPayment` request. Keys are limited to a max of 45
     * characters - however, the number of allowed characters might be less than 45, if multi-byte
     * characters are used. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
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
     * Internal Getter for PaymentId.
     * The unique ID of the payment being refunded. Required when unlinked=false, otherwise must not
     * be set.
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
     * The unique ID of the payment being refunded. Required when unlinked=false, otherwise must not
     * be set.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPaymentId() {
        return OptionalNullable.getFrom(paymentId);
    }

    /**
     * Internal Getter for DestinationId.
     * The ID indicating where funds will be refunded to. Required for unlinked refunds. For more
     * information, see [Create an unlinked
     * refund](https://developer.squareup.com/docs/payments-api/refund-payments#create-an-unlinked-refund).
     * For refunds linked to Square payments, destination_id is usually omitted; in this case, funds
     * will be returned to the original payment source. The field may be specified in order to
     * request a cross-method refund to a gift card. For more information, see [Cross-method refunds
     * to gift
     * cards](https://developer.squareup.com/docs/payments-api/refund-payments#cross-method-refunds-to-gift-cards).
     * @return Returns the Internal String
     */
    @JsonGetter("destination_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDestinationId() {
        return this.destinationId;
    }

    /**
     * Getter for DestinationId.
     * The ID indicating where funds will be refunded to. Required for unlinked refunds. For more
     * information, see [Create an unlinked
     * refund](https://developer.squareup.com/docs/payments-api/refund-payments#create-an-unlinked-refund).
     * For refunds linked to Square payments, destination_id is usually omitted; in this case, funds
     * will be returned to the original payment source. The field may be specified in order to
     * request a cross-method refund to a gift card. For more information, see [Cross-method refunds
     * to gift
     * cards](https://developer.squareup.com/docs/payments-api/refund-payments#cross-method-refunds-to-gift-cards).
     * @return Returns the String
     */
    @JsonIgnore
    public String getDestinationId() {
        return OptionalNullable.getFrom(destinationId);
    }

    /**
     * Internal Getter for Unlinked.
     * Indicates that the refund is not linked to a Square payment. If set to true, `destination_id`
     * and `location_id` must be supplied while `payment_id` must not be provided.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("unlinked")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetUnlinked() {
        return this.unlinked;
    }

    /**
     * Getter for Unlinked.
     * Indicates that the refund is not linked to a Square payment. If set to true, `destination_id`
     * and `location_id` must be supplied while `payment_id` must not be provided.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getUnlinked() {
        return OptionalNullable.getFrom(unlinked);
    }

    /**
     * Internal Getter for LocationId.
     * The location ID associated with the unlinked refund. Required for requests specifying
     * `unlinked=true`. Otherwise, if included when `unlinked=false`, will throw an error.
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
     * The location ID associated with the unlinked refund. Required for requests specifying
     * `unlinked=true`. Otherwise, if included when `unlinked=false`, will throw an error.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for CustomerId.
     * The [Customer](entity:Customer) ID of the customer associated with the refund. This is
     * required if the `destination_id` refers to a card on file created using the Cards API. Only
     * allowed when `unlinked=true`.
     * @return Returns the Internal String
     */
    @JsonGetter("customer_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for CustomerId.
     * The [Customer](entity:Customer) ID of the customer associated with the refund. This is
     * required if the `destination_id` refers to a card on file created using the Cards API. Only
     * allowed when `unlinked=true`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomerId() {
        return OptionalNullable.getFrom(customerId);
    }

    /**
     * Internal Getter for Reason.
     * A description of the reason for the refund.
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
     * A description of the reason for the refund.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReason() {
        return OptionalNullable.getFrom(reason);
    }

    /**
     * Internal Getter for PaymentVersionToken.
     * Used for optimistic concurrency. This opaque token identifies the current `Payment` version
     * that the caller expects. If the server has a different version of the Payment, the update
     * fails and a response with a VERSION_MISMATCH error is returned. If the versions match, or the
     * field is not provided, the refund proceeds as normal.
     * @return Returns the Internal String
     */
    @JsonGetter("payment_version_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPaymentVersionToken() {
        return this.paymentVersionToken;
    }

    /**
     * Getter for PaymentVersionToken.
     * Used for optimistic concurrency. This opaque token identifies the current `Payment` version
     * that the caller expects. If the server has a different version of the Payment, the update
     * fails and a response with a VERSION_MISMATCH error is returned. If the versions match, or the
     * field is not provided, the refund proceeds as normal.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPaymentVersionToken() {
        return OptionalNullable.getFrom(paymentVersionToken);
    }

    /**
     * Internal Getter for TeamMemberId.
     * An optional [TeamMember](entity:TeamMember) ID to associate with this refund.
     * @return Returns the Internal String
     */
    @JsonGetter("team_member_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTeamMemberId() {
        return this.teamMemberId;
    }

    /**
     * Getter for TeamMemberId.
     * An optional [TeamMember](entity:TeamMember) ID to associate with this refund.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTeamMemberId() {
        return OptionalNullable.getFrom(teamMemberId);
    }

    /**
     * Getter for CashDetails.
     * Stores details about a cash refund. Contains only non-confidential information.
     * @return Returns the DestinationDetailsCashRefundDetails
     */
    @JsonGetter("cash_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DestinationDetailsCashRefundDetails getCashDetails() {
        return cashDetails;
    }

    /**
     * Getter for ExternalDetails.
     * Stores details about an external refund. Contains only non-confidential information.
     * @return Returns the DestinationDetailsExternalRefundDetails
     */
    @JsonGetter("external_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public DestinationDetailsExternalRefundDetails getExternalDetails() {
        return externalDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, amountMoney, appFeeMoney, paymentId, destinationId,
                unlinked, locationId, customerId, reason, paymentVersionToken, teamMemberId,
                cashDetails, externalDetails);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RefundPaymentRequest)) {
            return false;
        }
        RefundPaymentRequest other = (RefundPaymentRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(appFeeMoney, other.appFeeMoney)
            && Objects.equals(paymentId, other.paymentId)
            && Objects.equals(destinationId, other.destinationId)
            && Objects.equals(unlinked, other.unlinked)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(customerId, other.customerId)
            && Objects.equals(reason, other.reason)
            && Objects.equals(paymentVersionToken, other.paymentVersionToken)
            && Objects.equals(teamMemberId, other.teamMemberId)
            && Objects.equals(cashDetails, other.cashDetails)
            && Objects.equals(externalDetails, other.externalDetails);
    }

    /**
     * Converts this RefundPaymentRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RefundPaymentRequest [" + "idempotencyKey=" + idempotencyKey + ", amountMoney="
                + amountMoney + ", appFeeMoney=" + appFeeMoney + ", paymentId=" + paymentId
                + ", destinationId=" + destinationId + ", unlinked=" + unlinked + ", locationId="
                + locationId + ", customerId=" + customerId + ", reason=" + reason
                + ", paymentVersionToken=" + paymentVersionToken + ", teamMemberId=" + teamMemberId
                + ", cashDetails=" + cashDetails + ", externalDetails=" + externalDetails + "]";
    }

    /**
     * Builds a new {@link RefundPaymentRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RefundPaymentRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, amountMoney)
                .appFeeMoney(getAppFeeMoney())
                .cashDetails(getCashDetails())
                .externalDetails(getExternalDetails());
        builder.paymentId = internalGetPaymentId();
        builder.destinationId = internalGetDestinationId();
        builder.unlinked = internalGetUnlinked();
        builder.locationId = internalGetLocationId();
        builder.customerId = internalGetCustomerId();
        builder.reason = internalGetReason();
        builder.paymentVersionToken = internalGetPaymentVersionToken();
        builder.teamMemberId = internalGetTeamMemberId();
        return builder;
    }

    /**
     * Class to build instances of {@link RefundPaymentRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private Money amountMoney;
        private Money appFeeMoney;
        private OptionalNullable<String> paymentId;
        private OptionalNullable<String> destinationId;
        private OptionalNullable<Boolean> unlinked;
        private OptionalNullable<String> locationId;
        private OptionalNullable<String> customerId;
        private OptionalNullable<String> reason;
        private OptionalNullable<String> paymentVersionToken;
        private OptionalNullable<String> teamMemberId;
        private DestinationDetailsCashRefundDetails cashDetails;
        private DestinationDetailsExternalRefundDetails externalDetails;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  amountMoney  Money value for amountMoney.
         */
        public Builder(String idempotencyKey, Money amountMoney) {
            this.idempotencyKey = idempotencyKey;
            this.amountMoney = amountMoney;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
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
         * Setter for appFeeMoney.
         * @param  appFeeMoney  Money value for appFeeMoney.
         * @return Builder
         */
        public Builder appFeeMoney(Money appFeeMoney) {
            this.appFeeMoney = appFeeMoney;
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
         * Setter for destinationId.
         * @param  destinationId  String value for destinationId.
         * @return Builder
         */
        public Builder destinationId(String destinationId) {
            this.destinationId = OptionalNullable.of(destinationId);
            return this;
        }

        /**
         * UnSetter for destinationId.
         * @return Builder
         */
        public Builder unsetDestinationId() {
            destinationId = null;
            return this;
        }

        /**
         * Setter for unlinked.
         * @param  unlinked  Boolean value for unlinked.
         * @return Builder
         */
        public Builder unlinked(Boolean unlinked) {
            this.unlinked = OptionalNullable.of(unlinked);
            return this;
        }

        /**
         * UnSetter for unlinked.
         * @return Builder
         */
        public Builder unsetUnlinked() {
            unlinked = null;
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
         * Setter for customerId.
         * @param  customerId  String value for customerId.
         * @return Builder
         */
        public Builder customerId(String customerId) {
            this.customerId = OptionalNullable.of(customerId);
            return this;
        }

        /**
         * UnSetter for customerId.
         * @return Builder
         */
        public Builder unsetCustomerId() {
            customerId = null;
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
         * Setter for paymentVersionToken.
         * @param  paymentVersionToken  String value for paymentVersionToken.
         * @return Builder
         */
        public Builder paymentVersionToken(String paymentVersionToken) {
            this.paymentVersionToken = OptionalNullable.of(paymentVersionToken);
            return this;
        }

        /**
         * UnSetter for paymentVersionToken.
         * @return Builder
         */
        public Builder unsetPaymentVersionToken() {
            paymentVersionToken = null;
            return this;
        }

        /**
         * Setter for teamMemberId.
         * @param  teamMemberId  String value for teamMemberId.
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = OptionalNullable.of(teamMemberId);
            return this;
        }

        /**
         * UnSetter for teamMemberId.
         * @return Builder
         */
        public Builder unsetTeamMemberId() {
            teamMemberId = null;
            return this;
        }

        /**
         * Setter for cashDetails.
         * @param  cashDetails  DestinationDetailsCashRefundDetails value for cashDetails.
         * @return Builder
         */
        public Builder cashDetails(DestinationDetailsCashRefundDetails cashDetails) {
            this.cashDetails = cashDetails;
            return this;
        }

        /**
         * Setter for externalDetails.
         * @param  externalDetails  DestinationDetailsExternalRefundDetails value for
         *         externalDetails.
         * @return Builder
         */
        public Builder externalDetails(DestinationDetailsExternalRefundDetails externalDetails) {
            this.externalDetails = externalDetails;
            return this;
        }

        /**
         * Builds a new {@link RefundPaymentRequest} object using the set fields.
         * @return {@link RefundPaymentRequest}
         */
        public RefundPaymentRequest build() {
            return new RefundPaymentRequest(idempotencyKey, amountMoney, appFeeMoney, paymentId,
                    destinationId, unlinked, locationId, customerId, reason, paymentVersionToken,
                    teamMemberId, cashDetails, externalDetails);
        }
    }
}
