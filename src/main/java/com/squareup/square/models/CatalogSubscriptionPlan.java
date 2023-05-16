
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
 * This is a model class for CatalogSubscriptionPlan type.
 */
public class CatalogSubscriptionPlan {
    private final String name;
    private final OptionalNullable<List<SubscriptionPhase>> phases;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     * @param  phases  List of SubscriptionPhase value for phases.
     */
    @JsonCreator
    public CatalogSubscriptionPlan(
            @JsonProperty("name") String name,
            @JsonProperty("phases") List<SubscriptionPhase> phases) {
        this.name = name;
        this.phases = OptionalNullable.of(phases);
    }

    /**
     * Internal initialization constructor.
     */
    protected CatalogSubscriptionPlan(String name,
            OptionalNullable<List<SubscriptionPhase>> phases) {
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
        Builder builder = new Builder(name);
        builder.phases = internalGetPhases();
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogSubscriptionPlan}.
     */
    public static class Builder {
        private String name;
        private OptionalNullable<List<SubscriptionPhase>> phases;

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
         * Builds a new {@link CatalogSubscriptionPlan} object using the set fields.
         * @return {@link CatalogSubscriptionPlan}
         */
        public CatalogSubscriptionPlan build() {
            return new CatalogSubscriptionPlan(name, phases);
        }
    }
}
