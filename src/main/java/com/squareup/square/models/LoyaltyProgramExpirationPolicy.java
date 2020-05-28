package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyProgramExpirationPolicy type.
 */
public class LoyaltyProgramExpirationPolicy {

    /**
     * Initialization constructor.
     * @param expirationDuration
     */
    @JsonCreator
    public LoyaltyProgramExpirationPolicy(
            @JsonProperty("expiration_duration") String expirationDuration) {
        this.expirationDuration = expirationDuration;
    }

    private final String expirationDuration;
    /**
     * Getter for ExpirationDuration.
     * The duration of time before points expire, in RFC 3339 format.
     */
    @JsonGetter("expiration_duration")
    public String getExpirationDuration() {
        return this.expirationDuration;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(expirationDuration);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyProgramExpirationPolicy)) {
            return false;
        }
        LoyaltyProgramExpirationPolicy loyaltyProgramExpirationPolicy = (LoyaltyProgramExpirationPolicy) obj;
        return Objects.equals(expirationDuration, loyaltyProgramExpirationPolicy.expirationDuration);
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
     * Class to build instances of {@link LoyaltyProgramExpirationPolicy}
     */
    public static class Builder {
        private String expirationDuration;

        /**
         * Initialization constructor
         */
        public Builder(String expirationDuration) {
            this.expirationDuration = expirationDuration;
        }

        /**
         * Setter for expirationDuration
         * @param expirationDuration
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
