package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListBreakTypesResponse {

    @JsonCreator
    public ListBreakTypesResponse(
            @JsonProperty("break_types") List<BreakType> breakTypes,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.breakTypes = breakTypes;
        this.cursor = cursor;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<BreakType> breakTypes;
    private final String cursor;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(breakTypes, cursor, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListBreakTypesResponse)) {
            return false;
        }
        ListBreakTypesResponse listBreakTypesResponse = (ListBreakTypesResponse) o;
        return Objects.equals(breakTypes, listBreakTypesResponse.breakTypes) &&
            Objects.equals(cursor, listBreakTypesResponse.cursor) &&
            Objects.equals(errors, listBreakTypesResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for BreakTypes.
     * A page of `BreakType` results.
     */
    @JsonGetter("break_types")
    public List<BreakType> getBreakTypes() { 
        return this.breakTypes;
    }

    /**
     * Getter for Cursor.
     * Value supplied in the subsequent request to fetch the next next page
     * of Break Type results.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .breakTypes(getBreakTypes())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<BreakType> breakTypes;
        private String cursor;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder breakTypes(List<BreakType> value) {
            breakTypes = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public ListBreakTypesResponse build() {
            ListBreakTypesResponse model = new ListBreakTypesResponse(breakTypes,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
