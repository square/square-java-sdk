
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CustomerSort type.
 */
public class CustomerSort {
    private final String field;
    private final String order;

    /**
     * Initialization constructor.
     * @param field String value for field.
     * @param order String value for order.
     */
    @JsonCreator
    public CustomerSort(
            @JsonProperty("field") String field,
            @JsonProperty("order") String order) {
        this.field = field;
        this.order = order;
    }

    /**
     * Getter for Field.
     * Specifies customer attributes as the sort key to customer profiles returned from a search.
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
        if (!(obj instanceof CustomerSort)) {
            return false;
        }
        CustomerSort other = (CustomerSort) obj;
        return Objects.equals(field, other.field)
            && Objects.equals(order, other.order);
    }

    /**
     * Converts this CustomerSort into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomerSort [" + "field=" + field + ", order=" + order + "]";
    }

    /**
     * Builds a new {@link CustomerSort.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerSort.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .field(getField())
                .order(getOrder());
        return builder;
    }

    /**
     * Class to build instances of {@link CustomerSort}.
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
         * Builds a new {@link CustomerSort} object using the set fields.
         * @return {@link CustomerSort}
         */
        public CustomerSort build() {
            return new CustomerSort(field, order);
        }
    }
}
