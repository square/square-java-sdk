package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListEmployeesResponse type.
 */
public class V1ListEmployeesResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListEmployeesResponse(
            @JsonProperty("items") List<V1Employee> items) {
        this.items = items;
    }

    private final List<V1Employee> items;
    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1Employee> getItems() {
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
        if(!(obj instanceof V1ListEmployeesResponse)) {
            return false;
        }
        V1ListEmployeesResponse v1ListEmployeesResponse = (V1ListEmployeesResponse) obj;
        return Objects.equals(items, v1ListEmployeesResponse.items);
    }

    /**
     * Builds a new {@link V1ListEmployeesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListEmployeesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListEmployeesResponse}
     */
    public static class Builder {
        private List<V1Employee> items;

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
        public Builder items(List<V1Employee> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListEmployeesResponse} object using the set fields.
         * @return {@link V1ListEmployeesResponse}
         */
        public V1ListEmployeesResponse build() {
            return new V1ListEmployeesResponse(items);
        }
    }
}
