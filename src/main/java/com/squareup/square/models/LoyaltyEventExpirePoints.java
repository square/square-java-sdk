
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for LoyaltyEventExpirePoints type.
 */
public class LoyaltyEventExpirePoints {
    private final String loyaltyProgramId;
    private final int points;

    /**
     * Initialization constructor.
     * @param loyaltyProgramId String value for loyaltyProgramId.
     * @param points int value for points.
     */
    @JsonCreator
    public LoyaltyEventExpirePoints(
            @JsonProperty("loyalty_program_id") String loyaltyProgramId,
            @JsonProperty("points") int points) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.points = points;
    }

    /**
     * Getter for LoyaltyProgramId.
     * The Square-assigned ID of the [loyalty program](#type-LoyaltyProgram).
     * @return Returns the String
     */
    @JsonGetter("loyalty_program_id")
    public String getLoyaltyProgramId() {
        return this.loyaltyProgramId;
    }

    /**
     * Getter for Points.
     * The number of points expired.
     * @return Returns the int
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEventExpirePoints)) {
            return false;
        }
        LoyaltyEventExpirePoints other = (LoyaltyEventExpirePoints) obj;
        return Objects.equals(loyaltyProgramId, other.loyaltyProgramId)
            && Objects.equals(points, other.points);
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
     * Class to build instances of {@link LoyaltyEventExpirePoints}.
     */
    public static class Builder {
        private String loyaltyProgramId;
        private int points;

        /**
         * Initialization constructor.
         * @param loyaltyProgramId String value for loyaltyProgramId.
         * @param points int value for points.
         */
        public Builder(String loyaltyProgramId,
                int points) {
            this.loyaltyProgramId = loyaltyProgramId;
            this.points = points;
        }

        /**
         * Setter for loyaltyProgramId.
         * @param loyaltyProgramId String value for loyaltyProgramId.
         * @return Builder
         */
        public Builder loyaltyProgramId(String loyaltyProgramId) {
            this.loyaltyProgramId = loyaltyProgramId;
            return this;
        }

        /**
         * Setter for points.
         * @param points int value for points.
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
