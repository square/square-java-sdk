
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ShippingFee type.
 */
public class ShippingFee {
    private final String name;
    private final Money charge;

    /**
     * Initialization constructor.
     * @param  charge  Money value for charge.
     * @param  name  String value for name.
     */
    @JsonCreator
    public ShippingFee(
            @JsonProperty("charge") Money charge,
            @JsonProperty("name") String name) {
        this.name = name;
        this.charge = charge;
    }

    /**
     * Getter for Name.
     * The name for the shipping fee.
     * @return Returns the String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }

    /**
     * Getter for Charge.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("charge")
    public Money getCharge() {
        return charge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, charge);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShippingFee)) {
            return false;
        }
        ShippingFee other = (ShippingFee) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(charge, other.charge);
    }

    /**
     * Converts this ShippingFee into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ShippingFee [" + "charge=" + charge + ", name=" + name + "]";
    }

    /**
     * Builds a new {@link ShippingFee.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ShippingFee.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(charge)
                .name(getName());
        return builder;
    }

    /**
     * Class to build instances of {@link ShippingFee}.
     */
    public static class Builder {
        private Money charge;
        private String name;

        /**
         * Initialization constructor.
         * @param  charge  Money value for charge.
         */
        public Builder(Money charge) {
            this.charge = charge;
        }

        /**
         * Setter for charge.
         * @param  charge  Money value for charge.
         * @return Builder
         */
        public Builder charge(Money charge) {
            this.charge = charge;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Builds a new {@link ShippingFee} object using the set fields.
         * @return {@link ShippingFee}
         */
        public ShippingFee build() {
            return new ShippingFee(charge, name);
        }
    }
}
