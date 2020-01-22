package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListCategoriesResponse type.
 */
public class V1ListCategoriesResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListCategoriesResponse(
            @JsonProperty("items") List<V1Category> items) {
        this.items = items;
    }

    private final List<V1Category> items;
    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Category> getItems() {
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
        if(!(obj instanceof V1ListCategoriesResponse)) {
            return false;
        }
        V1ListCategoriesResponse v1ListCategoriesResponse = (V1ListCategoriesResponse) obj;
        return Objects.equals(items, v1ListCategoriesResponse.items);
    }

    /**
     * Builds a new {@link V1ListCategoriesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListCategoriesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListCategoriesResponse}
     */
    public static class Builder {
        private List<V1Category> items;

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
        public Builder items(List<V1Category> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListCategoriesResponse} object using the set fields.
         * @return {@link V1ListCategoriesResponse}
         */
        public V1ListCategoriesResponse build() {
            return new V1ListCategoriesResponse(items);
        }
    }
}
