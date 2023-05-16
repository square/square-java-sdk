
package com.squareup.square.models;

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
 * This is a model class for TerminalCheckout type.
 */
public class TerminalCheckout {
    private final String id;
    private final Money amountMoney;
    private final OptionalNullable<String> referenceId;
    private final OptionalNullable<String> note;
    private final OptionalNullable<String> orderId;
    private final PaymentOptions paymentOptions;
    private final DeviceCheckoutOptions deviceOptions;
    private final OptionalNullable<String> deadlineDuration;
    private final String status;
    private final String cancelReason;
    private final List<String> paymentIds;
    private final String createdAt;
    private final String updatedAt;
    private final String appId;
    private final String locationId;
    private final String paymentType;
    private final OptionalNullable<String> teamMemberId;
    private final OptionalNullable<String> customerId;
    private final Money appFeeMoney;
    private final OptionalNullable<String> statementDescriptionIdentifier;
    private final Money tipMoney;

    /**
     * Initialization constructor.
     * @param  amountMoney  Money value for amountMoney.
     * @param  deviceOptions  DeviceCheckoutOptions value for deviceOptions.
     * @param  id  String value for id.
     * @param  referenceId  String value for referenceId.
     * @param  note  String value for note.
     * @param  orderId  String value for orderId.
     * @param  paymentOptions  PaymentOptions value for paymentOptions.
     * @param  deadlineDuration  String value for deadlineDuration.
     * @param  status  String value for status.
     * @param  cancelReason  String value for cancelReason.
     * @param  paymentIds  List of String value for paymentIds.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  appId  String value for appId.
     * @param  locationId  String value for locationId.
     * @param  paymentType  String value for paymentType.
     * @param  teamMemberId  String value for teamMemberId.
     * @param  customerId  String value for customerId.
     * @param  appFeeMoney  Money value for appFeeMoney.
     * @param  statementDescriptionIdentifier  String value for statementDescriptionIdentifier.
     * @param  tipMoney  Money value for tipMoney.
     */
    @JsonCreator
    public TerminalCheckout(
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("device_options") DeviceCheckoutOptions deviceOptions,
            @JsonProperty("id") String id,
            @JsonProperty("reference_id") String referenceId,
            @JsonProperty("note") String note,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("payment_options") PaymentOptions paymentOptions,
            @JsonProperty("deadline_duration") String deadlineDuration,
            @JsonProperty("status") String status,
            @JsonProperty("cancel_reason") String cancelReason,
            @JsonProperty("payment_ids") List<String> paymentIds,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("app_id") String appId,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("payment_type") String paymentType,
            @JsonProperty("team_member_id") String teamMemberId,
            @JsonProperty("customer_id") String customerId,
            @JsonProperty("app_fee_money") Money appFeeMoney,
            @JsonProperty("statement_description_identifier") String statementDescriptionIdentifier,
            @JsonProperty("tip_money") Money tipMoney) {
        this.id = id;
        this.amountMoney = amountMoney;
        this.referenceId = OptionalNullable.of(referenceId);
        this.note = OptionalNullable.of(note);
        this.orderId = OptionalNullable.of(orderId);
        this.paymentOptions = paymentOptions;
        this.deviceOptions = deviceOptions;
        this.deadlineDuration = OptionalNullable.of(deadlineDuration);
        this.status = status;
        this.cancelReason = cancelReason;
        this.paymentIds = paymentIds;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.appId = appId;
        this.locationId = locationId;
        this.paymentType = paymentType;
        this.teamMemberId = OptionalNullable.of(teamMemberId);
        this.customerId = OptionalNullable.of(customerId);
        this.appFeeMoney = appFeeMoney;
        this.statementDescriptionIdentifier = OptionalNullable.of(statementDescriptionIdentifier);
        this.tipMoney = tipMoney;
    }

    /**
     * Internal initialization constructor.
     */
    protected TerminalCheckout(Money amountMoney, DeviceCheckoutOptions deviceOptions, String id,
            OptionalNullable<String> referenceId, OptionalNullable<String> note,
            OptionalNullable<String> orderId, PaymentOptions paymentOptions,
            OptionalNullable<String> deadlineDuration, String status, String cancelReason,
            List<String> paymentIds, String createdAt, String updatedAt, String appId,
            String locationId, String paymentType, OptionalNullable<String> teamMemberId,
            OptionalNullable<String> customerId, Money appFeeMoney,
            OptionalNullable<String> statementDescriptionIdentifier, Money tipMoney) {
        this.id = id;
        this.amountMoney = amountMoney;
        this.referenceId = referenceId;
        this.note = note;
        this.orderId = orderId;
        this.paymentOptions = paymentOptions;
        this.deviceOptions = deviceOptions;
        this.deadlineDuration = deadlineDuration;
        this.status = status;
        this.cancelReason = cancelReason;
        this.paymentIds = paymentIds;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.appId = appId;
        this.locationId = locationId;
        this.paymentType = paymentType;
        this.teamMemberId = teamMemberId;
        this.customerId = customerId;
        this.appFeeMoney = appFeeMoney;
        this.statementDescriptionIdentifier = statementDescriptionIdentifier;
        this.tipMoney = tipMoney;
    }

    /**
     * Getter for Id.
     * A unique ID for this `TerminalCheckout`.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
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
     * Internal Getter for ReferenceId.
     * An optional user-defined reference ID that can be used to associate this `TerminalCheckout`
     * to another entity in an external system. For example, an order ID generated by a third-party
     * shopping cart. The ID is also associated with any payments used to complete the checkout.
     * @return Returns the Internal String
     */
    @JsonGetter("reference_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetReferenceId() {
        return this.referenceId;
    }

    /**
     * Getter for ReferenceId.
     * An optional user-defined reference ID that can be used to associate this `TerminalCheckout`
     * to another entity in an external system. For example, an order ID generated by a third-party
     * shopping cart. The ID is also associated with any payments used to complete the checkout.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReferenceId() {
        return OptionalNullable.getFrom(referenceId);
    }

    /**
     * Internal Getter for Note.
     * An optional note to associate with the checkout, as well as with any payments used to
     * complete the checkout. Note: maximum 500 characters
     * @return Returns the Internal String
     */
    @JsonGetter("note")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetNote() {
        return this.note;
    }

    /**
     * Getter for Note.
     * An optional note to associate with the checkout, as well as with any payments used to
     * complete the checkout. Note: maximum 500 characters
     * @return Returns the String
     */
    @JsonIgnore
    public String getNote() {
        return OptionalNullable.getFrom(note);
    }

    /**
     * Internal Getter for OrderId.
     * The reference to the Square order ID for the checkout request. Supported only in the US.
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
     * The reference to the Square order ID for the checkout request. Supported only in the US.
     * @return Returns the String
     */
    @JsonIgnore
    public String getOrderId() {
        return OptionalNullable.getFrom(orderId);
    }

    /**
     * Getter for PaymentOptions.
     * @return Returns the PaymentOptions
     */
    @JsonGetter("payment_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PaymentOptions getPaymentOptions() {
        return paymentOptions;
    }

    /**
     * Getter for DeviceOptions.
     * @return Returns the DeviceCheckoutOptions
     */
    @JsonGetter("device_options")
    public DeviceCheckoutOptions getDeviceOptions() {
        return deviceOptions;
    }

    /**
     * Internal Getter for DeadlineDuration.
     * An RFC 3339 duration, after which the checkout is automatically canceled. A
     * `TerminalCheckout` that is `PENDING` is automatically `CANCELED` and has a cancellation
     * reason of `TIMED_OUT`. Default: 5 minutes from creation Maximum: 5 minutes
     * @return Returns the Internal String
     */
    @JsonGetter("deadline_duration")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDeadlineDuration() {
        return this.deadlineDuration;
    }

    /**
     * Getter for DeadlineDuration.
     * An RFC 3339 duration, after which the checkout is automatically canceled. A
     * `TerminalCheckout` that is `PENDING` is automatically `CANCELED` and has a cancellation
     * reason of `TIMED_OUT`. Default: 5 minutes from creation Maximum: 5 minutes
     * @return Returns the String
     */
    @JsonIgnore
    public String getDeadlineDuration() {
        return OptionalNullable.getFrom(deadlineDuration);
    }

    /**
     * Getter for Status.
     * The status of the `TerminalCheckout`. Options: `PENDING`, `IN_PROGRESS`, `CANCEL_REQUESTED`,
     * `CANCELED`, `COMPLETED`
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for CancelReason.
     * @return Returns the String
     */
    @JsonGetter("cancel_reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * Getter for PaymentIds.
     * A list of IDs for payments created by this `TerminalCheckout`.
     * @return Returns the List of String
     */
    @JsonGetter("payment_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getPaymentIds() {
        return paymentIds;
    }

    /**
     * Getter for CreatedAt.
     * The time when the `TerminalCheckout` was created, as an RFC 3339 timestamp.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The time when the `TerminalCheckout` was last updated, as an RFC 3339 timestamp.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for AppId.
     * The ID of the application that created the checkout.
     * @return Returns the String
     */
    @JsonGetter("app_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAppId() {
        return appId;
    }

    /**
     * Getter for LocationId.
     * The location of the device where the `TerminalCheckout` was directed.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for PaymentType.
     * @return Returns the String
     */
    @JsonGetter("payment_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Internal Getter for TeamMemberId.
     * An optional ID of the team member associated with creating the checkout.
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
     * An optional ID of the team member associated with creating the checkout.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTeamMemberId() {
        return OptionalNullable.getFrom(teamMemberId);
    }

    /**
     * Internal Getter for CustomerId.
     * An optional ID of the customer associated with the checkout.
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
     * An optional ID of the customer associated with the checkout.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCustomerId() {
        return OptionalNullable.getFrom(customerId);
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
     * Internal Getter for StatementDescriptionIdentifier.
     * Optional additional payment information to include on the customer's card statement as part
     * of the statement description. This can be, for example, an invoice number, ticket number, or
     * short description that uniquely identifies the purchase. Supported only in the US.
     * @return Returns the Internal String
     */
    @JsonGetter("statement_description_identifier")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStatementDescriptionIdentifier() {
        return this.statementDescriptionIdentifier;
    }

    /**
     * Getter for StatementDescriptionIdentifier.
     * Optional additional payment information to include on the customer's card statement as part
     * of the statement description. This can be, for example, an invoice number, ticket number, or
     * short description that uniquely identifies the purchase. Supported only in the US.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStatementDescriptionIdentifier() {
        return OptionalNullable.getFrom(statementDescriptionIdentifier);
    }

    /**
     * Getter for TipMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("tip_money")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Money getTipMoney() {
        return tipMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amountMoney, referenceId, note, orderId, paymentOptions,
                deviceOptions, deadlineDuration, status, cancelReason, paymentIds, createdAt,
                updatedAt, appId, locationId, paymentType, teamMemberId, customerId, appFeeMoney,
                statementDescriptionIdentifier, tipMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TerminalCheckout)) {
            return false;
        }
        TerminalCheckout other = (TerminalCheckout) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(amountMoney, other.amountMoney)
            && Objects.equals(referenceId, other.referenceId)
            && Objects.equals(note, other.note)
            && Objects.equals(orderId, other.orderId)
            && Objects.equals(paymentOptions, other.paymentOptions)
            && Objects.equals(deviceOptions, other.deviceOptions)
            && Objects.equals(deadlineDuration, other.deadlineDuration)
            && Objects.equals(status, other.status)
            && Objects.equals(cancelReason, other.cancelReason)
            && Objects.equals(paymentIds, other.paymentIds)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(appId, other.appId)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(paymentType, other.paymentType)
            && Objects.equals(teamMemberId, other.teamMemberId)
            && Objects.equals(customerId, other.customerId)
            && Objects.equals(appFeeMoney, other.appFeeMoney)
            && Objects.equals(statementDescriptionIdentifier,
                    other.statementDescriptionIdentifier)
            && Objects.equals(tipMoney, other.tipMoney);
    }

    /**
     * Converts this TerminalCheckout into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TerminalCheckout [" + "amountMoney=" + amountMoney + ", deviceOptions="
                + deviceOptions + ", id=" + id + ", referenceId=" + referenceId + ", note=" + note
                + ", orderId=" + orderId + ", paymentOptions=" + paymentOptions
                + ", deadlineDuration=" + deadlineDuration + ", status=" + status
                + ", cancelReason=" + cancelReason + ", paymentIds=" + paymentIds + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + ", appId=" + appId + ", locationId="
                + locationId + ", paymentType=" + paymentType + ", teamMemberId=" + teamMemberId
                + ", customerId=" + customerId + ", appFeeMoney=" + appFeeMoney
                + ", statementDescriptionIdentifier=" + statementDescriptionIdentifier
                + ", tipMoney=" + tipMoney + "]";
    }

    /**
     * Builds a new {@link TerminalCheckout.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalCheckout.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(amountMoney, deviceOptions)
                .id(getId())
                .paymentOptions(getPaymentOptions())
                .status(getStatus())
                .cancelReason(getCancelReason())
                .paymentIds(getPaymentIds())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .appId(getAppId())
                .locationId(getLocationId())
                .paymentType(getPaymentType())
                .appFeeMoney(getAppFeeMoney())
                .tipMoney(getTipMoney());
        builder.referenceId = internalGetReferenceId();
        builder.note = internalGetNote();
        builder.orderId = internalGetOrderId();
        builder.deadlineDuration = internalGetDeadlineDuration();
        builder.teamMemberId = internalGetTeamMemberId();
        builder.customerId = internalGetCustomerId();
        builder.statementDescriptionIdentifier = internalGetStatementDescriptionIdentifier();
        return builder;
    }

    /**
     * Class to build instances of {@link TerminalCheckout}.
     */
    public static class Builder {
        private Money amountMoney;
        private DeviceCheckoutOptions deviceOptions;
        private String id;
        private OptionalNullable<String> referenceId;
        private OptionalNullable<String> note;
        private OptionalNullable<String> orderId;
        private PaymentOptions paymentOptions;
        private OptionalNullable<String> deadlineDuration;
        private String status;
        private String cancelReason;
        private List<String> paymentIds;
        private String createdAt;
        private String updatedAt;
        private String appId;
        private String locationId;
        private String paymentType;
        private OptionalNullable<String> teamMemberId;
        private OptionalNullable<String> customerId;
        private Money appFeeMoney;
        private OptionalNullable<String> statementDescriptionIdentifier;
        private Money tipMoney;

        /**
         * Initialization constructor.
         * @param  amountMoney  Money value for amountMoney.
         * @param  deviceOptions  DeviceCheckoutOptions value for deviceOptions.
         */
        public Builder(Money amountMoney, DeviceCheckoutOptions deviceOptions) {
            this.amountMoney = amountMoney;
            this.deviceOptions = deviceOptions;
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
         * Setter for deviceOptions.
         * @param  deviceOptions  DeviceCheckoutOptions value for deviceOptions.
         * @return Builder
         */
        public Builder deviceOptions(DeviceCheckoutOptions deviceOptions) {
            this.deviceOptions = deviceOptions;
            return this;
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
         * Setter for referenceId.
         * @param  referenceId  String value for referenceId.
         * @return Builder
         */
        public Builder referenceId(String referenceId) {
            this.referenceId = OptionalNullable.of(referenceId);
            return this;
        }

        /**
         * UnSetter for referenceId.
         * @return Builder
         */
        public Builder unsetReferenceId() {
            referenceId = null;
            return this;
        }

        /**
         * Setter for note.
         * @param  note  String value for note.
         * @return Builder
         */
        public Builder note(String note) {
            this.note = OptionalNullable.of(note);
            return this;
        }

        /**
         * UnSetter for note.
         * @return Builder
         */
        public Builder unsetNote() {
            note = null;
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
         * Setter for paymentOptions.
         * @param  paymentOptions  PaymentOptions value for paymentOptions.
         * @return Builder
         */
        public Builder paymentOptions(PaymentOptions paymentOptions) {
            this.paymentOptions = paymentOptions;
            return this;
        }

        /**
         * Setter for deadlineDuration.
         * @param  deadlineDuration  String value for deadlineDuration.
         * @return Builder
         */
        public Builder deadlineDuration(String deadlineDuration) {
            this.deadlineDuration = OptionalNullable.of(deadlineDuration);
            return this;
        }

        /**
         * UnSetter for deadlineDuration.
         * @return Builder
         */
        public Builder unsetDeadlineDuration() {
            deadlineDuration = null;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for cancelReason.
         * @param  cancelReason  String value for cancelReason.
         * @return Builder
         */
        public Builder cancelReason(String cancelReason) {
            this.cancelReason = cancelReason;
            return this;
        }

        /**
         * Setter for paymentIds.
         * @param  paymentIds  List of String value for paymentIds.
         * @return Builder
         */
        public Builder paymentIds(List<String> paymentIds) {
            this.paymentIds = paymentIds;
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
         * Setter for appId.
         * @param  appId  String value for appId.
         * @return Builder
         */
        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for paymentType.
         * @param  paymentType  String value for paymentType.
         * @return Builder
         */
        public Builder paymentType(String paymentType) {
            this.paymentType = paymentType;
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
         * Setter for appFeeMoney.
         * @param  appFeeMoney  Money value for appFeeMoney.
         * @return Builder
         */
        public Builder appFeeMoney(Money appFeeMoney) {
            this.appFeeMoney = appFeeMoney;
            return this;
        }

        /**
         * Setter for statementDescriptionIdentifier.
         * @param  statementDescriptionIdentifier  String value for statementDescriptionIdentifier.
         * @return Builder
         */
        public Builder statementDescriptionIdentifier(String statementDescriptionIdentifier) {
            this.statementDescriptionIdentifier =
                    OptionalNullable.of(statementDescriptionIdentifier);
            return this;
        }

        /**
         * UnSetter for statementDescriptionIdentifier.
         * @return Builder
         */
        public Builder unsetStatementDescriptionIdentifier() {
            statementDescriptionIdentifier = null;
            return this;
        }

        /**
         * Setter for tipMoney.
         * @param  tipMoney  Money value for tipMoney.
         * @return Builder
         */
        public Builder tipMoney(Money tipMoney) {
            this.tipMoney = tipMoney;
            return this;
        }

        /**
         * Builds a new {@link TerminalCheckout} object using the set fields.
         * @return {@link TerminalCheckout}
         */
        public TerminalCheckout build() {
            return new TerminalCheckout(amountMoney, deviceOptions, id, referenceId, note, orderId,
                    paymentOptions, deadlineDuration, status, cancelReason, paymentIds, createdAt,
                    updatedAt, appId, locationId, paymentType, teamMemberId, customerId,
                    appFeeMoney, statementDescriptionIdentifier, tipMoney);
        }
    }
}
