package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1ListEmployeeRolesResponse type.
 */
public class V1ListEmployeeRolesResponse {

    /**
     * Initialization constructor.
     * @param items
     */
    @JsonCreator
    public V1ListEmployeeRolesResponse(
            @JsonProperty("items") List<V1EmployeeRole> items) {
        this.items = items;
    }

    private final List<V1EmployeeRole> items;
    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1EmployeeRole> getItems() {
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
        if(!(obj instanceof V1ListEmployeeRolesResponse)) {
            return false;
        }
        V1ListEmployeeRolesResponse v1ListEmployeeRolesResponse = (V1ListEmployeeRolesResponse) obj;
        return Objects.equals(items, v1ListEmployeeRolesResponse.items);
    }

    /**
     * Builds a new {@link V1ListEmployeeRolesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListEmployeeRolesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    /**
     * Class to build instances of {@link V1ListEmployeeRolesResponse}
     */
    public static class Builder {
        private List<V1EmployeeRole> items;

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
        public Builder items(List<V1EmployeeRole> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListEmployeeRolesResponse} object using the set fields.
         * @return {@link V1ListEmployeeRolesResponse}
         */
        public V1ListEmployeeRolesResponse build() {
            return new V1ListEmployeeRolesResponse(items);
        }
    }
}
