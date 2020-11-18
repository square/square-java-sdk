
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1ListLocationsResponse type.
 */
public class V1ListLocationsResponse {
    private final List<V1Merchant> items;

    /**
     * Initialization constructor.
     * @param items List of V1Merchant value for items.
     */
    @JsonCreator
    public V1ListLocationsResponse(
            @JsonProperty("items") List<V1Merchant> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1Merchant
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListLocationsResponse)) {
            return false;
        }
        V1ListLocationsResponse other = (V1ListLocationsResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Converts this V1ListLocationsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListLocationsResponse [" + "items=" + items + "]";
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
     * Class to build instances of {@link V1ListLocationsResponse}.
     */
    public static class Builder {
        private List<V1Merchant> items;



        /**
         * Setter for items.
         * @param items List of V1Merchant value for items.
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
