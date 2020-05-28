package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for AdjustLoyaltyPointsRequest type.
 */
public class AdjustLoyaltyPointsRequest {

    /**
     * Initialization constructor.
     * @param idempotencyKey
     * @param adjustPoints
     */
    @JsonCreator
    public AdjustLoyaltyPointsRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("adjust_points") LoyaltyEventAdjustPoints adjustPoints) {
        this.idempotencyKey = idempotencyKey;
        this.adjustPoints = adjustPoints;
    }

    private final String idempotencyKey;
    private final LoyaltyEventAdjustPoints adjustPoints;
    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `AdjustLoyaltyPoints` request. 
     * Keys can be any valid string, but must be unique for every request.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for AdjustPoints.
     * Provides metadata when the event `type` is `ADJUST_POINTS`.
     */
    @JsonGetter("adjust_points")
    public LoyaltyEventAdjustPoints getAdjustPoints() {
        return this.adjustPoints;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, adjustPoints);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof AdjustLoyaltyPointsRequest)) {
            return false;
        }
        AdjustLoyaltyPointsRequest adjustLoyaltyPointsRequest = (AdjustLoyaltyPointsRequest) obj;
        return Objects.equals(idempotencyKey, adjustLoyaltyPointsRequest.idempotencyKey) &&
            Objects.equals(adjustPoints, adjustLoyaltyPointsRequest.adjustPoints);
    }

    /**
     * Builds a new {@link AdjustLoyaltyPointsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AdjustLoyaltyPointsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey,
            adjustPoints);
            return builder;
    }

    /**
     * Class to build instances of {@link AdjustLoyaltyPointsRequest}
     */
    public static class Builder {
        private String idempotencyKey;
        private LoyaltyEventAdjustPoints adjustPoints;

        /**
         * Initialization constructor
         */
        public Builder(String idempotencyKey,
                LoyaltyEventAdjustPoints adjustPoints) {
            this.idempotencyKey = idempotencyKey;
            this.adjustPoints = adjustPoints;
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
         * Setter for adjustPoints
         * @param adjustPoints
         * @return Builder
         */
        public Builder adjustPoints(LoyaltyEventAdjustPoints adjustPoints) {
            this.adjustPoints = adjustPoints;
            return this;
        }

        /**
         * Builds a new {@link AdjustLoyaltyPointsRequest} object using the set fields.
         * @return {@link AdjustLoyaltyPointsRequest}
         */
        public AdjustLoyaltyPointsRequest build() {
            return new AdjustLoyaltyPointsRequest(idempotencyKey,
                adjustPoints);
        }
    }
}
