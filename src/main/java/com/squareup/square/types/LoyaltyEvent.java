/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = LoyaltyEvent.Builder.class)
public final class LoyaltyEvent {
    private final Optional<String> id;

    private final LoyaltyEventType type;

    private final Optional<String> createdAt;

    private final Optional<LoyaltyEventAccumulatePoints> accumulatePoints;

    private final Optional<LoyaltyEventCreateReward> createReward;

    private final Optional<LoyaltyEventRedeemReward> redeemReward;

    private final Optional<LoyaltyEventDeleteReward> deleteReward;

    private final Optional<LoyaltyEventAdjustPoints> adjustPoints;

    private final Optional<String> loyaltyAccountId;

    private final Optional<String> locationId;

    private final LoyaltyEventSource source;

    private final Optional<LoyaltyEventExpirePoints> expirePoints;

    private final Optional<LoyaltyEventOther> otherEvent;

    private final Optional<LoyaltyEventAccumulatePromotionPoints> accumulatePromotionPoints;

    private final Map<String, Object> additionalProperties;

    private LoyaltyEvent(
            Optional<String> id,
            LoyaltyEventType type,
            Optional<String> createdAt,
            Optional<LoyaltyEventAccumulatePoints> accumulatePoints,
            Optional<LoyaltyEventCreateReward> createReward,
            Optional<LoyaltyEventRedeemReward> redeemReward,
            Optional<LoyaltyEventDeleteReward> deleteReward,
            Optional<LoyaltyEventAdjustPoints> adjustPoints,
            Optional<String> loyaltyAccountId,
            Optional<String> locationId,
            LoyaltyEventSource source,
            Optional<LoyaltyEventExpirePoints> expirePoints,
            Optional<LoyaltyEventOther> otherEvent,
            Optional<LoyaltyEventAccumulatePromotionPoints> accumulatePromotionPoints,
            Map<String, Object> additionalProperties) {
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
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The Square-assigned ID of the loyalty event.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return The type of the loyalty event.
     * See <a href="#type-loyaltyeventtype">LoyaltyEventType</a> for possible values
     */
    @JsonProperty("type")
    public LoyaltyEventType getType() {
        return type;
    }

    /**
     * @return The timestamp when the event was created, in RFC 3339 format.
     */
    @JsonProperty("created_at")
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return Provides metadata when the event <code>type</code> is <code>ACCUMULATE_POINTS</code>.
     */
    @JsonProperty("accumulate_points")
    public Optional<LoyaltyEventAccumulatePoints> getAccumulatePoints() {
        return accumulatePoints;
    }

    /**
     * @return Provides metadata when the event <code>type</code> is <code>CREATE_REWARD</code>.
     */
    @JsonProperty("create_reward")
    public Optional<LoyaltyEventCreateReward> getCreateReward() {
        return createReward;
    }

    /**
     * @return Provides metadata when the event <code>type</code> is <code>REDEEM_REWARD</code>.
     */
    @JsonProperty("redeem_reward")
    public Optional<LoyaltyEventRedeemReward> getRedeemReward() {
        return redeemReward;
    }

    /**
     * @return Provides metadata when the event <code>type</code> is <code>DELETE_REWARD</code>.
     */
    @JsonProperty("delete_reward")
    public Optional<LoyaltyEventDeleteReward> getDeleteReward() {
        return deleteReward;
    }

    /**
     * @return Provides metadata when the event <code>type</code> is <code>ADJUST_POINTS</code>.
     */
    @JsonProperty("adjust_points")
    public Optional<LoyaltyEventAdjustPoints> getAdjustPoints() {
        return adjustPoints;
    }

    /**
     * @return The ID of the <a href="entity:LoyaltyAccount">loyalty account</a> associated with the event.
     */
    @JsonProperty("loyalty_account_id")
    public Optional<String> getLoyaltyAccountId() {
        return loyaltyAccountId;
    }

    /**
     * @return The ID of the <a href="entity:Location">location</a> where the event occurred.
     */
    @JsonProperty("location_id")
    public Optional<String> getLocationId() {
        return locationId;
    }

    /**
     * @return Defines whether the event was generated by the Square Point of Sale.
     * See <a href="#type-loyaltyeventsource">LoyaltyEventSource</a> for possible values
     */
    @JsonProperty("source")
    public LoyaltyEventSource getSource() {
        return source;
    }

    /**
     * @return Provides metadata when the event <code>type</code> is <code>EXPIRE_POINTS</code>.
     */
    @JsonProperty("expire_points")
    public Optional<LoyaltyEventExpirePoints> getExpirePoints() {
        return expirePoints;
    }

    /**
     * @return Provides metadata when the event <code>type</code> is <code>OTHER</code>.
     */
    @JsonProperty("other_event")
    public Optional<LoyaltyEventOther> getOtherEvent() {
        return otherEvent;
    }

    /**
     * @return Provides metadata when the event <code>type</code> is <code>ACCUMULATE_PROMOTION_POINTS</code>.
     */
    @JsonProperty("accumulate_promotion_points")
    public Optional<LoyaltyEventAccumulatePromotionPoints> getAccumulatePromotionPoints() {
        return accumulatePromotionPoints;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LoyaltyEvent && equalTo((LoyaltyEvent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LoyaltyEvent other) {
        return id.equals(other.id)
                && type.equals(other.type)
                && createdAt.equals(other.createdAt)
                && accumulatePoints.equals(other.accumulatePoints)
                && createReward.equals(other.createReward)
                && redeemReward.equals(other.redeemReward)
                && deleteReward.equals(other.deleteReward)
                && adjustPoints.equals(other.adjustPoints)
                && loyaltyAccountId.equals(other.loyaltyAccountId)
                && locationId.equals(other.locationId)
                && source.equals(other.source)
                && expirePoints.equals(other.expirePoints)
                && otherEvent.equals(other.otherEvent)
                && accumulatePromotionPoints.equals(other.accumulatePromotionPoints);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.type,
                this.createdAt,
                this.accumulatePoints,
                this.createReward,
                this.redeemReward,
                this.deleteReward,
                this.adjustPoints,
                this.loyaltyAccountId,
                this.locationId,
                this.source,
                this.expirePoints,
                this.otherEvent,
                this.accumulatePromotionPoints);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TypeStage builder() {
        return new Builder();
    }

    public interface TypeStage {
        /**
         * <p>The type of the loyalty event.
         * See <a href="#type-loyaltyeventtype">LoyaltyEventType</a> for possible values</p>
         */
        SourceStage type(@NotNull LoyaltyEventType type);

        Builder from(LoyaltyEvent other);
    }

    public interface SourceStage {
        /**
         * <p>Defines whether the event was generated by the Square Point of Sale.
         * See <a href="#type-loyaltyeventsource">LoyaltyEventSource</a> for possible values</p>
         */
        _FinalStage source(@NotNull LoyaltyEventSource source);
    }

    public interface _FinalStage {
        LoyaltyEvent build();

        /**
         * <p>The Square-assigned ID of the loyalty event.</p>
         */
        _FinalStage id(Optional<String> id);

        _FinalStage id(String id);

        /**
         * <p>The timestamp when the event was created, in RFC 3339 format.</p>
         */
        _FinalStage createdAt(Optional<String> createdAt);

        _FinalStage createdAt(String createdAt);

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>ACCUMULATE_POINTS</code>.</p>
         */
        _FinalStage accumulatePoints(Optional<LoyaltyEventAccumulatePoints> accumulatePoints);

        _FinalStage accumulatePoints(LoyaltyEventAccumulatePoints accumulatePoints);

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>CREATE_REWARD</code>.</p>
         */
        _FinalStage createReward(Optional<LoyaltyEventCreateReward> createReward);

        _FinalStage createReward(LoyaltyEventCreateReward createReward);

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>REDEEM_REWARD</code>.</p>
         */
        _FinalStage redeemReward(Optional<LoyaltyEventRedeemReward> redeemReward);

        _FinalStage redeemReward(LoyaltyEventRedeemReward redeemReward);

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>DELETE_REWARD</code>.</p>
         */
        _FinalStage deleteReward(Optional<LoyaltyEventDeleteReward> deleteReward);

        _FinalStage deleteReward(LoyaltyEventDeleteReward deleteReward);

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>ADJUST_POINTS</code>.</p>
         */
        _FinalStage adjustPoints(Optional<LoyaltyEventAdjustPoints> adjustPoints);

        _FinalStage adjustPoints(LoyaltyEventAdjustPoints adjustPoints);

        /**
         * <p>The ID of the <a href="entity:LoyaltyAccount">loyalty account</a> associated with the event.</p>
         */
        _FinalStage loyaltyAccountId(Optional<String> loyaltyAccountId);

        _FinalStage loyaltyAccountId(String loyaltyAccountId);

        /**
         * <p>The ID of the <a href="entity:Location">location</a> where the event occurred.</p>
         */
        _FinalStage locationId(Optional<String> locationId);

        _FinalStage locationId(String locationId);

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>EXPIRE_POINTS</code>.</p>
         */
        _FinalStage expirePoints(Optional<LoyaltyEventExpirePoints> expirePoints);

        _FinalStage expirePoints(LoyaltyEventExpirePoints expirePoints);

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>OTHER</code>.</p>
         */
        _FinalStage otherEvent(Optional<LoyaltyEventOther> otherEvent);

        _FinalStage otherEvent(LoyaltyEventOther otherEvent);

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>ACCUMULATE_PROMOTION_POINTS</code>.</p>
         */
        _FinalStage accumulatePromotionPoints(
                Optional<LoyaltyEventAccumulatePromotionPoints> accumulatePromotionPoints);

        _FinalStage accumulatePromotionPoints(LoyaltyEventAccumulatePromotionPoints accumulatePromotionPoints);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TypeStage, SourceStage, _FinalStage {
        private LoyaltyEventType type;

        private LoyaltyEventSource source;

        private Optional<LoyaltyEventAccumulatePromotionPoints> accumulatePromotionPoints = Optional.empty();

        private Optional<LoyaltyEventOther> otherEvent = Optional.empty();

        private Optional<LoyaltyEventExpirePoints> expirePoints = Optional.empty();

        private Optional<String> locationId = Optional.empty();

        private Optional<String> loyaltyAccountId = Optional.empty();

        private Optional<LoyaltyEventAdjustPoints> adjustPoints = Optional.empty();

        private Optional<LoyaltyEventDeleteReward> deleteReward = Optional.empty();

        private Optional<LoyaltyEventRedeemReward> redeemReward = Optional.empty();

        private Optional<LoyaltyEventCreateReward> createReward = Optional.empty();

        private Optional<LoyaltyEventAccumulatePoints> accumulatePoints = Optional.empty();

        private Optional<String> createdAt = Optional.empty();

        private Optional<String> id = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(LoyaltyEvent other) {
            id(other.getId());
            type(other.getType());
            createdAt(other.getCreatedAt());
            accumulatePoints(other.getAccumulatePoints());
            createReward(other.getCreateReward());
            redeemReward(other.getRedeemReward());
            deleteReward(other.getDeleteReward());
            adjustPoints(other.getAdjustPoints());
            loyaltyAccountId(other.getLoyaltyAccountId());
            locationId(other.getLocationId());
            source(other.getSource());
            expirePoints(other.getExpirePoints());
            otherEvent(other.getOtherEvent());
            accumulatePromotionPoints(other.getAccumulatePromotionPoints());
            return this;
        }

        /**
         * <p>The type of the loyalty event.
         * See <a href="#type-loyaltyeventtype">LoyaltyEventType</a> for possible values</p>
         * <p>The type of the loyalty event.
         * See <a href="#type-loyaltyeventtype">LoyaltyEventType</a> for possible values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("type")
        public SourceStage type(@NotNull LoyaltyEventType type) {
            this.type = Objects.requireNonNull(type, "type must not be null");
            return this;
        }

        /**
         * <p>Defines whether the event was generated by the Square Point of Sale.
         * See <a href="#type-loyaltyeventsource">LoyaltyEventSource</a> for possible values</p>
         * <p>Defines whether the event was generated by the Square Point of Sale.
         * See <a href="#type-loyaltyeventsource">LoyaltyEventSource</a> for possible values</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("source")
        public _FinalStage source(@NotNull LoyaltyEventSource source) {
            this.source = Objects.requireNonNull(source, "source must not be null");
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>ACCUMULATE_PROMOTION_POINTS</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage accumulatePromotionPoints(LoyaltyEventAccumulatePromotionPoints accumulatePromotionPoints) {
            this.accumulatePromotionPoints = Optional.ofNullable(accumulatePromotionPoints);
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>ACCUMULATE_PROMOTION_POINTS</code>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "accumulate_promotion_points", nulls = Nulls.SKIP)
        public _FinalStage accumulatePromotionPoints(
                Optional<LoyaltyEventAccumulatePromotionPoints> accumulatePromotionPoints) {
            this.accumulatePromotionPoints = accumulatePromotionPoints;
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>OTHER</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage otherEvent(LoyaltyEventOther otherEvent) {
            this.otherEvent = Optional.ofNullable(otherEvent);
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>OTHER</code>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "other_event", nulls = Nulls.SKIP)
        public _FinalStage otherEvent(Optional<LoyaltyEventOther> otherEvent) {
            this.otherEvent = otherEvent;
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>EXPIRE_POINTS</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage expirePoints(LoyaltyEventExpirePoints expirePoints) {
            this.expirePoints = Optional.ofNullable(expirePoints);
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>EXPIRE_POINTS</code>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "expire_points", nulls = Nulls.SKIP)
        public _FinalStage expirePoints(Optional<LoyaltyEventExpirePoints> expirePoints) {
            this.expirePoints = expirePoints;
            return this;
        }

        /**
         * <p>The ID of the <a href="entity:Location">location</a> where the event occurred.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage locationId(String locationId) {
            this.locationId = Optional.ofNullable(locationId);
            return this;
        }

        /**
         * <p>The ID of the <a href="entity:Location">location</a> where the event occurred.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "location_id", nulls = Nulls.SKIP)
        public _FinalStage locationId(Optional<String> locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * <p>The ID of the <a href="entity:LoyaltyAccount">loyalty account</a> associated with the event.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage loyaltyAccountId(String loyaltyAccountId) {
            this.loyaltyAccountId = Optional.ofNullable(loyaltyAccountId);
            return this;
        }

        /**
         * <p>The ID of the <a href="entity:LoyaltyAccount">loyalty account</a> associated with the event.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "loyalty_account_id", nulls = Nulls.SKIP)
        public _FinalStage loyaltyAccountId(Optional<String> loyaltyAccountId) {
            this.loyaltyAccountId = loyaltyAccountId;
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>ADJUST_POINTS</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage adjustPoints(LoyaltyEventAdjustPoints adjustPoints) {
            this.adjustPoints = Optional.ofNullable(adjustPoints);
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>ADJUST_POINTS</code>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "adjust_points", nulls = Nulls.SKIP)
        public _FinalStage adjustPoints(Optional<LoyaltyEventAdjustPoints> adjustPoints) {
            this.adjustPoints = adjustPoints;
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>DELETE_REWARD</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage deleteReward(LoyaltyEventDeleteReward deleteReward) {
            this.deleteReward = Optional.ofNullable(deleteReward);
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>DELETE_REWARD</code>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "delete_reward", nulls = Nulls.SKIP)
        public _FinalStage deleteReward(Optional<LoyaltyEventDeleteReward> deleteReward) {
            this.deleteReward = deleteReward;
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>REDEEM_REWARD</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage redeemReward(LoyaltyEventRedeemReward redeemReward) {
            this.redeemReward = Optional.ofNullable(redeemReward);
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>REDEEM_REWARD</code>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "redeem_reward", nulls = Nulls.SKIP)
        public _FinalStage redeemReward(Optional<LoyaltyEventRedeemReward> redeemReward) {
            this.redeemReward = redeemReward;
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>CREATE_REWARD</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage createReward(LoyaltyEventCreateReward createReward) {
            this.createReward = Optional.ofNullable(createReward);
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>CREATE_REWARD</code>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "create_reward", nulls = Nulls.SKIP)
        public _FinalStage createReward(Optional<LoyaltyEventCreateReward> createReward) {
            this.createReward = createReward;
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>ACCUMULATE_POINTS</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage accumulatePoints(LoyaltyEventAccumulatePoints accumulatePoints) {
            this.accumulatePoints = Optional.ofNullable(accumulatePoints);
            return this;
        }

        /**
         * <p>Provides metadata when the event <code>type</code> is <code>ACCUMULATE_POINTS</code>.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "accumulate_points", nulls = Nulls.SKIP)
        public _FinalStage accumulatePoints(Optional<LoyaltyEventAccumulatePoints> accumulatePoints) {
            this.accumulatePoints = accumulatePoints;
            return this;
        }

        /**
         * <p>The timestamp when the event was created, in RFC 3339 format.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage createdAt(String createdAt) {
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        /**
         * <p>The timestamp when the event was created, in RFC 3339 format.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public _FinalStage createdAt(Optional<String> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * <p>The Square-assigned ID of the loyalty event.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage id(String id) {
            this.id = Optional.ofNullable(id);
            return this;
        }

        /**
         * <p>The Square-assigned ID of the loyalty event.</p>
         */
        @java.lang.Override
        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public _FinalStage id(Optional<String> id) {
            this.id = id;
            return this;
        }

        @java.lang.Override
        public LoyaltyEvent build() {
            return new LoyaltyEvent(
                    id,
                    type,
                    createdAt,
                    accumulatePoints,
                    createReward,
                    redeemReward,
                    deleteReward,
                    adjustPoints,
                    loyaltyAccountId,
                    locationId,
                    source,
                    expirePoints,
                    otherEvent,
                    accumulatePromotionPoints,
                    additionalProperties);
        }
    }
}
