
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for V1ListCashDrawerShiftsResponse type.
 */
public class V1ListCashDrawerShiftsResponse {
    private final List<V1CashDrawerShift> items;

    /**
     * Initialization constructor.
     * @param items List of V1CashDrawerShift value for items.
     */
    @JsonCreator
    public V1ListCashDrawerShiftsResponse(
            @JsonProperty("items") List<V1CashDrawerShift> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1CashDrawerShift
     */
    @JsonGetter("items")
    public List<V1CashDrawerShift> getItems() {
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
        if (!(obj instanceof V1ListCashDrawerShiftsResponse)) {
            return false;
        }
        V1ListCashDrawerShiftsResponse other = (V1ListCashDrawerShiftsResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Builds a new {@link V1ListCashDrawerShiftsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListCashDrawerShiftsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
        return builder;
    }

    /**
     * Class to build instances of {@link V1ListCashDrawerShiftsResponse}.
     */
    public static class Builder {
        private List<V1CashDrawerShift> items;



        /**
         * Setter for items.
         * @param items List of V1CashDrawerShift value for items.
         * @return Builder
         */
        public Builder items(List<V1CashDrawerShift> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListCashDrawerShiftsResponse} object using the set fields.
         * @return {@link V1ListCashDrawerShiftsResponse}
         */
        public V1ListCashDrawerShiftsResponse build() {
            return new V1ListCashDrawerShiftsResponse(items);
        }
    }
}
