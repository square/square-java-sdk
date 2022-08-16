
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyEvent type.
 */
public class LoyaltyEvent {
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
    private final LoyaltyEventAccumulatePromotionPoints accumulatePromotionPoints;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  type  String value for type.
     * @param  createdAt  String value for createdAt.
     * @param  loyaltyAccountId  String value for loyaltyAccountId.
     * @param  source  String value for source.
     * @param  accumulatePoints  LoyaltyEventAccumulatePoints value for accumulatePoints.
     * @param  createReward  LoyaltyEventCreateReward value for createReward.
     * @param  redeemReward  LoyaltyEventRedeemReward value for redeemReward.
     * @param  deleteReward  LoyaltyEventDeleteReward value for deleteReward.
     * @param  adjustPoints  LoyaltyEventAdjustPoints value for adjustPoints.
     * @param  locationId  String value for locationId.
     * @param  expirePoints  LoyaltyEventExpirePoints value for expirePoints.
     * @param  otherEvent  LoyaltyEventOther value for otherEvent.
     * @param  accumulatePromotionPoints  LoyaltyEventAccumulatePromotionPoints value for
     *         accumulatePromotionPoints.
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
            @JsonProperty("other_event") LoyaltyEventOther otherEvent,
            @JsonProperty("accumulate_promotion_points") LoyaltyEventAccumulatePromotionPoints accumulatePromotionPoints) {
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
        this.accumulatePromotionPoints = accumulatePromotionPoints;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the loyalty event.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for Type.
     * The type of the loyalty event.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the event was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for AccumulatePoints.
     * Provides metadata when the event `type` is `ACCUMULATE_POINTS`.
     * @return Returns the LoyaltyEventAccumulatePoints
     */
    @JsonGetter("accumulate_points")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventAccumulatePoints getAccumulatePoints() {
        return accumulatePoints;
    }

    /**
     * Getter for CreateReward.
     * Provides metadata when the event `type` is `CREATE_REWARD`.
     * @return Returns the LoyaltyEventCreateReward
     */
    @JsonGetter("create_reward")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventCreateReward getCreateReward() {
        return createReward;
    }

    /**
     * Getter for RedeemReward.
     * Provides metadata when the event `type` is `REDEEM_REWARD`.
     * @return Returns the LoyaltyEventRedeemReward
     */
    @JsonGetter("redeem_reward")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventRedeemReward getRedeemReward() {
        return redeemReward;
    }

    /**
     * Getter for DeleteReward.
     * Provides metadata when the event `type` is `DELETE_REWARD`.
     * @return Returns the LoyaltyEventDeleteReward
     */
    @JsonGetter("delete_reward")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventDeleteReward getDeleteReward() {
        return deleteReward;
    }

    /**
     * Getter for AdjustPoints.
     * Provides metadata when the event `type` is `ADJUST_POINTS`.
     * @return Returns the LoyaltyEventAdjustPoints
     */
    @JsonGetter("adjust_points")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventAdjustPoints getAdjustPoints() {
        return adjustPoints;
    }

    /**
     * Getter for LoyaltyAccountId.
     * The ID of the [loyalty account]($m/LoyaltyAccount) associated with the event.
     * @return Returns the String
     */
    @JsonGetter("loyalty_account_id")
    public String getLoyaltyAccountId() {
        return loyaltyAccountId;
    }

    /**
     * Getter for LocationId.
     * The ID of the [location]($m/Location) where the event occurred.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for Source.
     * Defines whether the event was generated by the Square Point of Sale.
     * @return Returns the String
     */
    @JsonGetter("source")
    public String getSource() {
        return source;
    }

    /**
     * Getter for ExpirePoints.
     * Provides metadata when the event `type` is `EXPIRE_POINTS`.
     * @return Returns the LoyaltyEventExpirePoints
     */
    @JsonGetter("expire_points")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventExpirePoints getExpirePoints() {
        return expirePoints;
    }

    /**
     * Getter for OtherEvent.
     * Provides metadata when the event `type` is `OTHER`.
     * @return Returns the LoyaltyEventOther
     */
    @JsonGetter("other_event")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventOther getOtherEvent() {
        return otherEvent;
    }

    /**
     * Getter for AccumulatePromotionPoints.
     * Provides metadata when the event `type` is `ACCUMULATE_PROMOTION_POINTS`.
     * @return Returns the LoyaltyEventAccumulatePromotionPoints
     */
    @JsonGetter("accumulate_promotion_points")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyEventAccumulatePromotionPoints getAccumulatePromotionPoints() {
        return accumulatePromotionPoints;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, createdAt, accumulatePoints, createReward, redeemReward,
                deleteReward, adjustPoints, loyaltyAccountId, locationId, source, expirePoints,
                otherEvent, accumulatePromotionPoints);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEvent)) {
            return false;
        }
        LoyaltyEvent other = (LoyaltyEvent) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(type, other.type)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(accumulatePoints, other.accumulatePoints)
            && Objects.equals(createReward, other.createReward)
            && Objects.equals(redeemReward, other.redeemReward)
            && Objects.equals(deleteReward, other.deleteReward)
            && Objects.equals(adjustPoints, other.adjustPoints)
            && Objects.equals(loyaltyAccountId, other.loyaltyAccountId)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(source, other.source)
            && Objects.equals(expirePoints, other.expirePoints)
            && Objects.equals(otherEvent, other.otherEvent)
            && Objects.equals(accumulatePromotionPoints, other.accumulatePromotionPoints);
    }

    /**
     * Converts this LoyaltyEvent into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyEvent [" + "id=" + id + ", type=" + type + ", createdAt=" + createdAt
                + ", loyaltyAccountId=" + loyaltyAccountId + ", source=" + source
                + ", accumulatePoints=" + accumulatePoints + ", createReward=" + createReward
                + ", redeemReward=" + redeemReward + ", deleteReward=" + deleteReward
                + ", adjustPoints=" + adjustPoints + ", locationId=" + locationId
                + ", expirePoints=" + expirePoints + ", otherEvent=" + otherEvent
                + ", accumulatePromotionPoints=" + accumulatePromotionPoints + "]";
    }

    /**
     * Builds a new {@link LoyaltyEvent.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEvent.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id, type, createdAt, loyaltyAccountId, source)
                .accumulatePoints(getAccumulatePoints())
                .createReward(getCreateReward())
                .redeemReward(getRedeemReward())
                .deleteReward(getDeleteReward())
                .adjustPoints(getAdjustPoints())
                .locationId(getLocationId())
                .expirePoints(getExpirePoints())
                .otherEvent(getOtherEvent())
                .accumulatePromotionPoints(getAccumulatePromotionPoints());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEvent}.
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
        private LoyaltyEventAccumulatePromotionPoints accumulatePromotionPoints;

        /**
         * Initialization constructor.
         * @param  id  String value for id.
         * @param  type  String value for type.
         * @param  createdAt  String value for createdAt.
         * @param  loyaltyAccountId  String value for loyaltyAccountId.
         * @param  source  String value for source.
         */
        public Builder(String id, String type, String createdAt, String loyaltyAccountId,
                String source) {
            this.id = id;
            this.type = type;
            this.createdAt = createdAt;
            this.loyaltyAccountId = loyaltyAccountId;
            this.source = source;
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
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
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
         * Setter for loyaltyAccountId.
         * @param  loyaltyAccountId  String value for loyaltyAccountId.
         * @return Builder
         */
        public Builder loyaltyAccountId(String loyaltyAccountId) {
            this.loyaltyAccountId = loyaltyAccountId;
            return this;
        }

        /**
         * Setter for source.
         * @param  source  String value for source.
         * @return Builder
         */
        public Builder source(String source) {
            this.source = source;
            return this;
        }

        /**
         * Setter for accumulatePoints.
         * @param  accumulatePoints  LoyaltyEventAccumulatePoints value for accumulatePoints.
         * @return Builder
         */
        public Builder accumulatePoints(LoyaltyEventAccumulatePoints accumulatePoints) {
            this.accumulatePoints = accumulatePoints;
            return this;
        }

        /**
         * Setter for createReward.
         * @param  createReward  LoyaltyEventCreateReward value for createReward.
         * @return Builder
         */
        public Builder createReward(LoyaltyEventCreateReward createReward) {
            this.createReward = createReward;
            return this;
        }

        /**
         * Setter for redeemReward.
         * @param  redeemReward  LoyaltyEventRedeemReward value for redeemReward.
         * @return Builder
         */
        public Builder redeemReward(LoyaltyEventRedeemReward redeemReward) {
            this.redeemReward = redeemReward;
            return this;
        }

        /**
         * Setter for deleteReward.
         * @param  deleteReward  LoyaltyEventDeleteReward value for deleteReward.
         * @return Builder
         */
        public Builder deleteReward(LoyaltyEventDeleteReward deleteReward) {
            this.deleteReward = deleteReward;
            return this;
        }

        /**
         * Setter for adjustPoints.
         * @param  adjustPoints  LoyaltyEventAdjustPoints value for adjustPoints.
         * @return Builder
         */
        public Builder adjustPoints(LoyaltyEventAdjustPoints adjustPoints) {
            this.adjustPoints = adjustPoints;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for expirePoints.
         * @param  expirePoints  LoyaltyEventExpirePoints value for expirePoints.
         * @return Builder
         */
        public Builder expirePoints(LoyaltyEventExpirePoints expirePoints) {
            this.expirePoints = expirePoints;
            return this;
        }

        /**
         * Setter for otherEvent.
         * @param  otherEvent  LoyaltyEventOther value for otherEvent.
         * @return Builder
         */
        public Builder otherEvent(LoyaltyEventOther otherEvent) {
            this.otherEvent = otherEvent;
            return this;
        }

        /**
         * Setter for accumulatePromotionPoints.
         * @param  accumulatePromotionPoints  LoyaltyEventAccumulatePromotionPoints value for
         *         accumulatePromotionPoints.
         * @return Builder
         */
        public Builder accumulatePromotionPoints(
                LoyaltyEventAccumulatePromotionPoints accumulatePromotionPoints) {
            this.accumulatePromotionPoints = accumulatePromotionPoints;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEvent} object using the set fields.
         * @return {@link LoyaltyEvent}
         */
        public LoyaltyEvent build() {
            return new LoyaltyEvent(id, type, createdAt, loyaltyAccountId, source, accumulatePoints,
                    createReward, redeemReward, deleteReward, adjustPoints, locationId,
                    expirePoints, otherEvent, accumulatePromotionPoints);
        }
    }
}
