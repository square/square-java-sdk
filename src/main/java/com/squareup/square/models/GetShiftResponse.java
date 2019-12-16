package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class GetShiftResponse {

    @JsonCreator
    public GetShiftResponse(
            @JsonProperty("shift") Shift shift,
            @JsonProperty("errors") List<Error> errors) {
        this.shift = shift;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final Shift shift;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(shift, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GetShiftResponse)) {
            return false;
        }
        GetShiftResponse getShiftResponse = (GetShiftResponse) o;
        return Objects.equals(shift, getShiftResponse.shift) &&
            Objects.equals(errors, getShiftResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Shift.
     * A record of the hourly rate, start, and end times for a single work shift 
     * for an employee. May include a record of the start and end times for breaks 
     * taken during the shift.
     */
    @JsonGetter("shift")
    public Shift getShift() { 
        return this.shift;
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
            .shift(getShift())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private Shift shift;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder shift(Shift value) {
            shift = value;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public GetShiftResponse build() {
            GetShiftResponse model = new GetShiftResponse(shift,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
