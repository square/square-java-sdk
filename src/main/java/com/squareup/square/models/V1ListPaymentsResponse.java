package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListPaymentsResponse type.
 */
public class V1ListPaymentsResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListPaymentsResponse(
            @JsonProperty("items") List<V1Payment> items) {
        this.items = items;
    }

    private final List<V1Payment> items;
    /**
     * Getter for Items.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1ListPaymentsResponse)) {
            return false;
        }
        V1ListPaymentsResponse v1ListPaymentsResponse = (V1ListPaymentsResponse) obj;
        return Objects.equals(items, v1ListPaymentsResponse.items);
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
     * Class to build instances of {@link V1ListPaymentsResponse}
     */
    public static class Builder {
        private List<V1Payment> items;

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
