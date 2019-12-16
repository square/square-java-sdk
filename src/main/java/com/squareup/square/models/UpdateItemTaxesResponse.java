package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class UpdateItemTaxesResponse {

    @JsonCreator
    public UpdateItemTaxesResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("updated_at") String updatedAt) {
        this.errors = errors;
        this.updatedAt = updatedAt;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final String updatedAt;

    @Override
    public int hashCode() {
        return Objects.hash(errors, updatedAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateItemTaxesResponse)) {
            return false;
        }
        UpdateItemTaxesResponse updateItemTaxesResponse = (UpdateItemTaxesResponse) o;
        return Objects.equals(errors, updateItemTaxesResponse.errors) &&
            Objects.equals(updatedAt, updateItemTaxesResponse.updatedAt);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on any errors encountered.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

    /**
     * Getter for UpdatedAt.
     * The database [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates) of this update in RFC 3339 format, e.g., `2016-09-04T23:59:33.123Z`.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() { 
        return this.updatedAt;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private String updatedAt;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder updatedAt(String value) {
            updatedAt = value;
            return this;
        }

        public UpdateItemTaxesResponse build() {
            UpdateItemTaxesResponse model = new UpdateItemTaxesResponse(errors,
                updatedAt);
            model.httpContext = httpContext;
            return model;
        }
    }
}
