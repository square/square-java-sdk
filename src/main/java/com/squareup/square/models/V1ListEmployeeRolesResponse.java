
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for V1ListEmployeeRolesResponse type.
 */
public class V1ListEmployeeRolesResponse {
    private final List<V1EmployeeRole> items;

    /**
     * Initialization constructor.
     * @param items List of V1EmployeeRole value for items.
     */
    @JsonCreator
    public V1ListEmployeeRolesResponse(
            @JsonProperty("items") List<V1EmployeeRole> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1EmployeeRole
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListEmployeeRolesResponse)) {
            return false;
        }
        V1ListEmployeeRolesResponse other = (V1ListEmployeeRolesResponse) obj;
        return Objects.equals(items, other.items);
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
     * Class to build instances of {@link V1ListEmployeeRolesResponse}.
     */
    public static class Builder {
        private List<V1EmployeeRole> items;



        /**
         * Setter for items.
         * @param items List of V1EmployeeRole value for items.
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
