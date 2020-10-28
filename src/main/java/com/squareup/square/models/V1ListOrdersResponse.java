
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for V1ListOrdersResponse type.
 */
public class V1ListOrdersResponse {
    private final List<V1Order> items;

    /**
     * Initialization constructor.
     * @param items List of V1Order value for items.
     */
    @JsonCreator
    public V1ListOrdersResponse(
            @JsonProperty("items") List<V1Order> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1Order
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListOrdersResponse)) {
            return false;
        }
        V1ListOrdersResponse other = (V1ListOrdersResponse) obj;
        return Objects.equals(items, other.items);
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
     * Class to build instances of {@link V1ListOrdersResponse}.
     */
    public static class Builder {
        private List<V1Order> items;



        /**
         * Setter for items.
         * @param items List of V1Order value for items.
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
