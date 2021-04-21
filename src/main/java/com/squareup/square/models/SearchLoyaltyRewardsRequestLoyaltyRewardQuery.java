
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SearchLoyaltyRewardsRequestLoyaltyRewardQuery type.
 */
public class SearchLoyaltyRewardsRequestLoyaltyRewardQuery {
    private final String loyaltyAccountId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;

    /**
     * Initialization constructor.
     * @param  loyaltyAccountId  String value for loyaltyAccountId.
     * @param  status  String value for status.
     */
    @JsonCreator
    public SearchLoyaltyRewardsRequestLoyaltyRewardQuery(
            @JsonProperty("loyalty_account_id") String loyaltyAccountId,
            @JsonProperty("status") String status) {
        this.loyaltyAccountId = loyaltyAccountId;
        this.status = status;
    }

    /**
     * Getter for LoyaltyAccountId.
     * The ID of the [loyalty account]($m/LoyaltyAccount) to which the loyalty reward belongs.
     * @return Returns the String
     */
    @JsonGetter("loyalty_account_id")
    public String getLoyaltyAccountId() {
        return loyaltyAccountId;
    }

    /**
     * Getter for Status.
     * The status of the loyalty reward.
     * @return Returns the String
     */
    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyaltyAccountId, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchLoyaltyRewardsRequestLoyaltyRewardQuery)) {
            return false;
        }
        SearchLoyaltyRewardsRequestLoyaltyRewardQuery other =
                (SearchLoyaltyRewardsRequestLoyaltyRewardQuery) obj;
        return Objects.equals(loyaltyAccountId, other.loyaltyAccountId)
            && Objects.equals(status, other.status);
    }

    /**
     * Converts this SearchLoyaltyRewardsRequestLoyaltyRewardQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchLoyaltyRewardsRequestLoyaltyRewardQuery [" + "loyaltyAccountId="
                + loyaltyAccountId + ", status=" + status + "]";
    }

    /**
     * Builds a new {@link SearchLoyaltyRewardsRequestLoyaltyRewardQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchLoyaltyRewardsRequestLoyaltyRewardQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(loyaltyAccountId)
                .status(getStatus());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchLoyaltyRewardsRequestLoyaltyRewardQuery}.
     */
    public static class Builder {
        private String loyaltyAccountId;
        private String status;

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
         * Setter for status.
         * @param  status  String value for status.
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link SearchLoyaltyRewardsRequestLoyaltyRewardQuery} object using the set
         * fields.
         * @return {@link SearchLoyaltyRewardsRequestLoyaltyRewardQuery}
         */
        public SearchLoyaltyRewardsRequestLoyaltyRewardQuery build() {
            return new SearchLoyaltyRewardsRequestLoyaltyRewardQuery(loyaltyAccountId, status);
        }
    }
}
