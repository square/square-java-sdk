
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1ListPaymentsResponse type.
 */
public class V1ListPaymentsResponse {
    private final List<V1Payment> items;

    /**
     * Initialization constructor.
     * @param items List of V1Payment value for items.
     */
    @JsonCreator
    public V1ListPaymentsResponse(
            @JsonProperty("items") List<V1Payment> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1Payment
     */
    @JsonGetter("items")
    public List<V1Payment> getItems() {
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
        if (!(obj instanceof V1ListPaymentsResponse)) {
            return false;
        }
        V1ListPaymentsResponse other = (V1ListPaymentsResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Converts this V1ListPaymentsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListPaymentsResponse [" + "items=" + items + "]";
    }

    /**
     * Builds a new {@link V1ListPaymentsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListPaymentsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .items(getItems());
        return builder;
    }

    /**
     * Class to build instances of {@link V1ListPaymentsResponse}.
     */
    public static class Builder {
        private List<V1Payment> items;



        /**
         * Setter for items.
         * @param items List of V1Payment value for items.
         * @return Builder
         */
        public Builder items(List<V1Payment> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListPaymentsResponse} object using the set fields.
         * @return {@link V1ListPaymentsResponse}
         */
        public V1ListPaymentsResponse build() {
            return new V1ListPaymentsResponse(items);
        }
    }
}
