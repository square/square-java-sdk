package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class UpdateItemModifierListsResponse {

    @JsonCreator
    public UpdateItemModifierListsResponse(
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
        if (!(o instanceof UpdateItemModifierListsResponse)) {
            return false;
        }
        UpdateItemModifierListsResponse updateItemModifierListsResponse = (UpdateItemModifierListsResponse) o;
        return Objects.equals(errors, updateItemModifierListsResponse.errors) &&
            Objects.equals(updatedAt, updateItemModifierListsResponse.updatedAt);
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

        public UpdateItemModifierListsResponse build() {
            UpdateItemModifierListsResponse model = new UpdateItemModifierListsResponse(errors,
                updatedAt);
            model.httpContext = httpContext;
            return model;
        }
    }
}
