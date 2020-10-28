
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for SubscriptionEvent type.
 */
public class SubscriptionEvent {
    private final String id;
    private final String subscriptionEventType;
    private final String effectiveDate;
    private final String planId;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param subscriptionEventType String value for subscriptionEventType.
     * @param effectiveDate String value for effectiveDate.
     * @param planId String value for planId.
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

    /**
     * Getter for Id.
     * The ID of the subscription event.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for SubscriptionEventType.
     * The possible subscription event types.
     * @return Returns the String
     */
    @JsonGetter("subscription_event_type")
    public String getSubscriptionEventType() {
        return this.subscriptionEventType;
    }

    /**
     * Getter for EffectiveDate.
     * The date, in YYYY-MM-DD format (for example, 2013-01-15), when the subscription event went
     * into effect.
     * @return Returns the String
     */
    @JsonGetter("effective_date")
    public String getEffectiveDate() {
        return this.effectiveDate;
    }

    /**
     * Getter for PlanId.
     * The ID of the subscription plan associated with the subscription.
     * @return Returns the String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriptionEvent)) {
            return false;
        }
        SubscriptionEvent other = (SubscriptionEvent) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(subscriptionEventType, other.subscriptionEventType)
            && Objects.equals(effectiveDate, other.effectiveDate)
            && Objects.equals(planId, other.planId);
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
     * Class to build instances of {@link SubscriptionEvent}.
     */
    public static class Builder {
        private String id;
        private String subscriptionEventType;
        private String effectiveDate;
        private String planId;

        /**
         * Initialization constructor.
         * @param id String value for id.
         * @param subscriptionEventType String value for subscriptionEventType.
         * @param effectiveDate String value for effectiveDate.
         * @param planId String value for planId.
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
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for subscriptionEventType.
         * @param subscriptionEventType String value for subscriptionEventType.
         * @return Builder
         */
        public Builder subscriptionEventType(String subscriptionEventType) {
            this.subscriptionEventType = subscriptionEventType;
            return this;
        }

        /**
         * Setter for effectiveDate.
         * @param effectiveDate String value for effectiveDate.
         * @return Builder
         */
        public Builder effectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        /**
         * Setter for planId.
         * @param planId String value for planId.
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
