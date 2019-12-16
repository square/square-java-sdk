package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListItemsResponse {

    @JsonCreator
    public V1ListItemsResponse(
            @JsonProperty("items") List<V1Item> items) {
        this.items = items;
    }

    private final List<V1Item> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListItemsResponse)) {
            return false;
        }
        V1ListItemsResponse v1ListItemsResponse = (V1ListItemsResponse) o;
        return Objects.equals(items, v1ListItemsResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Item> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1Item> items;

        public Builder() { }

        public Builder items(List<V1Item> value) {
            items = value;
            return this;
        }

        public V1ListItemsResponse build() {
            return new V1ListItemsResponse(items);
        }
    }
}
