package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListModifierListsResponse type.
 */
public class V1ListModifierListsResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListModifierListsResponse(
            @JsonProperty("items") List<V1ModifierList> items) {
        this.items = items;
    }

    private final List<V1ModifierList> items;
    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1ModifierList> getItems() {
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
        if(!(obj instanceof V1ListModifierListsResponse)) {
            return false;
        }
        V1ListModifierListsResponse v1ListModifierListsResponse = (V1ListModifierListsResponse) obj;
        return Objects.equals(items, v1ListModifierListsResponse.items);
    }

    /**
     * Builds a new {@link V1ListModifierListsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListModifierListsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListModifierListsResponse}
     */
    public static class Builder {
        private List<V1ModifierList> items;

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
        public Builder items(List<V1ModifierList> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListModifierListsResponse} object using the set fields.
         * @return {@link V1ListModifierListsResponse}
         */
        public V1ListModifierListsResponse build() {
            return new V1ListModifierListsResponse(items);
        }
    }
}
