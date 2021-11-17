
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final SubscriptionEventInfo info;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  subscriptionEventType  String value for subscriptionEventType.
     * @param  effectiveDate  String value for effectiveDate.
     * @param  planId  String value for planId.
     * @param  info  SubscriptionEventInfo value for info.
     */
    @JsonCreator
    public SubscriptionEvent(
            @JsonProperty("id") String id,
            @JsonProperty("subscription_event_type") String subscriptionEventType,
            @JsonProperty("effective_date") String effectiveDate,
            @JsonProperty("plan_id") String planId,
            @JsonProperty("info") SubscriptionEventInfo info) {
        this.id = id;
        this.subscriptionEventType = subscriptionEventType;
        this.effectiveDate = effectiveDate;
        this.planId = planId;
        this.info = info;
    }

    /**
     * Getter for Id.
     * The ID of the subscription event.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for SubscriptionEventType.
     * Supported types of an event occurred to a subscription.
     * @return Returns the String
     */
    @JsonGetter("subscription_event_type")
    public String getSubscriptionEventType() {
        return subscriptionEventType;
    }

    /**
     * Getter for EffectiveDate.
     * The `YYYY-MM-DD`-formatted date (for example, 2013-01-15) when the subscription event
     * occurred.
     * @return Returns the String
     */
    @JsonGetter("effective_date")
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Getter for PlanId.
     * The ID of the subscription plan associated with the subscription.
     * @return Returns the String
     */
    @JsonGetter("plan_id")
    public String getPlanId() {
        return planId;
    }

    /**
     * Getter for Info.
     * Provides information about the subscription event.
     * @return Returns the SubscriptionEventInfo
     */
    @JsonGetter("info")
    public SubscriptionEventInfo getInfo() {
        return info;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subscriptionEventType, effectiveDate, planId, info);
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
            && Objects.equals(planId, other.planId)
            && Objects.equals(info, other.info);
    }

    /**
     * Converts this SubscriptionEvent into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SubscriptionEvent [" + "id=" + id + ", subscriptionEventType="
                + subscriptionEventType + ", effectiveDate=" + effectiveDate + ", planId=" + planId
                + ", info=" + info + "]";
    }

    /**
     * Builds a new {@link SubscriptionEvent.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubscriptionEvent.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id, subscriptionEventType, effectiveDate, planId)
                .info(getInfo());
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
        private SubscriptionEventInfo info;

        /**
         * Initialization constructor.
         * @param  id  String value for id.
         * @param  subscriptionEventType  String value for subscriptionEventType.
         * @param  effectiveDate  String value for effectiveDate.
         * @param  planId  String value for planId.
         */
        public Builder(String id, String subscriptionEventType, String effectiveDate,
                String planId) {
            this.id = id;
            this.subscriptionEventType = subscriptionEventType;
            this.effectiveDate = effectiveDate;
            this.planId = planId;
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
         * Setter for subscriptionEventType.
         * @param  subscriptionEventType  String value for subscriptionEventType.
         * @return Builder
         */
        public Builder subscriptionEventType(String subscriptionEventType) {
            this.subscriptionEventType = subscriptionEventType;
            return this;
        }

        /**
         * Setter for effectiveDate.
         * @param  effectiveDate  String value for effectiveDate.
         * @return Builder
         */
        public Builder effectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        /**
         * Setter for planId.
         * @param  planId  String value for planId.
         * @return Builder
         */
        public Builder planId(String planId) {
            this.planId = planId;
            return this;
        }

        /**
         * Setter for info.
         * @param  info  SubscriptionEventInfo value for info.
         * @return Builder
         */
        public Builder info(SubscriptionEventInfo info) {
            this.info = info;
            return this;
        }

        /**
         * Builds a new {@link SubscriptionEvent} object using the set fields.
         * @return {@link SubscriptionEvent}
         */
        public SubscriptionEvent build() {
            return new SubscriptionEvent(id, subscriptionEventType, effectiveDate, planId, info);
        }
    }
}
