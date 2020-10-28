
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for ShiftSort type.
 */
public class ShiftSort {
    private final String field;
    private final String order;

    /**
     * Initialization constructor.
     * @param field String value for field.
     * @param order String value for order.
     */
    @JsonCreator
    public ShiftSort(
            @JsonProperty("field") String field,
            @JsonProperty("order") String order) {
        this.field = field;
        this.order = order;
    }

    /**
     * Getter for Field.
     * Enumerates the `Shift` fields to sort on.
     * @return Returns the String
     */
    @JsonGetter("field")
    public String getField() {
        return this.field;
    }

    /**
     * Getter for Order.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
     * @return Returns the String
     */
    @JsonGetter("order")
    public String getOrder() {
        return this.order;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(field, order);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShiftSort)) {
            return false;
        }
        ShiftSort other = (ShiftSort) obj;
        return Objects.equals(field, other.field)
            && Objects.equals(order, other.order);
    }

    /**
     * Builds a new {@link ShiftSort.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ShiftSort.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .field(getField())
            .order(getOrder());
        return builder;
    }

    /**
     * Class to build instances of {@link ShiftSort}.
     */
    public static class Builder {
        private String field;
        private String order;



        /**
         * Setter for field.
         * @param field String value for field.
         * @return Builder
         */
        public Builder field(String field) {
            this.field = field;
            return this;
        }

        /**
         * Setter for order.
         * @param order String value for order.
         * @return Builder
         */
        public Builder order(String order) {
            this.order = order;
            return this;
        }

        /**
         * Builds a new {@link ShiftSort} object using the set fields.
         * @return {@link ShiftSort}
         */
        public ShiftSort build() {
            return new ShiftSort(field,
                order);
        }
    }
}
