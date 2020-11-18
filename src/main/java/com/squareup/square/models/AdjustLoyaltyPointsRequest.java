
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for AdjustLoyaltyPointsRequest type.
 */
public class AdjustLoyaltyPointsRequest {
    private final String idempotencyKey;
    private final LoyaltyEventAdjustPoints adjustPoints;

    /**
     * Initialization constructor.
     * @param idempotencyKey String value for idempotencyKey.
     * @param adjustPoints LoyaltyEventAdjustPoints value for adjustPoints.
     */
    @JsonCreator
    public AdjustLoyaltyPointsRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("adjust_points") LoyaltyEventAdjustPoints adjustPoints) {
        this.idempotencyKey = idempotencyKey;
        this.adjustPoints = adjustPoints;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `AdjustLoyaltyPoints` request. Keys can be any valid
     * string, but must be unique for every request.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for AdjustPoints.
     * Provides metadata when the event `type` is `ADJUST_POINTS`.
     * @return Returns the LoyaltyEventAdjustPoints
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdjustLoyaltyPointsRequest)) {
            return false;
        }
        AdjustLoyaltyPointsRequest other = (AdjustLoyaltyPointsRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(adjustPoints, other.adjustPoints);
    }

    /**
     * Converts this AdjustLoyaltyPointsRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "AdjustLoyaltyPointsRequest [" + "idempotencyKey=" + idempotencyKey
                + ", adjustPoints=" + adjustPoints + "]";
    }

    /**
     * Builds a new {@link AdjustLoyaltyPointsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link AdjustLoyaltyPointsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, adjustPoints);
        return builder;
    }

    /**
     * Class to build instances of {@link AdjustLoyaltyPointsRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private LoyaltyEventAdjustPoints adjustPoints;

        /**
         * Initialization constructor.
         * @param idempotencyKey String value for idempotencyKey.
         * @param adjustPoints LoyaltyEventAdjustPoints value for adjustPoints.
         */
        public Builder(String idempotencyKey,
                LoyaltyEventAdjustPoints adjustPoints) {
            this.idempotencyKey = idempotencyKey;
            this.adjustPoints = adjustPoints;
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
         * Setter for adjustPoints.
         * @param adjustPoints LoyaltyEventAdjustPoints value for adjustPoints.
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
            return new AdjustLoyaltyPointsRequest(idempotencyKey, adjustPoints);
        }
    }
}
