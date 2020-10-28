
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for RetrieveLocationResponse type.
 */
public class RetrieveLocationResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Location location;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param location Location value for location.
     */
    @JsonCreator
    public RetrieveLocationResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("location") Location location) {
        this.errors = errors;
        this.location = location;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Location.
     * @return Returns the Location
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveLocationResponse)) {
            return false;
        }
        RetrieveLocationResponse other = (RetrieveLocationResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(location, other.location);
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
     * Class to build instances of {@link RetrieveLocationResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Location location;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for location.
         * @param location Location value for location.
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
            RetrieveLocationResponse model =
                    new RetrieveLocationResponse(errors,
                            location);
            model.httpContext = httpContext;
            return model;
        }
    }
}
