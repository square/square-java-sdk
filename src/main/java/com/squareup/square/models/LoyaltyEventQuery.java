package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyEventQuery type.
 */
public class LoyaltyEventQuery {

    /**
     * Initialization constructor.
     * @param filter
     */
    @JsonCreator
    public LoyaltyEventQuery(
            @JsonProperty("filter") LoyaltyEventFilter filter) {
        this.filter = filter;
    }

    private final LoyaltyEventFilter filter;
    /**
     * Getter for Filter.
     * The filtering criteria. If the request specifies multiple filters, 
     * the endpoint uses a logical AND to evaluate them.
     */
    @JsonGetter("filter")
    public LoyaltyEventFilter getFilter() {
        return this.filter;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(filter);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyEventQuery)) {
            return false;
        }
        LoyaltyEventQuery loyaltyEventQuery = (LoyaltyEventQuery) obj;
        return Objects.equals(filter, loyaltyEventQuery.filter);
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
     * Class to build instances of {@link LoyaltyEventQuery}
     */
    public static class Builder {
        private LoyaltyEventFilter filter;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for filter
         * @param filter
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
