
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CashAppDetails type.
 */
public class CashAppDetails {
    private final String buyerFullName;
    private final String buyerCountryCode;
    private final String buyerCashtag;

    /**
     * Initialization constructor.
     * @param  buyerFullName  String value for buyerFullName.
     * @param  buyerCountryCode  String value for buyerCountryCode.
     * @param  buyerCashtag  String value for buyerCashtag.
     */
    @JsonCreator
    public CashAppDetails(
            @JsonProperty("buyer_full_name") String buyerFullName,
            @JsonProperty("buyer_country_code") String buyerCountryCode,
            @JsonProperty("buyer_cashtag") String buyerCashtag) {
        this.buyerFullName = buyerFullName;
        this.buyerCountryCode = buyerCountryCode;
        this.buyerCashtag = buyerCashtag;
    }

    /**
     * Getter for BuyerFullName.
     * The name of the Cash App account holder.
     * @return Returns the String
     */
    @JsonGetter("buyer_full_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBuyerFullName() {
        return buyerFullName;
    }

    /**
     * Getter for BuyerCountryCode.
     * The country of the Cash App account holder, in ISO 3166-1-alpha-2 format. For possible
     * values, see [Country]($m/Country).
     * @return Returns the String
     */
    @JsonGetter("buyer_country_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBuyerCountryCode() {
        return buyerCountryCode;
    }

    /**
     * Getter for BuyerCashtag.
     * $Cashtag of the Cash App account holder.
     * @return Returns the String
     */
    @JsonGetter("buyer_cashtag")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBuyerCashtag() {
        return buyerCashtag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerFullName, buyerCountryCode, buyerCashtag);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CashAppDetails)) {
            return false;
        }
        CashAppDetails other = (CashAppDetails) obj;
        return Objects.equals(buyerFullName, other.buyerFullName)
            && Objects.equals(buyerCountryCode, other.buyerCountryCode)
            && Objects.equals(buyerCashtag, other.buyerCashtag);
    }

    /**
     * Converts this CashAppDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CashAppDetails [" + "buyerFullName=" + buyerFullName + ", buyerCountryCode="
                + buyerCountryCode + ", buyerCashtag=" + buyerCashtag + "]";
    }

    /**
     * Builds a new {@link CashAppDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CashAppDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .buyerFullName(getBuyerFullName())
                .buyerCountryCode(getBuyerCountryCode())
                .buyerCashtag(getBuyerCashtag());
        return builder;
    }

    /**
     * Class to build instances of {@link CashAppDetails}.
     */
    public static class Builder {
        private String buyerFullName;
        private String buyerCountryCode;
        private String buyerCashtag;



        /**
         * Setter for buyerFullName.
         * @param  buyerFullName  String value for buyerFullName.
         * @return Builder
         */
        public Builder buyerFullName(String buyerFullName) {
            this.buyerFullName = buyerFullName;
            return this;
        }

        /**
         * Setter for buyerCountryCode.
         * @param  buyerCountryCode  String value for buyerCountryCode.
         * @return Builder
         */
        public Builder buyerCountryCode(String buyerCountryCode) {
            this.buyerCountryCode = buyerCountryCode;
            return this;
        }

        /**
         * Setter for buyerCashtag.
         * @param  buyerCashtag  String value for buyerCashtag.
         * @return Builder
         */
        public Builder buyerCashtag(String buyerCashtag) {
            this.buyerCashtag = buyerCashtag;
            return this;
        }

        /**
         * Builds a new {@link CashAppDetails} object using the set fields.
         * @return {@link CashAppDetails}
         */
        public CashAppDetails build() {
            return new CashAppDetails(buyerFullName, buyerCountryCode, buyerCashtag);
        }
    }
}
