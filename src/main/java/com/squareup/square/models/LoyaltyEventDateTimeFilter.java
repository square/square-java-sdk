
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for LoyaltyEventDateTimeFilter type.
 */
public class LoyaltyEventDateTimeFilter {
    private final TimeRange createdAt;

    /**
     * Initialization constructor.
     * @param createdAt TimeRange value for createdAt.
     */
    @JsonCreator
    public LoyaltyEventDateTimeFilter(
            @JsonProperty("created_at") TimeRange createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Getter for CreatedAt.
     * Represents a generic time range. The start and end values are represented in RFC 3339 format.
     * Time ranges are customized to be inclusive or exclusive based on the needs of a particular
     * endpoint. Refer to the relevant endpoint-specific documentation to determine how time ranges
     * are handled.
     * @return Returns the TimeRange
     */
    @JsonGetter("created_at")
    public TimeRange getCreatedAt() {
        return this.createdAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEventDateTimeFilter)) {
            return false;
        }
        LoyaltyEventDateTimeFilter other = (LoyaltyEventDateTimeFilter) obj;
        return Objects.equals(createdAt, other.createdAt);
    }

    /**
     * Builds a new {@link LoyaltyEventDateTimeFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventDateTimeFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(createdAt);
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventDateTimeFilter}.
     */
    public static class Builder {
        private TimeRange createdAt;

        /**
         * Initialization constructor.
         * @param createdAt TimeRange value for createdAt.
         */
        public Builder(TimeRange createdAt) {
            this.createdAt = createdAt;
        }

        /**
         * Setter for createdAt.
         * @param createdAt TimeRange value for createdAt.
         * @return Builder
         */
        public Builder createdAt(TimeRange createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventDateTimeFilter} object using the set fields.
         * @return {@link LoyaltyEventDateTimeFilter}
         */
        public LoyaltyEventDateTimeFilter build() {
            return new LoyaltyEventDateTimeFilter(createdAt);
        }
    }
}
