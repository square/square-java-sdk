package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class GetBreakTypeResponse {

    @JsonCreator
    public GetBreakTypeResponse(
            @JsonProperty("break_type") BreakType breakType,
            @JsonProperty("errors") List<Error> errors) {
        this.breakType = breakType;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final BreakType breakType;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(breakType, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GetBreakTypeResponse)) {
            return false;
        }
        GetBreakTypeResponse getBreakTypeResponse = (GetBreakTypeResponse) o;
        return Objects.equals(breakType, getBreakTypeResponse.breakType) &&
            Objects.equals(errors, getBreakTypeResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for BreakType.
     * A defined break template that sets an expectation for possible `Break` 
     * instances on a `Shift`.
     */
    @JsonGetter("break_type")
    public BreakType getBreakType() { 
        return this.breakType;
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
            .breakType(getBreakType())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private BreakType breakType;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder breakType(BreakType value) {
            breakType = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public GetBreakTypeResponse build() {
            GetBreakTypeResponse model = new GetBreakTypeResponse(breakType,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
