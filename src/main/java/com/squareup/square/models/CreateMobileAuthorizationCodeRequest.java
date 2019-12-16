package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CreateMobileAuthorizationCodeRequest {

    @JsonCreator
    public CreateMobileAuthorizationCodeRequest(
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
        if (!(o instanceof CreateMobileAuthorizationCodeRequest)) {
            return false;
        }
        CreateMobileAuthorizationCodeRequest createMobileAuthorizationCodeRequest = (CreateMobileAuthorizationCodeRequest) o;
        return Objects.equals(locationId, createMobileAuthorizationCodeRequest.locationId);
    }

    /**
     * Getter for LocationId.
     * The Square location ID the authorization code should be tied to.
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .locationId(getLocationId());
            return builder;
    }

    public static class Builder {
        private String locationId;

        public Builder() { }

        public Builder locationId(String value) {
            locationId = value;
            return this;
        }

        public CreateMobileAuthorizationCodeRequest build() {
            return new CreateMobileAuthorizationCodeRequest(locationId);
        }
    }
}
