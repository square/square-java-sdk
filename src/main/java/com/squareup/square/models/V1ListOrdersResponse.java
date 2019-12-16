package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListOrdersResponse {

    @JsonCreator
    public V1ListOrdersResponse(
            @JsonProperty("items") List<V1Order> items) {
        this.items = items;
    }

    private final List<V1Order> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListOrdersResponse)) {
            return false;
        }
        V1ListOrdersResponse v1ListOrdersResponse = (V1ListOrdersResponse) o;
        return Objects.equals(items, v1ListOrdersResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Order> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1Order> items;

        public Builder() { }

        public Builder items(List<V1Order> value) {
            items = value;
            return this;
        }

        public V1ListOrdersResponse build() {
            return new V1ListOrdersResponse(items);
        }
    }
}
