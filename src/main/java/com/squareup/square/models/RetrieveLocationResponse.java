package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RetrieveLocationResponse type.
 */
public class RetrieveLocationResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param location
     */
    @JsonCreator
    public RetrieveLocationResponse(
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
        if(!(obj instanceof RetrieveLocationResponse)) {
            return false;
        }
        RetrieveLocationResponse retrieveLocationResponse = (RetrieveLocationResponse) obj;
        return Objects.equals(errors, retrieveLocationResponse.errors) &&
            Objects.equals(location, retrieveLocationResponse.location);
    }

    /**
     * Builds a new {@link RetrieveLocationResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveLocationResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .location(getLocation());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveLocationResponse}
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
         * Builds a new {@link RetrieveLocationResponse} object using the set fields.
         * @return {@link RetrieveLocationResponse}
         */
        public RetrieveLocationResponse build() {
            RetrieveLocationResponse model = new RetrieveLocationResponse(errors,
                location);
            model.httpContext = httpContext;
            return model;
        }
    }
}
