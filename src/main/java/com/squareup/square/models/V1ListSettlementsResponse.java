
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1ListSettlementsResponse type.
 */
public class V1ListSettlementsResponse {
    private final List<V1Settlement> items;

    /**
     * Initialization constructor.
     * @param items List of V1Settlement value for items.
     */
    @JsonCreator
    public V1ListSettlementsResponse(
            @JsonProperty("items") List<V1Settlement> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1Settlement
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListSettlementsResponse)) {
            return false;
        }
        V1ListSettlementsResponse other = (V1ListSettlementsResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Converts this V1ListSettlementsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListSettlementsResponse [" + "items=" + items + "]";
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
     * Class to build instances of {@link V1ListSettlementsResponse}.
     */
    public static class Builder {
        private List<V1Settlement> items;



        /**
         * Setter for items.
         * @param items List of V1Settlement value for items.
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
