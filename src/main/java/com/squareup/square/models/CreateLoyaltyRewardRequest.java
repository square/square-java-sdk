package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateLoyaltyRewardRequest type.
 */
public class CreateLoyaltyRewardRequest {

    /**
     * Initialization constructor.
     * @param reward
     * @param idempotencyKey
     */
    @JsonCreator
    public CreateLoyaltyRewardRequest(
            @JsonProperty("reward") LoyaltyReward reward,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.reward = reward;
        this.idempotencyKey = idempotencyKey;
    }

    private final LoyaltyReward reward;
    private final String idempotencyKey;
    /**
     * Getter for Reward.
     */
    @JsonGetter("reward")
    public LoyaltyReward getReward() {
        return this.reward;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `CreateLoyaltyReward` request. 
     * Keys can be any valid string, but must be unique for every request.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(reward, idempotencyKey);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateLoyaltyRewardRequest)) {
            return false;
        }
        CreateLoyaltyRewardRequest createLoyaltyRewardRequest = (CreateLoyaltyRewardRequest) obj;
        return Objects.equals(reward, createLoyaltyRewardRequest.reward) &&
            Objects.equals(idempotencyKey, createLoyaltyRewardRequest.idempotencyKey);
    }

    /**
     * Builds a new {@link CreateLoyaltyRewardRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateLoyaltyRewardRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(reward,
            idempotencyKey);
            return builder;
    }

    /**
     * Class to build instances of {@link CreateLoyaltyRewardRequest}
     */
    public static class Builder {
        private LoyaltyReward reward;
        private String idempotencyKey;

        /**
         * Initialization constructor
         */
        public Builder(LoyaltyReward reward,
                String idempotencyKey) {
            this.reward = reward;
            this.idempotencyKey = idempotencyKey;
        }

        /**
         * Setter for reward
         * @param reward
         * @return Builder
         */
        public Builder reward(LoyaltyReward reward) {
            this.reward = reward;
            return this;
        }
        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link CreateLoyaltyRewardRequest} object using the set fields.
         * @return {@link CreateLoyaltyRewardRequest}
         */
        public CreateLoyaltyRewardRequest build() {
            return new CreateLoyaltyRewardRequest(reward,
                idempotencyKey);
        }
    }
}
