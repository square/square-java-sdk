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
 * This is a model class for BuyNowPayLaterDetails type.
 */
public class BuyNowPayLaterDetails {
    private final OptionalNullable<String> brand;
    private final AfterpayDetails afterpayDetails;
    private final ClearpayDetails clearpayDetails;

    /**
     * Initialization constructor.
     * @param  brand  String value for brand.
     * @param  afterpayDetails  AfterpayDetails value for afterpayDetails.
     * @param  clearpayDetails  ClearpayDetails value for clearpayDetails.
     */
    @JsonCreator
    public BuyNowPayLaterDetails(
            @JsonProperty("brand") String brand,
            @JsonProperty("afterpay_details") AfterpayDetails afterpayDetails,
            @JsonProperty("clearpay_details") ClearpayDetails clearpayDetails) {
        this.brand = OptionalNullable.of(brand);
        this.afterpayDetails = afterpayDetails;
        this.clearpayDetails = clearpayDetails;
    }

    /**
     * Initialization constructor.
     * @param  brand  String value for brand.
     * @param  afterpayDetails  AfterpayDetails value for afterpayDetails.
     * @param  clearpayDetails  ClearpayDetails value for clearpayDetails.
     */
    protected BuyNowPayLaterDetails(
            OptionalNullable<String> brand, AfterpayDetails afterpayDetails, ClearpayDetails clearpayDetails) {
        this.brand = brand;
        this.afterpayDetails = afterpayDetails;
        this.clearpayDetails = clearpayDetails;
    }

    /**
     * Internal Getter for Brand.
     * The brand used for the Buy Now Pay Later payment. The brand can be `AFTERPAY`, `CLEARPAY` or
     * `UNKNOWN`.
     * @return Returns the Internal String
     */
    @JsonGetter("brand")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBrand() {
        return this.brand;
    }

    /**
     * Getter for Brand.
     * The brand used for the Buy Now Pay Later payment. The brand can be `AFTERPAY`, `CLEARPAY` or
     * `UNKNOWN`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBrand() {
        return OptionalNullable.getFrom(brand);
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

    /**
     * Getter for ClearpayDetails.
     * Additional details about Clearpay payments.
     * @return Returns the ClearpayDetails
     */
    @JsonGetter("clearpay_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ClearpayDetails getClearpayDetails() {
        return clearpayDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, afterpayDetails, clearpayDetails);
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
                && Objects.equals(afterpayDetails, other.afterpayDetails)
                && Objects.equals(clearpayDetails, other.clearpayDetails);
    }

    /**
     * Converts this BuyNowPayLaterDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BuyNowPayLaterDetails [" + "brand=" + brand + ", afterpayDetails=" + afterpayDetails
                + ", clearpayDetails=" + clearpayDetails + "]";
    }

    /**
     * Builds a new {@link BuyNowPayLaterDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BuyNowPayLaterDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().afterpayDetails(getAfterpayDetails()).clearpayDetails(getClearpayDetails());
        builder.brand = internalGetBrand();
        return builder;
    }

    /**
     * Class to build instances of {@link BuyNowPayLaterDetails}.
     */
    public static class Builder {
        private OptionalNullable<String> brand;
        private AfterpayDetails afterpayDetails;
        private ClearpayDetails clearpayDetails;

        /**
         * Setter for brand.
         * @param  brand  String value for brand.
         * @return Builder
         */
        public Builder brand(String brand) {
            this.brand = OptionalNullable.of(brand);
            return this;
        }

        /**
         * UnSetter for brand.
         * @return Builder
         */
        public Builder unsetBrand() {
            brand = null;
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
         * Setter for clearpayDetails.
         * @param  clearpayDetails  ClearpayDetails value for clearpayDetails.
         * @return Builder
         */
        public Builder clearpayDetails(ClearpayDetails clearpayDetails) {
            this.clearpayDetails = clearpayDetails;
            return this;
        }

        /**
         * Builds a new {@link BuyNowPayLaterDetails} object using the set fields.
         * @return {@link BuyNowPayLaterDetails}
         */
        public BuyNowPayLaterDetails build() {
            return new BuyNowPayLaterDetails(brand, afterpayDetails, clearpayDetails);
        }
    }
}
