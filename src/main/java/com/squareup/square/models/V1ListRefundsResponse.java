package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListRefundsResponse type.
 */
public class V1ListRefundsResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListRefundsResponse(
            @JsonProperty("items") List<V1Refund> items) {
        this.items = items;
    }

    private final List<V1Refund> items;
    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Refund> getItems() {
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
        if(!(obj instanceof V1ListRefundsResponse)) {
            return false;
        }
        V1ListRefundsResponse v1ListRefundsResponse = (V1ListRefundsResponse) obj;
        return Objects.equals(items, v1ListRefundsResponse.items);
    }

    /**
     * Builds a new {@link V1ListRefundsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListRefundsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListRefundsResponse}
     */
    public static class Builder {
        private List<V1Refund> items;

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
        public Builder items(List<V1Refund> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListRefundsResponse} object using the set fields.
         * @return {@link V1ListRefundsResponse}
         */
        public V1ListRefundsResponse build() {
            return new V1ListRefundsResponse(items);
        }
    }
}
