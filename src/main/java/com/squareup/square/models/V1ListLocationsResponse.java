package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListLocationsResponse type.
 */
public class V1ListLocationsResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListLocationsResponse(
            @JsonProperty("items") List<V1Merchant> items) {
        this.items = items;
    }

    private final List<V1Merchant> items;
    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Merchant> getItems() {
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
        if(!(obj instanceof V1ListLocationsResponse)) {
            return false;
        }
        V1ListLocationsResponse v1ListLocationsResponse = (V1ListLocationsResponse) obj;
        return Objects.equals(items, v1ListLocationsResponse.items);
    }

    /**
     * Builds a new {@link V1ListLocationsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListLocationsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListLocationsResponse}
     */
    public static class Builder {
        private List<V1Merchant> items;

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
        public Builder items(List<V1Merchant> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListLocationsResponse} object using the set fields.
         * @return {@link V1ListLocationsResponse}
         */
        public V1ListLocationsResponse build() {
            return new V1ListLocationsResponse(items);
        }
    }
}
