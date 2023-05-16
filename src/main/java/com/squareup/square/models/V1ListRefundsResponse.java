
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for V1ListRefundsResponse type.
 */
public class V1ListRefundsResponse {
    private final List<V1Refund> items;

    /**
     * Initialization constructor.
     * @param  items  List of V1Refund value for items.
     */
    @JsonCreator
    public V1ListRefundsResponse(
            @JsonProperty("items") List<V1Refund> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1Refund
     */
    @JsonGetter("items")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<V1Refund> getItems() {
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
        if (!(obj instanceof V1ListRefundsResponse)) {
            return false;
        }
        V1ListRefundsResponse other = (V1ListRefundsResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Converts this V1ListRefundsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1ListRefundsResponse [" + "items=" + items + "]";
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
     * Class to build instances of {@link V1ListRefundsResponse}.
     */
    public static class Builder {
        private List<V1Refund> items;



        /**
         * Setter for items.
         * @param  items  List of V1Refund value for items.
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
