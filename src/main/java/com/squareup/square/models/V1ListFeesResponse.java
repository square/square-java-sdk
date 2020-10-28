
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for V1ListFeesResponse type.
 */
public class V1ListFeesResponse {
    private final List<V1Fee> items;

    /**
     * Initialization constructor.
     * @param items List of V1Fee value for items.
     */
    @JsonCreator
    public V1ListFeesResponse(
            @JsonProperty("items") List<V1Fee> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1Fee
     */
    @JsonGetter("items")
    public List<V1Fee> getItems() {
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
        if (!(obj instanceof V1ListFeesResponse)) {
            return false;
        }
        V1ListFeesResponse other = (V1ListFeesResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Builds a new {@link V1ListFeesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListFeesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
        return builder;
    }

    /**
     * Class to build instances of {@link V1ListFeesResponse}.
     */
    public static class Builder {
        private List<V1Fee> items;



        /**
         * Setter for items.
         * @param items List of V1Fee value for items.
         * @return Builder
         */
        public Builder items(List<V1Fee> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListFeesResponse} object using the set fields.
         * @return {@link V1ListFeesResponse}
         */
        public V1ListFeesResponse build() {
            return new V1ListFeesResponse(items);
        }
    }
}
