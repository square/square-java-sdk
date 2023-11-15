
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
 * This is a model class for QuantityRatio type.
 */
public class QuantityRatio {
    private final OptionalNullable<Integer> quantity;
    private final OptionalNullable<Integer> quantityDenominator;

    /**
     * Initialization constructor.
     * @param  quantity  Integer value for quantity.
     * @param  quantityDenominator  Integer value for quantityDenominator.
     */
    @JsonCreator
    public QuantityRatio(
            @JsonProperty("quantity") Integer quantity,
            @JsonProperty("quantity_denominator") Integer quantityDenominator) {
        this.quantity = OptionalNullable.of(quantity);
        this.quantityDenominator = OptionalNullable.of(quantityDenominator);
    }

    /**
     * Initialization constructor.
     * @param  quantity  Integer value for quantity.
     * @param  quantityDenominator  Integer value for quantityDenominator.
     */

    protected QuantityRatio(OptionalNullable<Integer> quantity,
            OptionalNullable<Integer> quantityDenominator) {
        this.quantity = quantity;
        this.quantityDenominator = quantityDenominator;
    }

    /**
     * Internal Getter for Quantity.
     * The whole or fractional quantity as the numerator.
     * @return Returns the Internal Integer
     */
    @JsonGetter("quantity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetQuantity() {
        return this.quantity;
    }

    /**
     * Getter for Quantity.
     * The whole or fractional quantity as the numerator.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getQuantity() {
        return OptionalNullable.getFrom(quantity);
    }

    /**
     * Internal Getter for QuantityDenominator.
     * The whole or fractional quantity as the denominator. In the case of fractional quantity this
     * field is the denominator and quantity is the numerator. When unspecified, the value is `1`.
     * For example, when `quantity=3` and `quantity_donominator` is unspecified, the quantity ratio
     * is `3` or `3/1`.
     * @return Returns the Internal Integer
     */
    @JsonGetter("quantity_denominator")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Integer> internalGetQuantityDenominator() {
        return this.quantityDenominator;
    }

    /**
     * Getter for QuantityDenominator.
     * The whole or fractional quantity as the denominator. In the case of fractional quantity this
     * field is the denominator and quantity is the numerator. When unspecified, the value is `1`.
     * For example, when `quantity=3` and `quantity_donominator` is unspecified, the quantity ratio
     * is `3` or `3/1`.
     * @return Returns the Integer
     */
    @JsonIgnore
    public Integer getQuantityDenominator() {
        return OptionalNullable.getFrom(quantityDenominator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, quantityDenominator);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QuantityRatio)) {
            return false;
        }
        QuantityRatio other = (QuantityRatio) obj;
        return Objects.equals(quantity, other.quantity)
            && Objects.equals(quantityDenominator, other.quantityDenominator);
    }

    /**
     * Converts this QuantityRatio into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "QuantityRatio [" + "quantity=" + quantity + ", quantityDenominator="
                + quantityDenominator + "]";
    }

    /**
     * Builds a new {@link QuantityRatio.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link QuantityRatio.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.quantity = internalGetQuantity();
        builder.quantityDenominator = internalGetQuantityDenominator();
        return builder;
    }

    /**
     * Class to build instances of {@link QuantityRatio}.
     */
    public static class Builder {
        private OptionalNullable<Integer> quantity;
        private OptionalNullable<Integer> quantityDenominator;



        /**
         * Setter for quantity.
         * @param  quantity  Integer value for quantity.
         * @return Builder
         */
        public Builder quantity(Integer quantity) {
            this.quantity = OptionalNullable.of(quantity);
            return this;
        }

        /**
         * UnSetter for quantity.
         * @return Builder
         */
        public Builder unsetQuantity() {
            quantity = null;
            return this;
        }

        /**
         * Setter for quantityDenominator.
         * @param  quantityDenominator  Integer value for quantityDenominator.
         * @return Builder
         */
        public Builder quantityDenominator(Integer quantityDenominator) {
            this.quantityDenominator = OptionalNullable.of(quantityDenominator);
            return this;
        }

        /**
         * UnSetter for quantityDenominator.
         * @return Builder
         */
        public Builder unsetQuantityDenominator() {
            quantityDenominator = null;
            return this;
        }

        /**
         * Builds a new {@link QuantityRatio} object using the set fields.
         * @return {@link QuantityRatio}
         */
        public QuantityRatio build() {
            return new QuantityRatio(quantity, quantityDenominator);
        }
    }
}
