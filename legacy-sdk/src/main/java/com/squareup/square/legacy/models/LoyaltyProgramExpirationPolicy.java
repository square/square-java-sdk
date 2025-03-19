package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyProgramExpirationPolicy type.
 */
public class LoyaltyProgramExpirationPolicy {
    private final String expirationDuration;

    /**
     * Initialization constructor.
     * @param  expirationDuration  String value for expirationDuration.
     */
    @JsonCreator
    public LoyaltyProgramExpirationPolicy(@JsonProperty("expiration_duration") String expirationDuration) {
        this.expirationDuration = expirationDuration;
    }

    /**
     * Getter for ExpirationDuration.
     * The number of months before points expire, in `P[n]M` RFC 3339 duration format. For example,
     * a value of `P12M` represents a duration of 12 months. Points are valid through the last day
     * of the month in which they are scheduled to expire. For example, with a `P12M` duration,
     * points earned on July 6, 2020 expire on August 1, 2021.
     * @return Returns the String
     */
    @JsonGetter("expiration_duration")
    public String getExpirationDuration() {
        return expirationDuration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(expirationDuration);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyProgramExpirationPolicy)) {
            return false;
        }
        LoyaltyProgramExpirationPolicy other = (LoyaltyProgramExpirationPolicy) obj;
        return Objects.equals(expirationDuration, other.expirationDuration);
    }

    /**
     * Converts this LoyaltyProgramExpirationPolicy into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyProgramExpirationPolicy [" + "expirationDuration=" + expirationDuration + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgramExpirationPolicy.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgramExpirationPolicy.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(expirationDuration);
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramExpirationPolicy}.
     */
    public static class Builder {
        private String expirationDuration;

        /**
         * Initialization constructor.
         * @param  expirationDuration  String value for expirationDuration.
         */
        public Builder(String expirationDuration) {
            this.expirationDuration = expirationDuration;
        }

        /**
         * Setter for expirationDuration.
         * @param  expirationDuration  String value for expirationDuration.
         * @return Builder
         */
        public Builder expirationDuration(String expirationDuration) {
            this.expirationDuration = expirationDuration;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyProgramExpirationPolicy} object using the set fields.
         * @return {@link LoyaltyProgramExpirationPolicy}
         */
        public LoyaltyProgramExpirationPolicy build() {
            return new LoyaltyProgramExpirationPolicy(expirationDuration);
        }
    }
}
