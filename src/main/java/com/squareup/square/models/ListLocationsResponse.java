package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListLocationsResponse type.
 */
public class ListLocationsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param locations
     */
    @JsonCreator
    public ListLocationsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("locations") List<Location> locations) {
        this.errors = errors;
        this.locations = locations;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Location> locations;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Locations.
     * The business locations.
     */
    @JsonGetter("locations")
    public List<Location> getLocations() {
        return this.locations;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, locations);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListLocationsResponse)) {
            return false;
        }
        ListLocationsResponse listLocationsResponse = (ListLocationsResponse) obj;
        return Objects.equals(errors, listLocationsResponse.errors) &&
            Objects.equals(locations, listLocationsResponse.locations);
    }

    /**
     * Builds a new {@link ListLocationsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListLocationsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .locations(getLocations());
            return builder;
    }

    /**
     * Class to build instances of {@link ListLocationsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Location> locations;

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
         * Setter for locations
         * @param locations
         * @return Builder
         */
        public Builder locations(List<Location> locations) {
            this.locations = locations;
            return this;
        }

        /**
         * Builds a new {@link ListLocationsResponse} object using the set fields.
         * @return {@link ListLocationsResponse}
         */
        public ListLocationsResponse build() {
            ListLocationsResponse model = new ListLocationsResponse(errors,
                locations);
            model.httpContext = httpContext;
            return model;
        }
    }
}
