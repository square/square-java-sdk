
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
 * This is a model class for SubscriptionAction type.
 */
public class SubscriptionAction {
    private final String id;
    private final String type;
    private final OptionalNullable<String> effectiveDate;
    private final OptionalNullable<List<Phase>> phases;
    private final OptionalNullable<String> newPlanVariationId;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  type  String value for type.
     * @param  effectiveDate  String value for effectiveDate.
     * @param  phases  List of Phase value for phases.
     * @param  newPlanVariationId  String value for newPlanVariationId.
     */
    @JsonCreator
    public SubscriptionAction(
            @JsonProperty("id") String id,
            @JsonProperty("type") String type,
            @JsonProperty("effective_date") String effectiveDate,
            @JsonProperty("phases") List<Phase> phases,
            @JsonProperty("new_plan_variation_id") String newPlanVariationId) {
        this.id = id;
        this.type = type;
        this.effectiveDate = OptionalNullable.of(effectiveDate);
        this.phases = OptionalNullable.of(phases);
        this.newPlanVariationId = OptionalNullable.of(newPlanVariationId);
    }

    /**
     * Internal initialization constructor.
     */
    protected SubscriptionAction(String id, String type, OptionalNullable<String> effectiveDate,
            OptionalNullable<List<Phase>> phases, OptionalNullable<String> newPlanVariationId) {
        this.id = id;
        this.type = type;
        this.effectiveDate = effectiveDate;
        this.phases = phases;
        this.newPlanVariationId = newPlanVariationId;
    }

    /**
     * Getter for Id.
     * The ID of an action scoped to a subscription.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for Type.
     * Supported types of an action as a pending change to a subscription.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Internal Getter for EffectiveDate.
     * The `YYYY-MM-DD`-formatted date when the action occurs on the subscription.
     * @return Returns the Internal String
     */
    @JsonGetter("effective_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEffectiveDate() {
        return this.effectiveDate;
    }

    /**
     * Getter for EffectiveDate.
     * The `YYYY-MM-DD`-formatted date when the action occurs on the subscription.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEffectiveDate() {
        return OptionalNullable.getFrom(effectiveDate);
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
     * Internal Getter for NewPlanVariationId.
     * The target subscription plan variation that a subscription switches to, for a `SWAP_PLAN`
     * action.
     * @return Returns the Internal String
     */
    @JsonGetter("new_plan_variation_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetNewPlanVariationId() {
        return this.newPlanVariationId;
    }

    /**
     * Getter for NewPlanVariationId.
     * The target subscription plan variation that a subscription switches to, for a `SWAP_PLAN`
     * action.
     * @return Returns the String
     */
    @JsonIgnore
    public String getNewPlanVariationId() {
        return OptionalNullable.getFrom(newPlanVariationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, effectiveDate, phases, newPlanVariationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriptionAction)) {
            return false;
        }
        SubscriptionAction other = (SubscriptionAction) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(type, other.type)
            && Objects.equals(effectiveDate, other.effectiveDate)
            && Objects.equals(phases, other.phases)
            && Objects.equals(newPlanVariationId, other.newPlanVariationId);
    }

    /**
     * Converts this SubscriptionAction into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SubscriptionAction [" + "id=" + id + ", type=" + type + ", effectiveDate="
                + effectiveDate + ", phases=" + phases + ", newPlanVariationId="
                + newPlanVariationId + "]";
    }

    /**
     * Builds a new {@link SubscriptionAction.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubscriptionAction.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .type(getType());
        builder.effectiveDate = internalGetEffectiveDate();
        builder.phases = internalGetPhases();
        builder.newPlanVariationId = internalGetNewPlanVariationId();
        return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionAction}.
     */
    public static class Builder {
        private String id;
        private String type;
        private OptionalNullable<String> effectiveDate;
        private OptionalNullable<List<Phase>> phases;
        private OptionalNullable<String> newPlanVariationId;



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
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for effectiveDate.
         * @param  effectiveDate  String value for effectiveDate.
         * @return Builder
         */
        public Builder effectiveDate(String effectiveDate) {
            this.effectiveDate = OptionalNullable.of(effectiveDate);
            return this;
        }

        /**
         * UnSetter for effectiveDate.
         * @return Builder
         */
        public Builder unsetEffectiveDate() {
            effectiveDate = null;
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
         * Setter for newPlanVariationId.
         * @param  newPlanVariationId  String value for newPlanVariationId.
         * @return Builder
         */
        public Builder newPlanVariationId(String newPlanVariationId) {
            this.newPlanVariationId = OptionalNullable.of(newPlanVariationId);
            return this;
        }

        /**
         * UnSetter for newPlanVariationId.
         * @return Builder
         */
        public Builder unsetNewPlanVariationId() {
            newPlanVariationId = null;
            return this;
        }

        /**
         * Builds a new {@link SubscriptionAction} object using the set fields.
         * @return {@link SubscriptionAction}
         */
        public SubscriptionAction build() {
            return new SubscriptionAction(id, type, effectiveDate, phases, newPlanVariationId);
        }
    }
}
