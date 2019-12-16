package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CustomerSort {

    @JsonCreator
    public CustomerSort(
            @JsonProperty("field") String field,
            @JsonProperty("order") String order) {
        this.field = field;
        this.order = order;
    }

    private final String field;
    private final String order;

    @Override
    public int hashCode() {
        return Objects.hash(field, order);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerSort)) {
            return false;
        }
        CustomerSort customerSort = (CustomerSort) o;
        return Objects.equals(field, customerSort.field) &&
            Objects.equals(order, customerSort.order);
    }

    /**
     * Getter for Field.
     * Indicates the sort criteria for a list of Customers.
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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .field(getField())
            .order(getOrder());
            return builder;
    }

    public static class Builder {
        private String field;
        private String order;

        public Builder() { }

        public Builder field(String value) {
            field = value;
            return this;
        }
        public Builder order(String value) {
            order = value;
            return this;
        }

        public CustomerSort build() {
            return new CustomerSort(field,
                order);
        }
    }
}
