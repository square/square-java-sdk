package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ShiftSort {

    @JsonCreator
    public ShiftSort(
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
        if (!(o instanceof ShiftSort)) {
            return false;
        }
        ShiftSort shiftSort = (ShiftSort) o;
        return Objects.equals(field, shiftSort.field) &&
            Objects.equals(order, shiftSort.order);
    }

    /**
     * Getter for Field.
     * Enumerates the `Shift` fields to sort on.
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

        public ShiftSort build() {
            return new ShiftSort(field,
                order);
        }
    }
}
