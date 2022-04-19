
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for UpdateLocationResponse type.
 */
public class UpdateLocationResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Location location;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  location  Location value for location.
     */
    @JsonCreator
    public UpdateLocationResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("location") Location location) {
        this.errors = errors;
        this.location = location;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Location.
     * Represents one of a business' [locations](https://developer.squareup.com/docs/locations-api).
     * @return Returns the Location
     */
    @JsonGetter("location")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Location getLocation() {
        return location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, location);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateLocationResponse)) {
            return false;
        }
        UpdateLocationResponse other = (UpdateLocationResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(location, other.location);
    }

    /**
     * Converts this UpdateLocationResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateLocationResponse [" + "errors=" + errors + ", location=" + location + "]";
    }

    /**
     * Builds a new {@link UpdateLocationResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateLocationResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .location(getLocation());
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateLocationResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Location location;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

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
         * Builds a new {@link UpdateLocationResponse} object using the set fields.
         * @return {@link UpdateLocationResponse}
         */
        public UpdateLocationResponse build() {
            UpdateLocationResponse model =
                    new UpdateLocationResponse(errors, location);
            model.httpContext = httpContext;
            return model;
        }
    }
}
