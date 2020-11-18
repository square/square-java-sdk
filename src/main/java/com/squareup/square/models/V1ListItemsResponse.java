
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1ListItemsResponse type.
 */
public class V1ListItemsResponse {
    private final List<V1Item> items;

    /**
     * Initialization constructor.
     * @param items List of V1Item value for items.
     */
    @JsonCreator
    public V1ListItemsResponse(
            @JsonProperty("items") List<V1Item> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1Item
     */
    @JsonGetter("items")
    public List<V1Item> getItems() {
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
        if (!(obj instanceof V1ListItemsResponse)) {
            return false;
        }
        V1ListItemsResponse other = (V1ListItemsResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Converts this V1ListItemsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListItemsResponse [" + "items=" + items + "]";
    }

    /**
     * Builds a new {@link V1ListItemsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListItemsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .items(getItems());
        return builder;
    }

    /**
     * Class to build instances of {@link V1ListItemsResponse}.
     */
    public static class Builder {
        private List<V1Item> items;



        /**
         * Setter for items.
         * @param items List of V1Item value for items.
         * @return Builder
         */
        public Builder items(List<V1Item> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListItemsResponse} object using the set fields.
         * @return {@link V1ListItemsResponse}
         */
        public V1ListItemsResponse build() {
            return new V1ListItemsResponse(items);
        }
    }
}
