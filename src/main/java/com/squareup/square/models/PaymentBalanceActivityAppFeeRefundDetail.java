
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimatic.core.types.BaseModel;
import java.util.Objects;

/**
 * This is a model class for PaymentBalanceActivityAppFeeRefundDetail type.
 */
public class PaymentBalanceActivityAppFeeRefundDetail {
    private final String paymentId;
    private final String refundId;
    private final String locationId;

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  refundId  String value for refundId.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public PaymentBalanceActivityAppFeeRefundDetail(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("refund_id") String refundId,
            @JsonProperty("location_id") String locationId) {
        this.paymentId = paymentId;
        this.refundId = refundId;
        this.locationId = locationId;
    }

    /**
     * Getter for PaymentId.
     * The ID of the payment associated with this activity.
     * @return Returns the String
     */
    @JsonGetter("payment_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Getter for RefundId.
     * The ID of the refund associated with this activity.
     * @return Returns the String
     */
    @JsonGetter("refund_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRefundId() {
        return refundId;
    }

    /**
     * Getter for LocationId.
     * The ID of the location of the merchant associated with the payment refund activity
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, refundId, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentBalanceActivityAppFeeRefundDetail)) {
            return false;
        }
        PaymentBalanceActivityAppFeeRefundDetail other =
                (PaymentBalanceActivityAppFeeRefundDetail) obj;
        return Objects.equals(paymentId, other.paymentId)
            && Objects.equals(refundId, other.refundId)
            && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this PaymentBalanceActivityAppFeeRefundDetail into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentBalanceActivityAppFeeRefundDetail [" + "paymentId=" + paymentId
                + ", refundId=" + refundId + ", locationId=" + locationId + "]";
    }

    /**
     * Builds a new {@link PaymentBalanceActivityAppFeeRefundDetail.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentBalanceActivityAppFeeRefundDetail.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .paymentId(getPaymentId())
                .refundId(getRefundId())
                .locationId(getLocationId());
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentBalanceActivityAppFeeRefundDetail}.
     */
    public static class Builder {
        private String paymentId;
        private String refundId;
        private String locationId;



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
         * Setter for refundId.
         * @param  refundId  String value for refundId.
         * @return Builder
         */
        public Builder refundId(String refundId) {
            this.refundId = refundId;
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
         * Builds a new {@link PaymentBalanceActivityAppFeeRefundDetail} object using the set
         * fields.
         * @return {@link PaymentBalanceActivityAppFeeRefundDetail}
         */
        public PaymentBalanceActivityAppFeeRefundDetail build() {
            return new PaymentBalanceActivityAppFeeRefundDetail(paymentId, refundId, locationId);
        }
    }
}
