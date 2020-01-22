package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListPagesResponse type.
 */
public class V1ListPagesResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListPagesResponse(
            @JsonProperty("items") List<V1Page> items) {
        this.items = items;
    }

    private final List<V1Page> items;
    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Page> getItems() {
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
        if(!(obj instanceof V1ListPagesResponse)) {
            return false;
        }
        V1ListPagesResponse v1ListPagesResponse = (V1ListPagesResponse) obj;
        return Objects.equals(items, v1ListPagesResponse.items);
    }

    /**
     * Builds a new {@link V1ListPagesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListPagesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListPagesResponse}
     */
    public static class Builder {
        private List<V1Page> items;

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
        public Builder items(List<V1Page> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListPagesResponse} object using the set fields.
         * @return {@link V1ListPagesResponse}
         */
        public V1ListPagesResponse build() {
            return new V1ListPagesResponse(items);
        }
    }
}
