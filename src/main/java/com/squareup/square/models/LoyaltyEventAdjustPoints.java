package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyEventAdjustPoints type.
 */
public class LoyaltyEventAdjustPoints {

    /**
     * Initialization constructor.
     * @param points
     * @param loyaltyProgramId
     * @param reason
     */
    @JsonCreator
    public LoyaltyEventAdjustPoints(
            @JsonProperty("points") int points,
            @JsonProperty("loyalty_program_id") String loyaltyProgramId,
            @JsonProperty("reason") String reason) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.points = points;
        this.reason = reason;
    }

    private final String loyaltyProgramId;
    private final int points;
    private final String reason;
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
     * The number of points added or removed.
     */
    @JsonGetter("points")
    public int getPoints() {
        return this.points;
    }

    /**
     * Getter for Reason.
     * The reason for the adjustment of points.
     */
    @JsonGetter("reason")
    public String getReason() {
        return this.reason;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(loyaltyProgramId, points, reason);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyEventAdjustPoints)) {
            return false;
        }
        LoyaltyEventAdjustPoints loyaltyEventAdjustPoints = (LoyaltyEventAdjustPoints) obj;
        return Objects.equals(loyaltyProgramId, loyaltyEventAdjustPoints.loyaltyProgramId) &&
            Objects.equals(points, loyaltyEventAdjustPoints.points) &&
            Objects.equals(reason, loyaltyEventAdjustPoints.reason);
    }

    /**
     * Builds a new {@link LoyaltyEventAdjustPoints.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventAdjustPoints.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(points)
            .loyaltyProgramId(getLoyaltyProgramId())
            .reason(getReason());
            return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventAdjustPoints}
     */
    public static class Builder {
        private int points;
        private String loyaltyProgramId;
        private String reason;

        /**
         * Initialization constructor
         */
        public Builder(int points) {
            this.points = points;
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
         * Setter for loyaltyProgramId
         * @param loyaltyProgramId
         * @return Builder
         */
        public Builder loyaltyProgramId(String loyaltyProgramId) {
            this.loyaltyProgramId = loyaltyProgramId;
            return this;
        }
        /**
         * Setter for reason
         * @param reason
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventAdjustPoints} object using the set fields.
         * @return {@link LoyaltyEventAdjustPoints}
         */
        public LoyaltyEventAdjustPoints build() {
            return new LoyaltyEventAdjustPoints(points,
                loyaltyProgramId,
                reason);
        }
    }
}
