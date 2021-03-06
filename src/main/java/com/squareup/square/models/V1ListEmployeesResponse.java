
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1ListEmployeesResponse type.
 */
public class V1ListEmployeesResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<V1Employee> items;

    /**
     * Initialization constructor.
     * @param  items  List of V1Employee value for items.
     */
    @JsonCreator
    public V1ListEmployeesResponse(
            @JsonProperty("items") List<V1Employee> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1Employee
     */
    @JsonGetter("items")
    public List<V1Employee> getItems() {
        return items;
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
        if (!(obj instanceof V1ListEmployeesResponse)) {
            return false;
        }
        V1ListEmployeesResponse other = (V1ListEmployeesResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Converts this V1ListEmployeesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListEmployeesResponse [" + "items=" + items + "]";
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
     * Class to build instances of {@link V1ListEmployeesResponse}.
     */
    public static class Builder {
        private List<V1Employee> items;



        /**
         * Setter for items.
         * @param  items  List of V1Employee value for items.
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
