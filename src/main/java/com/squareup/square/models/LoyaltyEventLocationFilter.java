package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for LoyaltyEventLocationFilter type.
 */
public class LoyaltyEventLocationFilter {

    /**
     * Initialization constructor.
     * @param locationIds
     */
    @JsonCreator
    public LoyaltyEventLocationFilter(
            @JsonProperty("location_ids") List<String> locationIds) {
        this.locationIds = locationIds;
    }

    private final List<String> locationIds;
    /**
     * Getter for LocationIds.
     * The [location](#type-Location) IDs for loyalty events to query.
     * If multiple values are specified, the endpoint uses 
     * a logical OR to combine them.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof LoyaltyEventLocationFilter)) {
            return false;
        }
        LoyaltyEventLocationFilter loyaltyEventLocationFilter = (LoyaltyEventLocationFilter) obj;
        return Objects.equals(locationIds, loyaltyEventLocationFilter.locationIds);
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
     * Class to build instances of {@link LoyaltyEventLocationFilter}
     */
    public static class Builder {
        private List<String> locationIds;

        /**
         * Initialization constructor
         */
        public Builder(List<String> locationIds) {
            this.locationIds = locationIds;
        }

        /**
         * Setter for locationIds
         * @param locationIds
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
