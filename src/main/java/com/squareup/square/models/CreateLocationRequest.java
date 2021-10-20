
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateLocationRequest type.
 */
public class CreateLocationRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Location location;

    /**
     * Initialization constructor.
     * @param  location  Location value for location.
     */
    @JsonCreator
    public CreateLocationRequest(
            @JsonProperty("location") Location location) {
        this.location = location;
    }

    /**
     * Getter for Location.
     * Represents one of a business's locations.
     * @return Returns the Location
     */
    @JsonGetter("location")
    public Location getLocation() {
        return location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateLocationRequest)) {
            return false;
        }
        CreateLocationRequest other = (CreateLocationRequest) obj;
        return Objects.equals(location, other.location);
    }

    /**
     * Converts this CreateLocationRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateLocationRequest [" + "location=" + location + "]";
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
     * Class to build instances of {@link CreateLocationRequest}.
     */
    public static class Builder {
        private Location location;



        /**
         * Setter for location.
         * @param  location  Location value for location.
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
