package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateLocationRequest type.
 */
public class CreateLocationRequest {

    /**
     * Initialization constructor.
     * @param location
     */
    @JsonCreator
    public CreateLocationRequest(
            @JsonProperty("location") Location location) {
        this.location = location;
    }

    private final Location location;
    /**
     * Getter for Location.
     */
    @JsonGetter("location")
    public Location getLocation() {
        return this.location;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateLocationRequest)) {
            return false;
        }
        CreateLocationRequest createLocationRequest = (CreateLocationRequest) obj;
        return Objects.equals(location, createLocationRequest.location);
    }

    /**
     * Builds a new {@link CreateLocationRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateLocationRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .location(getLocation());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateLocationRequest}
     */
    public static class Builder {
        private Location location;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for location
         * @param location
         * @return Builder
         */
        public Builder location(Location location) {
            this.location = location;
            return this;
        }

        /**
         * Builds a new {@link CreateLocationRequest} object using the set fields.
         * @return {@link CreateLocationRequest}
         */
        public CreateLocationRequest build() {
            return new CreateLocationRequest(location);
        }
    }
}
