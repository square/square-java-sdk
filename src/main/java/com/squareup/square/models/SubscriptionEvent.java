package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SubscriptionEvent type.
 */
public class SubscriptionEvent {

    /**
     * Initialization constructor.
     * @param id
     * @param subscriptionEventType
     * @param effectiveDate
     * @param planId
     */
    @JsonCreator
    public SubscriptionEvent(
            @JsonProperty("id") String id,
            @JsonProperty("subscription_event_type") String subscriptionEventType,
            @JsonProperty("effective_date") String effectiveDate,
            @JsonProperty("plan_id") String planId) {
        this.id = id;
        this.subscriptionEventType = subscriptionEventType;
        this.effectiveDate = effectiveDate;
        this.planId = planId;
    }

    private final String id;
    private final String subscriptionEventType;
    private final String effectiveDate;
    private final String planId;
    /**
     * Getter for Id.
     * The ID of the subscription event.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for SubscriptionEventType.
     * The possible subscription event types.
     */
    @JsonGetter("subscription_event_type")
    public String getSubscriptionEventType() {
        return this.subscriptionEventType;
    }

    /**
     * Getter for EffectiveDate.
     * The date, in YYYY-MM-DD format (for
     * example, 2013-01-15), when the subscription event went into effect.
     */
    @JsonGetter("effective_date")
    public String getEffectiveDate() {
        return this.effectiveDate;
    }

    /**
     * Getter for PlanId.
     * The ID of the subscription plan associated with the subscription.
     */
    @JsonGetter("plan_id")
    public String getPlanId() {
        return this.planId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, subscriptionEventType, effectiveDate, planId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SubscriptionEvent)) {
            return false;
        }
        SubscriptionEvent subscriptionEvent = (SubscriptionEvent) obj;
        return Objects.equals(id, subscriptionEvent.id) &&
            Objects.equals(subscriptionEventType, subscriptionEvent.subscriptionEventType) &&
            Objects.equals(effectiveDate, subscriptionEvent.effectiveDate) &&
            Objects.equals(planId, subscriptionEvent.planId);
    }

    /**
     * Builds a new {@link SubscriptionEvent.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubscriptionEvent.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id,
            subscriptionEventType,
            effectiveDate,
            planId);
            return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionEvent}
     */
    public static class Builder {
        private String id;
        private String subscriptionEventType;
        private String effectiveDate;
        private String planId;

        /**
         * Initialization constructor
         */
        public Builder(String id,
                String subscriptionEventType,
                String effectiveDate,
                String planId) {
            this.id = id;
            this.subscriptionEventType = subscriptionEventType;
            this.effectiveDate = effectiveDate;
            this.planId = planId;
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
         * Setter for subscriptionEventType
         * @param subscriptionEventType
         * @return Builder
         */
        public Builder subscriptionEventType(String subscriptionEventType) {
            this.subscriptionEventType = subscriptionEventType;
            return this;
        }
        /**
         * Setter for effectiveDate
         * @param effectiveDate
         * @return Builder
         */
        public Builder effectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }
        /**
         * Setter for planId
         * @param planId
         * @return Builder
         */
        public Builder planId(String planId) {
            this.planId = planId;
            return this;
        }

        /**
         * Builds a new {@link SubscriptionEvent} object using the set fields.
         * @return {@link SubscriptionEvent}
         */
        public SubscriptionEvent build() {
            return new SubscriptionEvent(id,
                subscriptionEventType,
                effectiveDate,
                planId);
        }
    }
}
