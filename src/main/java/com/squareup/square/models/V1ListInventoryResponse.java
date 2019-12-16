package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListInventoryResponse {

    @JsonCreator
    public V1ListInventoryResponse(
            @JsonProperty("items") List<V1InventoryEntry> items) {
        this.items = items;
    }

    private final List<V1InventoryEntry> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListInventoryResponse)) {
            return false;
        }
        V1ListInventoryResponse v1ListInventoryResponse = (V1ListInventoryResponse) o;
        return Objects.equals(items, v1ListInventoryResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1InventoryEntry> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1InventoryEntry> items;

        public Builder() { }

        public Builder items(List<V1InventoryEntry> value) {
            items = value;
            return this;
        }

        public V1ListInventoryResponse build() {
            return new V1ListInventoryResponse(items);
        }
    }
}
