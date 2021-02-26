
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyEventQuery type.
 */
public class LoyaltyEventQuery {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final LoyaltyEventFilter filter;

    /**
     * Initialization constructor.
     * @param  filter  LoyaltyEventFilter value for filter.
     */
    @JsonCreator
    public LoyaltyEventQuery(
            @JsonProperty("filter") LoyaltyEventFilter filter) {
        this.filter = filter;
    }

    /**
     * Getter for Filter.
     * The filtering criteria. If the request specifies multiple filters, the endpoint uses a
     * logical AND to evaluate them.
     * @return Returns the LoyaltyEventFilter
     */
    @JsonGetter("filter")
    public LoyaltyEventFilter getFilter() {
        return filter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filter);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEventQuery)) {
            return false;
        }
        LoyaltyEventQuery other = (LoyaltyEventQuery) obj;
        return Objects.equals(filter, other.filter);
    }

    /**
     * Converts this LoyaltyEventQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyEventQuery [" + "filter=" + filter + "]";
    }

    /**
     * Builds a new {@link LoyaltyEventQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .filter(getFilter());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventQuery}.
     */
    public static class Builder {
        private LoyaltyEventFilter filter;



        /**
         * Setter for filter.
         * @param  filter  LoyaltyEventFilter value for filter.
         * @return Builder
         */
        public Builder filter(LoyaltyEventFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventQuery} object using the set fields.
         * @return {@link LoyaltyEventQuery}
         */
        public LoyaltyEventQuery build() {
            return new LoyaltyEventQuery(filter);
        }
    }
}
