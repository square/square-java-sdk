package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for AccumulateLoyaltyPointsRequest type.
 */
public class AccumulateLoyaltyPointsRequest {

    /**
     * Initialization constructor.
     * @param accumulatePoints
     * @param idempotencyKey
     * @param locationId
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

    private final LoyaltyEventAccumulatePoints accumulatePoints;
    private final String idempotencyKey;
    private final String locationId;
    /**
     * Getter for AccumulatePoints.
     * Provides metadata when the event `type` is `ACCUMULATE_POINTS`.
     */
    @JsonGetter("accumulate_points")
    public LoyaltyEventAccumulatePoints getAccumulatePoints() {
        return this.accumulatePoints;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the `AccumulateLoyaltyPoints` request. 
     * Keys can be any valid string but must be unique for every request.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for LocationId.
     * The [location](#type-Location) where the purchase was made.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof AccumulateLoyaltyPointsRequest)) {
            return false;
        }
        AccumulateLoyaltyPointsRequest accumulateLoyaltyPointsRequest = (AccumulateLoyaltyPointsRequest) obj;
        return Objects.equals(accumulatePoints, accumulateLoyaltyPointsRequest.accumulatePoints) &&
            Objects.equals(idempotencyKey, accumulateLoyaltyPointsRequest.idempotencyKey) &&
            Objects.equals(locationId, accumulateLoyaltyPointsRequest.locationId);
    }

    /**
     * Builds a new {@link AccumulateLoyaltyPointsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AccumulateLoyaltyPointsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(accumulatePoints,
            idempotencyKey,
            locationId);
            return builder;
    }

    /**
     * Class to build instances of {@link AccumulateLoyaltyPointsRequest}
     */
    public static class Builder {
        private LoyaltyEventAccumulatePoints accumulatePoints;
        private String idempotencyKey;
        private String locationId;

        /**
         * Initialization constructor
         */
        public Builder(LoyaltyEventAccumulatePoints accumulatePoints,
                String idempotencyKey,
                String locationId) {
            this.accumulatePoints = accumulatePoints;
            this.idempotencyKey = idempotencyKey;
            this.locationId = locationId;
        }

        /**
         * Setter for accumulatePoints
         * @param accumulatePoints
         * @return Builder
         */
        public Builder accumulatePoints(LoyaltyEventAccumulatePoints accumulatePoints) {
            this.accumulatePoints = accumulatePoints;
            return this;
        }
        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        /**
         * Setter for locationId
         * @param locationId
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
            return new AccumulateLoyaltyPointsRequest(accumulatePoints,
                idempotencyKey,
                locationId);
        }
    }
}
