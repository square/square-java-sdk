
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SwapPlanRequest type.
 */
public class SwapPlanRequest {
    private final String newPlanId;

    /**
     * Initialization constructor.
     * @param  newPlanId  String value for newPlanId.
     */
    @JsonCreator
    public SwapPlanRequest(
            @JsonProperty("new_plan_id") String newPlanId) {
        this.newPlanId = newPlanId;
    }

    /**
     * Getter for NewPlanId.
     * The ID of the new subscription plan.
     * @return Returns the String
     */
    @JsonGetter("new_plan_id")
    public String getNewPlanId() {
        return newPlanId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(newPlanId);
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
        return Objects.equals(newPlanId, other.newPlanId);
    }

    /**
     * Converts this SwapPlanRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SwapPlanRequest [" + "newPlanId=" + newPlanId + "]";
    }

    /**
     * Builds a new {@link SwapPlanRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SwapPlanRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(newPlanId);
        return builder;
    }

    /**
     * Class to build instances of {@link SwapPlanRequest}.
     */
    public static class Builder {
        private String newPlanId;

        /**
         * Initialization constructor.
         * @param  newPlanId  String value for newPlanId.
         */
        public Builder(String newPlanId) {
            this.newPlanId = newPlanId;
        }

        /**
         * Setter for newPlanId.
         * @param  newPlanId  String value for newPlanId.
         * @return Builder
         */
        public Builder newPlanId(String newPlanId) {
            this.newPlanId = newPlanId;
            return this;
        }

        /**
         * Builds a new {@link SwapPlanRequest} object using the set fields.
         * @return {@link SwapPlanRequest}
         */
        public SwapPlanRequest build() {
            return new SwapPlanRequest(newPlanId);
        }
    }
}
