package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListTimecardsResponse type.
 */
public class V1ListTimecardsResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListTimecardsResponse(
            @JsonProperty("items") List<V1Timecard> items) {
        this.items = items;
    }

    private final List<V1Timecard> items;
    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Timecard> getItems() {
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
        if(!(obj instanceof V1ListTimecardsResponse)) {
            return false;
        }
        V1ListTimecardsResponse v1ListTimecardsResponse = (V1ListTimecardsResponse) obj;
        return Objects.equals(items, v1ListTimecardsResponse.items);
    }

    /**
     * Builds a new {@link V1ListTimecardsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListTimecardsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListTimecardsResponse}
     */
    public static class Builder {
        private List<V1Timecard> items;

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
        public Builder items(List<V1Timecard> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListTimecardsResponse} object using the set fields.
         * @return {@link V1ListTimecardsResponse}
         */
        public V1ListTimecardsResponse build() {
            return new V1ListTimecardsResponse(items);
        }
    }
}
