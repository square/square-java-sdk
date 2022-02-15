
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for BuyNowPayLaterDetails type.
 */
public class BuyNowPayLaterDetails {
    private final String brand;
    private final AfterpayDetails afterpayDetails;

    /**
     * Initialization constructor.
     * @param  brand  String value for brand.
     * @param  afterpayDetails  AfterpayDetails value for afterpayDetails.
     */
    @JsonCreator
    public BuyNowPayLaterDetails(
            @JsonProperty("brand") String brand,
            @JsonProperty("afterpay_details") AfterpayDetails afterpayDetails) {
        this.brand = brand;
        this.afterpayDetails = afterpayDetails;
    }

    /**
     * Getter for Brand.
     * The brand used for the Buy Now Pay Later payment. The brand can be `AFTERPAY` or `UNKNOWN`.
     * @return Returns the String
     */
    @JsonGetter("brand")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBrand() {
        return brand;
    }

    /**
     * Getter for AfterpayDetails.
     * Additional details about Afterpay payments.
     * @return Returns the AfterpayDetails
     */
    @JsonGetter("afterpay_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public AfterpayDetails getAfterpayDetails() {
        return afterpayDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, afterpayDetails);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BuyNowPayLaterDetails)) {
            return false;
        }
        BuyNowPayLaterDetails other = (BuyNowPayLaterDetails) obj;
        return Objects.equals(brand, other.brand)
            && Objects.equals(afterpayDetails, other.afterpayDetails);
    }

    /**
     * Converts this BuyNowPayLaterDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BuyNowPayLaterDetails [" + "brand=" + brand + ", afterpayDetails=" + afterpayDetails
                + "]";
    }

    /**
     * Builds a new {@link BuyNowPayLaterDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BuyNowPayLaterDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .brand(getBrand())
                .afterpayDetails(getAfterpayDetails());
        return builder;
    }

    /**
     * Class to build instances of {@link BuyNowPayLaterDetails}.
     */
    public static class Builder {
        private String brand;
        private AfterpayDetails afterpayDetails;



        /**
         * Setter for brand.
         * @param  brand  String value for brand.
         * @return Builder
         */
        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        /**
         * Setter for afterpayDetails.
         * @param  afterpayDetails  AfterpayDetails value for afterpayDetails.
         * @return Builder
         */
        public Builder afterpayDetails(AfterpayDetails afterpayDetails) {
            this.afterpayDetails = afterpayDetails;
            return this;
        }

        /**
         * Builds a new {@link BuyNowPayLaterDetails} object using the set fields.
         * @return {@link BuyNowPayLaterDetails}
         */
        public BuyNowPayLaterDetails build() {
            return new BuyNowPayLaterDetails(brand, afterpayDetails);
        }
    }
}
