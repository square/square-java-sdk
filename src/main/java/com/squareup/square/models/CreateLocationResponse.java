package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class CreateLocationResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, location);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateLocationResponse)) {
            return false;
        }
        CreateLocationResponse createLocationResponse = (CreateLocationResponse) o;
        return Objects.equals(errors, createLocationResponse.errors) &&
            Objects.equals(location, createLocationResponse.location);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .location(getLocation());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Location location;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder location(Location value) {
            location = value;
            return this;
        }

        public CreateLocationResponse build() {
            CreateLocationResponse model = new CreateLocationResponse(errors,
                location);
            model.httpContext = httpContext;
            return model;
        }
    }
}
