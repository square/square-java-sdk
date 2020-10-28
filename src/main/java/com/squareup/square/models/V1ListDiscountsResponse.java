
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for V1ListDiscountsResponse type.
 */
public class V1ListDiscountsResponse {
    private final List<V1Discount> items;

    /**
     * Initialization constructor.
     * @param items List of V1Discount value for items.
     */
    @JsonCreator
    public V1ListDiscountsResponse(
            @JsonProperty("items") List<V1Discount> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1Discount
     */
    @JsonGetter("items")
    public List<V1Discount> getItems() {
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
        if (!(obj instanceof V1ListDiscountsResponse)) {
            return false;
        }
        V1ListDiscountsResponse other = (V1ListDiscountsResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Builds a new {@link V1ListDiscountsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListDiscountsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
        return builder;
    }

    /**
     * Class to build instances of {@link V1ListDiscountsResponse}.
     */
    public static class Builder {
        private List<V1Discount> items;



        /**
         * Setter for items.
         * @param items List of V1Discount value for items.
         * @return Builder
         */
        public Builder items(List<V1Discount> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListDiscountsResponse} object using the set fields.
         * @return {@link V1ListDiscountsResponse}
         */
        public V1ListDiscountsResponse build() {
            return new V1ListDiscountsResponse(items);
        }
    }
}
