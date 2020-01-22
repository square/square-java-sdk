package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListInventoryResponse type.
 */
public class V1ListInventoryResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListInventoryResponse(
            @JsonProperty("items") List<V1InventoryEntry> items) {
        this.items = items;
    }

    private final List<V1InventoryEntry> items;
    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1InventoryEntry> getItems() {
        return this.items;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1ListInventoryResponse)) {
            return false;
        }
        V1ListInventoryResponse v1ListInventoryResponse = (V1ListInventoryResponse) obj;
        return Objects.equals(items, v1ListInventoryResponse.items);
    }

    /**
     * Builds a new {@link V1ListInventoryResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListInventoryResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListInventoryResponse}
     */
    public static class Builder {
        private List<V1InventoryEntry> items;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for items
         * @param items
         * @return Builder
         */
        public Builder items(List<V1InventoryEntry> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListInventoryResponse} object using the set fields.
         * @return {@link V1ListInventoryResponse}
         */
        public V1ListInventoryResponse build() {
            return new V1ListInventoryResponse(items);
        }
    }
}
