
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for RedeemLoyaltyRewardRequest type.
 */
public class RedeemLoyaltyRewardRequest {
    private final String idempotencyKey;
    private final String locationId;

    /**
     * Initialization constructor.
     * @param idempotencyKey String value for idempotencyKey.
     * @param locationId String value for locationId.
     */
    @JsonCreator
    public RedeemLoyaltyRewardRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("location_id") String locationId) {
        this.idempotencyKey = idempotencyKey;
        this.locationId = locationId;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this `RedeemLoyaltyReward` request. Keys can be any valid
     * string, but must be unique for every request.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for LocationId.
     * The ID of the [location](#type-Location) where the reward is redeemed.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RedeemLoyaltyRewardRequest)) {
            return false;
        }
        RedeemLoyaltyRewardRequest other = (RedeemLoyaltyRewardRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(locationId, other.locationId);
    }

    /**
     * Builds a new {@link RedeemLoyaltyRewardRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RedeemLoyaltyRewardRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey,
            locationId);
        return builder;
    }

    /**
     * Class to build instances of {@link RedeemLoyaltyRewardRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private String locationId;

        /**
         * Initialization constructor.
         * @param idempotencyKey String value for idempotencyKey.
         * @param locationId String value for locationId.
         */
        public Builder(String idempotencyKey,
                String locationId) {
            this.idempotencyKey = idempotencyKey;
            this.locationId = locationId;
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
         * Builds a new {@link RedeemLoyaltyRewardRequest} object using the set fields.
         * @return {@link RedeemLoyaltyRewardRequest}
         */
        public RedeemLoyaltyRewardRequest build() {
            return new RedeemLoyaltyRewardRequest(idempotencyKey,
                locationId);
        }
    }
}
