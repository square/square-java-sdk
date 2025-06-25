package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for LoyaltyEventAdjustPoints type.
 */
public class LoyaltyEventAdjustPoints {
    private final String loyaltyProgramId;
    private final int points;
    private final OptionalNullable<String> reason;

    /**
     * Initialization constructor.
     * @param  points  int value for points.
     * @param  loyaltyProgramId  String value for loyaltyProgramId.
     * @param  reason  String value for reason.
     */
    @JsonCreator
    public LoyaltyEventAdjustPoints(
            @JsonProperty("points") int points,
            @JsonProperty("loyalty_program_id") String loyaltyProgramId,
            @JsonProperty("reason") String reason) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.points = points;
        this.reason = OptionalNullable.of(reason);
    }

    /**
     * Initialization constructor.
     * @param  points  int value for points.
     * @param  loyaltyProgramId  String value for loyaltyProgramId.
     * @param  reason  String value for reason.
     */
    protected LoyaltyEventAdjustPoints(int points, String loyaltyProgramId, OptionalNullable<String> reason) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.points = points;
        this.reason = reason;
    }

    /**
     * Getter for LoyaltyProgramId.
     * The Square-assigned ID of the [loyalty program](entity:LoyaltyProgram).
     * @return Returns the String
     */
    @JsonGetter("loyalty_program_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getLoyaltyProgramId() {
        return loyaltyProgramId;
    }

    /**
     * Getter for Points.
     * The number of points added or removed.
     * @return Returns the int
     */
    @JsonGetter("points")
    public int getPoints() {
        return points;
    }

    /**
     * Internal Getter for Reason.
     * The reason for the adjustment of points.
     * @return Returns the Internal String
     */
    @JsonGetter("reason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetReason() {
        return this.reason;
    }

    /**
     * Getter for Reason.
     * The reason for the adjustment of points.
     * @return Returns the String
     */
    @JsonIgnore
    public String getReason() {
        return OptionalNullable.getFrom(reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loyaltyProgramId, points, reason);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEventAdjustPoints)) {
            return false;
        }
        LoyaltyEventAdjustPoints other = (LoyaltyEventAdjustPoints) obj;
        return Objects.equals(loyaltyProgramId, other.loyaltyProgramId)
                && Objects.equals(points, other.points)
                && Objects.equals(reason, other.reason);
    }

    /**
     * Converts this LoyaltyEventAdjustPoints into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyEventAdjustPoints [" + "points=" + points + ", loyaltyProgramId=" + loyaltyProgramId
                + ", reason=" + reason + "]";
    }

    /**
     * Builds a new {@link LoyaltyEventAdjustPoints.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventAdjustPoints.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(points).loyaltyProgramId(getLoyaltyProgramId());
        builder.reason = internalGetReason();
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventAdjustPoints}.
     */
    public static class Builder {
        private int points;
        private String loyaltyProgramId;
        private OptionalNullable<String> reason;

        /**
         * Initialization constructor.
         * @param  points  int value for points.
         */
        public Builder(int points) {
            this.points = points;
        }

        /**
         * Setter for points.
         * @param  points  int value for points.
         * @return Builder
         */
        public Builder points(int points) {
            this.points = points;
            return this;
        }

        /**
         * Setter for loyaltyProgramId.
         * @param  loyaltyProgramId  String value for loyaltyProgramId.
         * @return Builder
         */
        public Builder loyaltyProgramId(String loyaltyProgramId) {
            this.loyaltyProgramId = loyaltyProgramId;
            return this;
        }

        /**
         * Setter for reason.
         * @param  reason  String value for reason.
         * @return Builder
         */
        public Builder reason(String reason) {
            this.reason = OptionalNullable.of(reason);
            return this;
        }

        /**
         * UnSetter for reason.
         * @return Builder
         */
        public Builder unsetReason() {
            reason = null;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventAdjustPoints} object using the set fields.
         * @return {@link LoyaltyEventAdjustPoints}
         */
        public LoyaltyEventAdjustPoints build() {
            return new LoyaltyEventAdjustPoints(points, loyaltyProgramId, reason);
        }
    }
}
