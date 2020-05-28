package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyEventExpirePoints type.
 */
public class LoyaltyEventExpirePoints {

    /**
     * Initialization constructor.
     * @param loyaltyProgramId
     * @param points
     */
    @JsonCreator
    public LoyaltyEventExpirePoints(
            @JsonProperty("loyalty_program_id") String loyaltyProgramId,
            @JsonProperty("points") int points) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.points = points;
    }

    private final String loyaltyProgramId;
    private final int points;
    /**
     * Getter for LoyaltyProgramId.
     * The Square-assigned ID of the [loyalty program](#type-LoyaltyProgram).
     */
    @JsonGetter("loyalty_program_id")
    public String getLoyaltyProgramId() {
        return this.loyaltyProgramId;
    }

    /**
     * Getter for Points.
     * The number of points expired.
     */
    @JsonGetter("points")
    public int getPoints() {
        return this.points;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(loyaltyProgramId, points);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyEventExpirePoints)) {
            return false;
        }
        LoyaltyEventExpirePoints loyaltyEventExpirePoints = (LoyaltyEventExpirePoints) obj;
        return Objects.equals(loyaltyProgramId, loyaltyEventExpirePoints.loyaltyProgramId) &&
            Objects.equals(points, loyaltyEventExpirePoints.points);
    }

    /**
     * Builds a new {@link LoyaltyEventExpirePoints.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventExpirePoints.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(loyaltyProgramId,
            points);
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventExpirePoints}
     */
    public static class Builder {
        private String loyaltyProgramId;
        private int points;

        /**
         * Initialization constructor
         */
        public Builder(String loyaltyProgramId,
                int points) {
            this.loyaltyProgramId = loyaltyProgramId;
            this.points = points;
        }

        /**
         * Setter for loyaltyProgramId
         * @param loyaltyProgramId
         * @return Builder
         */
        public Builder loyaltyProgramId(String loyaltyProgramId) {
            this.loyaltyProgramId = loyaltyProgramId;
            return this;
        }
        /**
         * Setter for points
         * @param points
         * @return Builder
         */
        public Builder points(int points) {
            this.points = points;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventExpirePoints} object using the set fields.
         * @return {@link LoyaltyEventExpirePoints}
         */
        public LoyaltyEventExpirePoints build() {
            return new LoyaltyEventExpirePoints(loyaltyProgramId,
                points);
        }
    }
}
