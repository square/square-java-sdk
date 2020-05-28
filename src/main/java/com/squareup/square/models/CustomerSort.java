package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CustomerSort type.
 */
public class CustomerSort {

    /**
     * Initialization constructor.
     * @param field
     * @param order
     */
    @JsonCreator
    public CustomerSort(
            @JsonProperty("field") String field,
            @JsonProperty("order") String order) {
        this.field = field;
        this.order = order;
    }

    private final String field;
    private final String order;
    /**
     * Getter for Field.
     * Specifies customer attributes as the sort key to customer profiles returned from a search.
     */
    @JsonGetter("field")
    public String getField() {
        return this.field;
    }

    /**
     * Getter for Order.
     * The order (e.g., chronological or alphabetical) in which results from a request are returned.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CustomerSort)) {
            return false;
        }
        CustomerSort customerSort = (CustomerSort) obj;
        return Objects.equals(field, customerSort.field) &&
            Objects.equals(order, customerSort.order);
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
     * Class to build instances of {@link CustomerSort}
     */
    public static class Builder {
        private String field;
        private String order;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for field
         * @param field
         * @return Builder
         */
        public Builder field(String field) {
            this.field = field;
            return this;
        }
        /**
         * Setter for order
         * @param order
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
            return new CustomerSort(field,
                order);
        }
    }
}
