package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CreateLocationResponse type.
 */
public class CreateLocationResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param location
     */
    @JsonCreator
    public CreateLocationResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("location") Location location) {
        this.errors = errors;
        this.location = location;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Location location;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Location.
     */
    @JsonGetter("location")
    public Location getLocation() {
        return this.location;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, location);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateLocationResponse)) {
            return false;
        }
        CreateLocationResponse createLocationResponse = (CreateLocationResponse) obj;
        return Objects.equals(errors, createLocationResponse.errors) &&
            Objects.equals(location, createLocationResponse.location);
    }

    /**
     * Builds a new {@link CreateLocationResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateLocationResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .location(getLocation());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateLocationResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Location location;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
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
         * Builds a new {@link CreateLocationResponse} object using the set fields.
         * @return {@link CreateLocationResponse}
         */
        public CreateLocationResponse build() {
            CreateLocationResponse model = new CreateLocationResponse(errors,
                location);
            model.httpContext = httpContext;
            return model;
        }
    }
}
