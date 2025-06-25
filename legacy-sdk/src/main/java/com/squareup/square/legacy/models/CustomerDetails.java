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
 * This is a model class for CustomerDetails type.
 */
public class CustomerDetails {
    private final OptionalNullable<Boolean> customerInitiated;
    private final OptionalNullable<Boolean> sellerKeyedIn;

    /**
     * Initialization constructor.
     * @param  customerInitiated  Boolean value for customerInitiated.
     * @param  sellerKeyedIn  Boolean value for sellerKeyedIn.
     */
    @JsonCreator
    public CustomerDetails(
            @JsonProperty("customer_initiated") Boolean customerInitiated,
            @JsonProperty("seller_keyed_in") Boolean sellerKeyedIn) {
        this.customerInitiated = OptionalNullable.of(customerInitiated);
        this.sellerKeyedIn = OptionalNullable.of(sellerKeyedIn);
    }

    /**
     * Initialization constructor.
     * @param  customerInitiated  Boolean value for customerInitiated.
     * @param  sellerKeyedIn  Boolean value for sellerKeyedIn.
     */
    protected CustomerDetails(OptionalNullable<Boolean> customerInitiated, OptionalNullable<Boolean> sellerKeyedIn) {
        this.customerInitiated = customerInitiated;
        this.sellerKeyedIn = sellerKeyedIn;
    }

    /**
     * Internal Getter for CustomerInitiated.
     * Indicates whether the customer initiated the payment.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("customer_initiated")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetCustomerInitiated() {
        return this.customerInitiated;
    }

    /**
     * Getter for CustomerInitiated.
     * Indicates whether the customer initiated the payment.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getCustomerInitiated() {
        return OptionalNullable.getFrom(customerInitiated);
    }

    /**
     * Internal Getter for SellerKeyedIn.
     * Indicates that the seller keyed in payment details on behalf of the customer. This is used to
     * flag a payment as Mail Order / Telephone Order (MOTO).
     * @return Returns the Internal Boolean
     */
    @JsonGetter("seller_keyed_in")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetSellerKeyedIn() {
        return this.sellerKeyedIn;
    }

    /**
     * Getter for SellerKeyedIn.
     * Indicates that the seller keyed in payment details on behalf of the customer. This is used to
     * flag a payment as Mail Order / Telephone Order (MOTO).
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getSellerKeyedIn() {
        return OptionalNullable.getFrom(sellerKeyedIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerInitiated, sellerKeyedIn);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomerDetails)) {
            return false;
        }
        CustomerDetails other = (CustomerDetails) obj;
        return Objects.equals(customerInitiated, other.customerInitiated)
                && Objects.equals(sellerKeyedIn, other.sellerKeyedIn);
    }

    /**
     * Converts this CustomerDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomerDetails [" + "customerInitiated=" + customerInitiated + ", sellerKeyedIn=" + sellerKeyedIn
                + "]";
    }

    /**
     * Builds a new {@link CustomerDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.customerInitiated = internalGetCustomerInitiated();
        builder.sellerKeyedIn = internalGetSellerKeyedIn();
        return builder;
    }

    /**
     * Class to build instances of {@link CustomerDetails}.
     */
    public static class Builder {
        private OptionalNullable<Boolean> customerInitiated;
        private OptionalNullable<Boolean> sellerKeyedIn;

        /**
         * Setter for customerInitiated.
         * @param  customerInitiated  Boolean value for customerInitiated.
         * @return Builder
         */
        public Builder customerInitiated(Boolean customerInitiated) {
            this.customerInitiated = OptionalNullable.of(customerInitiated);
            return this;
        }

        /**
         * UnSetter for customerInitiated.
         * @return Builder
         */
        public Builder unsetCustomerInitiated() {
            customerInitiated = null;
            return this;
        }

        /**
         * Setter for sellerKeyedIn.
         * @param  sellerKeyedIn  Boolean value for sellerKeyedIn.
         * @return Builder
         */
        public Builder sellerKeyedIn(Boolean sellerKeyedIn) {
            this.sellerKeyedIn = OptionalNullable.of(sellerKeyedIn);
            return this;
        }

        /**
         * UnSetter for sellerKeyedIn.
         * @return Builder
         */
        public Builder unsetSellerKeyedIn() {
            sellerKeyedIn = null;
            return this;
        }

        /**
         * Builds a new {@link CustomerDetails} object using the set fields.
         * @return {@link CustomerDetails}
         */
        public CustomerDetails build() {
            return new CustomerDetails(customerInitiated, sellerKeyedIn);
        }
    }
}
