package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListLocationsResponse {

    @JsonCreator
    public V1ListLocationsResponse(
            @JsonProperty("items") List<V1Merchant> items) {
        this.items = items;
    }

    private final List<V1Merchant> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListLocationsResponse)) {
            return false;
        }
        V1ListLocationsResponse v1ListLocationsResponse = (V1ListLocationsResponse) o;
        return Objects.equals(items, v1ListLocationsResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Merchant> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1Merchant> items;

        public Builder() { }

        public Builder items(List<V1Merchant> value) {
            items = value;
            return this;
        }

        public V1ListLocationsResponse build() {
            return new V1ListLocationsResponse(items);
        }
    }
}
