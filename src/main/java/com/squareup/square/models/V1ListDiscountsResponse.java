package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListDiscountsResponse {

    @JsonCreator
    public V1ListDiscountsResponse(
            @JsonProperty("items") List<V1Discount> items) {
        this.items = items;
    }

    private final List<V1Discount> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListDiscountsResponse)) {
            return false;
        }
        V1ListDiscountsResponse v1ListDiscountsResponse = (V1ListDiscountsResponse) o;
        return Objects.equals(items, v1ListDiscountsResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Discount> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1Discount> items;

        public Builder() { }

        public Builder items(List<V1Discount> value) {
            items = value;
            return this;
        }

        public V1ListDiscountsResponse build() {
            return new V1ListDiscountsResponse(items);
        }
    }
}
