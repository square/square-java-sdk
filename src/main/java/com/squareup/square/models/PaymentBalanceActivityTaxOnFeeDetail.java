
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimatic.core.types.BaseModel;
import java.util.Objects;

/**
 * This is a model class for PaymentBalanceActivityTaxOnFeeDetail type.
 */
public class PaymentBalanceActivityTaxOnFeeDetail {
    private final String paymentId;
    private final String taxRateDescription;

    /**
     * Initialization constructor.
     * @param  paymentId  String value for paymentId.
     * @param  taxRateDescription  String value for taxRateDescription.
     */
    @JsonCreator
    public PaymentBalanceActivityTaxOnFeeDetail(
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("tax_rate_description") String taxRateDescription) {
        this.paymentId = paymentId;
        this.taxRateDescription = taxRateDescription;
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
     * Getter for TaxRateDescription.
     * The description of the tax rate being applied. For example: "GST", "HST".
     * @return Returns the String
     */
    @JsonGetter("tax_rate_description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getTaxRateDescription() {
        return taxRateDescription;
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
        Builder builder = new Builder()
                .paymentId(getPaymentId())
                .taxRateDescription(getTaxRateDescription());
        return builder;
    }

    /**
     * Class to build instances of {@link PaymentBalanceActivityTaxOnFeeDetail}.
     */
    public static class Builder {
        private String paymentId;
        private String taxRateDescription;



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
         * Setter for taxRateDescription.
         * @param  taxRateDescription  String value for taxRateDescription.
         * @return Builder
         */
        public Builder taxRateDescription(String taxRateDescription) {
            this.taxRateDescription = taxRateDescription;
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
