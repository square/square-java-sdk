
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
 * This is a model class for PaymentBalanceActivityAppFeeRevenueDetail type.
 */
public class PaymentBalanceActivityAppFeeRevenueDetail {
    private final OptionalNullable<String> paymentId;
    private final OptionalNullable<String> locationId;

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public PaymentBalanceActivityAppFeeRevenueDetail(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("location_id") String locationId) {
        this.paymentId = OptionalNullable.of(paymentId);
        this.locationId = OptionalNullable.of(locationId);
    }

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  locationId  String value for locationId.
     */

    protected PaymentBalanceActivityAppFeeRevenueDetail(OptionalNullable<String> paymentId,
            OptionalNullable<String> locationId) {
        this.paymentId = paymentId;
        this.locationId = locationId;
    }

    /**
     * Internal Getter for PaymentId.
     * The ID of the payment associated with this activity.
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
     * The ID of the payment associated with this activity.
     * @return Returns the String
     */
    @JsonIgnore
    public String getPaymentId() {
        return OptionalNullable.getFrom(paymentId);
    }

    /**
     * Internal Getter for LocationId.
     * The ID of the location of the merchant associated with the payment activity
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
     * The ID of the location of the merchant associated with the payment activity
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentBalanceActivityAppFeeRevenueDetail)) {
            return false;
        }
        PaymentBalanceActivityAppFeeRevenueDetail other =
                (PaymentBalanceActivityAppFeeRevenueDetail) obj;
        return Objects.equals(paymentId, other.paymentId)
            && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this PaymentBalanceActivityAppFeeRevenueDetail into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentBalanceActivityAppFeeRevenueDetail [" + "paymentId=" + paymentId
                + ", locationId=" + locationId + "]";
    }

    /**
     * Builds a new {@link PaymentBalanceActivityAppFeeRevenueDetail.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentBalanceActivityAppFeeRevenueDetail.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.paymentId = internalGetPaymentId();
        builder.locationId = internalGetLocationId();
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentBalanceActivityAppFeeRevenueDetail}.
     */
    public static class Builder {
        private OptionalNullable<String> paymentId;
        private OptionalNullable<String> locationId;



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
         * Builds a new {@link PaymentBalanceActivityAppFeeRevenueDetail} object using the set
         * fields.
         * @return {@link PaymentBalanceActivityAppFeeRevenueDetail}
         */
        public PaymentBalanceActivityAppFeeRevenueDetail build() {
            return new PaymentBalanceActivityAppFeeRevenueDetail(paymentId, locationId);
        }
    }
}
