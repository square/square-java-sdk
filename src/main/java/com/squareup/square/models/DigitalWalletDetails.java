
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DigitalWalletDetails type.
 */
public class DigitalWalletDetails {
    private final String status;
    private final String brand;
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
        this.status = status;
        this.brand = brand;
        this.cashAppDetails = cashAppDetails;
    }

    /**
     * Getter for Status.
     * The status of the `WALLET` payment. The status can be `AUTHORIZED`, `CAPTURED`, `VOIDED`, or
     * `FAILED`.
     * @return Returns the String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getStatus() {
        return status;
    }

    /**
     * Getter for Brand.
     * The brand used for the `WALLET` payment. The brand can be `CASH_APP` or `UNKNOWN`.
     * @return Returns the String
     */
    @JsonGetter("brand")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBrand() {
        return brand;
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
                .status(getStatus())
                .brand(getBrand())
                .cashAppDetails(getCashAppDetails());
        return builder;
    }

    /**
     * Class to build instances of {@link DigitalWalletDetails}.
     */
    public static class Builder {
        private String status;
        private String brand;
        private CashAppDetails cashAppDetails;



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
         * Setter for brand.
         * @param  brand  String value for brand.
         * @return Builder
         */
        public Builder brand(String brand) {
            this.brand = brand;
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
