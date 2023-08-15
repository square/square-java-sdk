
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TenderBuyNowPayLaterDetails type.
 */
public class TenderBuyNowPayLaterDetails {
    private final String buyNowPayLaterBrand;
    private final String status;

    /**
     * Initialization constructor.
     * @param  buyNowPayLaterBrand  String value for buyNowPayLaterBrand.
     * @param  status  String value for status.
     */
    @JsonCreator
    public TenderBuyNowPayLaterDetails(
            @JsonProperty("buy_now_pay_later_brand") String buyNowPayLaterBrand,
            @JsonProperty("status") String status) {
        this.buyNowPayLaterBrand = buyNowPayLaterBrand;
        this.status = status;
    }

    /**
     * Getter for BuyNowPayLaterBrand.
     * @return Returns the String
     */
    @JsonGetter("buy_now_pay_later_brand")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBuyNowPayLaterBrand() {
        return buyNowPayLaterBrand;
    }

    /**
     * Getter for Status.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyNowPayLaterBrand, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TenderBuyNowPayLaterDetails)) {
            return false;
        }
        TenderBuyNowPayLaterDetails other = (TenderBuyNowPayLaterDetails) obj;
        return Objects.equals(buyNowPayLaterBrand, other.buyNowPayLaterBrand)
            && Objects.equals(status, other.status);
    }

    /**
     * Converts this TenderBuyNowPayLaterDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TenderBuyNowPayLaterDetails [" + "buyNowPayLaterBrand=" + buyNowPayLaterBrand
                + ", status=" + status + "]";
    }

    /**
     * Builds a new {@link TenderBuyNowPayLaterDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TenderBuyNowPayLaterDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .buyNowPayLaterBrand(getBuyNowPayLaterBrand())
                .status(getStatus());
        return builder;
    }

    /**
     * Class to build instances of {@link TenderBuyNowPayLaterDetails}.
     */
    public static class Builder {
        private String buyNowPayLaterBrand;
        private String status;



        /**
         * Setter for buyNowPayLaterBrand.
         * @param  buyNowPayLaterBrand  String value for buyNowPayLaterBrand.
         * @return Builder
         */
        public Builder buyNowPayLaterBrand(String buyNowPayLaterBrand) {
            this.buyNowPayLaterBrand = buyNowPayLaterBrand;
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
         * Builds a new {@link TenderBuyNowPayLaterDetails} object using the set fields.
         * @return {@link TenderBuyNowPayLaterDetails}
         */
        public TenderBuyNowPayLaterDetails build() {
            return new TenderBuyNowPayLaterDetails(buyNowPayLaterBrand, status);
        }
    }
}
