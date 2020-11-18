
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for AccumulateLoyaltyPointsRequest type.
 */
public class AccumulateLoyaltyPointsRequest {
    private final LoyaltyEventAccumulatePoints accumulatePoints;
    private final String idempotencyKey;
    private final String locationId;

    /**
     * Initialization constructor.
     * @param accumulatePoints LoyaltyEventAccumulatePoints value for accumulatePoints.
     * @param idempotencyKey String value for idempotencyKey.
     * @param locationId String value for locationId.
     */
    @JsonCreator
    public AccumulateLoyaltyPointsRequest(
            @JsonProperty("accumulate_points") LoyaltyEventAccumulatePoints accumulatePoints,
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("location_id") String locationId) {
        this.accumulatePoints = accumulatePoints;
        this.idempotencyKey = idempotencyKey;
        this.locationId = locationId;
    }

    /**
     * Getter for AccumulatePoints.
     * Provides metadata when the event `type` is `ACCUMULATE_POINTS`.
     * @return Returns the LoyaltyEventAccumulatePoints
     */
    @JsonGetter("accumulate_points")
    public LoyaltyEventAccumulatePoints getAccumulatePoints() {
        return this.accumulatePoints;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the `AccumulateLoyaltyPoints` request. Keys can be any valid
     * string but must be unique for every request.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for LocationId.
     * The [location](#type-Location) where the purchase was made.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accumulatePoints, idempotencyKey, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccumulateLoyaltyPointsRequest)) {
            return false;
        }
        AccumulateLoyaltyPointsRequest other = (AccumulateLoyaltyPointsRequest) obj;
        return Objects.equals(accumulatePoints, other.accumulatePoints)
            && Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(locationId, other.locationId);
    }

    /**
     * Converts this AccumulateLoyaltyPointsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "AccumulateLoyaltyPointsRequest [" + "accumulatePoints=" + accumulatePoints
                + ", idempotencyKey=" + idempotencyKey + ", locationId=" + locationId + "]";
    }

    /**
     * Builds a new {@link AccumulateLoyaltyPointsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AccumulateLoyaltyPointsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(accumulatePoints, idempotencyKey, locationId);
        return builder;
    }

    /**
     * Class to build instances of {@link AccumulateLoyaltyPointsRequest}.
     */
    public static class Builder {
        private LoyaltyEventAccumulatePoints accumulatePoints;
        private String idempotencyKey;
        private String locationId;

        /**
         * Initialization constructor.
         * @param accumulatePoints LoyaltyEventAccumulatePoints value for accumulatePoints.
         * @param idempotencyKey String value for idempotencyKey.
         * @param locationId String value for locationId.
         */
        public Builder(LoyaltyEventAccumulatePoints accumulatePoints,
                String idempotencyKey,
                String locationId) {
            this.accumulatePoints = accumulatePoints;
            this.idempotencyKey = idempotencyKey;
            this.locationId = locationId;
        }

        /**
         * Setter for accumulatePoints.
         * @param accumulatePoints LoyaltyEventAccumulatePoints value for accumulatePoints.
         * @return Builder
         */
        public Builder accumulatePoints(LoyaltyEventAccumulatePoints accumulatePoints) {
            this.accumulatePoints = accumulatePoints;
            return this;
        }

        /**
         * Setter for idempotencyKey.
         * @param idempotencyKey String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for locationId.
         * @param locationId String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Builds a new {@link AccumulateLoyaltyPointsRequest} object using the set fields.
         * @return {@link AccumulateLoyaltyPointsRequest}
         */
        public AccumulateLoyaltyPointsRequest build() {
            return new AccumulateLoyaltyPointsRequest(accumulatePoints, idempotencyKey, locationId);
        }
    }
}
