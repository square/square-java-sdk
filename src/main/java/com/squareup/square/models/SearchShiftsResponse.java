package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class SearchShiftsResponse {

    @JsonCreator
    public SearchShiftsResponse(
            @JsonProperty("shifts") List<Shift> shifts,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.shifts = shifts;
        this.cursor = cursor;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<Shift> shifts;
    private final String cursor;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(shifts, cursor, errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchShiftsResponse)) {
            return false;
        }
        SearchShiftsResponse searchShiftsResponse = (SearchShiftsResponse) o;
        return Objects.equals(shifts, searchShiftsResponse.shifts) &&
            Objects.equals(cursor, searchShiftsResponse.cursor) &&
            Objects.equals(errors, searchShiftsResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Shifts.
     * Shifts
     */
    @JsonGetter("shifts")
    public List<Shift> getShifts() { 
        return this.shifts;
    }

    /**
     * Getter for Cursor.
     * Opaque cursor for fetching the next page.
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
            .shifts(getShifts())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Shift> shifts;
        private String cursor;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder shifts(List<Shift> value) {
            shifts = value;
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

        public SearchShiftsResponse build() {
            SearchShiftsResponse model = new SearchShiftsResponse(shifts,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
