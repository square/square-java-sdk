
package com.squareup.square.models;

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
 * This is a model class for CatalogSubscriptionPlanVariation type.
 */
public class CatalogSubscriptionPlanVariation {
    private final String name;
    private final List<SubscriptionPhase> phases;
    private final OptionalNullable<String> subscriptionPlanId;
    private final OptionalNullable<Long> monthlyBillingAnchorDate;
    private final OptionalNullable<Boolean> canProrate;
    private final OptionalNullable<String> successorPlanVariationId;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  phases  List of SubscriptionPhase value for phases.
     * @param  subscriptionPlanId  String value for subscriptionPlanId.
     * @param  monthlyBillingAnchorDate  Long value for monthlyBillingAnchorDate.
     * @param  canProrate  Boolean value for canProrate.
     * @param  successorPlanVariationId  String value for successorPlanVariationId.
     */
    @JsonCreator
    public CatalogSubscriptionPlanVariation(
            @JsonProperty("name") String name,
            @JsonProperty("phases") List<SubscriptionPhase> phases,
            @JsonProperty("subscription_plan_id") String subscriptionPlanId,
            @JsonProperty("monthly_billing_anchor_date") Long monthlyBillingAnchorDate,
            @JsonProperty("can_prorate") Boolean canProrate,
            @JsonProperty("successor_plan_variation_id") String successorPlanVariationId) {
        this.name = name;
        this.phases = phases;
        this.subscriptionPlanId = OptionalNullable.of(subscriptionPlanId);
        this.monthlyBillingAnchorDate = OptionalNullable.of(monthlyBillingAnchorDate);
        this.canProrate = OptionalNullable.of(canProrate);
        this.successorPlanVariationId = OptionalNullable.of(successorPlanVariationId);
    }

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  phases  List of SubscriptionPhase value for phases.
     * @param  subscriptionPlanId  String value for subscriptionPlanId.
     * @param  monthlyBillingAnchorDate  Long value for monthlyBillingAnchorDate.
     * @param  canProrate  Boolean value for canProrate.
     * @param  successorPlanVariationId  String value for successorPlanVariationId.
     */

    protected CatalogSubscriptionPlanVariation(String name, List<SubscriptionPhase> phases,
            OptionalNullable<String> subscriptionPlanId,
            OptionalNullable<Long> monthlyBillingAnchorDate, OptionalNullable<Boolean> canProrate,
            OptionalNullable<String> successorPlanVariationId) {
        this.name = name;
        this.phases = phases;
        this.subscriptionPlanId = subscriptionPlanId;
        this.monthlyBillingAnchorDate = monthlyBillingAnchorDate;
        this.canProrate = canProrate;
        this.successorPlanVariationId = successorPlanVariationId;
    }

    /**
     * Getter for Name.
     * The name of the plan variation.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Getter for Phases.
     * A list containing each [SubscriptionPhase](entity:SubscriptionPhase) for this plan variation.
     * @return Returns the List of SubscriptionPhase
     */
    @JsonGetter("phases")
    public List<SubscriptionPhase> getPhases() {
        return phases;
    }

    /**
     * Internal Getter for SubscriptionPlanId.
     * The id of the subscription plan, if there is one.
     * @return Returns the Internal String
     */
    @JsonGetter("subscription_plan_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }

    /**
     * Getter for SubscriptionPlanId.
     * The id of the subscription plan, if there is one.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSubscriptionPlanId() {
        return OptionalNullable.getFrom(subscriptionPlanId);
    }

    /**
     * Internal Getter for MonthlyBillingAnchorDate.
     * The day of the month the billing period starts.
     * @return Returns the Internal Long
     */
    @JsonGetter("monthly_billing_anchor_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetMonthlyBillingAnchorDate() {
        return this.monthlyBillingAnchorDate;
    }

    /**
     * Getter for MonthlyBillingAnchorDate.
     * The day of the month the billing period starts.
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getMonthlyBillingAnchorDate() {
        return OptionalNullable.getFrom(monthlyBillingAnchorDate);
    }

    /**
     * Internal Getter for CanProrate.
     * Whether bills for this plan variation can be split for proration.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("can_prorate")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetCanProrate() {
        return this.canProrate;
    }

    /**
     * Getter for CanProrate.
     * Whether bills for this plan variation can be split for proration.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getCanProrate() {
        return OptionalNullable.getFrom(canProrate);
    }

    /**
     * Internal Getter for SuccessorPlanVariationId.
     * The ID of a "successor" plan variation to this one. If the field is set, and this object is
     * disabled at all locations, it indicates that this variation is deprecated and the object
     * identified by the successor ID be used in its stead.
     * @return Returns the Internal String
     */
    @JsonGetter("successor_plan_variation_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSuccessorPlanVariationId() {
        return this.successorPlanVariationId;
    }

    /**
     * Getter for SuccessorPlanVariationId.
     * The ID of a "successor" plan variation to this one. If the field is set, and this object is
     * disabled at all locations, it indicates that this variation is deprecated and the object
     * identified by the successor ID be used in its stead.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSuccessorPlanVariationId() {
        return OptionalNullable.getFrom(successorPlanVariationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phases, subscriptionPlanId, monthlyBillingAnchorDate, canProrate,
                successorPlanVariationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogSubscriptionPlanVariation)) {
            return false;
        }
        CatalogSubscriptionPlanVariation other = (CatalogSubscriptionPlanVariation) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(phases, other.phases)
            && Objects.equals(subscriptionPlanId, other.subscriptionPlanId)
            && Objects.equals(monthlyBillingAnchorDate, other.monthlyBillingAnchorDate)
            && Objects.equals(canProrate, other.canProrate)
            && Objects.equals(successorPlanVariationId, other.successorPlanVariationId);
    }

    /**
     * Converts this CatalogSubscriptionPlanVariation into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogSubscriptionPlanVariation [" + "name=" + name + ", phases=" + phases
                + ", subscriptionPlanId=" + subscriptionPlanId + ", monthlyBillingAnchorDate="
                + monthlyBillingAnchorDate + ", canProrate=" + canProrate
                + ", successorPlanVariationId=" + successorPlanVariationId + "]";
    }

    /**
     * Builds a new {@link CatalogSubscriptionPlanVariation.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogSubscriptionPlanVariation.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(name, phases);
        builder.subscriptionPlanId = internalGetSubscriptionPlanId();
        builder.monthlyBillingAnchorDate = internalGetMonthlyBillingAnchorDate();
        builder.canProrate = internalGetCanProrate();
        builder.successorPlanVariationId = internalGetSuccessorPlanVariationId();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogSubscriptionPlanVariation}.
     */
    public static class Builder {
        private String name;
        private List<SubscriptionPhase> phases;
        private OptionalNullable<String> subscriptionPlanId;
        private OptionalNullable<Long> monthlyBillingAnchorDate;
        private OptionalNullable<Boolean> canProrate;
        private OptionalNullable<String> successorPlanVariationId;

        /**
         * Initialization constructor.
         * @param  name  String value for name.
         * @param  phases  List of SubscriptionPhase value for phases.
         */
        public Builder(String name, List<SubscriptionPhase> phases) {
            this.name = name;
            this.phases = phases;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for phases.
         * @param  phases  List of SubscriptionPhase value for phases.
         * @return Builder
         */
        public Builder phases(List<SubscriptionPhase> phases) {
            this.phases = phases;
            return this;
        }

        /**
         * Setter for subscriptionPlanId.
         * @param  subscriptionPlanId  String value for subscriptionPlanId.
         * @return Builder
         */
        public Builder subscriptionPlanId(String subscriptionPlanId) {
            this.subscriptionPlanId = OptionalNullable.of(subscriptionPlanId);
            return this;
        }

        /**
         * UnSetter for subscriptionPlanId.
         * @return Builder
         */
        public Builder unsetSubscriptionPlanId() {
            subscriptionPlanId = null;
            return this;
        }

        /**
         * Setter for monthlyBillingAnchorDate.
         * @param  monthlyBillingAnchorDate  Long value for monthlyBillingAnchorDate.
         * @return Builder
         */
        public Builder monthlyBillingAnchorDate(Long monthlyBillingAnchorDate) {
            this.monthlyBillingAnchorDate = OptionalNullable.of(monthlyBillingAnchorDate);
            return this;
        }

        /**
         * UnSetter for monthlyBillingAnchorDate.
         * @return Builder
         */
        public Builder unsetMonthlyBillingAnchorDate() {
            monthlyBillingAnchorDate = null;
            return this;
        }

        /**
         * Setter for canProrate.
         * @param  canProrate  Boolean value for canProrate.
         * @return Builder
         */
        public Builder canProrate(Boolean canProrate) {
            this.canProrate = OptionalNullable.of(canProrate);
            return this;
        }

        /**
         * UnSetter for canProrate.
         * @return Builder
         */
        public Builder unsetCanProrate() {
            canProrate = null;
            return this;
        }

        /**
         * Setter for successorPlanVariationId.
         * @param  successorPlanVariationId  String value for successorPlanVariationId.
         * @return Builder
         */
        public Builder successorPlanVariationId(String successorPlanVariationId) {
            this.successorPlanVariationId = OptionalNullable.of(successorPlanVariationId);
            return this;
        }

        /**
         * UnSetter for successorPlanVariationId.
         * @return Builder
         */
        public Builder unsetSuccessorPlanVariationId() {
            successorPlanVariationId = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogSubscriptionPlanVariation} object using the set fields.
         * @return {@link CatalogSubscriptionPlanVariation}
         */
        public CatalogSubscriptionPlanVariation build() {
            return new CatalogSubscriptionPlanVariation(name, phases, subscriptionPlanId,
                    monthlyBillingAnchorDate, canProrate, successorPlanVariationId);
        }
    }
}
