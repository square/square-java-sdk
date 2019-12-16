package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class RetrieveCashDrawerShiftRequest {

    @JsonCreator
    public RetrieveCashDrawerShiftRequest(
            @JsonProperty("location_id") String locationId) {
        this.locationId = locationId;
    }

    private final String locationId;

    @Override
    public int hashCode() {
        return Objects.hash(locationId);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RetrieveCashDrawerShiftRequest)) {
            return false;
        }
        RetrieveCashDrawerShiftRequest retrieveCashDrawerShiftRequest = (RetrieveCashDrawerShiftRequest) o;
        return Objects.equals(locationId, retrieveCashDrawerShiftRequest.locationId);
    }
    
    /**
     * Getter for LocationId.
     * The ID of the location to retrieve cash drawer shifts from.
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(locationId);
            return builder;
    }

    public static class Builder {
        private String locationId;

        public Builder(String locationId) {
            this.locationId = locationId;
        }

        public Builder locationId(String value) {
            locationId = value;
            return this;
        }

        public RetrieveCashDrawerShiftRequest build() {
            return new RetrieveCashDrawerShiftRequest(locationId);
        }
    }
}
