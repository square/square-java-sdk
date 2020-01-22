package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListSettlementsResponse type.
 */
public class V1ListSettlementsResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListSettlementsResponse(
            @JsonProperty("items") List<V1Settlement> items) {
        this.items = items;
    }

    private final List<V1Settlement> items;
    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Settlement> getItems() {
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
        if(!(obj instanceof V1ListSettlementsResponse)) {
            return false;
        }
        V1ListSettlementsResponse v1ListSettlementsResponse = (V1ListSettlementsResponse) obj;
        return Objects.equals(items, v1ListSettlementsResponse.items);
    }

    /**
     * Builds a new {@link V1ListSettlementsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListSettlementsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListSettlementsResponse}
     */
    public static class Builder {
        private List<V1Settlement> items;

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
        public Builder items(List<V1Settlement> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListSettlementsResponse} object using the set fields.
         * @return {@link V1ListSettlementsResponse}
         */
        public V1ListSettlementsResponse build() {
            return new V1ListSettlementsResponse(items);
        }
    }
}
