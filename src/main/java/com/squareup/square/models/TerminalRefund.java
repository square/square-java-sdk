
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private final String deadlineDuration;
    private final String status;
    private final String cancelReason;
    private final String createdAt;
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param paymentId String value for paymentId.
     * @param amountMoney Money value for amountMoney.
     * @param id String value for id.
     * @param refundId String value for refundId.
     * @param orderId String value for orderId.
     * @param reason String value for reason.
     * @param deviceId String value for deviceId.
     * @param deadlineDuration String value for deadlineDuration.
     * @param status String value for status.
     * @param cancelReason String value for cancelReason.
     * @param createdAt String value for createdAt.
     * @param updatedAt String value for updatedAt.
     */
    @JsonCreator
    public TerminalRefund(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("id") String id,
            @JsonProperty("refund_id") String refundId,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("reason") String reason,
            @JsonProperty("device_id") String deviceId,
            @JsonProperty("deadline_duration") String deadlineDuration,
            @JsonProperty("status") String status,
            @JsonProperty("cancel_reason") String cancelReason,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
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
    }

    /**
     * Getter for Id.
     * A unique ID for this `TerminalRefund`
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for RefundId.
     * The reference to the payment refund created by completing this `TerminalRefund`.
     * @return Returns the String
     */
    @JsonGetter("refund_id")
    public String getRefundId() {
        return this.refundId;
    }

    /**
     * Getter for PaymentId.
     * Unique ID of the payment being refunded.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    public String getPaymentId() {
        return this.paymentId;
    }

    /**
     * Getter for OrderId.
     * The reference to the Square order id for the payment identified by the `payment_id`.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return this.orderId;
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
        return this.amountMoney;
    }

    /**
     * Getter for Reason.
     * A description of the reason for the refund. Note: maximum 192 characters
     * @return Returns the String
     */
    @JsonGetter("reason")
    public String getReason() {
        return this.reason;
    }

    /**
     * Getter for DeviceId.
     * The unique Id of the device intended for this `TerminalRefund`. The Id can be retrieved from
     * /v2/devices api.
     * @return Returns the String
     */
    @JsonGetter("device_id")
    public String getDeviceId() {
        return this.deviceId;
    }

    /**
     * Getter for DeadlineDuration.
     * The duration as an RFC 3339 duration, after which the refund will be automatically canceled.
     * TerminalRefunds that are `PENDING` will be automatically `CANCELED` and have a cancellation
     * reason of `TIMED_OUT` Default: 5 minutes from creation Maximum: 5 minutes
     * @return Returns the String
     */
    @JsonGetter("deadline_duration")
    public String getDeadlineDuration() {
        return this.deadlineDuration;
    }

    /**
     * Getter for Status.
     * The status of the `TerminalRefund`. Options: `PENDING`, `IN_PROGRESS`, `CANCELED`,
     * `COMPLETED`
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for CancelReason.
     * @return Returns the String
     */
    @JsonGetter("cancel_reason")
    public String getCancelReason() {
        return this.cancelReason;
    }

    /**
     * Getter for CreatedAt.
     * The time when the `TerminalRefund` was created as an RFC 3339 timestamp.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The time when the `TerminalRefund` was last updated as an RFC 3339 timestamp.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, refundId, paymentId, orderId, amountMoney, reason, deviceId,
                deadlineDuration, status, cancelReason, createdAt, updatedAt);
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
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this TerminalRefund into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TerminalRefund [" + "paymentId=" + paymentId + ", amountMoney=" + amountMoney
                + ", id=" + id + ", refundId=" + refundId + ", orderId=" + orderId + ", reason="
                + reason + ", deviceId=" + deviceId + ", deadlineDuration=" + deadlineDuration
                + ", status=" + status + ", cancelReason=" + cancelReason + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    /**
     * Builds a new {@link TerminalRefund.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TerminalRefund.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(paymentId, amountMoney)
                .id(getId())
                .refundId(getRefundId())
                .orderId(getOrderId())
                .reason(getReason())
                .deviceId(getDeviceId())
                .deadlineDuration(getDeadlineDuration())
                .status(getStatus())
                .cancelReason(getCancelReason())
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link TerminalRefund}.
     */
    public static class Builder {
        private String paymentId;
        private Money amountMoney;
        private String id;
        private String refundId;
        private String orderId;
        private String reason;
        private String deviceId;
        private String deadlineDuration;
        private String status;
        private String cancelReason;
        private String createdAt;
        private String updatedAt;

        /**
         * Initialization constructor.
         * @param paymentId String value for paymentId.
         * @param amountMoney Money value for amountMoney.
         */
        public Builder(String paymentId,
                Money amountMoney) {
            this.paymentId = paymentId;
            this.amountMoney = amountMoney;
        }

        /**
         * Setter for paymentId.
         * @param paymentId String value for paymentId.
         * @return Builder
         */
        public Builder paymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        /**
         * Setter for amountMoney.
         * @param amountMoney Money value for amountMoney.
         * @return Builder
         */
        public Builder amountMoney(Money amountMoney) {
            this.amountMoney = amountMoney;
            return this;
        }

        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for refundId.
         * @param refundId String value for refundId.
         * @return Builder
         */
        public Builder refundId(String refundId) {
            this.refundId = refundId;
            return this;
        }

        /**
         * Setter for orderId.
         * @param orderId String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Setter for reason.
         * @param reason String value for reason.
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Setter for deviceId.
         * @param deviceId String value for deviceId.
         * @return Builder
         */
        public Builder deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        /**
         * Setter for deadlineDuration.
         * @param deadlineDuration String value for deadlineDuration.
         * @return Builder
         */
        public Builder deadlineDuration(String deadlineDuration) {
            this.deadlineDuration = deadlineDuration;
            return this;
        }

        /**
         * Setter for status.
         * @param status String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Setter for cancelReason.
         * @param cancelReason String value for cancelReason.
         * @return Builder
         */
        public Builder cancelReason(String cancelReason) {
            this.cancelReason = cancelReason;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param createdAt String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param updatedAt String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Builds a new {@link TerminalRefund} object using the set fields.
         * @return {@link TerminalRefund}
         */
        public TerminalRefund build() {
            return new TerminalRefund(paymentId, amountMoney, id, refundId, orderId, reason,
                    deviceId, deadlineDuration, status, cancelReason, createdAt, updatedAt);
        }
    }
}
