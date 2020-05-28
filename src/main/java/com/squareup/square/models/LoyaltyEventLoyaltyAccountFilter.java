package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyEventLoyaltyAccountFilter type.
 */
public class LoyaltyEventLoyaltyAccountFilter {

    /**
     * Initialization constructor.
     * @param loyaltyAccountId
     */
    @JsonCreator
    public LoyaltyEventLoyaltyAccountFilter(
            @JsonProperty("loyalty_account_id") String loyaltyAccountId) {
        this.loyaltyAccountId = loyaltyAccountId;
    }

    private final String loyaltyAccountId;
    /**
     * Getter for LoyaltyAccountId.
     * The ID of the [loyalty account](#type-LoyaltyAccount) associated with loyalty events.
     */
    @JsonGetter("loyalty_account_id")
    public String getLoyaltyAccountId() {
        return this.loyaltyAccountId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(loyaltyAccountId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyEventLoyaltyAccountFilter)) {
            return false;
        }
        LoyaltyEventLoyaltyAccountFilter loyaltyEventLoyaltyAccountFilter = (LoyaltyEventLoyaltyAccountFilter) obj;
        return Objects.equals(loyaltyAccountId, loyaltyEventLoyaltyAccountFilter.loyaltyAccountId);
    }

    /**
     * Builds a new {@link LoyaltyEventLoyaltyAccountFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventLoyaltyAccountFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(loyaltyAccountId);
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventLoyaltyAccountFilter}
     */
    public static class Builder {
        private String loyaltyAccountId;

        /**
         * Initialization constructor
         */
        public Builder(String loyaltyAccountId) {
            this.loyaltyAccountId = loyaltyAccountId;
        }

        /**
         * Setter for loyaltyAccountId
         * @param loyaltyAccountId
         * @return Builder
         */
        public Builder loyaltyAccountId(String loyaltyAccountId) {
            this.loyaltyAccountId = loyaltyAccountId;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventLoyaltyAccountFilter} object using the set fields.
         * @return {@link LoyaltyEventLoyaltyAccountFilter}
         */
        public LoyaltyEventLoyaltyAccountFilter build() {
            return new LoyaltyEventLoyaltyAccountFilter(loyaltyAccountId);
        }
    }
}
