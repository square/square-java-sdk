
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1ListInventoryResponse type.
 */
public class V1ListInventoryResponse {
    private final List<V1InventoryEntry> items;

    /**
     * Initialization constructor.
     * @param items List of V1InventoryEntry value for items.
     */
    @JsonCreator
    public V1ListInventoryResponse(
            @JsonProperty("items") List<V1InventoryEntry> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1InventoryEntry
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListInventoryResponse)) {
            return false;
        }
        V1ListInventoryResponse other = (V1ListInventoryResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Converts this V1ListInventoryResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListInventoryResponse [" + "items=" + items + "]";
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
     * Class to build instances of {@link V1ListInventoryResponse}.
     */
    public static class Builder {
        private List<V1InventoryEntry> items;



        /**
         * Setter for items.
         * @param items List of V1InventoryEntry value for items.
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
