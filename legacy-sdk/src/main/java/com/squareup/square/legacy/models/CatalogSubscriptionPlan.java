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
 * This is a model class for CatalogSubscriptionPlan type.
 */
public class CatalogSubscriptionPlan {
    private final String name;
    private final OptionalNullable<List<SubscriptionPhase>> phases;
    private final OptionalNullable<List<CatalogObject>> subscriptionPlanVariations;
    private final OptionalNullable<List<String>> eligibleItemIds;
    private final OptionalNullable<List<String>> eligibleCategoryIds;
    private final OptionalNullable<Boolean> allItems;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  phases  List of SubscriptionPhase value for phases.
     * @param  subscriptionPlanVariations  List of CatalogObject value for
     *         subscriptionPlanVariations.
     * @param  eligibleItemIds  List of String value for eligibleItemIds.
     * @param  eligibleCategoryIds  List of String value for eligibleCategoryIds.
     * @param  allItems  Boolean value for allItems.
     */
    @JsonCreator
    public CatalogSubscriptionPlan(
            @JsonProperty("name") String name,
            @JsonProperty("phases") List<SubscriptionPhase> phases,
            @JsonProperty("subscription_plan_variations") List<CatalogObject> subscriptionPlanVariations,
            @JsonProperty("eligible_item_ids") List<String> eligibleItemIds,
            @JsonProperty("eligible_category_ids") List<String> eligibleCategoryIds,
            @JsonProperty("all_items") Boolean allItems) {
        this.name = name;
        this.phases = OptionalNullable.of(phases);
        this.subscriptionPlanVariations = OptionalNullable.of(subscriptionPlanVariations);
        this.eligibleItemIds = OptionalNullable.of(eligibleItemIds);
        this.eligibleCategoryIds = OptionalNullable.of(eligibleCategoryIds);
        this.allItems = OptionalNullable.of(allItems);
    }

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  phases  List of SubscriptionPhase value for phases.
     * @param  subscriptionPlanVariations  List of CatalogObject value for
     *         subscriptionPlanVariations.
     * @param  eligibleItemIds  List of String value for eligibleItemIds.
     * @param  eligibleCategoryIds  List of String value for eligibleCategoryIds.
     * @param  allItems  Boolean value for allItems.
     */
    protected CatalogSubscriptionPlan(
            String name,
            OptionalNullable<List<SubscriptionPhase>> phases,
            OptionalNullable<List<CatalogObject>> subscriptionPlanVariations,
            OptionalNullable<List<String>> eligibleItemIds,
            OptionalNullable<List<String>> eligibleCategoryIds,
            OptionalNullable<Boolean> allItems) {
        this.name = name;
        this.phases = phases;
        this.subscriptionPlanVariations = subscriptionPlanVariations;
        this.eligibleItemIds = eligibleItemIds;
        this.eligibleCategoryIds = eligibleCategoryIds;
        this.allItems = allItems;
    }

    /**
     * Getter for Name.
     * The name of the plan.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /**
     * Internal Getter for Phases.
     * A list of SubscriptionPhase containing the [SubscriptionPhase](entity:SubscriptionPhase) for
     * this plan. This field it required. Not including this field will throw a
     * REQUIRED_FIELD_MISSING error
     * @return Returns the Internal List of SubscriptionPhase
     */
    @JsonGetter("phases")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<SubscriptionPhase>> internalGetPhases() {
        return this.phases;
    }

    /**
     * Getter for Phases.
     * A list of SubscriptionPhase containing the [SubscriptionPhase](entity:SubscriptionPhase) for
     * this plan. This field it required. Not including this field will throw a
     * REQUIRED_FIELD_MISSING error
     * @return Returns the List of SubscriptionPhase
     */
    @JsonIgnore
    public List<SubscriptionPhase> getPhases() {
        return OptionalNullable.getFrom(phases);
    }

    /**
     * Internal Getter for SubscriptionPlanVariations.
     * The list of subscription plan variations available for this product
     * @return Returns the Internal List of CatalogObject
     */
    @JsonGetter("subscription_plan_variations")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CatalogObject>> internalGetSubscriptionPlanVariations() {
        return this.subscriptionPlanVariations;
    }

    /**
     * Getter for SubscriptionPlanVariations.
     * The list of subscription plan variations available for this product
     * @return Returns the List of CatalogObject
     */
    @JsonIgnore
    public List<CatalogObject> getSubscriptionPlanVariations() {
        return OptionalNullable.getFrom(subscriptionPlanVariations);
    }

    /**
     * Internal Getter for EligibleItemIds.
     * The list of IDs of `CatalogItems` that are eligible for subscription by this
     * SubscriptionPlan's variations.
     * @return Returns the Internal List of String
     */
    @JsonGetter("eligible_item_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetEligibleItemIds() {
        return this.eligibleItemIds;
    }

    /**
     * Getter for EligibleItemIds.
     * The list of IDs of `CatalogItems` that are eligible for subscription by this
     * SubscriptionPlan's variations.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getEligibleItemIds() {
        return OptionalNullable.getFrom(eligibleItemIds);
    }

    /**
     * Internal Getter for EligibleCategoryIds.
     * The list of IDs of `CatalogCategory` that are eligible for subscription by this
     * SubscriptionPlan's variations.
     * @return Returns the Internal List of String
     */
    @JsonGetter("eligible_category_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetEligibleCategoryIds() {
        return this.eligibleCategoryIds;
    }

    /**
     * Getter for EligibleCategoryIds.
     * The list of IDs of `CatalogCategory` that are eligible for subscription by this
     * SubscriptionPlan's variations.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getEligibleCategoryIds() {
        return OptionalNullable.getFrom(eligibleCategoryIds);
    }

    /**
     * Internal Getter for AllItems.
     * If true, all items in the merchant's catalog are subscribable by this SubscriptionPlan.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("all_items")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetAllItems() {
        return this.allItems;
    }

    /**
     * Getter for AllItems.
     * If true, all items in the merchant's catalog are subscribable by this SubscriptionPlan.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getAllItems() {
        return OptionalNullable.getFrom(allItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phases, subscriptionPlanVariations, eligibleItemIds, eligibleCategoryIds, allItems);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogSubscriptionPlan)) {
            return false;
        }
        CatalogSubscriptionPlan other = (CatalogSubscriptionPlan) obj;
        return Objects.equals(name, other.name)
                && Objects.equals(phases, other.phases)
                && Objects.equals(subscriptionPlanVariations, other.subscriptionPlanVariations)
                && Objects.equals(eligibleItemIds, other.eligibleItemIds)
                && Objects.equals(eligibleCategoryIds, other.eligibleCategoryIds)
                && Objects.equals(allItems, other.allItems);
    }

    /**
     * Converts this CatalogSubscriptionPlan into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogSubscriptionPlan [" + "name=" + name + ", phases=" + phases
                + ", subscriptionPlanVariations=" + subscriptionPlanVariations
                + ", eligibleItemIds=" + eligibleItemIds + ", eligibleCategoryIds="
                + eligibleCategoryIds + ", allItems=" + allItems + "]";
    }

    /**
     * Builds a new {@link CatalogSubscriptionPlan.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogSubscriptionPlan.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(name);
        builder.phases = internalGetPhases();
        builder.subscriptionPlanVariations = internalGetSubscriptionPlanVariations();
        builder.eligibleItemIds = internalGetEligibleItemIds();
        builder.eligibleCategoryIds = internalGetEligibleCategoryIds();
        builder.allItems = internalGetAllItems();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogSubscriptionPlan}.
     */
    public static class Builder {
        private String name;
        private OptionalNullable<List<SubscriptionPhase>> phases;
        private OptionalNullable<List<CatalogObject>> subscriptionPlanVariations;
        private OptionalNullable<List<String>> eligibleItemIds;
        private OptionalNullable<List<String>> eligibleCategoryIds;
        private OptionalNullable<Boolean> allItems;

        /**
         * Initialization constructor.
         * @param  name  String value for name.
         */
        public Builder(String name) {
            this.name = name;
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
         * Setter for subscriptionPlanVariations.
         * @param  subscriptionPlanVariations  List of CatalogObject value for
         *         subscriptionPlanVariations.
         * @return Builder
         */
        public Builder subscriptionPlanVariations(List<CatalogObject> subscriptionPlanVariations) {
            this.subscriptionPlanVariations = OptionalNullable.of(subscriptionPlanVariations);
            return this;
        }

        /**
         * UnSetter for subscriptionPlanVariations.
         * @return Builder
         */
        public Builder unsetSubscriptionPlanVariations() {
            subscriptionPlanVariations = null;
            return this;
        }

        /**
         * Setter for eligibleItemIds.
         * @param  eligibleItemIds  List of String value for eligibleItemIds.
         * @return Builder
         */
        public Builder eligibleItemIds(List<String> eligibleItemIds) {
            this.eligibleItemIds = OptionalNullable.of(eligibleItemIds);
            return this;
        }

        /**
         * UnSetter for eligibleItemIds.
         * @return Builder
         */
        public Builder unsetEligibleItemIds() {
            eligibleItemIds = null;
            return this;
        }

        /**
         * Setter for eligibleCategoryIds.
         * @param  eligibleCategoryIds  List of String value for eligibleCategoryIds.
         * @return Builder
         */
        public Builder eligibleCategoryIds(List<String> eligibleCategoryIds) {
            this.eligibleCategoryIds = OptionalNullable.of(eligibleCategoryIds);
            return this;
        }

        /**
         * UnSetter for eligibleCategoryIds.
         * @return Builder
         */
        public Builder unsetEligibleCategoryIds() {
            eligibleCategoryIds = null;
            return this;
        }

        /**
         * Setter for allItems.
         * @param  allItems  Boolean value for allItems.
         * @return Builder
         */
        public Builder allItems(Boolean allItems) {
            this.allItems = OptionalNullable.of(allItems);
            return this;
        }

        /**
         * UnSetter for allItems.
         * @return Builder
         */
        public Builder unsetAllItems() {
            allItems = null;
            return this;
        }

        /**
         * Builds a new {@link CatalogSubscriptionPlan} object using the set fields.
         * @return {@link CatalogSubscriptionPlan}
         */
        public CatalogSubscriptionPlan build() {
            return new CatalogSubscriptionPlan(
                    name, phases, subscriptionPlanVariations, eligibleItemIds, eligibleCategoryIds, allItems);
        }
    }
}
