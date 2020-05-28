package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyEvent type.
 */
public class LoyaltyEvent {

    /**
     * Initialization constructor.
     * @param id
     * @param type
     * @param createdAt
     * @param loyaltyAccountId
     * @param source
     * @param accumulatePoints
     * @param createReward
     * @param redeemReward
     * @param deleteReward
     * @param adjustPoints
     * @param locationId
     * @param expirePoints
     * @param otherEvent
     */
    @JsonCreator
    public LoyaltyEvent(
            @JsonProperty("id") String id,
            @JsonProperty("type") String type,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("loyalty_account_id") String loyaltyAccountId,
            @JsonProperty("source") String source,
            @JsonProperty("accumulate_points") LoyaltyEventAccumulatePoints accumulatePoints,
            @JsonProperty("create_reward") LoyaltyEventCreateReward createReward,
            @JsonProperty("redeem_reward") LoyaltyEventRedeemReward redeemReward,
            @JsonProperty("delete_reward") LoyaltyEventDeleteReward deleteReward,
            @JsonProperty("adjust_points") LoyaltyEventAdjustPoints adjustPoints,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("expire_points") LoyaltyEventExpirePoints expirePoints,
            @JsonProperty("other_event") LoyaltyEventOther otherEvent) {
        this.id = id;
        this.type = type;
        this.createdAt = createdAt;
        this.accumulatePoints = accumulatePoints;
        this.createReward = createReward;
        this.redeemReward = redeemReward;
        this.deleteReward = deleteReward;
        this.adjustPoints = adjustPoints;
        this.loyaltyAccountId = loyaltyAccountId;
        this.locationId = locationId;
        this.source = source;
        this.expirePoints = expirePoints;
        this.otherEvent = otherEvent;
    }

    private final String id;
    private final String type;
    private final String createdAt;
    private final LoyaltyEventAccumulatePoints accumulatePoints;
    private final LoyaltyEventCreateReward createReward;
    private final LoyaltyEventRedeemReward redeemReward;
    private final LoyaltyEventDeleteReward deleteReward;
    private final LoyaltyEventAdjustPoints adjustPoints;
    private final String loyaltyAccountId;
    private final String locationId;
    private final String source;
    private final LoyaltyEventExpirePoints expirePoints;
    private final LoyaltyEventOther otherEvent;
    /**
     * Getter for Id.
     * The Square-assigned ID of the loyalty event.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Type.
     * The type of the loyalty event.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the event was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for AccumulatePoints.
     * Provides metadata when the event `type` is `ACCUMULATE_POINTS`.
     */
    @JsonGetter("accumulate_points")
    public LoyaltyEventAccumulatePoints getAccumulatePoints() {
        return this.accumulatePoints;
    }

    /**
     * Getter for CreateReward.
     * Provides metadata when the event `type` is `CREATE_REWARD`.
     */
    @JsonGetter("create_reward")
    public LoyaltyEventCreateReward getCreateReward() {
        return this.createReward;
    }

    /**
     * Getter for RedeemReward.
     * Provides metadata when the event `type` is `REDEEM_REWARD`.
     */
    @JsonGetter("redeem_reward")
    public LoyaltyEventRedeemReward getRedeemReward() {
        return this.redeemReward;
    }

    /**
     * Getter for DeleteReward.
     * Provides metadata when the event `type` is `DELETE_REWARD`.
     */
    @JsonGetter("delete_reward")
    public LoyaltyEventDeleteReward getDeleteReward() {
        return this.deleteReward;
    }

    /**
     * Getter for AdjustPoints.
     * Provides metadata when the event `type` is `ADJUST_POINTS`.
     */
    @JsonGetter("adjust_points")
    public LoyaltyEventAdjustPoints getAdjustPoints() {
        return this.adjustPoints;
    }

    /**
     * Getter for LoyaltyAccountId.
     * The ID of the [loyalty account](#type-LoyaltyAccount) in which the event occurred.
     */
    @JsonGetter("loyalty_account_id")
    public String getLoyaltyAccountId() {
        return this.loyaltyAccountId;
    }

    /**
     * Getter for LocationId.
     * The ID of the [location](#type-Location) where the event occurred.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Source.
     * Defines whether the event was generated by the Square Point of Sale.
     */
    @JsonGetter("source")
    public String getSource() {
        return this.source;
    }

    /**
     * Getter for ExpirePoints.
     * Provides metadata when the event `type` is `EXPIRE_POINTS`.
     */
    @JsonGetter("expire_points")
    public LoyaltyEventExpirePoints getExpirePoints() {
        return this.expirePoints;
    }

    /**
     * Getter for OtherEvent.
     * Provides metadata when the event `type` is `OTHER`.
     */
    @JsonGetter("other_event")
    public LoyaltyEventOther getOtherEvent() {
        return this.otherEvent;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, type, createdAt, accumulatePoints, createReward, redeemReward,
            deleteReward, adjustPoints, loyaltyAccountId, locationId, source, expirePoints,
            otherEvent);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyEvent)) {
            return false;
        }
        LoyaltyEvent loyaltyEvent = (LoyaltyEvent) obj;
        return Objects.equals(id, loyaltyEvent.id) &&
            Objects.equals(type, loyaltyEvent.type) &&
            Objects.equals(createdAt, loyaltyEvent.createdAt) &&
            Objects.equals(accumulatePoints, loyaltyEvent.accumulatePoints) &&
            Objects.equals(createReward, loyaltyEvent.createReward) &&
            Objects.equals(redeemReward, loyaltyEvent.redeemReward) &&
            Objects.equals(deleteReward, loyaltyEvent.deleteReward) &&
            Objects.equals(adjustPoints, loyaltyEvent.adjustPoints) &&
            Objects.equals(loyaltyAccountId, loyaltyEvent.loyaltyAccountId) &&
            Objects.equals(locationId, loyaltyEvent.locationId) &&
            Objects.equals(source, loyaltyEvent.source) &&
            Objects.equals(expirePoints, loyaltyEvent.expirePoints) &&
            Objects.equals(otherEvent, loyaltyEvent.otherEvent);
    }

    /**
     * Builds a new {@link LoyaltyEvent.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEvent.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id,
            type,
            createdAt,
            loyaltyAccountId,
            source)
            .accumulatePoints(getAccumulatePoints())
            .createReward(getCreateReward())
            .redeemReward(getRedeemReward())
            .deleteReward(getDeleteReward())
            .adjustPoints(getAdjustPoints())
            .locationId(getLocationId())
            .expirePoints(getExpirePoints())
            .otherEvent(getOtherEvent());
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEvent}
     */
    public static class Builder {
        private String id;
        private String type;
        private String createdAt;
        private String loyaltyAccountId;
        private String source;
        private LoyaltyEventAccumulatePoints accumulatePoints;
        private LoyaltyEventCreateReward createReward;
        private LoyaltyEventRedeemReward redeemReward;
        private LoyaltyEventDeleteReward deleteReward;
        private LoyaltyEventAdjustPoints adjustPoints;
        private String locationId;
        private LoyaltyEventExpirePoints expirePoints;
        private LoyaltyEventOther otherEvent;

        /**
         * Initialization constructor
         */
        public Builder(String id,
                String type,
                String createdAt,
                String loyaltyAccountId,
                String source) {
            this.id = id;
            this.type = type;
            this.createdAt = createdAt;
            this.loyaltyAccountId = loyaltyAccountId;
            this.source = source;
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
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
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
         * Setter for loyaltyAccountId
         * @param loyaltyAccountId
         * @return Builder
         */
        public Builder loyaltyAccountId(String loyaltyAccountId) {
            this.loyaltyAccountId = loyaltyAccountId;
            return this;
        }
        /**
         * Setter for source
         * @param source
         * @return Builder
         */
        public Builder source(String source) {
            this.source = source;
            return this;
        }
        /**
         * Setter for accumulatePoints
         * @param accumulatePoints
         * @return Builder
         */
        public Builder accumulatePoints(LoyaltyEventAccumulatePoints accumulatePoints) {
            this.accumulatePoints = accumulatePoints;
            return this;
        }
        /**
         * Setter for createReward
         * @param createReward
         * @return Builder
         */
        public Builder createReward(LoyaltyEventCreateReward createReward) {
            this.createReward = createReward;
            return this;
        }
        /**
         * Setter for redeemReward
         * @param redeemReward
         * @return Builder
         */
        public Builder redeemReward(LoyaltyEventRedeemReward redeemReward) {
            this.redeemReward = redeemReward;
            return this;
        }
        /**
         * Setter for deleteReward
         * @param deleteReward
         * @return Builder
         */
        public Builder deleteReward(LoyaltyEventDeleteReward deleteReward) {
            this.deleteReward = deleteReward;
            return this;
        }
        /**
         * Setter for adjustPoints
         * @param adjustPoints
         * @return Builder
         */
        public Builder adjustPoints(LoyaltyEventAdjustPoints adjustPoints) {
            this.adjustPoints = adjustPoints;
            return this;
        }
        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }
        /**
         * Setter for expirePoints
         * @param expirePoints
         * @return Builder
         */
        public Builder expirePoints(LoyaltyEventExpirePoints expirePoints) {
            this.expirePoints = expirePoints;
            return this;
        }
        /**
         * Setter for otherEvent
         * @param otherEvent
         * @return Builder
         */
        public Builder otherEvent(LoyaltyEventOther otherEvent) {
            this.otherEvent = otherEvent;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEvent} object using the set fields.
         * @return {@link LoyaltyEvent}
         */
        public LoyaltyEvent build() {
            return new LoyaltyEvent(id,
                type,
                createdAt,
                loyaltyAccountId,
                source,
                accumulatePoints,
                createReward,
                redeemReward,
                deleteReward,
                adjustPoints,
                locationId,
                expirePoints,
                otherEvent);
        }
    }
}
