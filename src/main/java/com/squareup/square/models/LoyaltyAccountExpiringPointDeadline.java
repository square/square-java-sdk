
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyAccountExpiringPointDeadline type.
 */
public class LoyaltyAccountExpiringPointDeadline {
    private final int points;
    private final String expiresAt;

    /**
     * Initialization constructor.
     * @param  points  int value for points.
     * @param  expiresAt  String value for expiresAt.
     */
    @JsonCreator
    public LoyaltyAccountExpiringPointDeadline(
            @JsonProperty("points") int points,
            @JsonProperty("expires_at") String expiresAt) {
        this.points = points;
        this.expiresAt = expiresAt;
    }

    /**
     * Getter for Points.
     * The number of points scheduled to expire at the `expires_at` timestamp.
     * @return Returns the int
     */
    @JsonGetter("points")
    public int getPoints() {
        return points;
    }

    /**
     * Getter for ExpiresAt.
     * The timestamp of when the points are scheduled to expire, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("expires_at")
    public String getExpiresAt() {
        return expiresAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, expiresAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyAccountExpiringPointDeadline)) {
            return false;
        }
        LoyaltyAccountExpiringPointDeadline other = (LoyaltyAccountExpiringPointDeadline) obj;
        return Objects.equals(points, other.points)
            && Objects.equals(expiresAt, other.expiresAt);
    }

    /**
     * Converts this LoyaltyAccountExpiringPointDeadline into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyAccountExpiringPointDeadline [" + "points=" + points + ", expiresAt="
                + expiresAt + "]";
    }

    /**
     * Builds a new {@link LoyaltyAccountExpiringPointDeadline.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyAccountExpiringPointDeadline.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(points, expiresAt);
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyAccountExpiringPointDeadline}.
     */
    public static class Builder {
        private int points;
        private String expiresAt;

        /**
         * Initialization constructor.
         * @param  points  int value for points.
         * @param  expiresAt  String value for expiresAt.
         */
        public Builder(int points, String expiresAt) {
            this.points = points;
            this.expiresAt = expiresAt;
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
         * Setter for expiresAt.
         * @param  expiresAt  String value for expiresAt.
         * @return Builder
         */
        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyAccountExpiringPointDeadline} object using the set fields.
         * @return {@link LoyaltyAccountExpiringPointDeadline}
         */
        public LoyaltyAccountExpiringPointDeadline build() {
            return new LoyaltyAccountExpiringPointDeadline(points, expiresAt);
        }
    }
}
