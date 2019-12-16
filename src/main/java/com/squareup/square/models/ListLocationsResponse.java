package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListLocationsResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, locations);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListLocationsResponse)) {
            return false;
        }
        ListLocationsResponse listLocationsResponse = (ListLocationsResponse) o;
        return Objects.equals(errors, listLocationsResponse.errors) &&
            Objects.equals(locations, listLocationsResponse.locations);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .locations(getLocations());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Location> locations;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder locations(List<Location> value) {
            locations = value;
            return this;
        }

        public ListLocationsResponse build() {
            ListLocationsResponse model = new ListLocationsResponse(errors,
                locations);
            model.httpContext = httpContext;
            return model;
        }
    }
}
