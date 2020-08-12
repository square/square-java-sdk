package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogSubscriptionPlan type.
 */
public class CatalogSubscriptionPlan {

    /**
     * Initialization constructor.
     * @param name
     * @param phases
     */
    @JsonCreator
    public CatalogSubscriptionPlan(
            @JsonProperty("name") String name,
            @JsonProperty("phases") List<SubscriptionPhase> phases) {
        this.name = name;
        this.phases = phases;
    }

    private final String name;
    private final List<SubscriptionPhase> phases;
    /**
     * Getter for Name.
     * The name of the plan.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Phases.
     * A list of SubscriptionPhase containing the [SubscriptionPhase](#type-SubscriptionPhase) for this plan.
     */
    @JsonGetter("phases")
    public List<SubscriptionPhase> getPhases() {
        return this.phases;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(name, phases);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogSubscriptionPlan)) {
            return false;
        }
        CatalogSubscriptionPlan catalogSubscriptionPlan = (CatalogSubscriptionPlan) obj;
        return Objects.equals(name, catalogSubscriptionPlan.name) &&
            Objects.equals(phases, catalogSubscriptionPlan.phases);
    }

    /**
     * Builds a new {@link CatalogSubscriptionPlan.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogSubscriptionPlan.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .name(getName())
            .phases(getPhases());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogSubscriptionPlan}
     */
    public static class Builder {
        private String name;
        private List<SubscriptionPhase> phases;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for phases
         * @param phases
         * @return Builder
         */
        public Builder phases(List<SubscriptionPhase> phases) {
            this.phases = phases;
            return this;
        }

        /**
         * Builds a new {@link CatalogSubscriptionPlan} object using the set fields.
         * @return {@link CatalogSubscriptionPlan}
         */
        public CatalogSubscriptionPlan build() {
            return new CatalogSubscriptionPlan(name,
                phases);
        }
    }
}
