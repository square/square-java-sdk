package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListItemsResponse type.
 */
public class V1ListItemsResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListItemsResponse(
            @JsonProperty("items") List<V1Item> items) {
        this.items = items;
    }

    private final List<V1Item> items;
    /**
     * Getter for Items.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1ListItemsResponse)) {
            return false;
        }
        V1ListItemsResponse v1ListItemsResponse = (V1ListItemsResponse) obj;
        return Objects.equals(items, v1ListItemsResponse.items);
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
     * Class to build instances of {@link V1ListItemsResponse}
     */
    public static class Builder {
        private List<V1Item> items;

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
