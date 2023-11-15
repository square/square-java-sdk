
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
 * This is a model class for SwapPlanRequest type.
 */
public class SwapPlanRequest {
    private final OptionalNullable<String> newPlanVariationId;
    private final OptionalNullable<List<PhaseInput>> phases;

    /**
     * Initialization constructor.
     * @param  newPlanVariationId  String value for newPlanVariationId.
     * @param  phases  List of PhaseInput value for phases.
     */
    @JsonCreator
    public SwapPlanRequest(
            @JsonProperty("new_plan_variation_id") String newPlanVariationId,
            @JsonProperty("phases") List<PhaseInput> phases) {
        this.newPlanVariationId = OptionalNullable.of(newPlanVariationId);
        this.phases = OptionalNullable.of(phases);
    }

    /**
     * Initialization constructor.
     * @param  newPlanVariationId  String value for newPlanVariationId.
     * @param  phases  List of PhaseInput value for phases.
     */

    protected SwapPlanRequest(OptionalNullable<String> newPlanVariationId,
            OptionalNullable<List<PhaseInput>> phases) {
        this.newPlanVariationId = newPlanVariationId;
        this.phases = phases;
    }

    /**
     * Internal Getter for NewPlanVariationId.
     * The ID of the new subscription plan variation. This field is required.
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
     * The ID of the new subscription plan variation. This field is required.
     * @return Returns the String
     */
    @JsonIgnore
    public String getNewPlanVariationId() {
        return OptionalNullable.getFrom(newPlanVariationId);
    }

    /**
     * Internal Getter for Phases.
     * A list of PhaseInputs, to pass phase-specific information used in the swap.
     * @return Returns the Internal List of PhaseInput
     */
    @JsonGetter("phases")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<PhaseInput>> internalGetPhases() {
        return this.phases;
    }

    /**
     * Getter for Phases.
     * A list of PhaseInputs, to pass phase-specific information used in the swap.
     * @return Returns the List of PhaseInput
     */
    @JsonIgnore
    public List<PhaseInput> getPhases() {
        return OptionalNullable.getFrom(phases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newPlanVariationId, phases);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapPlanRequest)) {
            return false;
        }
        SwapPlanRequest other = (SwapPlanRequest) obj;
        return Objects.equals(newPlanVariationId, other.newPlanVariationId)
            && Objects.equals(phases, other.phases);
    }

    /**
     * Converts this SwapPlanRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SwapPlanRequest [" + "newPlanVariationId=" + newPlanVariationId + ", phases="
                + phases + "]";
    }

    /**
     * Builds a new {@link SwapPlanRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SwapPlanRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.newPlanVariationId = internalGetNewPlanVariationId();
        builder.phases = internalGetPhases();
        return builder;
    }

    /**
     * Class to build instances of {@link SwapPlanRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> newPlanVariationId;
        private OptionalNullable<List<PhaseInput>> phases;



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
         * Setter for phases.
         * @param  phases  List of PhaseInput value for phases.
         * @return Builder
         */
        public Builder phases(List<PhaseInput> phases) {
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
         * Builds a new {@link SwapPlanRequest} object using the set fields.
         * @return {@link SwapPlanRequest}
         */
        public SwapPlanRequest build() {
            return new SwapPlanRequest(newPlanVariationId, phases);
        }
    }
}
