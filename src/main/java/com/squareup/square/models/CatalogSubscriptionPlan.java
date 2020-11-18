
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogSubscriptionPlan type.
 */
public class CatalogSubscriptionPlan {
    private final String name;
    private final List<SubscriptionPhase> phases;

    /**
     * Initialization constructor.
     * @param name String value for name.
     * @param phases List of SubscriptionPhase value for phases.
     */
    @JsonCreator
    public CatalogSubscriptionPlan(
            @JsonProperty("name") String name,
            @JsonProperty("phases") List<SubscriptionPhase> phases) {
        this.name = name;
        this.phases = phases;
    }

    /**
     * Getter for Name.
     * The name of the plan.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Phases.
     * A list of SubscriptionPhase containing the [SubscriptionPhase](#type-SubscriptionPhase) for
     * this plan.
     * @return Returns the List of SubscriptionPhase
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogSubscriptionPlan)) {
            return false;
        }
        CatalogSubscriptionPlan other = (CatalogSubscriptionPlan) obj;
        return Objects.equals(name, other.name)
            && Objects.equals(phases, other.phases);
    }

    /**
     * Converts this CatalogSubscriptionPlan into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogSubscriptionPlan [" + "name=" + name + ", phases=" + phases + "]";
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
     * Class to build instances of {@link CatalogSubscriptionPlan}.
     */
    public static class Builder {
        private String name;
        private List<SubscriptionPhase> phases;



        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for phases.
         * @param phases List of SubscriptionPhase value for phases.
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
            return new CatalogSubscriptionPlan(name, phases);
        }
    }
}
