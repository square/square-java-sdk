package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListOrdersResponse type.
 */
public class V1ListOrdersResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListOrdersResponse(
            @JsonProperty("items") List<V1Order> items) {
        this.items = items;
    }

    private final List<V1Order> items;
    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Order> getItems() {
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
        if(!(obj instanceof V1ListOrdersResponse)) {
            return false;
        }
        V1ListOrdersResponse v1ListOrdersResponse = (V1ListOrdersResponse) obj;
        return Objects.equals(items, v1ListOrdersResponse.items);
    }

    /**
     * Builds a new {@link V1ListOrdersResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListOrdersResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListOrdersResponse}
     */
    public static class Builder {
        private List<V1Order> items;

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
        public Builder items(List<V1Order> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListOrdersResponse} object using the set fields.
         * @return {@link V1ListOrdersResponse}
         */
        public V1ListOrdersResponse build() {
            return new V1ListOrdersResponse(items);
        }
    }
}
