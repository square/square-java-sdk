
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyEventLoyaltyAccountFilter type.
 */
public class LoyaltyEventLoyaltyAccountFilter {
    private final String loyaltyAccountId;

    /**
     * Initialization constructor.
     * @param  loyaltyAccountId  String value for loyaltyAccountId.
     */
    @JsonCreator
    public LoyaltyEventLoyaltyAccountFilter(
            @JsonProperty("loyalty_account_id") String loyaltyAccountId) {
        this.loyaltyAccountId = loyaltyAccountId;
    }

    /**
     * Getter for LoyaltyAccountId.
     * The ID of the [loyalty account]($m/LoyaltyAccount) associated with loyalty events.
     * @return Returns the String
     */
    @JsonGetter("loyalty_account_id")
    public String getLoyaltyAccountId() {
        return loyaltyAccountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyaltyAccountId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEventLoyaltyAccountFilter)) {
            return false;
        }
        LoyaltyEventLoyaltyAccountFilter other = (LoyaltyEventLoyaltyAccountFilter) obj;
        return Objects.equals(loyaltyAccountId, other.loyaltyAccountId);
    }

    /**
     * Converts this LoyaltyEventLoyaltyAccountFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyEventLoyaltyAccountFilter [" + "loyaltyAccountId=" + loyaltyAccountId + "]";
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
     * Class to build instances of {@link LoyaltyEventLoyaltyAccountFilter}.
     */
    public static class Builder {
        private String loyaltyAccountId;

        /**
         * Initialization constructor.
         * @param  loyaltyAccountId  String value for loyaltyAccountId.
         */
        public Builder(String loyaltyAccountId) {
            this.loyaltyAccountId = loyaltyAccountId;
        }

        /**
         * Setter for loyaltyAccountId.
         * @param  loyaltyAccountId  String value for loyaltyAccountId.
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
