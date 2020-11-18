
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1ListCategoriesResponse type.
 */
public class V1ListCategoriesResponse {
    private final List<V1Category> items;

    /**
     * Initialization constructor.
     * @param items List of V1Category value for items.
     */
    @JsonCreator
    public V1ListCategoriesResponse(
            @JsonProperty("items") List<V1Category> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1Category
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListCategoriesResponse)) {
            return false;
        }
        V1ListCategoriesResponse other = (V1ListCategoriesResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Converts this V1ListCategoriesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListCategoriesResponse [" + "items=" + items + "]";
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
     * Class to build instances of {@link V1ListCategoriesResponse}.
     */
    public static class Builder {
        private List<V1Category> items;



        /**
         * Setter for items.
         * @param items List of V1Category value for items.
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
