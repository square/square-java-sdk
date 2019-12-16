package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListCashDrawerShiftsResponse {

    @JsonCreator
    public V1ListCashDrawerShiftsResponse(
            @JsonProperty("items") List<V1CashDrawerShift> items) {
        this.items = items;
    }

    private final List<V1CashDrawerShift> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListCashDrawerShiftsResponse)) {
            return false;
        }
        V1ListCashDrawerShiftsResponse v1ListCashDrawerShiftsResponse = (V1ListCashDrawerShiftsResponse) o;
        return Objects.equals(items, v1ListCashDrawerShiftsResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1CashDrawerShift> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1CashDrawerShift> items;

        public Builder() { }

        public Builder items(List<V1CashDrawerShift> value) {
            items = value;
            return this;
        }

        public V1ListCashDrawerShiftsResponse build() {
            return new V1ListCashDrawerShiftsResponse(items);
        }
    }
}
