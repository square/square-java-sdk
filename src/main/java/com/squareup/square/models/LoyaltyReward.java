package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyReward type.
 */
public class LoyaltyReward {

    /**
     * Initialization constructor.
     * @param loyaltyAccountId
     * @param rewardTierId
     * @param id
     * @param status
     * @param points
     * @param orderId
     * @param createdAt
     * @param updatedAt
     * @param redeemedAt
     */
    @JsonCreator
    public LoyaltyReward(
            @JsonProperty("loyalty_account_id") String loyaltyAccountId,
            @JsonProperty("reward_tier_id") String rewardTierId,
            @JsonProperty("id") String id,
            @JsonProperty("status") String status,
            @JsonProperty("points") Integer points,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("redeemed_at") String redeemedAt) {
        this.id = id;
        this.status = status;
        this.loyaltyAccountId = loyaltyAccountId;
        this.rewardTierId = rewardTierId;
        this.points = points;
        this.orderId = orderId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.redeemedAt = redeemedAt;
    }

    private final String id;
    private final String status;
    private final String loyaltyAccountId;
    private final String rewardTierId;
    private final Integer points;
    private final String orderId;
    private final String createdAt;
    private final String updatedAt;
    private final String redeemedAt;
    /**
     * Getter for Id.
     * The Square-assigned ID of the loyalty reward.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Status.
     * The status of the loyalty reward.
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for LoyaltyAccountId.
     * The Square-assigned ID of the [loyalty account](#type-LoyaltyAccount) to which the reward belongs.
     */
    @JsonGetter("loyalty_account_id")
    public String getLoyaltyAccountId() {
        return this.loyaltyAccountId;
    }

    /**
     * Getter for RewardTierId.
     * The Square-assigned ID of the [reward tier](#type-LoyaltyProgramRewardTier) used to create the reward.
     */
    @JsonGetter("reward_tier_id")
    public String getRewardTierId() {
        return this.rewardTierId;
    }

    /**
     * Getter for Points.
     * The number of loyalty points used for the reward.
     */
    @JsonGetter("points")
    public Integer getPoints() {
        return this.points;
    }

    /**
     * Getter for OrderId.
     * The Square-assigned ID of the [order](#type-Order) to which the reward is attached.
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the reward was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the reward was last updated, in RFC 3339 format.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Getter for RedeemedAt.
     * The timestamp when the reward was redeemed, in RFC 3339 format.
     */
    @JsonGetter("redeemed_at")
    public String getRedeemedAt() {
        return this.redeemedAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, status, loyaltyAccountId, rewardTierId, points, orderId, createdAt,
            updatedAt, redeemedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyReward)) {
            return false;
        }
        LoyaltyReward loyaltyReward = (LoyaltyReward) obj;
        return Objects.equals(id, loyaltyReward.id) &&
            Objects.equals(status, loyaltyReward.status) &&
            Objects.equals(loyaltyAccountId, loyaltyReward.loyaltyAccountId) &&
            Objects.equals(rewardTierId, loyaltyReward.rewardTierId) &&
            Objects.equals(points, loyaltyReward.points) &&
            Objects.equals(orderId, loyaltyReward.orderId) &&
            Objects.equals(createdAt, loyaltyReward.createdAt) &&
            Objects.equals(updatedAt, loyaltyReward.updatedAt) &&
            Objects.equals(redeemedAt, loyaltyReward.redeemedAt);
    }

    /**
     * Builds a new {@link LoyaltyReward.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyReward.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(loyaltyAccountId,
            rewardTierId)
            .id(getId())
            .status(getStatus())
            .points(getPoints())
            .orderId(getOrderId())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt())
            .redeemedAt(getRedeemedAt());
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyReward}
     */
    public static class Builder {
        private String loyaltyAccountId;
        private String rewardTierId;
        private String id;
        private String status;
        private Integer points;
        private String orderId;
        private String createdAt;
        private String updatedAt;
        private String redeemedAt;

        /**
         * Initialization constructor
         */
        public Builder(String loyaltyAccountId,
                String rewardTierId) {
            this.loyaltyAccountId = loyaltyAccountId;
            this.rewardTierId = rewardTierId;
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
         * Setter for rewardTierId
         * @param rewardTierId
         * @return Builder
         */
        public Builder rewardTierId(String rewardTierId) {
            this.rewardTierId = rewardTierId;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
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
         * Setter for points
         * @param points
         * @return Builder
         */
        public Builder points(Integer points) {
            this.points = points;
            return this;
        }
        /**
         * Setter for orderId
         * @param orderId
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for updatedAt
         * @param updatedAt
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        /**
         * Setter for redeemedAt
         * @param redeemedAt
         * @return Builder
         */
        public Builder redeemedAt(String redeemedAt) {
            this.redeemedAt = redeemedAt;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyReward} object using the set fields.
         * @return {@link LoyaltyReward}
         */
        public LoyaltyReward build() {
            return new LoyaltyReward(loyaltyAccountId,
                rewardTierId,
                id,
                status,
                points,
                orderId,
                createdAt,
                updatedAt,
                redeemedAt);
        }
    }
}
