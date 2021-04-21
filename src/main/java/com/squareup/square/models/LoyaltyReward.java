
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyReward type.
 */
public class LoyaltyReward {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String status;
    private final String loyaltyAccountId;
    private final String rewardTierId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer points;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String orderId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String updatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String redeemedAt;

    /**
     * Initialization constructor.
     * @param  loyaltyAccountId  String value for loyaltyAccountId.
     * @param  rewardTierId  String value for rewardTierId.
     * @param  id  String value for id.
     * @param  status  String value for status.
     * @param  points  Integer value for points.
     * @param  orderId  String value for orderId.
     * @param  createdAt  String value for createdAt.
     * @param  updatedAt  String value for updatedAt.
     * @param  redeemedAt  String value for redeemedAt.
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

    /**
     * Getter for Id.
     * The Square-assigned ID of the loyalty reward.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
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

    /**
     * Getter for LoyaltyAccountId.
     * The Square-assigned ID of the [loyalty account]($m/LoyaltyAccount) to which the reward
     * belongs.
     * @return Returns the String
     */
    @JsonGetter("loyalty_account_id")
    public String getLoyaltyAccountId() {
        return loyaltyAccountId;
    }

    /**
     * Getter for RewardTierId.
     * The Square-assigned ID of the [reward tier]($m/LoyaltyProgramRewardTier) used to create the
     * reward.
     * @return Returns the String
     */
    @JsonGetter("reward_tier_id")
    public String getRewardTierId() {
        return rewardTierId;
    }

    /**
     * Getter for Points.
     * The number of loyalty points used for the reward.
     * @return Returns the Integer
     */
    @JsonGetter("points")
    public Integer getPoints() {
        return points;
    }

    /**
     * Getter for OrderId.
     * The Square-assigned ID of the [order]($m/Order) to which the reward is attached.
     * @return Returns the String
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return orderId;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the reward was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the reward was last updated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Getter for RedeemedAt.
     * The timestamp when the reward was redeemed, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("redeemed_at")
    public String getRedeemedAt() {
        return redeemedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, loyaltyAccountId, rewardTierId, points, orderId, createdAt,
                updatedAt, redeemedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyReward)) {
            return false;
        }
        LoyaltyReward other = (LoyaltyReward) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(status, other.status)
            && Objects.equals(loyaltyAccountId, other.loyaltyAccountId)
            && Objects.equals(rewardTierId, other.rewardTierId)
            && Objects.equals(points, other.points)
            && Objects.equals(orderId, other.orderId)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(updatedAt, other.updatedAt)
            && Objects.equals(redeemedAt, other.redeemedAt);
    }

    /**
     * Converts this LoyaltyReward into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyReward [" + "loyaltyAccountId=" + loyaltyAccountId + ", rewardTierId="
                + rewardTierId + ", id=" + id + ", status=" + status + ", points=" + points
                + ", orderId=" + orderId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", redeemedAt=" + redeemedAt + "]";
    }

    /**
     * Builds a new {@link LoyaltyReward.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyReward.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(loyaltyAccountId, rewardTierId)
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
     * Class to build instances of {@link LoyaltyReward}.
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
         * Initialization constructor.
         * @param  loyaltyAccountId  String value for loyaltyAccountId.
         * @param  rewardTierId  String value for rewardTierId.
         */
        public Builder(String loyaltyAccountId, String rewardTierId) {
            this.loyaltyAccountId = loyaltyAccountId;
            this.rewardTierId = rewardTierId;
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
         * Setter for rewardTierId.
         * @param  rewardTierId  String value for rewardTierId.
         * @return Builder
         */
        public Builder rewardTierId(String rewardTierId) {
            this.rewardTierId = rewardTierId;
            return this;
        }

        /**
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
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
         * Setter for points.
         * @param  points  Integer value for points.
         * @return Builder
         */
        public Builder points(Integer points) {
            this.points = points;
            return this;
        }

        /**
         * Setter for orderId.
         * @param  orderId  String value for orderId.
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Setter for redeemedAt.
         * @param  redeemedAt  String value for redeemedAt.
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
            return new LoyaltyReward(loyaltyAccountId, rewardTierId, id, status, points, orderId,
                    createdAt, updatedAt, redeemedAt);
        }
    }
}
