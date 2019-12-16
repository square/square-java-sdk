package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class UpdateLocationRequest {

    @JsonCreator
    public UpdateLocationRequest(
            @JsonProperty("location") Location location) {
        this.location = location;
    }

    private final Location location;

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateLocationRequest)) {
            return false;
        }
        UpdateLocationRequest updateLocationRequest = (UpdateLocationRequest) o;
        return Objects.equals(location, updateLocationRequest.location);
    }

    /**
     * Getter for Location.
     */
    @JsonGetter("location")
    public Location getLocation() { 
        return this.location;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .location(getLocation());
            return builder;
    }

    public static class Builder {
        private Location location;

        public Builder() { }

        public Builder location(Location value) {
            location = value;
            return this;
        }

        public UpdateLocationRequest build() {
            return new UpdateLocationRequest(location);
        }
    }
}
