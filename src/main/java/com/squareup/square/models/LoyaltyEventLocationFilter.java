
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for LoyaltyEventLocationFilter type.
 */
public class LoyaltyEventLocationFilter {
    private final List<String> locationIds;

    /**
     * Initialization constructor.
     * @param locationIds List of String value for locationIds.
     */
    @JsonCreator
    public LoyaltyEventLocationFilter(
            @JsonProperty("location_ids") List<String> locationIds) {
        this.locationIds = locationIds;
    }

    /**
     * Getter for LocationIds.
     * The [location](#type-Location) IDs for loyalty events to query. If multiple values are
     * specified, the endpoint uses a logical OR to combine them.
     * @return Returns the List of String
     */
    @JsonGetter("location_ids")
    public List<String> getLocationIds() {
        return this.locationIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEventLocationFilter)) {
            return false;
        }
        LoyaltyEventLocationFilter other = (LoyaltyEventLocationFilter) obj;
        return Objects.equals(locationIds, other.locationIds);
    }

    /**
     * Converts this LoyaltyEventLocationFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyEventLocationFilter [" + "locationIds=" + locationIds + "]";
    }

    /**
     * Builds a new {@link LoyaltyEventLocationFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventLocationFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationIds);
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventLocationFilter}.
     */
    public static class Builder {
        private List<String> locationIds;

        /**
         * Initialization constructor.
         * @param locationIds List of String value for locationIds.
         */
        public Builder(List<String> locationIds) {
            this.locationIds = locationIds;
        }

        /**
         * Setter for locationIds.
         * @param locationIds List of String value for locationIds.
         * @return Builder
         */
        public Builder locationIds(List<String> locationIds) {
            this.locationIds = locationIds;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventLocationFilter} object using the set fields.
         * @return {@link LoyaltyEventLocationFilter}
         */
        public LoyaltyEventLocationFilter build() {
            return new LoyaltyEventLocationFilter(locationIds);
        }
    }
}
