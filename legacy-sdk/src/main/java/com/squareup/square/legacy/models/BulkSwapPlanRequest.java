package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for BulkSwapPlanRequest type.
 */
public class BulkSwapPlanRequest {
    private final String newPlanVariationId;
    private final String oldPlanVariationId;
    private final String locationId;

    /**
     * Initialization constructor.
     * @param  newPlanVariationId  String value for newPlanVariationId.
     * @param  oldPlanVariationId  String value for oldPlanVariationId.
     * @param  locationId  String value for locationId.
     */
    @JsonCreator
    public BulkSwapPlanRequest(
            @JsonProperty("new_plan_variation_id") String newPlanVariationId,
            @JsonProperty("old_plan_variation_id") String oldPlanVariationId,
            @JsonProperty("location_id") String locationId) {
        this.newPlanVariationId = newPlanVariationId;
        this.oldPlanVariationId = oldPlanVariationId;
        this.locationId = locationId;
    }

    /**
     * Getter for NewPlanVariationId.
     * The ID of the new subscription plan variation. This field is required.
     * @return Returns the String
     */
    @JsonGetter("new_plan_variation_id")
    public String getNewPlanVariationId() {
        return newPlanVariationId;
    }

    /**
     * Getter for OldPlanVariationId.
     * The ID of the plan variation whose subscriptions should be swapped. Active subscriptions
     * using this plan variation will be subscribed to the new plan variation on their next billing
     * day.
     * @return Returns the String
     */
    @JsonGetter("old_plan_variation_id")
    public String getOldPlanVariationId() {
        return oldPlanVariationId;
    }

    /**
     * Getter for LocationId.
     * The ID of the location to associate with the swapped subscriptions.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(newPlanVariationId, oldPlanVariationId, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkSwapPlanRequest)) {
            return false;
        }
        BulkSwapPlanRequest other = (BulkSwapPlanRequest) obj;
        return Objects.equals(newPlanVariationId, other.newPlanVariationId)
                && Objects.equals(oldPlanVariationId, other.oldPlanVariationId)
                && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this BulkSwapPlanRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkSwapPlanRequest [" + "newPlanVariationId=" + newPlanVariationId + ", oldPlanVariationId="
                + oldPlanVariationId + ", locationId=" + locationId + "]";
    }

    /**
     * Builds a new {@link BulkSwapPlanRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkSwapPlanRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(newPlanVariationId, oldPlanVariationId, locationId);
        return builder;
    }

    /**
     * Class to build instances of {@link BulkSwapPlanRequest}.
     */
    public static class Builder {
        private String newPlanVariationId;
        private String oldPlanVariationId;
        private String locationId;

        /**
         * Initialization constructor.
         * @param  newPlanVariationId  String value for newPlanVariationId.
         * @param  oldPlanVariationId  String value for oldPlanVariationId.
         * @param  locationId  String value for locationId.
         */
        public Builder(String newPlanVariationId, String oldPlanVariationId, String locationId) {
            this.newPlanVariationId = newPlanVariationId;
            this.oldPlanVariationId = oldPlanVariationId;
            this.locationId = locationId;
        }

        /**
         * Setter for newPlanVariationId.
         * @param  newPlanVariationId  String value for newPlanVariationId.
         * @return Builder
         */
        public Builder newPlanVariationId(String newPlanVariationId) {
            this.newPlanVariationId = newPlanVariationId;
            return this;
        }

        /**
         * Setter for oldPlanVariationId.
         * @param  oldPlanVariationId  String value for oldPlanVariationId.
         * @return Builder
         */
        public Builder oldPlanVariationId(String oldPlanVariationId) {
            this.oldPlanVariationId = oldPlanVariationId;
            return this;
        }

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Builds a new {@link BulkSwapPlanRequest} object using the set fields.
         * @return {@link BulkSwapPlanRequest}
         */
        public BulkSwapPlanRequest build() {
            return new BulkSwapPlanRequest(newPlanVariationId, oldPlanVariationId, locationId);
        }
    }
}
