package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SubscriptionEvent type.
 */
public class SubscriptionEvent {
    private final String id;
    private final String subscriptionEventType;
    private final String effectiveDate;
    private final Integer monthlyBillingAnchorDate;
    private final SubscriptionEventInfo info;
    private final OptionalNullable<List<Phase>> phases;
    private final String planVariationId;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  subscriptionEventType  String value for subscriptionEventType.
     * @param  effectiveDate  String value for effectiveDate.
     * @param  planVariationId  String value for planVariationId.
     * @param  monthlyBillingAnchorDate  Integer value for monthlyBillingAnchorDate.
     * @param  info  SubscriptionEventInfo value for info.
     * @param  phases  List of Phase value for phases.
     */
    @JsonCreator
    public SubscriptionEvent(
            @JsonProperty("id") String id,
            @JsonProperty("subscription_event_type") String subscriptionEventType,
            @JsonProperty("effective_date") String effectiveDate,
            @JsonProperty("plan_variation_id") String planVariationId,
            @JsonProperty("monthly_billing_anchor_date") Integer monthlyBillingAnchorDate,
            @JsonProperty("info") SubscriptionEventInfo info,
            @JsonProperty("phases") List<Phase> phases) {
        this.id = id;
        this.subscriptionEventType = subscriptionEventType;
        this.effectiveDate = effectiveDate;
        this.monthlyBillingAnchorDate = monthlyBillingAnchorDate;
        this.info = info;
        this.phases = OptionalNullable.of(phases);
        this.planVariationId = planVariationId;
    }

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  subscriptionEventType  String value for subscriptionEventType.
     * @param  effectiveDate  String value for effectiveDate.
     * @param  planVariationId  String value for planVariationId.
     * @param  monthlyBillingAnchorDate  Integer value for monthlyBillingAnchorDate.
     * @param  info  SubscriptionEventInfo value for info.
     * @param  phases  List of Phase value for phases.
     */
    protected SubscriptionEvent(
            String id,
            String subscriptionEventType,
            String effectiveDate,
            String planVariationId,
            Integer monthlyBillingAnchorDate,
            SubscriptionEventInfo info,
            OptionalNullable<List<Phase>> phases) {
        this.id = id;
        this.subscriptionEventType = subscriptionEventType;
        this.effectiveDate = effectiveDate;
        this.monthlyBillingAnchorDate = monthlyBillingAnchorDate;
        this.info = info;
        this.phases = phases;
        this.planVariationId = planVariationId;
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
     * Getter for MonthlyBillingAnchorDate.
     * The day-of-the-month the billing anchor date was changed to, if applicable.
     * @return Returns the Integer
     */
    @JsonGetter("monthly_billing_anchor_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getMonthlyBillingAnchorDate() {
        return monthlyBillingAnchorDate;
    }

    /**
     * Getter for Info.
     * Provides information about the subscription event.
     * @return Returns the SubscriptionEventInfo
     */
    @JsonGetter("info")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public SubscriptionEventInfo getInfo() {
        return info;
    }

    /**
     * Internal Getter for Phases.
     * A list of Phases, to pass phase-specific information used in the swap.
     * @return Returns the Internal List of Phase
     */
    @JsonGetter("phases")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<Phase>> internalGetPhases() {
        return this.phases;
    }

    /**
     * Getter for Phases.
     * A list of Phases, to pass phase-specific information used in the swap.
     * @return Returns the List of Phase
     */
    @JsonIgnore
    public List<Phase> getPhases() {
        return OptionalNullable.getFrom(phases);
    }

    /**
     * Getter for PlanVariationId.
     * The ID of the subscription plan variation associated with the subscription.
     * @return Returns the String
     */
    @JsonGetter("plan_variation_id")
    public String getPlanVariationId() {
        return planVariationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, subscriptionEventType, effectiveDate, monthlyBillingAnchorDate, info, phases, planVariationId);
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
                && Objects.equals(monthlyBillingAnchorDate, other.monthlyBillingAnchorDate)
                && Objects.equals(info, other.info)
                && Objects.equals(phases, other.phases)
                && Objects.equals(planVariationId, other.planVariationId);
    }

    /**
     * Converts this SubscriptionEvent into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SubscriptionEvent [" + "id=" + id + ", subscriptionEventType="
                + subscriptionEventType + ", effectiveDate=" + effectiveDate + ", planVariationId="
                + planVariationId + ", monthlyBillingAnchorDate=" + monthlyBillingAnchorDate
                + ", info=" + info + ", phases=" + phases + "]";
    }

    /**
     * Builds a new {@link SubscriptionEvent.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubscriptionEvent.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id, subscriptionEventType, effectiveDate, planVariationId)
                .monthlyBillingAnchorDate(getMonthlyBillingAnchorDate())
                .info(getInfo());
        builder.phases = internalGetPhases();
        return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionEvent}.
     */
    public static class Builder {
        private String id;
        private String subscriptionEventType;
        private String effectiveDate;
        private String planVariationId;
        private Integer monthlyBillingAnchorDate;
        private SubscriptionEventInfo info;
        private OptionalNullable<List<Phase>> phases;

        /**
         * Initialization constructor.
         * @param  id  String value for id.
         * @param  subscriptionEventType  String value for subscriptionEventType.
         * @param  effectiveDate  String value for effectiveDate.
         * @param  planVariationId  String value for planVariationId.
         */
        public Builder(String id, String subscriptionEventType, String effectiveDate, String planVariationId) {
            this.id = id;
            this.subscriptionEventType = subscriptionEventType;
            this.effectiveDate = effectiveDate;
            this.planVariationId = planVariationId;
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
         * Setter for planVariationId.
         * @param  planVariationId  String value for planVariationId.
         * @return Builder
         */
        public Builder planVariationId(String planVariationId) {
            this.planVariationId = planVariationId;
            return this;
        }

        /**
         * Setter for monthlyBillingAnchorDate.
         * @param  monthlyBillingAnchorDate  Integer value for monthlyBillingAnchorDate.
         * @return Builder
         */
        public Builder monthlyBillingAnchorDate(Integer monthlyBillingAnchorDate) {
            this.monthlyBillingAnchorDate = monthlyBillingAnchorDate;
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
         * Setter for phases.
         * @param  phases  List of Phase value for phases.
         * @return Builder
         */
        public Builder phases(List<Phase> phases) {
            this.phases = OptionalNullable.of(phases);
            return this;
        }

        /**
         * UnSetter for phases.
         * @return Builder
         */
        public Builder unsetPhases() {
            phases = null;
            return this;
        }

        /**
         * Builds a new {@link SubscriptionEvent} object using the set fields.
         * @return {@link SubscriptionEvent}
         */
        public SubscriptionEvent build() {
            return new SubscriptionEvent(
                    id, subscriptionEventType, effectiveDate, planVariationId, monthlyBillingAnchorDate, info, phases);
        }
    }
}
