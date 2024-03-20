
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
 * This is a model class for DigitalWalletDetails type.
 */
public class DigitalWalletDetails {
    private final OptionalNullable<String> status;
    private final OptionalNullable<String> brand;
    private final CashAppDetails cashAppDetails;

    /**
     * Initialization constructor.
     * @param  status  String value for status.
     * @param  brand  String value for brand.
     * @param  cashAppDetails  CashAppDetails value for cashAppDetails.
     */
    @JsonCreator
    public DigitalWalletDetails(
            @JsonProperty("status") String status,
            @JsonProperty("brand") String brand,
            @JsonProperty("cash_app_details") CashAppDetails cashAppDetails) {
        this.status = OptionalNullable.of(status);
        this.brand = OptionalNullable.of(brand);
        this.cashAppDetails = cashAppDetails;
    }

    /**
     * Initialization constructor.
     * @param  status  String value for status.
     * @param  brand  String value for brand.
     * @param  cashAppDetails  CashAppDetails value for cashAppDetails.
     */

    protected DigitalWalletDetails(OptionalNullable<String> status, OptionalNullable<String> brand,
            CashAppDetails cashAppDetails) {
        this.status = status;
        this.brand = brand;
        this.cashAppDetails = cashAppDetails;
    }

    /**
     * Internal Getter for Status.
     * The status of the `WALLET` payment. The status can be `AUTHORIZED`, `CAPTURED`, `VOIDED`, or
     * `FAILED`.
     * @return Returns the Internal String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetStatus() {
        return this.status;
    }

    /**
     * Getter for Status.
     * The status of the `WALLET` payment. The status can be `AUTHORIZED`, `CAPTURED`, `VOIDED`, or
     * `FAILED`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getStatus() {
        return OptionalNullable.getFrom(status);
    }

    /**
     * Internal Getter for Brand.
     * The brand used for the `WALLET` payment. The brand can be `CASH_APP`, `PAYPAY`, `ALIPAY`,
     * `RAKUTEN_PAY`, `AU_PAY`, `D_BARAI`, `MERPAY`, `WECHAT_PAY` or `UNKNOWN`.
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
     * The brand used for the `WALLET` payment. The brand can be `CASH_APP`, `PAYPAY`, `ALIPAY`,
     * `RAKUTEN_PAY`, `AU_PAY`, `D_BARAI`, `MERPAY`, `WECHAT_PAY` or `UNKNOWN`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBrand() {
        return OptionalNullable.getFrom(brand);
    }

    /**
     * Getter for CashAppDetails.
     * Additional details about `WALLET` type payments with the `brand` of `CASH_APP`.
     * @return Returns the CashAppDetails
     */
    @JsonGetter("cash_app_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CashAppDetails getCashAppDetails() {
        return cashAppDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, brand, cashAppDetails);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DigitalWalletDetails)) {
            return false;
        }
        DigitalWalletDetails other = (DigitalWalletDetails) obj;
        return Objects.equals(status, other.status)
            && Objects.equals(brand, other.brand)
            && Objects.equals(cashAppDetails, other.cashAppDetails);
    }

    /**
     * Converts this DigitalWalletDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DigitalWalletDetails [" + "status=" + status + ", brand=" + brand
                + ", cashAppDetails=" + cashAppDetails + "]";
    }

    /**
     * Builds a new {@link DigitalWalletDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DigitalWalletDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .cashAppDetails(getCashAppDetails());
        builder.status = internalGetStatus();
        builder.brand = internalGetBrand();
        return builder;
    }

    /**
     * Class to build instances of {@link DigitalWalletDetails}.
     */
    public static class Builder {
        private OptionalNullable<String> status;
        private OptionalNullable<String> brand;
        private CashAppDetails cashAppDetails;



        /**
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = OptionalNullable.of(status);
            return this;
        }

        /**
         * UnSetter for status.
         * @return Builder
         */
        public Builder unsetStatus() {
            status = null;
            return this;
        }

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
         * Setter for cashAppDetails.
         * @param  cashAppDetails  CashAppDetails value for cashAppDetails.
         * @return Builder
         */
        public Builder cashAppDetails(CashAppDetails cashAppDetails) {
            this.cashAppDetails = cashAppDetails;
            return this;
        }

        /**
         * Builds a new {@link DigitalWalletDetails} object using the set fields.
         * @return {@link DigitalWalletDetails}
         */
        public DigitalWalletDetails build() {
            return new DigitalWalletDetails(status, brand, cashAppDetails);
        }
    }
}
