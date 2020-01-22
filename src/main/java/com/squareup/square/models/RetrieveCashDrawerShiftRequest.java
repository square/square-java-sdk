package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for RetrieveCashDrawerShiftRequest type.
 */
public class RetrieveCashDrawerShiftRequest {

    /**
     * Initialization constructor.
     * @param locationId
     */
    @JsonCreator
    public RetrieveCashDrawerShiftRequest(
            @JsonProperty("location_id") String locationId) {
        this.locationId = locationId;
    }

    private final String locationId;
    /**
     * Getter for LocationId.
     * The ID of the location to retrieve cash drawer shifts from.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveCashDrawerShiftRequest)) {
            return false;
        }
        RetrieveCashDrawerShiftRequest retrieveCashDrawerShiftRequest = (RetrieveCashDrawerShiftRequest) obj;
        return Objects.equals(locationId, retrieveCashDrawerShiftRequest.locationId);
    }

    /**
     * Builds a new {@link RetrieveCashDrawerShiftRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveCashDrawerShiftRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId);
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveCashDrawerShiftRequest}
     */
    public static class Builder {
        private String locationId;

        /**
         * Initialization constructor
         */
        public Builder(String locationId) {
            this.locationId = locationId;
        }

        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Builds a new {@link RetrieveCashDrawerShiftRequest} object using the set fields.
         * @return {@link RetrieveCashDrawerShiftRequest}
         */
        public RetrieveCashDrawerShiftRequest build() {
            return new RetrieveCashDrawerShiftRequest(locationId);
        }
    }
}
