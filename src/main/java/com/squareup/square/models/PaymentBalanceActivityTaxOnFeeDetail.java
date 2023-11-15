
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
 * This is a model class for PaymentBalanceActivityTaxOnFeeDetail type.
 */
public class PaymentBalanceActivityTaxOnFeeDetail {
    private final OptionalNullable<String> paymentId;
    private final OptionalNullable<String> taxRateDescription;

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  taxRateDescription  String value for taxRateDescription.
     */
    @JsonCreator
    public PaymentBalanceActivityTaxOnFeeDetail(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("tax_rate_description") String taxRateDescription) {
        this.paymentId = OptionalNullable.of(paymentId);
        this.taxRateDescription = OptionalNullable.of(taxRateDescription);
    }

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  taxRateDescription  String value for taxRateDescription.
     */

    protected PaymentBalanceActivityTaxOnFeeDetail(OptionalNullable<String> paymentId,
            OptionalNullable<String> taxRateDescription) {
        this.paymentId = paymentId;
        this.taxRateDescription = taxRateDescription;
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
     * Internal Getter for TaxRateDescription.
     * The description of the tax rate being applied. For example: "GST", "HST".
     * @return Returns the Internal String
     */
    @JsonGetter("tax_rate_description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTaxRateDescription() {
        return this.taxRateDescription;
    }

    /**
     * Getter for TaxRateDescription.
     * The description of the tax rate being applied. For example: "GST", "HST".
     * @return Returns the String
     */
    @JsonIgnore
    public String getTaxRateDescription() {
        return OptionalNullable.getFrom(taxRateDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, taxRateDescription);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentBalanceActivityTaxOnFeeDetail)) {
            return false;
        }
        PaymentBalanceActivityTaxOnFeeDetail other = (PaymentBalanceActivityTaxOnFeeDetail) obj;
        return Objects.equals(paymentId, other.paymentId)
            && Objects.equals(taxRateDescription, other.taxRateDescription);
    }

    /**
     * Converts this PaymentBalanceActivityTaxOnFeeDetail into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PaymentBalanceActivityTaxOnFeeDetail [" + "paymentId=" + paymentId
                + ", taxRateDescription=" + taxRateDescription + "]";
    }

    /**
     * Builds a new {@link PaymentBalanceActivityTaxOnFeeDetail.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PaymentBalanceActivityTaxOnFeeDetail.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.paymentId = internalGetPaymentId();
        builder.taxRateDescription = internalGetTaxRateDescription();
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentBalanceActivityTaxOnFeeDetail}.
     */
    public static class Builder {
        private OptionalNullable<String> paymentId;
        private OptionalNullable<String> taxRateDescription;



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
         * Setter for taxRateDescription.
         * @param  taxRateDescription  String value for taxRateDescription.
         * @return Builder
         */
        public Builder taxRateDescription(String taxRateDescription) {
            this.taxRateDescription = OptionalNullable.of(taxRateDescription);
            return this;
        }

        /**
         * UnSetter for taxRateDescription.
         * @return Builder
         */
        public Builder unsetTaxRateDescription() {
            taxRateDescription = null;
            return this;
        }

        /**
         * Builds a new {@link PaymentBalanceActivityTaxOnFeeDetail} object using the set fields.
         * @return {@link PaymentBalanceActivityTaxOnFeeDetail}
         */
        public PaymentBalanceActivityTaxOnFeeDetail build() {
            return new PaymentBalanceActivityTaxOnFeeDetail(paymentId, taxRateDescription);
        }
    }
}
