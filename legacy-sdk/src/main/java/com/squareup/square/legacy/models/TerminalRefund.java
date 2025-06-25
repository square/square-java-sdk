package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for TerminalRefund type.
 */
public class TerminalRefund {
    private final String id;
    private final String refundId;
    private final String paymentId;
    private final String orderId;
    private final Money amountMoney;
    private final String reason;
    private final String deviceId;
    private final OptionalNullable<String> deadlineDuration;
    private final String status;
    private final String cancelReason;
    private final String createdAt;
    private final String updatedAt;
    private final String appId;
    private final String locationId;

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  amountMoney  Money value for amountMoney.
     * @param  reason  String value for reason.
     * @param  deviceId  String value for deviceId.
     * @param  id  String value for id.
     * @param  refundId  String value for refundId.
     * @param  orderId  String value for orderId.
     * @param  deadlineDuration  String value for deadlineDuration.
     * @param  status  String value for status.
     * @param  cancelReason  String value for cancelReason.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  appId  String value for appId.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public TerminalRefund(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("reason") String reason,
            @JsonProperty("device_id") String deviceId,
            @JsonProperty("id") String id,
            @JsonProperty("refund_id") String refundId,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("deadline_duration") String deadlineDuration,
            @JsonProperty("status") String status,
            @JsonProperty("cancel_reason") String cancelReason,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("app_id") String appId,
            @JsonProperty("location_id") String locationId) {
        this.id = id;
        this.refundId = refundId;
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amountMoney = amountMoney;
        this.reason = reason;
        this.deviceId = deviceId;
        this.deadlineDuration = OptionalNullable.of(deadlineDuration);
        this.status = status;
        this.cancelReason = cancelReason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.appId = appId;
        this.locationId = locationId;
    }

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  amountMoney  Money value for amountMoney.
     * @param  reason  String value for reason.
     * @param  deviceId  String value for deviceId.
     * @param  id  String value for id.
     * @param  refundId  String value for refundId.
     * @param  orderId  String value for orderId.
     * @param  deadlineDuration  String value for deadlineDuration.
     * @param  status  String value for status.
     * @param  cancelReason  String value for cancelReason.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  appId  String value for appId.
     * @param  locationId  String value for locationId.
     */
    protected TerminalRefund(
            String paymentId,
            Money amountMoney,
            String reason,
            String deviceId,
            String id,
            String refundId,
            String orderId,
            OptionalNullable<String> deadlineDuration,
            String status,
            String cancelReason,
            String createdAt,
            String updatedAt,
            String appId,
            String locationId) {
        this.id = id;
        this.refundId = refundId;
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amountMoney = amountMoney;
        this.reason = reason;
        this.deviceId = deviceId;
        this.deadlineDuration = deadlineDuration;
        this.status = status;
        this.cancelReason = cancelReason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.appId = appId;
        this.locationId = locationId;
    }

    /**
     * Getter for Id.
     * A unique ID for this `TerminalRefund`.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for RefundId.
     * The reference to the payment refund created by completing this `TerminalRefund`.
     * @return Returns the String
     */
    @JsonGetter("refund_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRefundId() {
        return refundId;
    }

    /**
     * Getter for PaymentId.
     * The unique ID of the payment being refunded.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Getter for OrderId.
     * The reference to the Square order ID for the payment identified by the `payment_id`.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getOrderId() {
        return orderId;
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
     * Getter for Reason.
     * A description of the reason for the refund.
     * @return Returns the String
     */
    @JsonGetter("reason")
    public String getReason() {
        return reason;
    }

    /**
     * Getter for DeviceId.
     * The unique ID of the device intended for this `TerminalRefund`. The Id can be retrieved from
     * /v2/devices api.
     * @return Returns the String
     */
    @JsonGetter("device_id")
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Internal Getter for DeadlineDuration.
     * The RFC 3339 duration, after which the refund is automatically canceled. A `TerminalRefund`
     * that is `PENDING` is automatically `CANCELED` and has a cancellation reason of `TIMED_OUT`.
     * Default: 5 minutes from creation. Maximum: 5 minutes
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
     * The RFC 3339 duration, after which the refund is automatically canceled. A `TerminalRefund`
     * that is `PENDING` is automatically `CANCELED` and has a cancellation reason of `TIMED_OUT`.
     * Default: 5 minutes from creation. Maximum: 5 minutes
     * @return Returns the String
     */
    @JsonIgnore
    public String getDeadlineDuration() {
        return OptionalNullable.getFrom(deadlineDuration);
    }

    /**
     * Getter for Status.
     * The status of the `TerminalRefund`. Options: `PENDING`, `IN_PROGRESS`, `CANCEL_REQUESTED`,
     * `CANCELED`, or `COMPLETED`.
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
     * Getter for CreatedAt.
     * The time when the `TerminalRefund` was created, as an RFC 3339 timestamp.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The time when the `TerminalRefund` was last updated, as an RFC 3339 timestamp.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for AppId.
     * The ID of the application that created the refund.
     * @return Returns the String
     */
    @JsonGetter("app_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAppId() {
        return appId;
    }

    /**
     * Getter for LocationId.
     * The location of the device where the `TerminalRefund` was directed.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                refundId,
                paymentId,
                orderId,
                amountMoney,
                reason,
                deviceId,
                deadlineDuration,
                status,
                cancelReason,
                createdAt,
                updatedAt,
                appId,
                locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TerminalRefund)) {
            return false;
        }
        TerminalRefund other = (TerminalRefund) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(refundId, other.refundId)
                && Objects.equals(paymentId, other.paymentId)
                && Objects.equals(orderId, other.orderId)
                && Objects.equals(amountMoney, other.amountMoney)
                && Objects.equals(reason, other.reason)
                && Objects.equals(deviceId, other.deviceId)
                && Objects.equals(deadlineDuration, other.deadlineDuration)
                && Objects.equals(status, other.status)
                && Objects.equals(cancelReason, other.cancelReason)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(updatedAt, other.updatedAt)
                && Objects.equals(appId, other.appId)
                && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this TerminalRefund into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TerminalRefund [" + "paymentId=" + paymentId + ", amountMoney=" + amountMoney
                + ", reason=" + reason + ", deviceId=" + deviceId + ", id=" + id + ", refundId="
                + refundId + ", orderId=" + orderId + ", deadlineDuration=" + deadlineDuration
                + ", status=" + status + ", cancelReason=" + cancelReason + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + ", appId=" + appId + ", locationId="
                + locationId + "]";
    }

    /**
     * Builds a new {@link TerminalRefund.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalRefund.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(paymentId, amountMoney, reason, deviceId)
                .id(getId())
                .refundId(getRefundId())
                .orderId(getOrderId())
                .status(getStatus())
                .cancelReason(getCancelReason())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .appId(getAppId())
                .locationId(getLocationId());
        builder.deadlineDuration = internalGetDeadlineDuration();
        return builder;
    }

    /**
     * Class to build instances of {@link TerminalRefund}.
     */
    public static class Builder {
        private String paymentId;
        private Money amountMoney;
        private String reason;
        private String deviceId;
        private String id;
        private String refundId;
        private String orderId;
        private OptionalNullable<String> deadlineDuration;
        private String status;
        private String cancelReason;
        private String createdAt;
        private String updatedAt;
        private String appId;
        private String locationId;

        /**
         * Initialization constructor.
         * @param  paymentId  String value for paymentId.
         * @param  amountMoney  Money value for amountMoney.
         * @param  reason  String value for reason.
         * @param  deviceId  String value for deviceId.
         */
        public Builder(String paymentId, Money amountMoney, String reason, String deviceId) {
            this.paymentId = paymentId;
            this.amountMoney = amountMoney;
            this.reason = reason;
            this.deviceId = deviceId;
        }

        /**
         * Setter for paymentId.
         * @param  paymentId  String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
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
         * Setter for reason.
         * @param  reason  String value for reason.
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Setter for deviceId.
         * @param  deviceId  String value for deviceId.
         * @return Builder
         */
        public Builder deviceId(String deviceId) {
            this.deviceId = deviceId;
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
         * Setter for refundId.
         * @param  refundId  String value for refundId.
         * @return Builder
         */
        public Builder refundId(String refundId) {
            this.refundId = refundId;
            return this;
        }

        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
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
         * Builds a new {@link TerminalRefund} object using the set fields.
         * @return {@link TerminalRefund}
         */
        public TerminalRefund build() {
            return new TerminalRefund(
                    paymentId,
                    amountMoney,
                    reason,
                    deviceId,
                    id,
                    refundId,
                    orderId,
                    deadlineDuration,
                    status,
                    cancelReason,
                    createdAt,
                    updatedAt,
                    appId,
                    locationId);
        }
    }
}
