
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for PrePopulatedData type.
 */
public class PrePopulatedData {
    private final OptionalNullable<String> buyerEmail;
    private final OptionalNullable<String> buyerPhoneNumber;
    private final Address buyerAddress;

    /**
     * Initialization constructor.
     * @param  buyerEmail  String value for buyerEmail.
     * @param  buyerPhoneNumber  String value for buyerPhoneNumber.
     * @param  buyerAddress  Address value for buyerAddress.
     */
    @JsonCreator
    public PrePopulatedData(
            @JsonProperty("buyer_email") String buyerEmail,
            @JsonProperty("buyer_phone_number") String buyerPhoneNumber,
            @JsonProperty("buyer_address") Address buyerAddress) {
        this.buyerEmail = OptionalNullable.of(buyerEmail);
        this.buyerPhoneNumber = OptionalNullable.of(buyerPhoneNumber);
        this.buyerAddress = buyerAddress;
    }

    /**
     * Internal initialization constructor.
     */
    protected PrePopulatedData(OptionalNullable<String> buyerEmail,
            OptionalNullable<String> buyerPhoneNumber, Address buyerAddress) {
        this.buyerEmail = buyerEmail;
        this.buyerPhoneNumber = buyerPhoneNumber;
        this.buyerAddress = buyerAddress;
    }

    /**
     * Internal Getter for BuyerEmail.
     * The buyer email to prepopulate in the payment form.
     * @return Returns the Internal String
     */
    @JsonGetter("buyer_email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBuyerEmail() {
        return this.buyerEmail;
    }

    /**
     * Getter for BuyerEmail.
     * The buyer email to prepopulate in the payment form.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBuyerEmail() {
        return OptionalNullable.getFrom(buyerEmail);
    }

    /**
     * Internal Getter for BuyerPhoneNumber.
     * The buyer phone number to prepopulate in the payment form.
     * @return Returns the Internal String
     */
    @JsonGetter("buyer_phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetBuyerPhoneNumber() {
        return this.buyerPhoneNumber;
    }

    /**
     * Getter for BuyerPhoneNumber.
     * The buyer phone number to prepopulate in the payment form.
     * @return Returns the String
     */
    @JsonIgnore
    public String getBuyerPhoneNumber() {
        return OptionalNullable.getFrom(buyerPhoneNumber);
    }

    /**
     * Getter for BuyerAddress.
     * Represents a postal address in a country. For more information, see [Working with
     * Addresses](https://developer.squareup.com/docs/build-basics/working-with-addresses).
     * @return Returns the Address
     */
    @JsonGetter("buyer_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Address getBuyerAddress() {
        return buyerAddress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerEmail, buyerPhoneNumber, buyerAddress);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrePopulatedData)) {
            return false;
        }
        PrePopulatedData other = (PrePopulatedData) obj;
        return Objects.equals(buyerEmail, other.buyerEmail)
            && Objects.equals(buyerPhoneNumber, other.buyerPhoneNumber)
            && Objects.equals(buyerAddress, other.buyerAddress);
    }

    /**
     * Converts this PrePopulatedData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "PrePopulatedData [" + "buyerEmail=" + buyerEmail + ", buyerPhoneNumber="
                + buyerPhoneNumber + ", buyerAddress=" + buyerAddress + "]";
    }

    /**
     * Builds a new {@link PrePopulatedData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link PrePopulatedData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .buyerAddress(getBuyerAddress());
        builder.buyerEmail = internalGetBuyerEmail();
        builder.buyerPhoneNumber = internalGetBuyerPhoneNumber();
        return builder;
    }

    /**
     * Class to build instances of {@link PrePopulatedData}.
     */
    public static class Builder {
        private OptionalNullable<String> buyerEmail;
        private OptionalNullable<String> buyerPhoneNumber;
        private Address buyerAddress;



        /**
         * Setter for buyerEmail.
         * @param  buyerEmail  String value for buyerEmail.
         * @return Builder
         */
        public Builder buyerEmail(String buyerEmail) {
            this.buyerEmail = OptionalNullable.of(buyerEmail);
            return this;
        }

        /**
         * UnSetter for buyerEmail.
         * @return Builder
         */
        public Builder unsetBuyerEmail() {
            buyerEmail = null;
            return this;
        }

        /**
         * Setter for buyerPhoneNumber.
         * @param  buyerPhoneNumber  String value for buyerPhoneNumber.
         * @return Builder
         */
        public Builder buyerPhoneNumber(String buyerPhoneNumber) {
            this.buyerPhoneNumber = OptionalNullable.of(buyerPhoneNumber);
            return this;
        }

        /**
         * UnSetter for buyerPhoneNumber.
         * @return Builder
         */
        public Builder unsetBuyerPhoneNumber() {
            buyerPhoneNumber = null;
            return this;
        }

        /**
         * Setter for buyerAddress.
         * @param  buyerAddress  Address value for buyerAddress.
         * @return Builder
         */
        public Builder buyerAddress(Address buyerAddress) {
            this.buyerAddress = buyerAddress;
            return this;
        }

        /**
         * Builds a new {@link PrePopulatedData} object using the set fields.
         * @return {@link PrePopulatedData}
         */
        public PrePopulatedData build() {
            return new PrePopulatedData(buyerEmail, buyerPhoneNumber, buyerAddress);
        }
    }
}
