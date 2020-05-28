package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchLoyaltyRewardsRequestLoyaltyRewardQuery type.
 */
public class SearchLoyaltyRewardsRequestLoyaltyRewardQuery {

    /**
     * Initialization constructor.
     * @param loyaltyAccountId
     * @param status
     */
    @JsonCreator
    public SearchLoyaltyRewardsRequestLoyaltyRewardQuery(
            @JsonProperty("loyalty_account_id") String loyaltyAccountId,
            @JsonProperty("status") String status) {
        this.loyaltyAccountId = loyaltyAccountId;
        this.status = status;
    }

    private final String loyaltyAccountId;
    private final String status;
    /**
     * Getter for LoyaltyAccountId.
     * The ID of the [loyalty account](#type-LoyaltyAccount) to which the loyalty reward belongs.
     */
    @JsonGetter("loyalty_account_id")
    public String getLoyaltyAccountId() {
        return this.loyaltyAccountId;
    }

    /**
     * Getter for Status.
     * The status of the loyalty reward.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(loyaltyAccountId, status);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchLoyaltyRewardsRequestLoyaltyRewardQuery)) {
            return false;
        }
        SearchLoyaltyRewardsRequestLoyaltyRewardQuery searchLoyaltyRewardsRequestLoyaltyRewardQuery = (SearchLoyaltyRewardsRequestLoyaltyRewardQuery) obj;
        return Objects.equals(loyaltyAccountId, searchLoyaltyRewardsRequestLoyaltyRewardQuery.loyaltyAccountId) &&
            Objects.equals(status, searchLoyaltyRewardsRequestLoyaltyRewardQuery.status);
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
     * Class to build instances of {@link SearchLoyaltyRewardsRequestLoyaltyRewardQuery}
     */
    public static class Builder {
        private String loyaltyAccountId;
        private String status;

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
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new {@link SearchLoyaltyRewardsRequestLoyaltyRewardQuery} object using the set fields.
         * @return {@link SearchLoyaltyRewardsRequestLoyaltyRewardQuery}
         */
        public SearchLoyaltyRewardsRequestLoyaltyRewardQuery build() {
            return new SearchLoyaltyRewardsRequestLoyaltyRewardQuery(loyaltyAccountId,
                status);
        }
    }
}
